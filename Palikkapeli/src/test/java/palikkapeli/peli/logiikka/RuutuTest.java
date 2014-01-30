package palikkapeli.peli.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class RuutuTest {

    private Ruutu r1, r2;

    @Before
    public void setUp() {
        r1 = new Ruutu(0, 0);
        r2 = new Ruutu(5, 5);
    }

    @Test
    public void getXYToimii() {
        assertEquals(0, r1.getX());
        assertEquals(0, r1.getY());
        assertEquals(5, r2.getX());
        assertEquals(5, r2.getY());
    }

    @Test
    public void viereinenPalauttaaViereisen() {
        //testaa samalla equalsin true-tapaukset
        assertEquals(new Ruutu(1, 0), r1.viereinen(Suunta.OIKEA));
        assertEquals(new Ruutu(0, 1), r1.viereinen(Suunta.ALAS));
        assertEquals(new Ruutu(5, 6), r2.viereinen(Suunta.ALAS));
        assertEquals(new Ruutu(5, 4), r2.viereinen(Suunta.YLOS));
        assertEquals(new Ruutu(6, 5), r2.viereinen(Suunta.OIKEA));
        assertEquals(new Ruutu(4, 5), r2.viereinen(Suunta.VASEN));
    }

    @Test
    public void testaaEquals() {
        assertEquals(false, r1.equals(r2));
        assertEquals(false, r1.equals(null));
        assertEquals(false, r1.equals(new Object()));
    }

    @Test
    public void testaaHashCode() {
        Ruutu r3 = new Ruutu(10, 10);
        Ruutu r4 = new Ruutu(10, 10);
        Ruutu r5 = new Ruutu(11, 11);
        assertEquals(r3.hashCode(), r4.hashCode());
        assertEquals(false, r4.hashCode() == r5.hashCode());
        assertEquals(8867, r5.hashCode()); //ihan vaan mutanttien tappamiseksi..
    }

}
