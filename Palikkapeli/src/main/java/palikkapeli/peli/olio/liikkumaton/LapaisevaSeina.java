package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Varillinen;
import palikkapeli.peli.olio.PeliOlio;

/**
 * Seinä, jonka läpi pystyy mahdollisesti kulkemaan
 *
 * @author Janne Ruoho
 */
public abstract class LapaisevaSeina extends PeliOlio implements Varillinen {

    public LapaisevaSeina(Peli peli, int x, int y) {
        super(peli, x, y);
    }
}
