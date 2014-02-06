package palikkapeli.ui.syote;

import palikkapeli.peli.PeliKokoelma;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.ohjaus.Aktivoituva;
import palikkapeli.peli.logiikka.ohjaus.Liikkuva;
import palikkapeli.peli.logiikka.ohjaus.Ohjautuva;

/**
 * Huolehtii käyttäjän syötteiden välittämisestä logiikalle
 *
 * @author Janne Ruoho
 */
public final class Ohjain extends PeliKokoelma<Ohjautuva> {

    private final Nappaimisto nappaimisto;

    public Ohjain(Nappaimisto nappaimisto) {
        this.nappaimisto = nappaimisto;
    }

    /**
     * Käsittelee annetun Ohjautuva-olion
     *
     * @param ohjattava Ohjautuva
     */
    public void kasitteleOhjattava(Ohjautuva ohjattava) {
        if (ohjattava instanceof Liikkuva) {
            kasitteleLiikkuva((Liikkuva) ohjattava);
        }
        if (ohjattava instanceof Aktivoituva) {
            kasitteleAktivoituva((Aktivoituva) ohjattava);
        }
    }

    /**
     * Käsittelee annetun Liikkuva-olion
     *
     * @param liikutettava Liikkuva
     */
    public void kasitteleLiikkuva(Liikkuva liikutettava) {
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
     * @param aktivoituva Aktivoituva
     */
    public void kasitteleAktivoituva(Aktivoituva aktivoituva) {
        if (aktivoituva.getAktivoivaNappain().onPainettu(nappaimisto)) {
            aktivoituva.aktivoidu();
        }
    }

    /**
     * Käsittelee kaikki kokoelman oliot
     */
    public void kasitteleOhjattavat() {
        nappaimisto.synkronoi();
        for (Ohjautuva ohjattava : getOliot()) {
            kasitteleOhjattava(ohjattava);
        }
    }
}
