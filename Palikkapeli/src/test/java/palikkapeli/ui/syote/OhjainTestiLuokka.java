package palikkapeli.ui.syote;

import palikkapeli.peli.logiikka.ohjaus.Liikkuva;

/**
 *
 * @author Janne Ruoho
 */
public class OhjainTestiLuokka implements Liikkuva {

    private int x, y;

    public OhjainTestiLuokka(int x, int y) {
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
    public void liikuYlos() {
        y--;
    }

    @Override
    public void liikuAlas() {
        y++;
    }

    @Override
    public void liikuVasemmalle() {
        x--;
    }

    @Override
    public void liikuOikealle() {
        x++;
    }

}
