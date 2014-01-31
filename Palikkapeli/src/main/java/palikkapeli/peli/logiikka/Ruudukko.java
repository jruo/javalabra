package palikkapeli.peli.logiikka;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import palikkapeli.peli.Peli;

/**
 * Peliruudukko. Jokaiseen ruudukon ruutuun voi sijoittaa T-tyyppisiä olioita
 *
 * @author Janne Ruoho
 * @param <T> Ruudukkoon lisättävien olioiden tyyppi
 */
public final class Ruudukko<T> {

    public static final int RUUDUN_KOKO = 20;

    private final Object lukko = new Object();
    private final Set<T>[][] oliot;
    private final Map<T, Ruutu> sijainnit;
    private final int leveys, korkeus;

    public Ruudukko() {
        leveys = Peli.IKKUNAN_LEVEYS / RUUDUN_KOKO;
        korkeus = Peli.IKKUNAN_KORKEUS / RUUDUN_KOKO;
        oliot = (HashSet<T>[][]) new HashSet<?>[korkeus][leveys]; //???
        sijainnit = new HashMap<>();
        alustaRuudukko();
    }

    /**
     * Alustaa ruudukon listat
     */
    public void alustaRuudukko() {
        for (int i = 0; i < oliot.length; i++) {
            for (int j = 0; j < oliot[i].length; j++) {
                oliot[i][j] = new HashSet<>();
            }
        }
    }

    /**
     * Lisää olion ruudukon ruutuun, jos se ei ole jo siellä
     *
     * @param olio Lisättävä olio
     * @param ruutu Ruutu
     */
    public void lisaaOlio(T olio, Ruutu ruutu) {
        synchronized (lukko) {
            if (!sijainnit.containsKey(olio)) { //Lisätään vain, jos olio ei ole jo ruudukossa
                oliotRuudussa(ruutu).add(olio);
                sijainnit.put(olio, ruutu);
            }
        }
    }

    /**
     * Poistaa olion omasta ruudustaan
     *
     * @param olio Olio
     */
    public void poistaOlio(T olio) {
        synchronized (lukko) {
            if (sijainnit.containsKey(olio)) {
                Ruutu ruutu = sijainnit.get(olio);
                oliotRuudussa(ruutu).remove(olio);
                sijainnit.remove(olio);
            }
        }
    }

    /**
     * Palauttaa ruudun, jossa annettu olio sijaitsee
     *
     * @param olio Olio
     * @return Olion ruutu tai null, jos olio ei sijaitse missään ruudussa
     */
    public Ruutu olionRuutu(T olio) {
        synchronized (lukko) {
            if (sijainnit.containsKey(olio)) {
                return sijainnit.get(olio);
            }
            return null;
        }
    }

    /**
     * Tarkistaa, onko ruudukon ruutu täysin tyhjä olioista
     *
     * @param ruutu Ruutu
     * @return true jos tyhjä, false muutoin
     */
    public boolean onTyhja(Ruutu ruutu) {
        synchronized (lukko) {
            return oliotRuudussa(ruutu).isEmpty();
        }
    }

    /**
     * Tarkistaa, onko annettu olio ruudussa
     *
     * @param ruutu Ruutu
     * @param olio Olio
     * @return true jos on, false muutoin
     */
    public boolean onOlioRuudussa(Ruutu ruutu, T olio) {
        synchronized (lukko) {
            return oliotRuudussa(ruutu).contains(olio);
        }
    }

    /**
     * Tarkistaa onko annetuntyyppistä luokan oliota ruudussa
     *
     * @param tyyppi Olion tyyppi
     * @param ruutu Ruutu
     * @return true jos on, false muutoin
     */
    public boolean onTyyppiRuudussa(Class<? extends T> tyyppi, Ruutu ruutu) {
        synchronized (lukko) {
            Set<T> setti = oliotRuudussa(ruutu);
            for (T olio : setti) {
                if (tyyppi.equals(olio.getClass())) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Palauttaa listan ruudussa olevista olioista
     *
     * @param ruutu Ruutu
     * @return Lista
     */
    public Set<T> oliotRuudussa(Ruutu ruutu) {
        synchronized (lukko) {
            int x = ruutu.getX();
            int y = ruutu.getY();
            if (x < 0 || y < 0 || y >= oliot.length || x >= oliot[y].length) {
                return new HashSet<T>();
            }
            return oliot[ruutu.getY()][ruutu.getX()];
        }
    }

    /**
     * Siirtää olion annettuun ruutuun
     *
     * @param olio Siirrettävä olio
     * @param ruutu Haluttu Ruutu
     */
    public void siirraOlio(T olio, Ruutu ruutu) {
        synchronized (lukko) {
            poistaOlio(olio);
            lisaaOlio(olio, ruutu);
        }
    }

    /**
     * Palauttaa koko ruudukon
     *
     * @return Ruudukko
     */
    public Set<T>[][] getOlioJoukot() {
        return oliot;
    }

    /**
     * Muuttaa annetun koordinaatin ruuduksi
     *
     * @param x X
     * @param y Y
     * @return Ruutu
     */
    public Ruutu xyRuuduksi(int x, int y) {
        return new Ruutu(x / RUUDUN_KOKO, y / RUUDUN_KOKO);
    }

    /**
     * Tarkistaa, onko annettu koordinaatti täysin kohdistettu ruudukkoon
     *
     * @param x X
     * @param y Y
     * @return true jos kohdistettu, false muutoin
     */
    public boolean onKohdistettu(int x, int y) {
        return x % RUUDUN_KOKO == 0 && y % RUUDUN_KOKO == 0;
    }
}
