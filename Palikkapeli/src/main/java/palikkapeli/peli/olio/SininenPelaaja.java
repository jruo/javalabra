package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Sininen pelaaja
 *
 * @author Janne Ruoho
 */
public class SininenPelaaja extends Pelaaja {

    public SininenPelaaja(Peli peli, int x, int y) {
        super(peli, x, y, Vari.SININEN);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/sininenpelaaja.png");
    }

}
