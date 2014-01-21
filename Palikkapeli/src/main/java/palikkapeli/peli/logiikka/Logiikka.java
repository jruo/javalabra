package palikkapeli.peli.logiikka;

import palikkapeli.peli.PeliSilmukka;
import palikkapeli.ui.syote.Nappaimisto;

/**
 * Huolehtii pelin logiikasta
 *
 * @author Janne Ruoho
 */
public class Logiikka extends PeliSilmukka<Looginen> {

    private final Nappaimisto nappaimisto;

    public Logiikka(Nappaimisto nappaimisto) {
        this.nappaimisto = nappaimisto;
    }

    @Override
    public void paivita() {
        nappaimisto.synkronoi();
        for (Looginen looginen : getOliot()) {
            looginen.suoritaLogiikka();
        }
    }
}
