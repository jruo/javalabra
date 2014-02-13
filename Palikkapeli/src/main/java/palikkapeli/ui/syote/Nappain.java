package palikkapeli.ui.syote;

import java.awt.event.KeyEvent;

/**
 * Näppäimistön näppäin
 *
 * @author Janne Ruoho
 */
public enum Nappain {

    YLOS(KeyEvent.VK_UP),
    ALAS(KeyEvent.VK_DOWN),
    VASEN(KeyEvent.VK_LEFT),
    OIKEA(KeyEvent.VK_RIGHT),
    VALILYONTI(KeyEvent.VK_SPACE),
    R(KeyEvent.VK_R);
    /**
     * Näppäinkoodi
     */
    private final int nappainkoodi;

    /**
     * Nappain
     *
     * @param nappainkoodi Näppäinen näppäinkoodi
     */
    private Nappain(int nappainkoodi) {
        this.nappainkoodi = nappainkoodi;
    }

    /**
     * Tarkistaa onko näppäin painettu
     *
     * @param nappaimisto Näppäimistö
     * @return true jos on, false muutoin
     */
    public final boolean onPainettu(Nappaimisto nappaimisto) {
        return nappaimisto.onPainettu(nappainkoodi);
    }
}
