package palikkapeli.peli.logiikka;

/**
 * Suunta
 *
 * @author Janne Ruoho
 */
public enum Suunta {

    YLOS(0, -1), ALAS(0, 1), VASEN(-1, 0), OIKEA(1, 0);

    /**
     * Suuntavektorin komponentit
     */
    private final int x, y;

    /**
     * Suuntavektori
     *
     * @param x X-komponentti
     * @param y Y-komponentti
     */
    Suunta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Palauttaa suunnan suuntavektorin x-komponentin
     *
     * @return X
     */
    public final int getX() {
        return x;
    }

    /**
     * Palauttaa suunnan suuntavektorin y-komponentin
     *
     * @return
     */
    public final int getY() {
        return y;
    }
}
