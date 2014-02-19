package palikkapeli.peli.olio.apuolio;

import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Näyttää pelaajalle lopputekstit
 *
 * @author Janne Ruoho
 */
public class PeliLoppu extends PeliOlio {

    /**
     * Luo uuden PeliLoppu-olion. Koordinaateilla ei ole merkitystä
     *
     * @param x
     * @param y
     */
    public PeliLoppu(int x, int y) {
        super(x, y);
        this.x = 0;
        this.y = 0;
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/lopputeksti.png");
    }

}
