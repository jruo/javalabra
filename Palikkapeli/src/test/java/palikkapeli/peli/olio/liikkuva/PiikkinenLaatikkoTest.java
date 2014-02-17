package palikkapeli.peli.olio.liikkuva;

import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.taso.TasonVaihtaja;

/**
 *
 * @author Janne Ruoho
 */
public class PiikkinenLaatikkoTest {

    private Peli peli;
    private TasonVaihtaja vaihtaja;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        peli = Peli.INSTANSSI;
        vaihtaja = new TasonVaihtaja();
        Field vaih = Peli.class.getDeclaredField("tasonVaihtaja");
        vaih.setAccessible(true);
        vaih.set(peli, vaihtaja);
        vaihtaja.getTasot().clear();
        vaihtaja.getTasot().add("/tasot/piikkilaatikkoTestiTaso");
        vaihtaja.seuraavaTaso();
    }

    @Test
    public void tasoResetoituuKunOsuuPelaajaan() throws InterruptedException {
        Pelaaja p = peli.getOliot().getLuokanOlio(Pelaaja.class);
        p.liiku(Suunta.YLOS);
        Thread.sleep(1000);
        p = peli.getOliot().getLuokanOlio(Pelaaja.class);
        assertEquals(new Ruutu(4, 1), p.omaRuutu());
    }

}
