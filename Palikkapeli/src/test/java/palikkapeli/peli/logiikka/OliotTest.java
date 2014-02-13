package palikkapeli.peli.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.peli.olio.PeliOlioTestiLuokka;
import palikkapeli.peli.olio.liikkuva.Pelaaja;

/**
 *
 * @author Janne Ruoho
 */
public class OliotTest {

    Oliot oliot;
    PeliOlioTestiLuokka o1, o2, o3;

    @Before
    public void setUp() {
        oliot = new Oliot();
        o1 = new PeliOlioTestiLuokka(0, 0);
        o2 = new PeliOlioTestiLuokka(1, 1);
        o3 = new PeliOlioTestiLuokka(0, 0);
        oliot.lisaa(o1, o2, o3);
    }

    @Test
    public void alustusAlustaaOliot() {
        oliot.alustaOliot();
        assertEquals(true, o1.onAlustettu());
        assertEquals(true, o2.onAlustettu());
        assertEquals(true, o3.onAlustettu());
    }

    @Test
    public void getLuokanOlioPalauttaaEnsimmaisenLisatyn() {
        assertEquals(o1, oliot.getLuokanOlio(PeliOlioTestiLuokka.class));
    }

    @Test
    public void getLuokanOlioPalauttaaNullJosEiLoydy() {
        assertEquals(null, oliot.getLuokanOlio(Pelaaja.class));
    }

    @Test
    public void getLuokanOlioSuodattimellaPalauttaaOikeanOlion() {
        assertEquals(o2, oliot.getLuokanOlio(PeliOlio.class, new Suodatin<PeliOlio>() {
            @Override
            public boolean hyvaksy(PeliOlio suodatettava) {
                return suodatettava.getX() == 1 && suodatettava.getY() == 1;
            }
        }));
    }

    @Test
    public void getLuokanOlioSuodattimellaPalauttaaEnsimmaisenSuodatintaVastaavan() {
        assertEquals(o1, oliot.getLuokanOlio(PeliOlio.class, new Suodatin<PeliOlio>() {
            @Override
            public boolean hyvaksy(PeliOlio suodatettava) {
                return suodatettava.getX() == 0 && suodatettava.getY() == 0;
            }
        }));
    }
}
