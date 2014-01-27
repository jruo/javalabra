package palikkapeli.peli.olio;

import palikkapeli.peli.olio.PeliOlio;
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

        assertEquals(0, o1.getX());
        assertEquals(0, o1.getY());

        assertEquals(10, o2.getX());
        assertEquals(10, o2.getY());

        o1.setX(50);
        o1.setY(60);

        assertEquals(50, o1.getX());
        assertEquals(60, o1.getY());
    }

    public class Olio extends PeliOlio {

        public Olio(Peli peli) {
            super(peli);
        }

        public Olio(Peli peli, int x, int y) {
            super(peli, x, y);
        }
    }
}
