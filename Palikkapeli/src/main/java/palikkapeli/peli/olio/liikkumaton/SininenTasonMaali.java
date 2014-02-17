package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Sinisen pelaajan maali
 *
 * @author Janne Ruoho
 */
public class SininenTasonMaali extends TasonMaali {

    /**
     * Luo uuden SininenTasonMaali annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public SininenTasonMaali(int x, int y) {
        super(x, y);
    }

    @Override
    public Vari getVari() {
        return Vari.SININEN;
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros piirros = new Piirros(this, 2);
        piirros.lisaaKuva(5, 5, "/kuvat/sininenmaali.png");
        return piirros;
    }
}
