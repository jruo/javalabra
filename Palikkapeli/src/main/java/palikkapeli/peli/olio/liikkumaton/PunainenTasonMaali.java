package palikkapeli.peli.olio.liikkumaton;

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
        Piirros piirros = new Piirros(this);
        piirros.lisaaKuva(5, 5, "/kuvat/punainenmaali.png");
        return piirros;
    }

}
