package palikkapeli.peli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Janne Ruoho
 */
public class PeliTest {
    
    Peli peli;

    @Before
    public void setUp() {
        peli = new Peli();
    }
    
    @Test
    public void getIkkunaToimii() {
        assertTrue(peli.getIkkuna() != null);
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
}
