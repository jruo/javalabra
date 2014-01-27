package palikkapeli.peli.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.ui.syote.Nappaimisto;

/**
 *
 * @author Janne Ruoho
 */
public class LogiikkaTest {

    private LooginenTestiLuokka l1, l2, l3;
    private Logiikka log;
    private Nappaimisto nap;

    @Before
    public void setUp() {
        l1 = new LooginenTestiLuokka();
        l2 = new LooginenTestiLuokka();
        l3 = new LooginenTestiLuokka();
        nap = new Nappaimisto();
        log = new Logiikka();
    }

    @Test
    public void paivitaPaivittaaKaikki() {
        log.lisaaOliot(l1, l2, l3);
        assertEquals(0, l1.getLaskuri());
        assertEquals(0, l2.getLaskuri());
        assertEquals(0, l3.getLaskuri());
        log.paivita();
        assertEquals(1, l1.getLaskuri());
        assertEquals(1, l2.getLaskuri());
        assertEquals(1, l3.getLaskuri());
        log.paivita();
        assertEquals(2, l1.getLaskuri());
        assertEquals(2, l2.getLaskuri());
        assertEquals(2, l3.getLaskuri());
    }

    @Test
    public void nappaimistoSynkronoituu() {
        log.lisaaOliot(l1, l2, l3);
        assertEquals(0, l1.getNappaimistoLaskuri());
        assertEquals(0, l2.getNappaimistoLaskuri());
        assertEquals(0, l3.getNappaimistoLaskuri());
        nap.asetaNappaimenTila(10, true);
        log.paivita();
        assertEquals(1, l1.getNappaimistoLaskuri());
        assertEquals(1, l2.getNappaimistoLaskuri());
        assertEquals(1, l3.getNappaimistoLaskuri());
        nap.asetaNappaimenTila(10, false);
        log.paivita();
        assertEquals(1, l1.getNappaimistoLaskuri());
        assertEquals(1, l2.getNappaimistoLaskuri());
        assertEquals(1, l3.getNappaimistoLaskuri());
    }

    /**
     * Apuluokka testaamiseen
     */
    public class LooginenTestiLuokka implements Looginen {

        private int laskuri, nappaimistoLaskuri;

        public LooginenTestiLuokka() {
            laskuri = 0;
            nappaimistoLaskuri = 0;
        }

        public int getLaskuri() {
            return laskuri;
        }

        public int getNappaimistoLaskuri() {
            return nappaimistoLaskuri;
        }

        @Override
        public void suoritaLogiikka() {
            laskuri++;

            if (nap.onPainettu(10)) {
                nappaimistoLaskuri++;
            }
        }
    }
}
