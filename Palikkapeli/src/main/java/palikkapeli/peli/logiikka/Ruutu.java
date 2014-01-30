package palikkapeli.peli.logiikka;

/**
 *
 * @author Janne Ruoho
 */
public class Ruutu {

    private final int x, y;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Ruutu viereinen(Suunta suunta) {
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
