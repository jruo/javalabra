package palikkapeli.ui.grafiikka;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.grafiikka.alkeispiirros.Alkeispiirros;
import palikkapeli.ui.grafiikka.alkeispiirros.Kuva;
import palikkapeli.ui.grafiikka.alkeispiirros.Suorakulmio;
import palikkapeli.ui.grafiikka.alkeispiirros.Teksti;

/**
 * Piirros (kuva, teksti, suorakulmio yms), joka tarjoaa graafisen esityksen
 * PeliOliolle.
 *
 * @author Janne Ruoho
 */
public final class Piirros {

    private final PeliOlio peliOlio;
    private final List<Alkeispiirros> osat;

    public Piirros(PeliOlio omistaja) {
        this(omistaja, null);
    }

    public Piirros(PeliOlio omistaja, String kuvanTiedostonimi) {
        osat = new ArrayList<>();
        peliOlio = omistaja;
        lisaaKuva(0, 0, kuvanTiedostonimi);
    }

    /**
     * Piirtää tämän piirroksen alkeispiirrokset
     *
     * @param g Grafiikka
     */
    public void piirra(Graphics2D g) {
        for (Alkeispiirros alkeispiirros : osat) {
            alkeispiirros.asetaOrigo(peliOlio.getX(), peliOlio.getY());
            alkeispiirros.piirra(g);
        }
    }

    /**
     * Lisää kuvan piirrokseen
     *
     * @param xd Kuvan x-koordinaatti suhteessa origoon
     * @param yd Kuvan y-koordinaatti suhteessa origoon
     * @param kuvanTiedostonimi Kuvan tiedostonimi
     * @return Lisätty Kuva-alkeispiirros
     */
    public Kuva lisaaKuva(int xd, int yd, String kuvanTiedostonimi) {
        if (kuvanTiedostonimi == null) {
            return null;
        }
        Kuva kuva = new Kuva(KuvanLataaja.lataaKuva(kuvanTiedostonimi), xd, yd);
        osat.add(kuva);
        return kuva;
    }

    /**
     * Lisää tekstin piirrokseen
     *
     * @param xd Tekstin x-koordinaatti suhteessa origoon
     * @param yd Tekstin y-koordinaatti suhteessa origoon
     * @param sisalto Tekstin sisältö
     * @param vari Tekstin väri
     * @return Lisätty Teksti-alkeispiirros
     */
    public Teksti lisaaTeksti(int xd, int yd, String sisalto, Color vari) {
        Teksti teksti = new Teksti(sisalto, vari, xd, yd);
        osat.add(teksti);
        return teksti;
    }

    /**
     * Lisää suorakulmion piirrokseen
     *
     * @param xd Suorakulmion x-koordinaatti suhteessa origoon
     * @param yd Suorakulmion y-koordinaatti suhteessa origoon
     * @param leveys Suorakulmion leveys
     * @param korkeus Suorakulmion korkeus
     * @param vari Suorakulmion väri
     * @param taytetty true, jos suorakulmion tulisi olla täytetty, false jos
     * pelkät ääriviivat piirretään
     * @return Lisätty Suorakulmio
     */
    public Suorakulmio lisaaSuorakulmio(int xd, int yd, int leveys, int korkeus, Color vari, boolean taytetty) {
        Suorakulmio suorakulmio = new Suorakulmio(xd, yd, leveys, korkeus, vari, taytetty);
        osat.add(suorakulmio);
        return suorakulmio;
    }
}
