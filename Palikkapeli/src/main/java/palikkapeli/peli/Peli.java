package palikkapeli.peli;

import palikkapeli.peli.logiikka.Logiikka;
import palikkapeli.peli.logiikka.Oliot;
import palikkapeli.peli.logiikka.Ruudukko;
import palikkapeli.peli.olio.PeliOlio;
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
public final class Peli {

    private final Oliot oliot;
    private final Ikkuna ikkuna;
    private final Ohjain ohjain;
    private final Logiikka logiikka;
    private final Grafiikka grafiikka;
    private final Nappaimisto nappaimisto;
    private final TasonVaihtaja tasonVaihtaja;
    private final Ruudukko<PeliOlio> ruudukko;
    public static final int IKKUNAN_LEVEYS = 500;
    public static final int IKKUNAN_KORKEUS = 400;

    public Peli() {
        ikkuna = new Ikkuna(IKKUNAN_LEVEYS, IKKUNAN_KORKEUS);
        nappaimisto = new Nappaimisto();
        ohjain = new Ohjain(nappaimisto);
        ruudukko = new Ruudukko<>();
        logiikka = new Logiikka(ohjain);
        grafiikka = new Grafiikka(ikkuna.getPiirtoPaneeli());
        tasonVaihtaja = new TasonVaihtaja(this);
        oliot = new Oliot();

        ikkuna.lisaaNapaimistonKuuntelija(nappaimisto.getKuuntelija());

        logiikka.kaynnista();
        grafiikka.kaynnista();
    }

    /**
     * Palauttaa oliot-kokoelman
     *
     * @return Oliot
     */
    public Oliot getOliot() {
        return oliot;
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

    /**
     * Palauttaa pelin ruudukon
     *
     * @return Ruudukko
     */
    public Ruudukko<PeliOlio> getRuudukko() {
        return ruudukko;
    }
}
