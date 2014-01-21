package palikkapeli.peli.grafiikka;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import palikkapeli.peli.Peli;
import palikkapeli.peli.PeliSilmukka;
import palikkapeli.ui.PiirtoPaneeli;

/**
 * Huolehtii pelin grafiikan piirtämisestä
 *
 * @author Janne Ruoho
 */
public class Grafiikka extends PeliSilmukka<Graafinen> {

    private final BufferedImage puskuriKuva;
    private final Graphics2D paneelinGrafiikka;
    private final Graphics2D kuvanGrafiikka;

    public Grafiikka(PiirtoPaneeli piirtoPaneeli) {
        paneelinGrafiikka = (Graphics2D) piirtoPaneeli.getGraphics();
        puskuriKuva = new BufferedImage(Peli.IKKUNAN_LEVEYS, Peli.IKKUNAN_KORKEUS, BufferedImage.TYPE_INT_RGB);
        kuvanGrafiikka = puskuriKuva.createGraphics();
    }

    @Override
    public void paivita() {
        kuvanGrafiikka.setColor(Color.LIGHT_GRAY);
        kuvanGrafiikka.fillRect(0, 0, Peli.IKKUNAN_LEVEYS, Peli.IKKUNAN_KORKEUS);
        for (Graafinen graafinen : getOliot()) {
            graafinen.piirra(kuvanGrafiikka);
        }
        paneelinGrafiikka.drawImage(puskuriKuva, 0, 0, null);
    }
}
