package palikkapeli.peli.olio.apuolio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class PeliLoppuTest {

    private PeliLoppu pl;

    @Before
    public void setUp() {
        pl = new PeliLoppu(123, 123);
    }

    @Test
    public void xyAlussaOikein() {
        assertEquals(0, pl.getX());
        assertEquals(0, pl.getY());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(pl.luoOmaPiirros() != null);
    }

}
