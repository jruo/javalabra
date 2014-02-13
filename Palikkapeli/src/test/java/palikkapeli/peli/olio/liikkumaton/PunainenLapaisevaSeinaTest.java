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
public class PunainenLapaisevaSeinaTest {

    PunainenLapaisevaSeina seina;

    @Before
    public void setUp() {
        seina = new PunainenLapaisevaSeina(0, 0);
    }

    @Test
    public void variOnPunainen() {
        assertEquals(Vari.PUNAINEN, seina.getVari());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(seina.luoOmaPiirros() != null);
    }

}
