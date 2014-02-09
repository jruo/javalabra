package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Vain sinisiä olioita läpäisevä seinä
 *
 * @author Janne Ruoho
 */
public class SininenLapaisevaSeina extends LapaisevaSeina {

    public SininenLapaisevaSeina(Peli peli, int x, int y) {
        super(peli, x, y);
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
