package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Viiva-alkeispiirros
 *
 * @author Janne Ruoho
 */
public class Viiva extends Alkeispiirros {

    private final int x1, y1, x2, y2;
    private final Color vari;

    public Viiva(int x1, int y1, int x2, int y2, Color vari) {
        super(x1, y1);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.vari = vari;
    }

    @Override
    public void piirra(Graphics2D g) {
        g.setColor(vari);
        g.drawLine(x, y, x + (x2 - x1), y + (y2 - y1));
    }
}
