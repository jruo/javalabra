package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Looginen;
import palikkapeli.peli.logiikka.ohjaus.Ohjautuva;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Yliluokka kaikille pelin olioille
 *
 * @author Janne Ruoho
 */
public abstract class PeliOlio implements Looginen, Ohjautuva {

    protected int x, y;
    protected Peli peli;

    /**
     * Luo PeliOlion annettuun Peliin ja koordinaatteihin
     *
     * @param peli Peli
     * @param x X-koordinaatti
     * @param y Y-koordinaatti
     */
    public PeliOlio(Peli peli, int x, int y) {
        this.peli = peli;
        this.x = x;
        this.y = y;
        this.peli.getOhjain().lisaa(this);
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

    /**
     * Metodi, jossa PeliOlio luo oman piirroksensa
     *
     * @return Piirros
     */
    public abstract Piirros luoOmaPiirros();

    @Override
    public void suoritaLogiikka() {
    }

}
