package palikkapeli.peli.taso;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruudukko;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.peli.olio.apuolio.PelaajanVaihtaja;
import palikkapeli.peli.olio.apuolio.TasonResetoija;
import palikkapeli.peli.olio.liikkumaton.KiinteaSeina;
import palikkapeli.peli.olio.liikkumaton.PunainenLapaisevaSeina;
import palikkapeli.peli.olio.liikkumaton.PunainenTasonMaali;
import palikkapeli.peli.olio.liikkumaton.SininenLapaisevaSeina;
import palikkapeli.peli.olio.liikkumaton.SininenTasonMaali;
import palikkapeli.peli.olio.liikkuva.PunainenLaatikko;
import palikkapeli.peli.olio.liikkuva.PunainenPelaaja;
import palikkapeli.peli.olio.liikkuva.SininenLaatikko;
import palikkapeli.peli.olio.liikkuva.SininenPelaaja;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Edustaa pelin tasoa. Luo kaikki tason PeliOliot
 *
 * @author Janne Ruoho
 */
public final class Taso {

    /**
     * Kartta, joka osoittaa id:n tiettyyn luokkaan
     */
    private static final Map<Integer, Class<? extends PeliOlio>> olionID = new HashMap<>();
    /**
     * Kaksiulotteinen taulukko tason luokkien id:istä
     */
    private final int[][] taso;

    static {
        olionID.put(1, KiinteaSeina.class);
        olionID.put(10, PelaajanVaihtaja.class);
        olionID.put(11, SininenPelaaja.class);
        olionID.put(12, PunainenPelaaja.class);
        olionID.put(21, SininenLapaisevaSeina.class);
        olionID.put(22, PunainenLapaisevaSeina.class);
        olionID.put(31, SininenLaatikko.class);
        olionID.put(32, PunainenLaatikko.class);
        olionID.put(41, SininenTasonMaali.class);
        olionID.put(42, PunainenTasonMaali.class);

        olionID.put(101, TasonResetoija.class);
    }

    /**
     * Luo uuden Tason annetuilla id:illä
     *
     * @param taso Kaksiulotteinen taulukko olioiden id:istä
     */
    public Taso(int[][] taso) {
        this.taso = taso;
    }

    /**
     * Luo tason oliot
     */
    public void rakennaTaso() {
        tyhjennaVanhaTaso();

        //Luodaan oliot niitä vastaavista id:istä
        List<PeliOlio> oliot = new ArrayList<>();
        List<Piirros> piirrokset = new ArrayList<>();

        for (int i = 0; i < taso.length; i++) {
            for (int j = 0; j < taso[i].length; j++) {
                int id = taso[i][j];

                if (id == 0) {
                    continue;
                }

                Class<? extends PeliOlio> luokka = muutaLuokaksi(id);

                if (luokka == null) {
                    continue;
                }

                PeliOlio olio = luoOlio(luokka, j * Ruudukko.RUUDUN_KOKO, i * Ruudukko.RUUDUN_KOKO);

                oliot.add(olio);
                piirrokset.add(olio.luoOmaPiirros());
            }
        }

        lisaaOliotJaPiirrokset(oliot, piirrokset);
    }

    /**
     * Tyhjentää pelin nykyisen tason
     */
    public void tyhjennaVanhaTaso() {
        Peli.INSTANSSI.getLogiikka().tyhjenna();
        Peli.INSTANSSI.getGrafiikka().tyhjenna();
        Peli.INSTANSSI.getOhjain().tyhjenna();
        Peli.INSTANSSI.getOliot().tyhjenna();
        Peli.INSTANSSI.getRuudukko().alustaRuudukko();
    }

    /**
     * Lisää peliin annetut oliot ja piirrokset
     *
     * @param oliot Lista lisättävistä olioista
     * @param piirrokset Lista lisättävistä piirroksista
     */
    public void lisaaOliotJaPiirrokset(List<PeliOlio> oliot, List<Piirros> piirrokset) {
        Peli.INSTANSSI.getLogiikka().lisaa(oliot);
        Peli.INSTANSSI.getGrafiikka().lisaa(piirrokset);
        Peli.INSTANSSI.getGrafiikka().jarjestaPiirtosyvyys();
        Peli.INSTANSSI.getOhjain().lisaa(oliot);
        Peli.INSTANSSI.getOliot().lisaa(oliot);
        Peli.INSTANSSI.getOliot().alustaOliot();
    }

    /**
     * Muuttaa annetun id:n sitä vastaavan PeliOlion luokaksi
     *
     * @param id id
     * @return id:tä vastaava luokka
     */
    public Class<? extends PeliOlio> muutaLuokaksi(int id) {
        if (olionID.containsKey(id)) {
            return olionID.get(id);
        }
        return null;
    }

    /**
     * Luo olion annetusta PeliOlion luokasta.
     *
     * @param luokka Luokka
     * @param x Olion x-koordinaatti
     * @param y Olion y-koordinaatti
     * @return PeliOlio
     */
    public PeliOlio luoOlio(Class<? extends PeliOlio> luokka, int x, int y) {
        try {
            Constructor<?> konstruktori = luokka.getConstructors()[0];
            PeliOlio olio = (PeliOlio) konstruktori.newInstance(x, y);
            return olio;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.out.println("Virhe luotaessa oliota luokasta " + luokka.getName());
            System.exit(1);
            return null;
        }
    }
}
