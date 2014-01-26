package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Janne Ruoho
 */
public class Teksti extends Alkeispiirros implements Muokattava<String> {

    private String teksti;
    private Color vari;

    public Teksti(String teksti, Color vari, int x, int y) {
        super(x, y);
        this.teksti = teksti;
        this.vari = vari;
    }

    @Override
    public void piirra(Graphics2D g) {
        g.setColor(vari);
        g.drawString(teksti, x, y);
    }

    @Override
    public void muokkaa(String muokkaus) {
        teksti = muokkaus;
    }
}
