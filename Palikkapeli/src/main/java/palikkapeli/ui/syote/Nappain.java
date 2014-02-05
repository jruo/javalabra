package palikkapeli.ui.syote;

import java.awt.event.KeyEvent;

public enum Nappain {

    YLOS(KeyEvent.VK_UP),
    ALAS(KeyEvent.VK_DOWN),
    VASEN(KeyEvent.VK_LEFT),
    OIKEA(KeyEvent.VK_RIGHT),
    VALILYONTI(KeyEvent.VK_SPACE);
    private final int nappainkoodi;

    private Nappain(int nappainkoodi) {
        this.nappainkoodi = nappainkoodi;
    }

    public boolean onPainettu(Nappaimisto nappaimisto) {
        return nappaimisto.onPainettu(nappainkoodi);
    }
}
