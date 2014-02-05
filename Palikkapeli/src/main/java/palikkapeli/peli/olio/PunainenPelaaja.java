package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Punainen pelaaja
 *
 * @author Janne Ruoho
 */
public class PunainenPelaaja extends Pelaaja {

    public PunainenPelaaja(Peli peli, int x, int y) {
        super(peli, x, y, Vari.PUNAINEN);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/punainenpelaaja.png");
    }

}
