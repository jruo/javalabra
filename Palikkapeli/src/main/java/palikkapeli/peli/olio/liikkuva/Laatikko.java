package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruutu;

/**
 *
 * @author Janne Ruoho
 */
public abstract class Laatikko extends LiikkuvaPeliOlio {

    public Laatikko(Peli peli, int x, int y) {
        super(peli, x, y);
    }

    @Override
    public boolean hyvaksySiirryttavaRuutu(Ruutu siirryttava) {
        if (ruudukko.onTyyppiRuudussa(Laatikko.class, siirryttava)) {
            return false;
        }
        return true;
    }
}
