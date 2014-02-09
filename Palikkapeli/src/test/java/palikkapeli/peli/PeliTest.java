package palikkapeli.peli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class PeliTest {

    Peli peli;

    @Before
    public void setUp() {
        peli = Peli.INSTANSSI;
    }

    @Test
    public void getIkkunaToimii() {
        assertTrue(peli.getIkkuna() != null);
    }

    @Test
    public void getOhjainToimii() {
        assertTrue(peli.getOhjain() != null);
    }

    @Test
    public void getLogiikkaToimii() {
        assertTrue(peli.getLogiikka() != null);
    }

    @Test
    public void getGrafiikkaToimii() {
        assertTrue(peli.getGrafiikka() != null);
    }

    @Test
    public void getNappaimistoToimii() {
        assertTrue(peli.getNappaimisto() != null);
    }

    @Test
    public void getTasonVaihtajaToimii() {
        assertTrue(peli.getTasonVaihtaja() != null);
    }

    @Test
    public void ikkunaSaaNappaimistonKuuntelijan() {
        assertEquals(peli.getNappaimisto().getKuuntelija(),
                peli.getIkkuna().getKeyListeners()[0]);
    }

    @Test
    public void silmukatKaynnistyvat() {
        assertEquals(true, peli.getLogiikka().onKaynnissa());
        assertEquals(true, peli.getGrafiikka().onKaynnissa());
    }
}
