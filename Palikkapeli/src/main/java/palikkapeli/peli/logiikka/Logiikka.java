package palikkapeli.peli.logiikka;

import palikkapeli.peli.PeliSilmukka;
import palikkapeli.ui.syote.Ohjain;

/**
 * Huolehtii pelin logiikasta
 *
 * @author Janne Ruoho
 */
public final class Logiikka extends PeliSilmukka<Looginen> {

    /**
     * Ohjain, joka käsittelee pelaajan syötteen välittämisen logiikalle
     */
    private final Ohjain ohjain;

    /**
     * Luo uuden Logiikka-olion
     *
     * @param ohjain Ohjain
     */
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
