package palikkapeli.peli.olio.liikkuva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class PystyPiikkinenLaatikkoTest {

    private PystyPiikkinenLaatikko ppl;

    @Before
    public void setUp() {
        ppl = new PystyPiikkinenLaatikko(0, 0);
    }

    @Test
    public void liikkumissuuntaOnPysty() {
        assertEquals(PiikkinenLaatikko.Liikkumissuunta.PYSTY, ppl.getLiikkumissuunta());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(ppl.luoOmaPiirros() != null);
    }

}
