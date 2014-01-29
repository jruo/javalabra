package palikkapeli.peli.taso;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Logiikka;
import palikkapeli.peli.olio.KiinteaSeina;
import palikkapeli.peli.olio.Pelaaja;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.grafiikka.Grafiikka;
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
        olionID.put(10, Pelaaja.class);
    }

    public Taso(Peli peli, int[][] taso) {
        this.peli = peli;
        this.taso = taso;
    }

    public void rakennaTaso() {
        Logiikka logiikka = peli.getLogiikka();
        Grafiikka grafiikka = peli.getGrafiikka();
        int ruudukko = Peli.RUUDUKON_KOKO;

        List<PeliOlio> oliot = new ArrayList<>();
        List<Piirros> piirrokset = new ArrayList<>();

        for (int i = 0; i < taso.length; i++) {
            for (int j = 0; j < taso[i].length; j++) {
                int id = taso[i][j];

                if (id == 0) {
                    continue;
                }

                Class<? extends PeliOlio> luokka = muutaLuokaksi(id);
                PeliOlio olio = luoOlio(luokka, j * ruudukko, i * ruudukko);

                oliot.add(olio);
                piirrokset.add(olio.luoOmaPiirros());
            }
        }

        logiikka.lisaa(oliot);
        grafiikka.lisaa(piirrokset);
    }

    public Class<? extends PeliOlio> muutaLuokaksi(int id) {
        if (olionID.containsKey(id)) {
            return olionID.get(id);
        }
        return null;
    }

    public PeliOlio luoOlio(Class<? extends PeliOlio> luokka, int x, int y) {
        try {
            Constructor<?> konstruktori = luokka.getConstructors()[0];
            PeliOlio olio = (PeliOlio) konstruktori.newInstance(peli, x, y);
            return olio;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.out.println("Virhe luotaessa oliota luokasta " + luokka.getName());
        }
        System.exit(1);
        return null;
    }

}
