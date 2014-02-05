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
public class Ohjain extends PeliKokoelma<Ohjautuva> {

    private final Nappaimisto nappaimisto;

    public Ohjain(Nappaimisto nappaimisto) {
        this.nappaimisto = nappaimisto;
    }

    public void kasitteleOhjattava(Ohjautuva ohjattava) {
        if (ohjattava instanceof Liikkuva) {
            Liikkuva liikutettava = (Liikkuva) ohjattava;

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
        if (ohjattava instanceof Aktivoituva) {
            Aktivoituva aktivoituva = (Aktivoituva) ohjattava;
            if (aktivoituva.getAktivoivaNappain().onPainettu(nappaimisto)) {
                aktivoituva.aktivoidu();
            }
        }
    }

    public void kasitteleOhjattavat() {
        nappaimisto.synkronoi();
        for (Ohjautuva ohjattava : getOliot()) {
            kasitteleOhjattava(ohjattava);
        }
    }
}
