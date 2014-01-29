package palikkapeli.peli.logiikka;

/**
 *
 * @author Janne Ruoho
 */
public class LooginenTestiLuokka implements Looginen {

    private int laskuri;

    public LooginenTestiLuokka() {
        laskuri = 0;
    }

    public int getLaskuri() {
        return laskuri;
    }

    @Override
    public void suoritaLogiikka() {
        laskuri++;
    }
}
