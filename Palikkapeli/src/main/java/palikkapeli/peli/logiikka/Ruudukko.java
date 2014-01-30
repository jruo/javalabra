package palikkapeli.peli.logiikka;

import java.util.HashSet;
import java.util.Set;
import palikkapeli.peli.Peli;
import palikkapeli.peli.olio.PeliOlio;

/**
 * Peliruudukko. Jokaiseen ruudukon ruutuun voi sijoittaa PeliOlioita
 *
 * @author Janne Ruoho
 */
public final class Ruudukko {

    public static final int RUUDUN_KOKO = 20;

    private final Set<PeliOlio>[][] oliot;
    private final int leveys, korkeus;

    public Ruudukko() {
        leveys = Peli.IKKUNAN_LEVEYS / RUUDUN_KOKO;
        korkeus = Peli.IKKUNAN_KORKEUS / RUUDUN_KOKO;
        oliot = (HashSet<PeliOlio>[][]) new HashSet<?>[korkeus][leveys]; //???
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
    public void lisaaOlio(PeliOlio olio, Ruutu ruutu) {
        if (olionRuutu(olio) == null) { //Lisätään vain, jos olio ei ole jo ruudukossa
            oliotRuudussa(ruutu).add(olio);
        }
    }

    /**
     * Poistaa olion omasta ruudustaan
     *
     * @param olio Olio
     */
    public void poistaOlio(PeliOlio olio) {
        Ruutu ruutu = olionRuutu(olio);
        if (ruutu != null) {
            oliotRuudussa(ruutu).remove(olio);
        }
    }

    /**
     * Palauttaa ruudun, jossa annettu olio sijaitsee
     *
     * @param olio Olio
     * @return Olion ruutu tai null, jos olio ei sijaitse missään ruudussa
     */
    public Ruutu olionRuutu(PeliOlio olio) {
        for (int i = 0; i < oliot.length; i++) {
            for (int j = 0; j < oliot[i].length; j++) {
                if (oliot[i][j].contains(olio)) {
                    return new Ruutu(j, i);
                }
            }
        }
        return null;
    }

    /**
     * Tarkistaa, onko ruudukon ruutu täysin tyhjä
     *
     * @param ruutu Ruutu
     * @return true jos tyhjä, false muutoin
     */
    public boolean onTyhja(Ruutu ruutu) {
        return oliotRuudussa(ruutu).isEmpty();
    }

    /**
     * Tarkistaa, onko annettu olio ruudussa
     *
     * @param ruutu Ruutu
     * @param olio Olio
     * @return true jos on, false muutoin
     */
    public boolean onOlioRuudussa(Ruutu ruutu, PeliOlio olio) {
        return oliotRuudussa(ruutu).contains(olio);
    }

    /**
     * Palauttaa listan ruudussa olevista olioista
     *
     * @param ruutu Ruutu
     * @return Lista
     */
    public Set<PeliOlio> oliotRuudussa(Ruutu ruutu) {
        return oliot[ruutu.getY()][ruutu.getX()];
    }

    /**
     * Palauttaa koko ruudukon
     *
     * @return Ruudukko
     */
    public Set<PeliOlio>[][] getOlioListat() {
        return oliot;
    }

    /**
     * Muuttaa annetun koordinaatin ruuduksi
     *
     * @param x X
     * @param y Y
     * @return Ruutu
     */
    public static Ruutu xyRuuduksi(int x, int y) {
        return new Ruutu(x / RUUDUN_KOKO, y / RUUDUN_KOKO);
    }

    /**
     * Tarkistaa, onko annettu koordinaatti täysin kohdistettu ruudukkoon
     *
     * @param x X
     * @param y Y
     * @return true jos kohdistettu, false muutoin
     */
    public static boolean onKohdistettu(int x, int y) {
        return x % RUUDUN_KOKO == 0 && y % RUUDUN_KOKO == 0;
    }
}
