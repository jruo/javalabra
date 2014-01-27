package palikkapeli.ui.grafiikka;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Huolehtii kuvien lataamisesta
 *
 * @author Janne Ruoho
 */
public class KuvanLataaja {

    public static BufferedImage lataaKuva(String tiedostonimi) {
        try {
            URL kuvanURL = KuvanLataaja.class.getResource(tiedostonimi);
            BufferedImage kuva = ImageIO.read(kuvanURL);
            return kuva;
        } catch (IOException ex) {
            System.out.println("Kuvaa " + tiedostonimi + " ei voitu ladata!");
            return null;
        }
    }
}
