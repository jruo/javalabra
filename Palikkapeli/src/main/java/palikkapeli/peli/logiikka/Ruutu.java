package palikkapeli.peli.logiikka;

/**
 * Edustaa Ruudukon ruutua
 *
 * @author Janne Ruoho
 */
public class Ruutu {

    /**
     * Ruudun sijainti Ruudukossa (ei pikseleinä, vaan taulukon indekseinä)
     */
    private final int x, y;

    /**
     * Luo uuden Ruutu-olion annettuun sijaintiin
     *
     * @param x X-sijainti
     * @param y Y-sijainti
     */
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Palauttaa ruudun x-sijainnin ruudukossa (ei todellista koordinaattia
     * ikkunassa)
     *
     * @return x-sijainti
     */
    public final int getX() {
        return x;
    }

    /**
     * Palauttaa ruudun y-sijainnin ruudukossa
     *
     * @return
     */
    public final int getY() {
        return y;
    }

    /**
     * Palauttaa ruudun viereisen ruudun annetussa suunnassa
     *
     * @param suunta Suunta
     * @return Viereinen ruutu
     */
    public final Ruutu viereinen(Suunta suunta) {
        return new Ruutu(x + suunta.getX(), y + suunta.getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ruutu other = (Ruutu) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.x;
        hash = 41 * hash + this.y;
        return hash;
    }
}
