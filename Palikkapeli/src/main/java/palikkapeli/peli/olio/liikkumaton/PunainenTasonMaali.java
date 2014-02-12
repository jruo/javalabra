package palikkapeli.peli.olio.liikkumaton;

import java.awt.Color;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author Janne Ruoho
 */
public class PunainenTasonMaali extends TasonMaali {

    public PunainenTasonMaali(int x, int y) {
        super(x, y);
    }

    @Override
    public Vari getVari() {
        return Vari.PUNAINEN;
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros p = new Piirros(this);
        p.lisaaSuorakulmio(5, 5, 10, 10, Color.red, true);
        return p;
    }

}
