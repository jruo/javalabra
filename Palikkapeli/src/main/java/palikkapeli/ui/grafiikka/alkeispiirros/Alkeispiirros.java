package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Graphics2D;

/**
 * Yliluokka piirroksen alkeisosille
 *
 * @author Janne Ruoho
 */
public abstract class Alkeispiirros {

    private final int kohdeX, kohdeY;
    protected int x, y;

    public Alkeispiirros() {
        kohdeX = 0;
        kohdeY = 0;
    }

    public Alkeispiirros(int x, int y) {
        kohdeX = x;
        kohdeY = y;
    }

    /**
     * Asettaa piirroksen origon
     *
     * @param x Origon x-koordinaatti
     * @param y Origon y-koordinaatti
     */
    public void asetaOrigo(int x, int y) {
        this.x = x + kohdeX;
        this.y = y + kohdeY;
    }

    /**
     * Piirtää alkeispiirroksen
     *
     * @param g Grafiikka
     */
    public abstract void piirra(Graphics2D g);
}
