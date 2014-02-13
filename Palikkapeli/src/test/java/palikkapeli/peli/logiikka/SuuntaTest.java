package palikkapeli.peli.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class SuuntaTest {

    @Test
    public void getXYToimii() {
        assertEquals(0, Suunta.YLOS.getX());
        assertEquals(-1, Suunta.YLOS.getY());
        assertEquals(0, Suunta.ALAS.getX());
        assertEquals(1, Suunta.ALAS.getY());
        assertEquals(-1, Suunta.VASEN.getX());
        assertEquals(0, Suunta.VASEN.getY());
        assertEquals(1, Suunta.OIKEA.getX());
        assertEquals(0, Suunta.OIKEA.getY());
    }

}
