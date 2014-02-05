package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Seinä, jonka läpi pystyy mahdollisesti kulkemaan
 *
 * @author Janne Ruoho
 */
public class LapaisevaSeina extends PeliOlio {

    public LapaisevaSeina(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public void suoritaOmaLogiikka() {
    }

    @Override
    public Piirros luoOmaPiirros() {
        return null;
    }

    @Override
    public void alusta() {
    }

}
