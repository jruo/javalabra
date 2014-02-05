package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Seinä, jonka läpi ei voi kulkea, eikä sitä voi liikuttaa
 *
 * @author Janne Ruoho
 */
public class KiinteaSeina extends PeliOlio {

    public KiinteaSeina(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/kiinteaseina.png");
    }

    @Override
    public void suoritaOmaLogiikka() {
    }

    @Override
    public void alusta() {
    }

}
