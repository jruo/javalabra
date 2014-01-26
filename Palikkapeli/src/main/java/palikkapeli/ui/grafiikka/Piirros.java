package palikkapeli.ui.grafiikka;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import palikkapeli.peli.oliot.PeliOlio;
import palikkapeli.ui.grafiikka.alkeispiirros.Alkeispiirros;
import palikkapeli.ui.grafiikka.alkeispiirros.Kuva;
import palikkapeli.ui.grafiikka.alkeispiirros.Suorakulmio;
import palikkapeli.ui.grafiikka.alkeispiirros.Teksti;

/**
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

    public void piirra(Graphics2D g) {
        for (Alkeispiirros alkeispiirros : osat) {
            alkeispiirros.asetaOrigo(peliOlio.getX(), peliOlio.getY());
            alkeispiirros.piirra(g);
        }
    }

    public Kuva lisaaKuva(int xd, int yd, String kuvanTiedostonimi) {
        Kuva kuva = new Kuva(null, xd, yd);
        osat.add(kuva);
        return kuva;
    }

    public Teksti lisaaTeksti(int xd, int yd, String sisalto, Color vari) {
        Teksti teksti = new Teksti(sisalto, vari, xd, yd);
        osat.add(teksti);
        return teksti;
    }

    public Suorakulmio lisaaSuorakulmio(int xd, int yd, int leveys, int korkeus, Color vari, boolean taytetty) {
        Suorakulmio suorakulmio = new Suorakulmio(xd, yd, leveys, korkeus, vari, taytetty);
        osat.add(suorakulmio);
        return suorakulmio;
    }
}
