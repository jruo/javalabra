package palikkapeli.peli.olio.liikkumaton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.logiikka.Vari;

/**
 *
 * @author Janne Ruoho
 */
public class SininenTasonMaaliTest {

    SininenTasonMaali maali;

    @Before
    public void setUp() {
        maali = new SininenTasonMaali(0, 0);
    }

    @Test
    public void variOnPunainen() {
        assertEquals(Vari.SININEN, maali.getVari());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(maali.luoOmaPiirros() != null);
    }

}
