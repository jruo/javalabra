package palikkapeli.peli.olio.liikkuva;

import palikkapeli.ui.grafiikka.Piirros;

/**
 *
 * @author janne
 */
public class PystyPiikkinenLaatikko extends PiikkinenLaatikko {

    /**
     * Luo uuden PystyPiikkinenLaatikko-olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public PystyPiikkinenLaatikko(int x, int y) {
        super(x, y);
    }

    @Override
    public Liikkumissuunta getLiikkumissuunta() {
        return Liikkumissuunta.PYSTY;
    }

    @Override
    public Piirros luoOmaPiirros() {
        Piirros p = new Piirros(this);
        p.lisaaKuva(0, -2, "/kuvat/pystypiikkilaatikko.png");
        return p;
    }

}
