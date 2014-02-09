package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author Janne Ruoho
 */
public class SininenLaatikko extends Laatikko {

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
