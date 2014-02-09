package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Seinä, jonka läpi ei voi kulkea, eikä sitä voi liikuttaa
 *
 * @author Janne Ruoho
 */
public class KiinteaSeina extends PeliOlio {

    public KiinteaSeina(int x, int y) {
        super(x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/kiinteaseina.png");
    }
}
