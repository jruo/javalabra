package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.ui.grafiikka.alkeispiirros.Muokattava;

/**
 * Debug/testausluokka, joka piirtää ruudulle todellisen logiikan
 * päivitysnopeuden
 *
 * @author Janne Ruoho
 */
public class FPSLaskuri extends PeliOlio {

    private long aika;
    private int laskuri, laskuriMax;
    private Muokattava<String> teksti;

    public FPSLaskuri(Peli peli) {
        super(peli);
        aika = System.currentTimeMillis();
        laskuri = 0;
        laskuriMax = 0;
    }

    public void asetaMuokattavaTeksti(Muokattava<String> teksti) {
        this.teksti = teksti;
    }

    @Override
    public void suoritaLogiikka() {
        if (System.currentTimeMillis() - aika >= 1000) {
            aika = System.currentTimeMillis();
            laskuriMax = laskuri;
            laskuri = 0;
            teksti.muokkaa("FPS: " + laskuriMax);
        }
        laskuri++;
    }
}
