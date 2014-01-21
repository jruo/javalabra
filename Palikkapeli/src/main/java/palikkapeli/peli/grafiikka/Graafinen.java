package palikkapeli.peli.grafiikka;

import java.awt.Graphics2D;

/**
 * Rajapinta kaikille pelin oliolle, joiden tulee piirtää jotain
 *
 * @author Janne Ruoho
 */
public interface Graafinen {

    /**
     * Metodi, johon olion piirtokoodi tulee sijoittaa
     *
     * @param g Grafiikkaolio
     */
    public void piirra(Graphics2D g);
}
