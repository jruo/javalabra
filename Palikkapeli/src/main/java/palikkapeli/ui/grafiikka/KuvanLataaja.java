package palikkapeli.ui.grafiikka;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * Huolehtii kuvien lataamisesta
 *
 * @author Janne Ruoho
 */
public class KuvanLataaja {

    /**
     * Kartta, joka osoittaa kuvien tiedostonimet ladattuihin kuviin
     */
    private static final Map<String, BufferedImage> ladatutKuvat = new HashMap<>();

    /**
     * Lataa kuvan
     *
     * @param tiedostonimi Kuvan tiedostonimi, esim "/kuvat/pelaaja.png"
     * @return Kuva
     */
    public static BufferedImage lataaKuva(String tiedostonimi) {
        try {
            if (ladatutKuvat.containsKey(tiedostonimi)) {
                return lataaKuvaMuistista(tiedostonimi);
            } else {
                return lataaKuvaTiedostosta(tiedostonimi);
            }
        } catch (Exception ex) {
            System.out.println("Kuvaa " + tiedostonimi + " ei voitu ladata!");
            return null;
        }
    }

    /**
     * Lataa kuvan muistista, jos se on jo ladattu kerran tiedostosta. Säästää
     * paljon aikaa jos kuvaa yritetään ladata useita kertoja
     *
     * @param tiedostonimi Kuvan tiedostonimi
     * @return Kuva
     */
    public static BufferedImage lataaKuvaMuistista(String tiedostonimi) {
        return ladatutKuvat.get(tiedostonimi);
    }

    /**
     * Lataa kuvan tiedostosta
     *
     * @param tiedostonimi Kuvan tiedostonimi
     * @return Kuva
     * @throws Exception
     */
    public static BufferedImage lataaKuvaTiedostosta(String tiedostonimi) throws Exception {
        URL kuvanURL = KuvanLataaja.class.getResource(tiedostonimi);
        BufferedImage kuva = ImageIO.read(kuvanURL);
        ladatutKuvat.put(tiedostonimi, kuva);
        return kuva;
    }
}
