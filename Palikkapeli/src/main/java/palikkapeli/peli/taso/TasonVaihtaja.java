package palikkapeli.peli.taso;

import java.util.ArrayList;
import palikkapeli.peli.Peli;
import palikkapeli.peli.oliot.FPSLaskuri;
import palikkapeli.peli.oliot.Pelaaja;

/**
 * Huolehtii tasojen vaihtamisesta
 *
 * @author Janne Ruoho
 */
public class TasonVaihtaja {

    private final Peli peli;

    public TasonVaihtaja(Peli peli) {
        this.peli = peli;
        luoTestiTaso();
    }

    /**
     * testausmetodi
     */
    private void luoTestiTaso() {
        ArrayList<Pelaaja> lista = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Pelaaja p = new Pelaaja(peli, 10 + i, 10);
            lista.add(p);
        }
        FPSLaskuri laskuri = new FPSLaskuri(peli);
        peli.getLogiikka().lisaaOliot(laskuri);
        peli.getGrafiikka().lisaaOliot(laskuri);
        peli.getLogiikka().lisaaOliot(lista);
        peli.getGrafiikka().lisaaOliot(lista);

        peli.getLogiikka().kaynnista();
        peli.getGrafiikka().kaynnista();
    }
}
