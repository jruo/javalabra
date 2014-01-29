package palikkapeli.peli;

import palikkapeli.peli.logiikka.Logiikka;
import palikkapeli.peli.taso.TasonVaihtaja;
import palikkapeli.ui.Ikkuna;
import palikkapeli.ui.grafiikka.Grafiikka;
import palikkapeli.ui.syote.Nappaimisto;
import palikkapeli.ui.syote.Ohjain;

/**
 * Pitää koko pelin kaikki komponentit kasassa
 *
 * @author Janne Ruoho
 */
public class Peli {

    private final Ikkuna ikkuna;
    private final Ohjain ohjain;
    private final Logiikka logiikka;
    private final Grafiikka grafiikka;
    private final Nappaimisto nappaimisto;
    private final TasonVaihtaja tasonVaihtaja;
    public static final int IKKUNAN_LEVEYS = 500;
    public static final int IKKUNAN_KORKEUS = 400;
    public static final int RUUDUKON_KOKO = 20;

    public Peli() {
        ikkuna = new Ikkuna(IKKUNAN_LEVEYS, IKKUNAN_KORKEUS);
        nappaimisto = new Nappaimisto();
        ohjain = new Ohjain(nappaimisto);
        logiikka = new Logiikka();
        grafiikka = new Grafiikka(ikkuna.getPiirtoPaneeli());
        tasonVaihtaja = new TasonVaihtaja(this);

        ikkuna.lisaaNapaimistonKuuntelija(nappaimisto.getKuuntelija());

        ohjain.kaynnista();
        logiikka.kaynnista();
        grafiikka.kaynnista();
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
     * Paluttaa pelin ohjaimen
     *
     * @return Ohjain
     */
    public Ohjain getOhjain() {
        return ohjain;
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
