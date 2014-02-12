package palikkapeli.peli.olio.liikkumaton;

import java.awt.Color;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author Janne Ruoho
 */
public class SininenTasonMaali extends TasonMaali {

    public SininenTasonMaali(int x, int y) {
        super(x, y);
    }

    @Override
    public Vari getVari() {
        return Vari.SININEN;
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros p = new Piirros(this);
        p.lisaaSuorakulmio(5, 5, 10, 10, Color.blue, true);
        return p;
    }

}
