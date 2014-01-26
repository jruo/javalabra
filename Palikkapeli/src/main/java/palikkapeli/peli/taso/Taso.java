package palikkapeli.peli.taso;

import palikkapeli.peli.Peli;
import palikkapeli.ui.grafiikka.Grafiikka;
import palikkapeli.peli.logiikka.Logiikka;

/**
 *
 * @author Janne Ruoho
 */
public class Taso {

    private final Logiikka logiikka;
    private final Grafiikka grafiikka;

    public Taso(Peli peli) {
        logiikka = peli.getLogiikka();
        grafiikka = peli.getGrafiikka();
    }

    public void luo() {

    }

}
