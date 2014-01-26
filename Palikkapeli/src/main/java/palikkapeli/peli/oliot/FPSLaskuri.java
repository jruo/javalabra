package palikkapeli.peli.oliot;

import palikkapeli.peli.Peli;
import palikkapeli.ui.grafiikka.alkeispiirros.Muokattava;

/**
 * Debug/testausluokka, joka piirtää ruudulle todellisen logiikan
 * päivitysnopeuden
 *
 * @author Janne Ruoho
 */
public class FPSLaskuri extends PeliOlio {

    private long logiikkaAika;
    private int logiikkaLaskuri, logiikkaMaxLaskuri;
    private Muokattava<String> teksti;

    public FPSLaskuri(Peli peli) {
        super(peli);
        logiikkaAika = System.currentTimeMillis();
        logiikkaLaskuri = 0;
        logiikkaMaxLaskuri = 0;
    }

    public void asetaMuokattavaTeksti(Muokattava<String> teksti) {
        this.teksti = teksti;
    }

    @Override
    public void suoritaLogiikka() {
        if (System.currentTimeMillis() - logiikkaAika >= 1000) {
            logiikkaAika = System.currentTimeMillis();
            logiikkaMaxLaskuri = logiikkaLaskuri;
            logiikkaLaskuri = 0;
            teksti.muokkaa("FPS: " + logiikkaMaxLaskuri);
        }
        logiikkaLaskuri++;
    }
}
