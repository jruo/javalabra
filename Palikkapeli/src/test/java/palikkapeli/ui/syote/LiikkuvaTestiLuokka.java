package palikkapeli.ui.syote;

import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.ohjaus.Liikkuva;

/**
 *
 * @author Janne Ruoho
 */
public class LiikkuvaTestiLuokka implements Liikkuva {

    private int x, y;

    public LiikkuvaTestiLuokka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void liiku(Suunta suunta) {
        x += suunta.getXSuunta();
        y += suunta.getYSuunta();
    }

}
