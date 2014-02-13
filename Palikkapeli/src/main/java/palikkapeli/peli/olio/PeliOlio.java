package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Looginen;
import palikkapeli.peli.logiikka.Oliot;
import palikkapeli.peli.logiikka.Ruudukko;
import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.ohjaus.Ohjattava;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Yliluokka kaikille pelin olioille
 *
 * @author Janne Ruoho
 */
public abstract class PeliOlio implements Looginen, Ohjattava {

    protected int x, y;
    protected final Peli peli;
    protected final Oliot oliot;
    protected final Ruudukko ruudukko;

    /**
     * Luo PeliOlion annettuun Peliin ja koordinaatteihin
     *
     * @param x X-koordinaatti
     * @param y Y-koordinaatti
     */
    public PeliOlio(int x, int y) {
        this.x = x;
        this.y = y;

        peli = Peli.INSTANSSI;
        oliot = peli.getOliot();
        ruudukko = peli.getRuudukko();
        ruudukko.lisaaOlio(this, sijaintiRuuduksi());
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

    /**
     * Metodi, joka kutsutaan vasta kun kaikki tason oliot on lisätty
     * tarpeellisiin kokoelmiin yms
     */
    public void alusta() {
    }

    /**
     * Metodi, jossa PeliOlio luo oman piirroksensa
     *
     * @return Piirros
     */
    public Piirros luoOmaPiirros() {
        return null;
    }

    @Override
    public void suoritaLogiikka() {
    }
}
