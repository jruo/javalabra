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
public class PunainenPelaajaTest {

    PunainenPelaaja pelaaja;

    @Before
    public void setUp() {
        pelaaja = new PunainenPelaaja(0, 0);
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(pelaaja.luoOmaPiirros() != null);
    }

    @Test
    public void variOnPunainen() {
        assertEquals(Vari.PUNAINEN, pelaaja.getVari());
    }

}
