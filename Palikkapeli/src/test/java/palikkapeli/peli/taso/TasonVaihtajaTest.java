package palikkapeli.peli.taso;

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
    public void setUp() {
        peli = new Peli();
        vaihtaja = new TasonVaihtaja(peli);
        vaihtaja.getTasot().clear();
        vaihtaja.getTasot().add("/tasot/taso");
        vaihtaja.getTasot().add("/tasot/taso2");
        vaihtaja.getTasot().add("/tasot/taso3");
    }

    @Test
    public void seuraavaTasoToimii() {
        peli.getTasonVaihtaja().seuraavaTaso();
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        peli.getTasonVaihtaja().seuraavaTaso();
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        peli.getTasonVaihtaja().seuraavaTaso();
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(4, 4)));
        peli.getTasonVaihtaja().seuraavaTaso();
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(1, 0)));
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(4, 4)));
    }
}
