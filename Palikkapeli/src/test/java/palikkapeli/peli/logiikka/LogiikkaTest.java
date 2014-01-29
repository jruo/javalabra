package palikkapeli.peli.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class LogiikkaTest {

    private LooginenTestiLuokka l1, l2, l3;
    private Logiikka logiikka;

    @Before
    public void setUp() {
        l1 = new LooginenTestiLuokka();
        l2 = new LooginenTestiLuokka();
        l3 = new LooginenTestiLuokka();
        logiikka = new Logiikka();
    }

    @Test
    public void paivitaPaivittaaKaikki() {
        logiikka.lisaa(l1, l2, l3);
        assertEquals(0, l1.getLaskuri());
        assertEquals(0, l2.getLaskuri());
        assertEquals(0, l3.getLaskuri());
        logiikka.paivita();
        assertEquals(1, l1.getLaskuri());
        assertEquals(1, l2.getLaskuri());
        assertEquals(1, l3.getLaskuri());
        logiikka.paivita();
        assertEquals(2, l1.getLaskuri());
        assertEquals(2, l2.getLaskuri());
        assertEquals(2, l3.getLaskuri());
    }
}
