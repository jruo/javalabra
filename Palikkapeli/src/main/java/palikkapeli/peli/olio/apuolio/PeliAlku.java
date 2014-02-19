package palikkapeli.peli.olio.apuolio;

import palikkapeli.peli.logiikka.ohjaus.Aktivoitava;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.grafiikka.Piirros;
import palikkapeli.ui.syote.Nappain;

/**
 * Näyttää pelaajalle alkutekstit
 *
 * @author Janne Ruoho
 */
public class PeliAlku extends PeliOlio implements Aktivoitava {

    /**
     * Luo uuden PeliAlku-olion. Koordinaateilla ei ole merkitystä
     *
     * @param x
     * @param y
     */
    public PeliAlku(int x, int y) {
        super(x, y);
        this.x = 0;
        this.y = -5000;
    }

    @Override
    public void suoritaLogiikka() {
        if (y < 0) {
            y /= 1.04;
        }
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/alkuteksti.png");
    }

    @Override
    public void aktivoidu() {
        peli.getTasonVaihtaja().seuraavaTaso();
    }

    @Override
    public Nappain getAktivoivaNappain() {
        return Nappain.ENTER;
    }

}
