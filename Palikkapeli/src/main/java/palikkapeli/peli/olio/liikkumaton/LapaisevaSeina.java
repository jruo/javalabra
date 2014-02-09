package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.logiikka.Varillinen;
import palikkapeli.peli.olio.PeliOlio;

/**
 * Seinä, jonka läpi pystyy mahdollisesti kulkemaan
 *
 * @author Janne Ruoho
 */
public abstract class LapaisevaSeina extends PeliOlio implements Varillinen {

    public LapaisevaSeina(int x, int y) {
        super(x, y);
    }
}
