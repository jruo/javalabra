package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Teksti-alkeispiirros
 *
 * @author Janne Ruoho
 */
public class Teksti extends Alkeispiirros implements Muokattava<String> {

    /**
     * Tekstin sisältä
     */
    private String teksti;
    /**
     * Tekstin väri
     */
    private final Color vari;
    /**
     * Tekstin fontti
     */
    private Font fontti;

    /**
     * Luo uuden Tekstin
     *
     * @param teksti Tekstin sisältö
     * @param vari Tekstin väri
     * @param x X-koordinaatti
     * @param y Y-koordinaatti
     */
    public Teksti(String teksti, Color vari, int x, int y) {
        super(x, y);
        this.teksti = teksti;
        this.vari = vari;
    }

    /**
     * Asettaa tekstin fontin
     *
     * @param fontti Fontti
     */
    public void setFontti(Font fontti) {
        this.fontti = fontti;
    }

    @Override
    public void piirra(Graphics2D g) {
        if (fontti != null) {
            g.setFont(fontti);
        }
        g.setColor(vari);
        g.drawString(teksti, x, y);
    }

    @Override
    public void muokkaa(String muokkaus) {
        teksti = muokkaus;
    }
}
