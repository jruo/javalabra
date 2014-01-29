package palikkapeli.peli.taso;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import palikkapeli.peli.Peli;

/**
 *
 * @author Janne Ruoho
 */
public class TasonLataaja {

    private final Peli peli;

    public TasonLataaja(Peli peli) {
        this.peli = peli;
    }

    public Taso lataaTaso(String tiedostonimi) {

        return null;
    }

    public BufferedReader luoLukija(String tiedostonimi) {
        InputStream striimi = getClass().getResourceAsStream(tiedostonimi);
        BufferedReader lukija = new BufferedReader(new InputStreamReader(striimi));
        return lukija;
    }

}
