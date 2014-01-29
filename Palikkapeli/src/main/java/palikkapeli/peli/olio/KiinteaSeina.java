package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.ui.grafiikka.Piirros;

/**
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

}
