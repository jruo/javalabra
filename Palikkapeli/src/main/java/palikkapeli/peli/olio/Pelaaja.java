package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.ohjaus.Liikkuva;

/**
 * Pelaajaluokka
 *
 * @author Janne Ruoho
 */
public class Pelaaja extends PeliOlio implements Liikkuva {

    public Pelaaja(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public void suoritaLogiikka() {
    }

    @Override
    public void liikuYlos() {
        y -= 3;
    }

    @Override
    public void liikuAlas() {
        y += 3;
    }

    @Override
    public void liikuVasemmalle() {
        x -= 3;
    }

    @Override
    public void liikuOikealle() {
        x += 3;
    }
}
