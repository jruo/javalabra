package palikkapeli.peli.oliot;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.Peli;

/**
 *
 * @author Janne Ruoho
 */
public class PeliOlioTest {

    @Before
    public void setUp() {
    }

    @Test
    public void kaikkiGetteritJaSetteritToimii() {
        Olio o1 = new Olio(new Peli());
        Olio o2 = new Olio(new Peli(), 10, 10);
        Olio o3 = new Olio(new Peli(), 10, 10, "PeliOlioTestiKuva.png");

        assertEquals(0, o1.getX());
        assertEquals(0, o1.getY());
        assertEquals(null, o1.getKuva());
        assertEquals(10, o2.getX());
        assertEquals(10, o2.getY());

        o1.setX(50);
        o1.setY(60);

        assertEquals(50, o1.getX());
        assertEquals(60, o1.getY());

        // TODO: testaa getKuva ja setKuva
    }

    public class Olio extends PeliOlio {

        public Olio(Peli peli) {
            super(peli);
        }

        public Olio(Peli peli, int x, int y) {
            super(peli, x, y);
        }

        public Olio(Peli peli, int x, int y, String kuva) {
            super(peli, x, y, kuva);
        }
    }
}
