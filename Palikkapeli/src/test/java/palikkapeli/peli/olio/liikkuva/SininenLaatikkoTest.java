package palikkapeli.peli.olio.liikkuva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.logiikka.Vari;

/**
 *
 * @author Janne Ruoho
 */
public class SininenLaatikkoTest {

    SininenLaatikko laatikko;

    @Before
    public void setUp() {
        laatikko = new SininenLaatikko(0, 0);
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(laatikko.luoOmaPiirros() != null);
    }

    @Test
    public void variOnSininen() {
        assertEquals(Vari.SININEN, laatikko.getVari());
    }

}
