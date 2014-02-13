package palikkapeli.peli.olio;

/**
 *
 * @author Janne Ruoho
 */
public class PeliOlioTestiLuokka extends PeliOlio {

    private boolean alustettu = false;

    public PeliOlioTestiLuokka(int x, int y) {
        super(x, y);
    }

    @Override
    public void alusta() {
        alustettu = true;
    }

    public boolean onAlustettu() {
        return alustettu;
    }
}
