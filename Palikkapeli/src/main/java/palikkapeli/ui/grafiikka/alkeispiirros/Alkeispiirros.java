package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Graphics2D;

/**
 *
 * @author Janne Ruoho
 */
public abstract class Alkeispiirros {

    private int kohdeX, kohdeY;
    protected int x, y;

    public Alkeispiirros() {
        kohdeX = 0;
        kohdeY = 0;
    }

    public Alkeispiirros(int x, int y) {
        kohdeX = x;
        kohdeY = y;
    }

    public void asetaOrigo(int x, int y) {
        this.x = x + kohdeX;
        this.y = y + kohdeY;
    }

    public abstract void piirra(Graphics2D g);
}
