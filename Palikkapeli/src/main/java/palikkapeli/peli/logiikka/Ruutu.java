package palikkapeli.peli.logiikka;

/**
 * Eddustaa Ruudukon ruutua
 *
 * @author Janne Ruoho
 */
public class Ruutu {

    private final int x, y;

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
        return new Ruutu(x + suunta.getXSuunta(), y + suunta.getYSuunta());
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
