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
import palikkapeli.ui.grafiikka.alkeispiirros.Viiva;

/**
 * Piirros (kuva, teksti, suorakulmio yms), joka tarjoaa graafisen esityksen
 * PeliOliolle.
 *
 * @author Janne Ruoho
 */
public final class Piirros implements Comparable<Piirros> {

    /**
     * Piirroksen omistajaolio
     */
    private final PeliOlio peliOlio;
    /**
     * Lista piirroksen alkeispiirroksista
     */
    private final List<Alkeispiirros> osat;
    /**
     * Piirroksen piirtosyvyys. Suurimman piirtosyvyyden piirros piirtyy aina
     * alimmaiseksi ja pienimmän ylimmäiseksi
     */
    private final int piirtoSyvyys;

    /**
     * Luo uuden Piirroksen
     *
     * @param omistaja Piirroksen omistaja
     */
    public Piirros(PeliOlio omistaja) {
        this(omistaja, null, 0);
    }

    /**
     * Luo uuden Piirroksen piirtosyvyydellä
     *
     * @param omistaja Piirroksen omistaja
     * @param piirtoSyvyys Piirtosyvyys
     */
    public Piirros(PeliOlio omistaja, int piirtoSyvyys) {
        this(omistaja, null, piirtoSyvyys);
    }

    /**
     * Luo uuden Piirroksen kuvalla
     *
     * @param omistaja Piirroksen omistaja
     * @param kuvanTiedostonimi Kuvan tiedostonimi
     */
    public Piirros(PeliOlio omistaja, String kuvanTiedostonimi) {
        this(omistaja, kuvanTiedostonimi, 0);
    }

    /**
     * Luo uuden Piirroksen kuvalla ja piirtosyvyydellä
     *
     * @param omistaja Piirroksen omistaja
     * @param kuvanTiedostonimi Kuvan tiedostonimi
     * @param piirtoSyvyys Piirtosyvyys
     */
    public Piirros(PeliOlio omistaja, String kuvanTiedostonimi, int piirtoSyvyys) {
        osat = new ArrayList<>();
        peliOlio = omistaja;
        lisaaKuva(0, 0, kuvanTiedostonimi);
        this.piirtoSyvyys = piirtoSyvyys;
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

    /**
     * Lisää viivan piirrokseen
     *
     * @param xd1 Viivan ensimmäinen x-koordinaatti suhteessa origoon
     * @param yd1 Viivan ensimmäinen y-koordinaatti suhteessa origoon
     * @param xd2 Viivan toinen x-koordinaatti suhteessa origoon
     * @param yd2 Viivan toinen y-koordinaatti suhteessa origoon
     * @param vari Viivan väri
     * @return Lisätty viiva
     */
    public Viiva lisaaViiva(int xd1, int yd1, int xd2, int yd2, Color vari) {
        Viiva viiva = new Viiva(xd1, yd1, xd2, yd2, vari);
        osat.add(viiva);
        return viiva;
    }

    @Override
    public int compareTo(Piirros o) {
        //Järjestetään piirtosyvyyden mukaan laskevaan järjestykseen
        return o.piirtoSyvyys - piirtoSyvyys;
    }
}
