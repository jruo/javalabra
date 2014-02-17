package palikkapeli.peli.olio.apuolio;

import java.awt.Color;
import java.awt.Font;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.grafiikka.Piirros;
import palikkapeli.ui.grafiikka.alkeispiirros.Teksti;

/**
 * Näyttää pelaajalle lopputekstit
 *
 * @author Janne Ruoho
 */
public class PeliLoppu extends PeliOlio {

    /**
     * Luo uuden PeliLoppu-olion. Koordinaateilla ei ole merkitystä
     *
     * @param x
     * @param y
     */
    public PeliLoppu(int x, int y) {
        super(x, y);
        this.x = 0;
        this.y = 0;
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros p = new Piirros(this);
        Teksti teksti = p.lisaaTeksti(70, 180, "Pääsit pelin läpi!", Color.BLACK);
        Font fontti = new Font("Arial", 1, 37);
        teksti.setFontti(fontti);

        Teksti teksti2 = p.lisaaTeksti(100, 220, "Janne Ruoho 2014 - Ohjelmoinnin harjoitustyö", Color.GRAY);
        Font fontti2 = new Font("Arial", 0, 13);
        teksti2.setFontti(fontti2);
        return p;
    }

}
