package palikkapeli.peli.logiikka;

/**
 * Suunta. Aika itsestäänselvää...
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

    /**
     * Palauttaa suunnan suuntavektorin x-komponentin
     *
     * @return X
     */
    public int getXSuunta() {
        return x;
    }

    /**
     * Palauttaa suunnan suuntavektorin y-komponentin
     *
     * @return
     */
    public int getYSuunta() {
        return y;
    }
}
