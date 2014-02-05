package palikkapeli.peli.taso;

import palikkapeli.peli.Peli;

/**
 * Huolehtii tasojen vaihtamisesta
 *
 * @author Janne Ruoho
 */
public final class TasonVaihtaja {

    private final Peli peli;

    public TasonVaihtaja(Peli peli) {
        this.peli = peli;
    }

    /**
     * Siirtyy pelin seuraavaan tasoon
     */
    public void seuraavaTaso() {
        TasonLataaja lataaja = new TasonLataaja(peli);
        Taso taso = lataaja.lataaTaso("/tasot/taso1");
        taso.rakennaTaso();
    }
}
