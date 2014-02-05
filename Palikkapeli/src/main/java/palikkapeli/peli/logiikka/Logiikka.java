package palikkapeli.peli.logiikka;

import palikkapeli.peli.PeliSilmukka;
import palikkapeli.ui.syote.Ohjain;

/**
 * Huolehtii pelin logiikasta
 *
 * @author Janne Ruoho
 */
public class Logiikka extends PeliSilmukka<Looginen> {

    private final Ohjain ohjain;

    public Logiikka(Ohjain ohjain) {
        this.ohjain = ohjain;
    }

    @Override
    public void paivita() {
        ohjain.kasitteleOhjattavat();
        for (Looginen looginen : getOliot()) {
            looginen.suoritaLogiikka();
        }
    }
}
