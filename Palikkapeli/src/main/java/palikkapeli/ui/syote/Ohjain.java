package palikkapeli.ui.syote;

import palikkapeli.peli.PeliKokoelma;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.ohjaus.Aktivoitava;
import palikkapeli.peli.logiikka.ohjaus.Liikutettava;
import palikkapeli.peli.logiikka.ohjaus.Ohjattava;

/**
 * Huolehtii käyttäjän syötteiden välittämisestä logiikalle
 *
 * @author Janne Ruoho
 */
public final class Ohjain extends PeliKokoelma<Ohjattava> {

    private final Nappaimisto nappaimisto;

    public Ohjain(Nappaimisto nappaimisto) {
        this.nappaimisto = nappaimisto;
    }

    /**
     * Käsittelee annetun Ohjattava-olion
     *
     * @param ohjattava Ohjattava
     */
    public void kasitteleOhjattava(Ohjattava ohjattava) {
        if (ohjattava instanceof Liikutettava) {
            kasitteleLiikkuva((Liikutettava) ohjattava);
        }
        if (ohjattava instanceof Aktivoitava) {
            kasitteleAktivoituva((Aktivoitava) ohjattava);
        }
    }

    /**
     * Käsittelee annetun Liikutettava-olion
     *
     * @param liikutettava Liikutettava
     */
    public void kasitteleLiikkuva(Liikutettava liikutettava) {
        if (Nappain.YLOS.onPainettu(nappaimisto)) {
            liikutettava.liiku(Suunta.YLOS);
        } else if (Nappain.ALAS.onPainettu(nappaimisto)) {
            liikutettava.liiku(Suunta.ALAS);
        } else if (Nappain.VASEN.onPainettu(nappaimisto)) {
            liikutettava.liiku(Suunta.VASEN);
        } else if (Nappain.OIKEA.onPainettu(nappaimisto)) {
            liikutettava.liiku(Suunta.OIKEA);
        }
    }

    /**
     * Käsittelee annetun aktivoituva-olion
     *
     * @param aktivoituva Aktivoitava
     */
    public void kasitteleAktivoituva(Aktivoitava aktivoituva) {
        if (aktivoituva.getAktivoivaNappain().onPainettu(nappaimisto)) {
            aktivoituva.aktivoidu();
        }
    }

    /**
     * Käsittelee kaikki kokoelman oliot
     */
    public void kasitteleOhjattavat() {
        nappaimisto.synkronoi();
        for (Ohjattava ohjattava : getOliot()) {
            kasitteleOhjattava(ohjattava);
        }
    }
}
