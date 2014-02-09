package palikkapeli.peli.olio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class PeliOlioTest {

    PeliOlioTestiLuokka o1, o2;

    @Before
    public void setUp() {
        o1 = new PeliOlioTestiLuokka(0, 0);
        o2 = new PeliOlioTestiLuokka(10, 10);
    }

    @Test
    public void koordinaattiGetteritJaSetteritToimii() {
        assertEquals(0, o1.getX());
        assertEquals(0, o1.getY());

        assertEquals(10, o2.getX());
        assertEquals(10, o2.getY());

        o1.setX(50);
        o1.setY(60);

        assertEquals(50, o1.getX());
        assertEquals(60, o1.getY());
    }

    @Test
    public void olioLisataanRuudukkoon() {
        assertTrue(o1.peli.getRuudukko().getOlioJoukot()[0][0].contains(o1));
        assertTrue(o2.peli.getRuudukko().getOlioJoukot()[0][0].contains(o2));
    }
}
