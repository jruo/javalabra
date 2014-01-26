package palikkapeli.peli.oliot;

import java.awt.event.KeyEvent;
import palikkapeli.peli.Peli;

/**
 * Pelaajaluokka
 *
 * @author Janne Ruoho
 */
public class Pelaaja extends PeliOlio {

    public Pelaaja(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public void suoritaLogiikka() {
        if (nappaimisto.onPainettu(KeyEvent.VK_UP)) {
            y -= 3;
        }
        if (nappaimisto.onPainettu(KeyEvent.VK_DOWN)) {
            y += 3;
        }
        if (nappaimisto.onPainettu(KeyEvent.VK_RIGHT)) {
            x += 3;
        }
        if (nappaimisto.onPainettu(KeyEvent.VK_LEFT)) {
            x -= 3;
        }
    }
}
