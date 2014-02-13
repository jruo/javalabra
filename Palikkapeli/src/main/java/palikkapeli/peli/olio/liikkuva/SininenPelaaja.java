package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Sininen pelaaja
 *
 * @author Janne Ruoho
 */
public class SininenPelaaja extends Pelaaja {

    /**
     * Luo uuden SininenPelaaja-olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public SininenPelaaja(int x, int y) {
        super(x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/sininenpelaaja.png", -1);
    }

    @Override
    public Vari getVari() {
        return Vari.SININEN;
    }

}
