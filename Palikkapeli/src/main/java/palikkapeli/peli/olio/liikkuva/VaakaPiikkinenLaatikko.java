package palikkapeli.peli.olio.liikkuva;

import palikkapeli.ui.grafiikka.Piirros;

/**
 * Vaakatasossa liikkuva piikkinen laatiikko
 *
 * @author Janne Ruoho
 */
public class VaakaPiikkinenLaatikko extends PiikkinenLaatikko {

    /**
     * Luo uuden VaakaPiikkinenLaatikko-olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public VaakaPiikkinenLaatikko(int x, int y) {
        super(x, y);
    }

    @Override
    public Liikkumissuunta getLiikkumissuunta() {
        return Liikkumissuunta.VAAKA;
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros p = new Piirros(this);
        p.lisaaKuva(-2, 0, "/kuvat/vaakapiikkilaatikko.png");
        return p;
    }
}
