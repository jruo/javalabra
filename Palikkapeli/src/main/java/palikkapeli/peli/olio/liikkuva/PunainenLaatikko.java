package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Punainen liikutettava laatikko
 *
 * @author Janne Ruoho
 */
public class PunainenLaatikko extends Laatikko {

    /**
     * Luo uuden PunainenLaatikko-olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public PunainenLaatikko(int x, int y) {
        super(x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/punainenlaatikko.png");
    }

    @Override
    public Vari getVari() {
        return Vari.PUNAINEN;
    }

}
