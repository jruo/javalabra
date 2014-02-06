package palikkapeli.peli.taso;

import java.util.ArrayList;
import java.util.List;
import palikkapeli.peli.Peli;

/**
 * Huolehtii tasojen vaihtamisesta
 *
 * @author Janne Ruoho
 */
public final class TasonVaihtaja {

    private static final List<String> tasot = new ArrayList<>();
    private final Peli peli;
    private final TasonLataaja lataaja;
    private int nykyinenTaso;

    static {
        tasot.add("/tasot/taso1");
        tasot.add("/tasot/taso2");
        tasot.add("/tasot/taso3");
    }

    public TasonVaihtaja(Peli peli) {
        this.peli = peli;
        lataaja = new TasonLataaja(peli);
        nykyinenTaso = 0;
    }

    /**
     * Siirtyy pelin seuraavaan tasoon
     */
    public void seuraavaTaso() {
        if (nykyinenTaso < tasot.size()) {
            String tiedostoNimi = tasot.get(nykyinenTaso++);
            Taso taso = lataaja.lataaTaso(tiedostoNimi);
            taso.rakennaTaso();
        } else {
            //peli läpi
        }
    }

    /**
     * Palauttaa listan tasojen tiedostonimistä
     *
     * @return Lista tasoista
     */
    public List<String> getTasot() {
        return tasot;
    }
}
