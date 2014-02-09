package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author Janne Ruoho
 */
public class PunainenLaatikko extends Laatikko {

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
