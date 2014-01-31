package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author Janne Ruoho
 */
public class PeliOlioTestiLuokka extends PeliOlio {

    public PeliOlioTestiLuokka(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this);
    }

    @Override
    public void suoritaOmaLogiikka() {
    }
}
