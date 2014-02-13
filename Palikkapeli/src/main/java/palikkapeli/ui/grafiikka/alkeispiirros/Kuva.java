package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Kuva-alkeispiirros
 *
 * @author Janne Ruoho
 */
public class Kuva extends Alkeispiirros {

    /**
     * Kuva
     */
    private final BufferedImage kuva;

    /**
     * Luo uuden Kuvan
     *
     * @param kuva Kuva
     * @param x X
     * @param y Y
     */
    public Kuva(BufferedImage kuva, int x, int y) {
        super(x, y);
        this.kuva = kuva;
    }

    @Override
    public void piirra(Graphics2D g) {
        g.drawImage(kuva, x, y, null);
    }
}
