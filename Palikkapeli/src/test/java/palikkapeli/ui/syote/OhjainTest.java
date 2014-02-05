package palikkapeli.ui.syote;

import java.awt.event.KeyEvent;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class OhjainTest {

    private OhjainTestiLuokka o1;
    private Ohjain ohjain;
    private Nappaimisto nap;

    @Before
    public void setUp() {
        nap = new Nappaimisto();
        ohjain = new Ohjain(nap);
        o1 = new OhjainTestiLuokka(10, 10);
        ohjain.lisaa(o1);
    }

    @Test
    public void kasitteleOhjattavaToimii() {
        assertEquals(10, o1.getX());
        assertEquals(10, o1.getY());
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_UP, true);
        ohjain.kasitteleOhjattava(o1);
        assertEquals(10, o1.getX());
        assertEquals(9, o1.getY());
        ohjain.kasitteleOhjattava(o1);
        assertEquals(8, o1.getY());
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_UP, false);
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_LEFT, true);
        ohjain.kasitteleOhjattava(o1);
        assertEquals(9, o1.getX());
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_LEFT, false);
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_RIGHT, true);
        ohjain.kasitteleOhjattava(o1);
        assertEquals(10, o1.getX());
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_RIGHT, false);
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_DOWN, true);
        ohjain.kasitteleOhjattava(o1);
        assertEquals(9, o1.getY());
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_DOWN, false);
    }

    @Test
    public void paivitysToimii() throws InterruptedException {
//        ohjain.kaynnista();
//        asetaNappaimistonNappain(KeyEvent.VK_RIGHT, true);
//        Thread.sleep(50);
//        assertTrue(o1.getX() > 11);
    }

    @Test
    public void nappainEnuminOnPainettuToimii() {
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_UP, true);
        assertEquals(true, Nappain.YLOS.onPainettu(nap));
    }

    private void asetaNappaimistonNappainJaSynkronoi(int nappainkoodi, boolean painettu) {
        asetaNappaimistonNappain(nappainkoodi, painettu);
        nap.synkronoi();
    }

    private void asetaNappaimistonNappain(int nappainkoodi, boolean painettu) {
        nap.asetaNappaimenTila(nappainkoodi, painettu);
    }
}
