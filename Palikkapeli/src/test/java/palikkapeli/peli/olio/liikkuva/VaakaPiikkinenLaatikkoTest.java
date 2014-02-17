package palikkapeli.peli.olio.liikkuva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class VaakaPiikkinenLaatikkoTest {

    private VaakaPiikkinenLaatikko vpl;

    @Before
    public void setUp() {
        vpl = new VaakaPiikkinenLaatikko(0, 0);
    }

    @Test
    public void liikkumissuuntaOnVaaka() {
        assertEquals(PiikkinenLaatikko.Liikkumissuunta.VAAKA, vpl.getLiikkumissuunta());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(vpl.luoOmaPiirros() != null);
    }

}
