package palikkapeli.ui.syote;

import java.awt.event.KeyEvent;
import palikkapeli.peli.PeliSilmukka;
import palikkapeli.peli.logiikka.ohjaus.Liikkuva;
import palikkapeli.peli.logiikka.ohjaus.Ohjautuva;

/**
 * Huolehtii käyttäjän syötteiden välittämisestä logiikalle
 *
 * @author Janne Ruoho
 */
public class Ohjain extends PeliSilmukka<Ohjautuva> {

    private final Nappaimisto nappaimisto;

    public Ohjain(Nappaimisto nappaimisto) {
        this.nappaimisto = nappaimisto;
    }

    public void kasitteleOhjattava(Ohjautuva ohjattava) {
        if (ohjattava instanceof Liikkuva) {
            Liikkuva liikutettava = (Liikkuva) ohjattava;

            if (Nappain.YLOS.onPainettu(nappaimisto)) {
                liikutettava.liikuYlos();
            }
            if (Nappain.ALAS.onPainettu(nappaimisto)) {
                liikutettava.liikuAlas();
            }
            if (Nappain.VASEN.onPainettu(nappaimisto)) {
                liikutettava.liikuVasemmalle();
            }
            if (Nappain.OIKEA.onPainettu(nappaimisto)) {
                liikutettava.liikuOikealle();
            }
        }
    }

    @Override
    public void paivita() {
        nappaimisto.synkronoi();
        for (Ohjautuva ohjattava : getPaivitettavat()) {
            kasitteleOhjattava(ohjattava);
        }
    }

    public enum Nappain {

        YLOS(KeyEvent.VK_UP),
        ALAS(KeyEvent.VK_DOWN),
        VASEN(KeyEvent.VK_LEFT),
        OIKEA(KeyEvent.VK_RIGHT);
        private final int nappainkoodi;

        private Nappain(int nappainkoodi) {
            this.nappainkoodi = nappainkoodi;
        }

        public boolean onPainettu(Nappaimisto nappaimisto) {
            return nappaimisto.onPainettu(nappainkoodi);
        }
    }
}
