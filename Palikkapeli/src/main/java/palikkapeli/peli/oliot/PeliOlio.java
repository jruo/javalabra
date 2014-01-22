package palikkapeli.peli.oliot;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import palikkapeli.peli.Peli;
import palikkapeli.peli.grafiikka.Graafinen;
import palikkapeli.peli.logiikka.Looginen;
import palikkapeli.ui.syote.Nappaimisto;

/**
 * Yliluokka kaikille pelin olioille
 *
 * @author Janne Ruoho
 */
public abstract class PeliOlio implements Looginen, Graafinen {

    private BufferedImage kuva;
    protected int x, y;
    protected Nappaimisto nappaimisto;

    /**
     * Luo PeliOlion annettuun Peliin
     *
     * @param peli Peli
     */
    public PeliOlio(Peli peli) {
        this(peli, 0, 0, null);
    }

    /**
     * Luo PeliOlion annettuun Peliin ja koordinaatteihin
     *
     * @param peli Peli
     * @param x X-koordinaatti
     * @param y Y-koordinaatti
     */
    public PeliOlio(Peli peli, int x, int y) {
        this(peli, x, y, null);
    }

    /**
     * Luo PeliOlion annettuun Peliin ja koordinaatteihin sekä asettaa sille
     * kuvan
     *
     * @param peli Peli
     * @param x X-koordinaatti
     * @param y Y-koordinaatti
     * @param kuvanTiedostonimi Kuvatiedoston polku
     */
    public PeliOlio(Peli peli, int x, int y, String kuvanTiedostonimi) {
        this.nappaimisto = peli.getNappaimisto();
        this.x = x;
        this.y = y;
        setKuva(kuvanTiedostonimi);
    }

    /**
     * Asettaa olion kuvan
     *
     * @param tiedostonimi
     */
    public final void setKuva(String tiedostonimi) {
        // TODO: kuvan lataus
    }

    /**
     * Palauttaa kuvan
     *
     * @return Kuva
     */
    public final BufferedImage getKuva() {
        return kuva;
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

    /**
     * Olion piirtokoodi, joka piirtää vakiona oliolle asetetun kuvan nykyisiin
     * (x, y)-koordinaatteihin
     *
     * @param g Grafiikkaolio
     */
    @Override
    public void piirra(Graphics2D g) {
        if (kuva == null) {
            return;
        }
        g.drawImage(kuva, x, y, null);
    }
}
