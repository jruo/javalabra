package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Vari;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Punainen pelaaja
 *
 * @author Janne Ruoho
 */
public class PunainenPelaaja extends Pelaaja {

    public PunainenPelaaja(int x, int y) {
        super(x, y);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/punainenpelaaja.png", -1);
    }

    @Override
    public Vari getVari() {
        return Vari.PUNAINEN;
    }

}
