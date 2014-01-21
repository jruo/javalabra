package palikkapeli.peli.oliot;

import java.awt.Color;
import java.awt.Graphics2D;
import palikkapeli.peli.Peli;

/**
 * Debug/testausluokka, joka piirtää ruudulle todellisen logiikan ja grafiikan
 * päivitysnopeuden
 *
 * @author Janne Ruoho
 */
public class FPSLaskuri extends PeliOlio {

    private long logiikkaAika, grafiikkaAika;
    private int logiikkaLaskuri, logiikkaMaxLaskuri;
    private int grafiikkaLaskuri, grafiikkaMaxLaskuri;

    public FPSLaskuri(Peli peli) {
        super(peli);
        logiikkaAika = System.currentTimeMillis();
        grafiikkaAika = System.currentTimeMillis();
        logiikkaLaskuri = 0;
        grafiikkaLaskuri = 0;
        logiikkaMaxLaskuri = 0;
        grafiikkaMaxLaskuri = 0;
    }

    @Override
    public void suoritaLogiikka() {
        if (System.currentTimeMillis() - logiikkaAika >= 1000) {
            logiikkaAika = System.currentTimeMillis();
            logiikkaMaxLaskuri = logiikkaLaskuri;
            logiikkaLaskuri = 0;
        }
        logiikkaLaskuri++;
    }

    @Override
    public void piirra(Graphics2D g) {
        if (System.currentTimeMillis() - grafiikkaAika >= 1000) {
            grafiikkaAika = System.currentTimeMillis();
            grafiikkaMaxLaskuri = grafiikkaLaskuri;
            grafiikkaLaskuri = 0;
        }
        grafiikkaLaskuri++;

        g.setColor(Color.RED);
        g.drawString("L: " + logiikkaMaxLaskuri + ", G: " + grafiikkaMaxLaskuri, 5, 15);
    }
}
