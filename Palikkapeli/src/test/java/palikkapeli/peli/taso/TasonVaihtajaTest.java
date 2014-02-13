package palikkapeli.peli.taso;

import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruutu;

/**
 *
 * @author Janne Ruoho
 */
public class TasonVaihtajaTest {

    TasonVaihtaja vaihtaja;
    Peli peli;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        peli = Peli.INSTANSSI;
        vaihtaja = new TasonVaihtaja();
        Field vaih = Peli.class.getDeclaredField("tasonVaihtaja");
        vaih.setAccessible(true);
        vaih.set(peli, vaihtaja);
        vaihtaja.getTasot().clear();
        vaihtaja.getTasot().add("/tasot/taso");
        vaihtaja.getTasot().add("/tasot/taso2");
        vaihtaja.getTasot().add("/tasot/taso3");
    }

    @Test
    public void seuraavaTasoToimii() {
        vaihtaja.seuraavaTaso();
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        vaihtaja.seuraavaTaso();
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        vaihtaja.seuraavaTaso();
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(4, 4)));
        vaihtaja.seuraavaTaso();
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(4, 4)));
    }

    @Test
    public void tasonResetointiToimii() {
        vaihtaja.seuraavaTaso();
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        peli.getRuudukko().alustaRuudukko();
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        vaihtaja.resetoiNykyinenTaso();
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
    }
}
