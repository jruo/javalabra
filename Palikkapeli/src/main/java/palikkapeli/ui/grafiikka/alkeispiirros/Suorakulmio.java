package palikkapeli.ui.grafiikka.alkeispiirros;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Suorakulmio-alkeispiirros
 *
 * @author Janne Ruoho
 */
public class Suorakulmio extends Alkeispiirros {

    /**
     * Suorakulmion leveys ja korkeus
     */
    private final int leveys, korkeus;
    /**
     * Suorakulmion väri
     */
    private final Color vari;
    /**
     * Onko suorakulmio täytetty vai pelkät ääriviivat
     */
    private final boolean taytetty;

    /**
     * Luo uuden Suorakulmion
     *
     * @param x X-koordinaatti
     * @param y Y-koordinaatti
     * @param leveys Leveys
     * @param korkeus Korkeus
     * @param vari Väri
     * @param taytetty true jos täytetty, false jos ääriviivat
     */
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
