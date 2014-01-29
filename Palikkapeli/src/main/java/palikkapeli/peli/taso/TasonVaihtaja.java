package palikkapeli.peli.taso;

import palikkapeli.peli.Peli;

/**
 * Huolehtii tasojen vaihtamisesta
 *
 * @author Janne Ruoho
 */
public class TasonVaihtaja {

    private final Peli peli;

    public TasonVaihtaja(Peli peli) {
        this.peli = peli;
        luoTestiTaso();
    }

    /**
     * testausmetodi
     */
    private void luoTestiTaso() {
        TasonLataaja lataaja = new TasonLataaja(peli);
        Taso taso = lataaja.lataaTaso("/tasot/taso1");
        taso.rakennaTaso();
    }
}
