package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Looginen;
import palikkapeli.peli.logiikka.Ruudukko;
import palikkapeli.peli.logiikka.Ruutu;
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
    protected Ruudukko ruudukko;

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
        this.ruudukko = peli.getRuudukko();
        this.ruudukko.lisaaOlio(this, sijaintiRuuduksi());
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
     * Palauttaa Pelin
     *
     * @return Peli
     */
    public final Peli getPeli() {
        return peli;
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
     * Luo Ruutu-olion joka vastaa omia koordinaatteja
     *
     * @return Ruutu
     */
    public final Ruutu sijaintiRuuduksi() {
        return ruudukko.xyRuuduksi(x, y);
    }

    /**
     * Palauttaa Ruutu-olion, jossa tämä olio sijaitsee Ruudukon tiedossa
     *
     * @return
     */
    public final Ruutu omaRuutu() {
        return ruudukko.olionRuutu(this);
    }

    @Override
    public final void suoritaLogiikka() {
        suoritaOmaLogiikka();
        if (!omaRuutu().equals(sijaintiRuuduksi())) {
            ruudukko.siirraOlio(this, sijaintiRuuduksi());
        }
    }

    /**
     * Metodi, joka kutsutaan vasta kun kaikki tason oliot on lisätty
     * tarpeellisiin kokoelmiin yms
     */
    public abstract void alusta();

    /**
     * Metodi PeliOlion omalle logiikalle
     */
    public abstract void suoritaOmaLogiikka();

    /**
     * Metodi, jossa PeliOlio luo oman piirroksensa
     *
     * @return Piirros
     */
    public abstract Piirros luoOmaPiirros();

}
