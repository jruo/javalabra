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
public class PunainenTasonMaaliTest {

    PunainenTasonMaali maali;

    @Before
    public void setUp() {
        maali = new PunainenTasonMaali(0, 0);
    }

    @Test
    public void variOnPunainen() {
        assertEquals(Vari.PUNAINEN, maali.getVari());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(maali.luoOmaPiirros() != null);
    }

}
