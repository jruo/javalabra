package palikkapeli.peli.oliot;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Looginen;
import palikkapeli.ui.syote.Nappaimisto;

/**
 * Yliluokka kaikille pelin olioille
 *
 * @author Janne Ruoho
 */
public abstract class PeliOlio implements Looginen {

    protected int x, y;
    protected Nappaimisto nappaimisto;

    /**
     * Luo PeliOlion annettuun Peliin
     *
     * @param peli Peli
     */
    public PeliOlio(Peli peli) {
        this(peli, 0, 0);
    }

    /**
     * Luo PeliOlion annettuun Peliin ja koordinaatteihin
     *
     * @param peli Peli
     * @param x X-koordinaatti
     * @param y Y-koordinaatti
     */
    public PeliOlio(Peli peli, int x, int y) {
        this.nappaimisto = peli.getNappaimisto();
        this.x = x;
        this.y = y;
    }

    /**
     * Palauttaa X-koordinaatin
     *
     * @return X
     */
    public final int getX() {
        return x;
    }

    /**
     * Palauttaa Y-koordinaatin
     *
     * @return Y
     */
    public final int getY() {
        return y;
    }

    /**
     * Asettaa X-koordinaatin
     *
     * @param x X
     */
    public final void setX(int x) {
        this.x = x;
    }

    /**
     * Asettaa Y-koordinaatin
     *
     * @param y Y
     */
    public final void setY(int y) {
        this.y = y;
    }

    @Override
    public void suoritaLogiikka() {
    }
}
