package palikkapeli.peli.olio.apuolio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.ui.syote.Nappain;

/**
 *
 * @author Janne Ruoho
 */
public class PeliAlkuTest {

    private PeliAlku pa;

    @Before
    public void setUp() {
        pa = new PeliAlku(1234123, 123413);
    }

    @Test
    public void aktivoivaNappainOnEnter() {
        assertEquals(Nappain.ENTER, pa.getAktivoivaNappain());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(pa.luoOmaPiirros() != null);
    }

    @Test
    public void xyAlussaOnOikein() {
        assertEquals(-5000, pa.getY());
        assertEquals(0, pa.getX());
    }

    @Test
    public void suoritaLogiikkaToimii() {
        pa.suoritaLogiikka();
        assertEquals(-4807, pa.getY());
        pa.suoritaLogiikka();
        assertEquals(-4622, pa.getY());

    }

}
