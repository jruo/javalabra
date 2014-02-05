package palikkapeli.peli.taso;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruudukko;
import palikkapeli.peli.olio.KiinteaSeina;
import palikkapeli.peli.olio.PelaajanVaihtaja;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.peli.olio.PunainenPelaaja;
import palikkapeli.peli.olio.SininenPelaaja;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Edustaa pelin tasoa. Luo kaikki tason PeliOliot
 *
 * @author Janne Ruoho
 */
public class Taso {

    private static final Map<Integer, Class<? extends PeliOlio>> olionID = new HashMap<>();
    private final int[][] taso;
    private final Peli peli;

    static {
        olionID.put(1, KiinteaSeina.class);
        olionID.put(10, PelaajanVaihtaja.class);
        olionID.put(11, SininenPelaaja.class);
        olionID.put(12, PunainenPelaaja.class);
    }

    public Taso(Peli peli, int[][] taso) {
        this.peli = peli;
        this.taso = taso;
    }

    /**
     * Luo tason oliot
     */
    public void rakennaTaso() {
        //Tyhjennetään peli edellisen tason jäljiltä
        peli.getLogiikka().tyhjenna();
        peli.getGrafiikka().tyhjenna();
        peli.getOhjain().tyhjenna();
        peli.getOliot().tyhjenna();
        peli.getRuudukko().alustaRuudukko();

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

        //Lisätään kaikki luodut oliot peliin
        peli.getLogiikka().lisaa(oliot);
        peli.getGrafiikka().lisaa(piirrokset);
        peli.getOhjain().lisaa(oliot);
        peli.getOliot().lisaa(oliot);
        peli.getOliot().alustaOliot();
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
            PeliOlio olio = (PeliOlio) konstruktori.newInstance(peli, x, y);
            return olio;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.out.println("Virhe luotaessa oliota luokasta " + luokka.getName());
            System.exit(1);
            return null;
        }
    }
}
