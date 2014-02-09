package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Sininen pelaaja
 *
 * @author Janne Ruoho
 */
public class SininenPelaaja extends Pelaaja {

    public SininenPelaaja(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/sininenpelaaja.png", -1);
    }

    @Override
    public Vari getVari() {
        return Vari.SININEN;
    }

}
