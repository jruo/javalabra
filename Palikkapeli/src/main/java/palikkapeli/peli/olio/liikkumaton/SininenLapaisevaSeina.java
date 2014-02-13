package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Sinisen värin läpäisevä seinä
 *
 * @author Janne Ruoho
 */
public class SininenLapaisevaSeina extends LapaisevaSeina {

    /**
     * Luo uuden SininenLapaisevaSeina-olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y y
     */
    public SininenLapaisevaSeina(int x, int y) {
        super(x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/sininenseina.png", 1);
    }

    @Override
    public Vari getVari() {
        return Vari.SININEN;
    }

}
