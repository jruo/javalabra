package palikkapeli.ui.grafiikka;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Collections;
import palikkapeli.peli.Peli;
import palikkapeli.peli.PeliSilmukka;
import palikkapeli.ui.PiirtoPaneeli;

/**
 * Huolehtii pelin grafiikan piirtämisestä
 *
 * @author Janne Ruoho
 */
public final class Grafiikka extends PeliSilmukka<Piirros> {

    /**
     * Kuva, johon kaikki grafiikka piirretään. Lopuksi kuva itse piirretään
     * piirtopaneeliin
     */
    private final BufferedImage puskuriKuva;
    /**
     * Taustakuva
     */
    private final BufferedImage taustaKuva;
    /**
     * Piirtopaneelin grafiikkaolio
     */
    private final Graphics2D paneelinGrafiikka;
    /**
     * Puskurikuvan grafiikkaolio
     */
    private final Graphics2D kuvanGrafiikka;

    /**
     * Luo uuden Grafiikka-olion
     *
     * @param piirtoPaneeli Piirtopaneeli, johon grafiikka piirretään
     */
    public Grafiikka(PiirtoPaneeli piirtoPaneeli) {
        paneelinGrafiikka = (Graphics2D) piirtoPaneeli.getGraphics();
        puskuriKuva = new BufferedImage(Peli.IKKUNAN_LEVEYS, Peli.IKKUNAN_KORKEUS, BufferedImage.TYPE_INT_RGB);
        kuvanGrafiikka = puskuriKuva.createGraphics();
        taustaKuva = KuvanLataaja.lataaKuva("/kuvat/tausta.png");
    }

    @Override
    public void paivita() {
        piirraTausta();
        for (Piirros piirros : getOliot()) {
            if (piirros != null) {
                piirros.piirra(kuvanGrafiikka);
            }
        }
        paneelinGrafiikka.drawImage(puskuriKuva, 0, 0, null);
    }

    /**
     * Piirtää ikkunan taustan
     */
    public void piirraTausta() {
        kuvanGrafiikka.drawImage(taustaKuva, null, 0, 0);
    }

    /**
     * Järjestää kokoelman oliot piirtojärjestykseen
     */
    public void jarjestaPiirtosyvyys() {
        Collections.sort(getOliot());
    }
}
