package palikkapeli.peli.olio.liikkumaton;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class KiinteaSeinaTest {

    KiinteaSeina ks;

    @Before
    public void setUp() {
        ks = new KiinteaSeina(0, 0);
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(ks.luoOmaPiirros() != null);
    }

}
