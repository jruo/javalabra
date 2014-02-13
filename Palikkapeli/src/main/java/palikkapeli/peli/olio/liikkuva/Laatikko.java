package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Ruutu;

/**
 * Liikutettava laatikko
 *
 * @author Janne Ruoho
 */
public abstract class Laatikko extends LiikkuvaPeliOlio {

    /**
     * Luo uuden laatikon annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
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
