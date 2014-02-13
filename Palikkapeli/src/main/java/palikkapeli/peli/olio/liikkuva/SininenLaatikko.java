package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Sininen liikutettava laatikko
 *
 * @author Janne Ruoho
 */
public class SininenLaatikko extends Laatikko {

    /**
     * Luo uuden SininenLaatikko-olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public SininenLaatikko(int x, int y) {
        super(x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/sininenlaatikko.png");
    }

    @Override
    public Vari getVari() {
        return Vari.SININEN;
    }

}
