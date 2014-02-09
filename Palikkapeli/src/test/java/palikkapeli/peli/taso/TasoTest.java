package palikkapeli.peli.taso;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.olio.liikkumaton.KiinteaSeina;
import palikkapeli.peli.olio.liikkuva.Pelaaja;
import palikkapeli.peli.olio.liikkuva.PunainenPelaaja;
import palikkapeli.peli.olio.liikkuva.SininenPelaaja;

/**
 *
 * @author Janne Ruoho
 */
public class TasoTest {

    Taso taso1, taso2;
    Peli peli;
    int[][] oliot1 = {
        {1, 0, 11},
        {0, 1, 12},
        {0, 0, 1},
        {10, 999}
    };
    int[][] oliot2 = {
        {0, 1, 0},
        {1, 0, 0},
        {1, 0, 0}
    };

    @Before
    public void setUp() {
        peli = new Peli();
        taso1 = new Taso(peli, oliot1);
        taso2 = new Taso(peli, oliot2);
    }

    @Test
    public void muutaLuokaksiMuuttaaOikein() {
        assertEquals(null, taso1.muutaLuokaksi(-1));
        assertEquals(null, taso1.muutaLuokaksi(Integer.MAX_VALUE));
        assertEquals(null, taso1.muutaLuokaksi(0));
        assertEquals(KiinteaSeina.class, taso1.muutaLuokaksi(1));
        assertEquals(SininenPelaaja.class, taso1.muutaLuokaksi(11));
    }

    @Test
    public void rakennaTasoLuoOliotOikeisiinRuutuihin() {
        taso1.rakennaTaso();
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(1, 1)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(2, 2)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(SininenPelaaja.class, new Ruutu(2, 0)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(PunainenPelaaja.class, new Ruutu(2, 1)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(Pelaaja.class, new Ruutu(2, 1)));
    }

    @Test
    public void tyhjennaVanhaTasoTyhjentaaKaiken() {
        taso1.rakennaTaso();
        taso1.tyhjennaVanhaTaso();
        assertEquals(true, peli.getLogiikka().getOliot().isEmpty());
        assertEquals(true, peli.getGrafiikka().getOliot().isEmpty());
        assertEquals(true, peli.getOhjain().getOliot().isEmpty());
        assertEquals(true, peli.getOliot().getOliot().isEmpty());
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 1)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(0, 2)));
        assertEquals(true, peli.getRuudukko().onTyhja(new Ruutu(2, 2)));
    }

    @Test
    public void rakenntaTasoTyhjentaaVanhanTasonPoisAlta() {
        taso1.rakennaTaso();
        taso2.rakennaTaso();
        assertEquals(false, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(0, 0)));
        assertEquals(false, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(1, 1)));
        assertEquals(false, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(2, 2)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(1, 0)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(0, 1)));
        assertEquals(true, peli.getRuudukko().onTyyppiRuudussa(KiinteaSeina.class, new Ruutu(0, 2)));
    }

    @Test
    public void rakennaTasoLisaaKaikkiOliotKaikkiinKokoelmiin() {
        taso1.rakennaTaso();
        assertEquals(false, peli.getLogiikka().getOliot().isEmpty());
        assertEquals(false, peli.getGrafiikka().getOliot().isEmpty());
        assertEquals(false, peli.getOhjain().getOliot().isEmpty());
        assertEquals(false, peli.getOliot().getOliot().isEmpty());
        assertEquals(false, peli.getRuudukko().onTyhja(new Ruutu(0, 0)));
    }
}
