package palikkapeli.peli.logiikka;

/**
 *
 * @author Janne Ruoho
 */
public enum Suunta {

    YLOS(0, -1), ALAS(0, 1), VASEN(-1, 0), OIKEA(1, 0);

    private final int x, y;

    Suunta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXSuunta() {
        return x;
    }

    public int getYSuunta() {
        return y;
    }
}
