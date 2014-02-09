package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author Janne Ruoho
 */
public class PunainenLapaisevaSeina extends LapaisevaSeina {

    public PunainenLapaisevaSeina(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/punainenseina.png", 1);
    }

    @Override
    public Vari getVari() {
        return Vari.PUNAINEN;
    }

}
