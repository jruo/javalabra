package palikkapeli.peli.olio.liikkuva;

import java.awt.Color;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author Janne Ruoho
 */
public class SininenLaatikko extends Laatikko {

    public SininenLaatikko(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros p = new Piirros(this);
        p.lisaaSuorakulmio(0, 0, 20, 20, Color.blue, true);
        return p;
    }

    @Override
    public Vari getVari() {
        return Vari.SININEN;
    }

}
