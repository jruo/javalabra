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

    private LiikkuvaTestiLuokka o1;
    private AktivoituvaTestiLuokka o2;
    private Ohjain ohjain;
    private Nappaimisto nap;

    @Before
    public void setUp() {
        nap = new Nappaimisto();
        ohjain = new Ohjain(nap);
        o1 = new LiikkuvaTestiLuokka(10, 10);
        o2 = new AktivoituvaTestiLuokka();
        ohjain.lisaa(o1, o2);
    }

    @Test
    public void kasitteleOhjattavaToimiiLiikkuvalla() {
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
    public void kasitteleOhjattavaToimiiAktivoituvalla() {
        assertEquals(0, o2.getLaskuri());
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_SPACE, true);
        ohjain.kasitteleOhjattava(o2);
        assertEquals(1, o2.getLaskuri());
        asetaNappaimistonNappainJaSynkronoi(KeyEvent.VK_SPACE, true);
        ohjain.kasitteleOhjattava(o2);
        assertEquals(2, o2.getLaskuri());
    }

    @Test
    public void kasitteleOhjattavatToimii() {
        asetaNappaimistonNappain(KeyEvent.VK_UP, true);
        asetaNappaimistonNappain(KeyEvent.VK_SPACE, true);
        ohjain.kasitteleOhjattavat();
        assertEquals(9, o1.getY());
        assertEquals(1, o2.getLaskuri());
        asetaNappaimistonNappain(KeyEvent.VK_UP, false);
        asetaNappaimistonNappain(KeyEvent.VK_RIGHT, true);
        ohjain.kasitteleOhjattavat();
        assertEquals(9, o1.getY());
        assertEquals(11, o1.getX());
        assertEquals(2, o2.getLaskuri());
    }

    private void asetaNappaimistonNappainJaSynkronoi(int nappainkoodi, boolean painettu) {
        asetaNappaimistonNappain(nappainkoodi, painettu);
        nap.synkronoi();
    }

    private void asetaNappaimistonNappain(int nappainkoodi, boolean painettu) {
        nap.asetaNappaimenTila(nappainkoodi, painettu);
    }
}
