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
public class PunainenLaatikkoTest {

    PunainenLaatikko laatikko;

    @Before
    public void setUp() {
        laatikko = new PunainenLaatikko(0, 0);
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(laatikko.luoOmaPiirros() != null);
    }

    @Test
    public void variOnPunainen() {
        assertEquals(Vari.PUNAINEN, laatikko.getVari());
    }

}
