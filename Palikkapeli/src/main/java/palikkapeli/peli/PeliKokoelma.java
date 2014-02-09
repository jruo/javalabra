package palikkapeli.peli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Kokoelma T-tyyppisiä olioita
 *
 * @author Janne Ruoho
 * @param <T> Kokoelmaan lisättävien olioiden tyyppi
 */
public abstract class PeliKokoelma<T> {

    private final List<T> oliot;

    public PeliKokoelma() {
        oliot = new ArrayList<>();
    }

    /**
     * Lisaa annetun olion kokoelmaan
     *
     * @param lisattava Lisättävä olio
     */
    public final void lisaa(T lisattava) {
        if (lisattava == null || oliot.contains(lisattava)) {
            return;
        }
        oliot.add(lisattava);
    }

    /**
     * Lisää kaikki annetut oliot kokoelmaan
     *
     * @param lisattavat Lisättävät oliot
     */
    public final void lisaa(T... lisattavat) {
        for (T lisattava : lisattavat) {
            lisaa(lisattava);
        }
    }

    /**
     * Lisää kaikki annetut oliot kokoelmaan
     *
     * @param lisattavat Lisättävät oliot
     */
    public final void lisaa(Collection<? extends T> lisattavat) {
        for (T t : lisattavat) {
            lisaa(t);
        }
    }

    /**
     * Poistaa annetun olion kokoelmasta
     *
     * @param poistettava Poistettava olio
     */
    public final void poista(T poistettava) {
        if (oliot.contains(poistettava)) {
            oliot.remove(poistettava);
        }
    }

    /**
     * Tyhjentää kokoelman
     */
    public final void tyhjenna() {
        oliot.clear();
    }

    /**
     * Palauttaa listan kokoelman olioista
     *
     * @return Lista
     */
    public final List<T> getOliot() {
        return oliot;
    }

}
