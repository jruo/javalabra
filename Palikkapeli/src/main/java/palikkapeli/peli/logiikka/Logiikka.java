package palikkapeli.peli.logiikka;

import palikkapeli.peli.PeliSilmukka;

/**
 * Huolehtii pelin logiikasta
 *
 * @author Janne Ruoho
 */
public class Logiikka extends PeliSilmukka<Looginen> {

    @Override
    public void paivita() {
        for (Looginen looginen : getPaivitettavat()) {
            looginen.suoritaLogiikka();
        }
    }
}
