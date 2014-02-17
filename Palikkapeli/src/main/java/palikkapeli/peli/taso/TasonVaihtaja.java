package palikkapeli.peli.taso;

import java.util.ArrayList;
import java.util.List;

/**
 * Huolehtii tasojen vaihtamisesta
 *
 * @author Janne Ruoho
 */
public final class TasonVaihtaja {

    /**
     * Lista tasojen tiedostonimistä
     */
    private static final List<String> tasot = new ArrayList<>();
    /**
     * TasonLataaja, joka lataa tasot tiedostoista
     */
    private final TasonLataaja lataaja;
    /**
     * Tämänhetkinen taso
     */
    private int nykyinenTaso;

    static {
        tasot.add("/tasot/tasoPeliAlku");
        tasot.add("/tasot/taso1");
        tasot.add("/tasot/taso2");
        tasot.add("/tasot/taso3");
        tasot.add("/tasot/tasoPeliLoppu");
    }

    /**
     * Luo uuden TasonVaihtajan
     */
    public TasonVaihtaja() {
        lataaja = new TasonLataaja();
        nykyinenTaso = -1;
    }

    /**
     * Siirtyy pelin seuraavaan tasoon
     */
    public void seuraavaTaso() {
        if (nykyinenTaso < tasot.size() - 1) {
            String tiedostonimi = tasot.get(++nykyinenTaso);
            luoTaso(tiedostonimi);
        } else {
            //peli läpi
        }
    }

    /**
     * Resetoi pelin nykyisen tason
     */
    public void resetoiNykyinenTaso() {
        String tiedostonimi = tasot.get(nykyinenTaso);
        luoTaso(tiedostonimi);
    }

    /**
     * Luo tason annetusta tiedostosta
     *
     * @param tiedostonimi Tasotiedoston tiedostonimi
     */
    public void luoTaso(String tiedostonimi) {
        Taso taso = lataaja.lataaTaso(tiedostonimi);
        taso.rakennaTaso();
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
