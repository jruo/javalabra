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
        assertEquals(0, Suunta.YLOS.getXSuunta());
        assertEquals(-1, Suunta.YLOS.getYSuunta());
        assertEquals(0, Suunta.ALAS.getXSuunta());
        assertEquals(1, Suunta.ALAS.getYSuunta());
        assertEquals(-1, Suunta.VASEN.getXSuunta());
        assertEquals(0, Suunta.VASEN.getYSuunta());
        assertEquals(1, Suunta.OIKEA.getXSuunta());
        assertEquals(0, Suunta.OIKEA.getYSuunta());
    }

}
