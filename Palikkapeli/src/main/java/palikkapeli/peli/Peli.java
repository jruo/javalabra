package palikkapeli.peli;

import palikkapeli.ui.grafiikka.Grafiikka;
import palikkapeli.peli.logiikka.Logiikka;
import palikkapeli.peli.taso.TasonVaihtaja;
import palikkapeli.ui.Ikkuna;
import palikkapeli.ui.syote.Nappaimisto;

/**
 * Pitää koko pelin kaikki komponentit kasassa
 *
 * @author Janne Ruoho
 */
public class Peli {

    private final Ikkuna ikkuna;
    private final Logiikka logiikka;
    private final Grafiikka grafiikka;
    private final Nappaimisto nappaimisto;
    private final TasonVaihtaja tasonVaihtaja;
    public static final int IKKUNAN_LEVEYS = 700;
    public static final int IKKUNAN_KORKEUS = 500;

    public Peli() {
        ikkuna = new Ikkuna(IKKUNAN_LEVEYS, IKKUNAN_KORKEUS);
        nappaimisto = new Nappaimisto();
        logiikka = new Logiikka(nappaimisto);
        grafiikka = new Grafiikka(ikkuna.getPiirtoPaneeli());
        tasonVaihtaja = new TasonVaihtaja(this);

        ikkuna.lisaaNapaimistonKuuntelija(nappaimisto.getKuuntelija());
    }

    /**
     * Palauttaa peli-ikkunan
     *
     * @return Ikkuna
     */
    public Ikkuna getIkkuna() {
        return ikkuna;
    }

    /**
     * Palauttaa pelin logiikkasilmukan
     *
     * @return Logiikka
     */
    public Logiikka getLogiikka() {
        return logiikka;
    }

    /**
     * Palauttaa pelin grafiikkasilmukan
     *
     * @return Grafiikka
     */
    public Grafiikka getGrafiikka() {
        return grafiikka;
    }

    /**
     * Palauttaa pelin näppäimistönkäsittelijän
     *
     * @return Näppäimistö
     */
    public Nappaimisto getNappaimisto() {
        return nappaimisto;
    }

    /**
     * Palauttaa tasonvaihtajan
     *
     * @return Tasonvaihtaja
     */
    public TasonVaihtaja getTasonVaihtaja() {
        return tasonVaihtaja;
    }
}
