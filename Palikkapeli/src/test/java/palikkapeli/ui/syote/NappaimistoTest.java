package palikkapeli.ui.syote;

import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.JFrame;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class NappaimistoTest {

    Nappaimisto nap;

    @Before
    public void setUp() {
        nap = new Nappaimisto();
    }

    @Test
    public void getKuuntelijaPalauttaaKuuntelijan() {
        assertTrue(nap.getKuuntelija() != null);
    }

    @Test
    public void getNappaintenTodellinenTilaPalauttaaKartan() {
        assertTrue(nap.getNappaintenTodellinenTila() != null);
    }

    @Test
    public void getNappaintenSynkronoituTilaPalaittaaKartan() {
        assertTrue(nap.getNappaintenSynkronoituTila() != null);
    }

    @Test
    public void asetaNappaimenTilaAsettaaAsettaaOikein() {
        Map<Integer, Boolean> kartta = nap.getNappaintenTodellinenTila();
        assertEquals(null, kartta.get(10));
        assertEquals(null, kartta.get(20));
        assertEquals(null, kartta.get(30));
        nap.asetaNappaimenTila(10, true);
        nap.asetaNappaimenTila(20, true);
        assertEquals(true, kartta.get(10));
        assertEquals(true, kartta.get(20));
        assertEquals(null, kartta.get(30));
        nap.asetaNappaimenTila(10, false);
        nap.asetaNappaimenTila(20, false);
        nap.asetaNappaimenTila(30, false);
        assertEquals(false, kartta.get(10));
        assertEquals(false, kartta.get(20));
        assertEquals(false, kartta.get(30));
    }

    @Test
    public void synkronointiToimii() {
        Map<Integer, Boolean> synkronoituKartta = nap.getNappaintenSynkronoituTila();
        nap.asetaNappaimenTila(10, true);
        nap.asetaNappaimenTila(20, true);
        nap.asetaNappaimenTila(30, true);
        assertEquals(null, synkronoituKartta.get(10));
        assertEquals(null, synkronoituKartta.get(20));
        assertEquals(null, synkronoituKartta.get(30));
        nap.synkronoi();
        assertEquals(true, synkronoituKartta.get(10));
        assertEquals(true, synkronoituKartta.get(20));
        assertEquals(true, synkronoituKartta.get(30));
        nap.asetaNappaimenTila(10, false);
        nap.asetaNappaimenTila(20, false);
        nap.asetaNappaimenTila(30, false);
        nap.synkronoi();
        assertEquals(false, synkronoituKartta.get(10));
        assertEquals(false, synkronoituKartta.get(20));
        assertEquals(false, synkronoituKartta.get(30));
    }

    @Test
    public void onPainettuToimii() {
        assertEquals(false, nap.onPainettu(10));
        assertEquals(false, nap.onPainettu(20));
        assertEquals(false, nap.onPainettu(30));
        nap.asetaNappaimenTila(10, true);
        nap.asetaNappaimenTila(20, true);
        nap.synkronoi();
        assertEquals(true, nap.onPainettu(10));
        assertEquals(true, nap.onPainettu(20));
        assertEquals(false, nap.onPainettu(30));
        nap.asetaNappaimenTila(10, false);
        nap.asetaNappaimenTila(20, false);
        nap.asetaNappaimenTila(30, false);
        nap.synkronoi();
        assertEquals(false, nap.onPainettu(10));
        assertEquals(false, nap.onPainettu(20));
        assertEquals(false, nap.onPainettu(30));
    }

    @Test
    public void nappaintenKuuntelijaToimii() {
        JFrame ikkuna = new JFrame();
        ikkuna.setVisible(true);
        ikkuna.requestFocus();
        ikkuna.addKeyListener(nap.getKuuntelija());
        KeyEvent paina = new KeyEvent(ikkuna, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        KeyEvent vapauta = new KeyEvent(ikkuna, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        ikkuna.dispatchEvent(paina);
        nap.synkronoi();
        assertEquals(true, nap.onPainettu(KeyEvent.VK_UP));
        ikkuna.dispatchEvent(vapauta);
        nap.synkronoi();
        assertEquals(false, nap.onPainettu(KeyEvent.VK_UP));
    }
}
