package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Graphics2D;

/**
 * Yliluokka piirroksen alkeisosille
 *
 * @author Janne Ruoho
 */
public abstract class Alkeispiirros {

    /**
     * Koordinaatit, joihin alkeispiirros tulisi piirtää suhteessa origon
     * koordinaatteihin
     */
    private final int kohdeX, kohdeY;
    /**
     * Absoluuttiset koordinaatit, joihin alkeispiirros tulisi piirtää
     */
    protected int x, y;

    /**
     * Luo uuden Alkeispiirroksen koordinaatteihin (0, 0)
     */
    public Alkeispiirros() {
        kohdeX = 0;
        kohdeY = 0;
    }

    /**
     * Luo uuden Alkeispiirroksen annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
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
    public final void asetaOrigo(int x, int y) {
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
