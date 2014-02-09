package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Ruutu;

/**
 *
 * @author Janne Ruoho
 */
public abstract class Laatikko extends LiikkuvaPeliOlio {

    public Laatikko(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean hyvaksySiirryttavaRuutu(Ruutu siirryttava) {
        if (ruudukko.onTyyppiRuudussa(Laatikko.class, siirryttava)) {
            return false;
        }
        return true;
    }
}
