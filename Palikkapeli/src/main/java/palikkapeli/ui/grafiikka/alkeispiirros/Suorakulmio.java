package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Suorakulmio-alkeispiirros
 *
 * @author Janne Ruoho
 */
public class Suorakulmio extends Alkeispiirros {

    private final int leveys, korkeus;
    private final Color vari;
    private final boolean taytetty;

    public Suorakulmio(int x, int y, int leveys, int korkeus, Color vari, boolean taytetty) {
        super(x, y);
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.vari = vari;
        this.taytetty = taytetty;
    }

    @Override
    public void piirra(Graphics2D g) {
        g.setColor(vari);
        if (taytetty) {
            g.fillRect(x, y, leveys, korkeus);
        } else {
            g.drawRect(x, y, leveys, korkeus);
        }
    }
}
