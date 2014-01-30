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
    }

    public void seuraavaTaso() {
        TasonLataaja lataaja = new TasonLataaja(peli);
        Taso taso = lataaja.lataaTaso("/tasot/taso1");
        taso.rakennaTaso();
    }
}
