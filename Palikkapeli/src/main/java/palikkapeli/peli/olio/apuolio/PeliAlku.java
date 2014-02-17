package palikkapeli.peli.olio.apuolio;

import java.awt.Color;
import java.awt.Font;
import palikkapeli.peli.logiikka.ohjaus.Aktivoitava;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.grafiikka.Piirros;
import palikkapeli.ui.grafiikka.alkeispiirros.Teksti;
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
            y /= 1.05;
        }
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros p = new Piirros(this);
        Teksti teksti = p.lisaaTeksti(110, 170, "PALIKKAPELI", Color.BLACK);
        Font fontti = new Font("Arial", 1, 37);
        teksti.setFontti(fontti);

        Teksti teksti2 = p.lisaaTeksti(140, 200, "Paina [Enter] jatkaaksesi", Color.BLACK);
        Font fontti2 = new Font("Arial", 1, 15);
        teksti2.setFontti(fontti2);
        return p;
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
