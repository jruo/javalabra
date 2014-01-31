package palikkapeli.peli.logiikka;

import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Janne Ruoho
 */
public class RuudukkoTest {

    private RuudukkoTestiLuokka o1, o2, o3, o4;
    private Ruudukko<RuudukkoTestiLuokka> ruudukko;

    @Before
    public void setUp() {
        o1 = new RuudukkoTestiLuokka();
        o2 = new RuudukkoTestiLuokka();
        o3 = new RuudukkoTestiLuokka();
        o4 = new RuudukkoTestiLuokka();
        ruudukko = new Ruudukko<>();

        ruudukko.lisaaOlio(o1, new Ruutu(0, 0));
        ruudukko.lisaaOlio(o2, new Ruutu(1, 1));
        ruudukko.lisaaOlio(o3, new Ruutu(4, 4));
    }

    @Test
    public void lisaaOlioToimii() {
        Set[][] setti = ruudukko.getOlioJoukot();
        ruudukko.lisaaOlio(o3, new Ruutu(5, 5)); //sama uudelleen

        assertEquals(true, setti[0][0].contains(o1));
        assertEquals(true, setti[1][1].contains(o2));
        assertEquals(true, setti[4][4].contains(o3));
        assertEquals(false, setti[5][5].contains(o3));
        assertEquals(false, setti[1][1].contains(o3));
        assertEquals(false, setti[6][6].contains(o2));
        assertEquals(false, setti[0][6].contains(o1));
    }

    @Test
    public void poistaOlioToimii() {
        Set[][] setti = ruudukko.getOlioJoukot();

        ruudukko.poistaOlio(o1);
        assertEquals(false, setti[0][0].contains(o1));
        ruudukko.poistaOlio(o2);
        assertEquals(false, setti[1][1].contains(o2));
        ruudukko.poistaOlio(o3);
        assertEquals(false, setti[4][4].contains(o3));
    }

    @Test
    public void olionRuutuToimii() {
        assertEquals(new Ruutu(0, 0), ruudukko.olionRuutu(o1));
        assertEquals(new Ruutu(1, 1), ruudukko.olionRuutu(o2));
        assertEquals(new Ruutu(4, 4), ruudukko.olionRuutu(o3));
        assertEquals(false, new Ruutu(5, 5).equals(ruudukko.olionRuutu(o3)));
        assertEquals(null, ruudukko.olionRuutu(o4));
    }

    @Test
    public void onTyhjaToimii() {
        assertEquals(true, ruudukko.onTyhja(new Ruutu(0, 1)));
        assertEquals(true, ruudukko.onTyhja(new Ruutu(1, 0)));
        assertEquals(true, ruudukko.onTyhja(new Ruutu(0, 2)));
        assertEquals(true, ruudukko.onTyhja(new Ruutu(2, 1)));
        assertEquals(true, ruudukko.onTyhja(new Ruutu(3, 3)));
        assertEquals(false, ruudukko.onTyhja(new Ruutu(0, 0)));
        assertEquals(false, ruudukko.onTyhja(new Ruutu(1, 1)));
        assertEquals(false, ruudukko.onTyhja(new Ruutu(4, 4)));
    }

    @Test
    public void onOlioRuudussaToimii() {
        assertEquals(true, ruudukko.onOlioRuudussa(new Ruutu(0, 0), o1));
        assertEquals(true, ruudukko.onOlioRuudussa(new Ruutu(1, 1), o2));
        assertEquals(true, ruudukko.onOlioRuudussa(new Ruutu(4, 4), o3));
        assertEquals(false, ruudukko.onOlioRuudussa(new Ruutu(5, 5), o3));
        assertEquals(false, ruudukko.onOlioRuudussa(new Ruutu(1, 0), o1));
        assertEquals(false, ruudukko.onOlioRuudussa(new Ruutu(2, 2), o2));
    }

    @Test
    public void onTyyppiRuudussaToimii() {
        RuudukkoTestiLuokkaAlaluokkaYksi ala1 = new RuudukkoTestiLuokkaAlaluokkaYksi();
        RuudukkoTestiLuokkaAlaluokkaKaksi ala2 = new RuudukkoTestiLuokkaAlaluokkaKaksi();

        ruudukko.lisaaOlio(ala1, new Ruutu(10, 10));
        ruudukko.lisaaOlio(ala2, new Ruutu(11, 11));

        assertEquals(true, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaYksi.class, new Ruutu(10, 10)));
        assertEquals(false, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaKaksi.class, new Ruutu(10, 10)));

        assertEquals(false, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaYksi.class, new Ruutu(11, 11)));
        assertEquals(true, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaKaksi.class, new Ruutu(11, 11)));

        assertEquals(true, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokka.class, new Ruutu(0, 0)));
        assertEquals(false, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokka.class, new Ruutu(2, 2)));
    }

    @Test
    public void onTyyppiRuudussaToimiiJosUseitaSamassa() {
        RuudukkoTestiLuokkaAlaluokkaYksi ala1 = new RuudukkoTestiLuokkaAlaluokkaYksi();
        RuudukkoTestiLuokkaAlaluokkaKaksi ala2 = new RuudukkoTestiLuokkaAlaluokkaKaksi();

        ruudukko.lisaaOlio(ala1, new Ruutu(10, 10));
        ruudukko.lisaaOlio(ala2, new Ruutu(10, 10));

        assertEquals(true, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaYksi.class, new Ruutu(10, 10)));
        assertEquals(true, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaKaksi.class, new Ruutu(10, 10)));

        assertEquals(false, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaYksi.class, new Ruutu(11, 11)));
        assertEquals(false, ruudukko.onTyyppiRuudussa(RuudukkoTestiLuokkaAlaluokkaKaksi.class, new Ruutu(11, 11)));
    }

    @Test
    public void oliotRuudussaPalauttaaOikeanListan() {
        assertEquals(true, ruudukko.oliotRuudussa(new Ruutu(0, 0)).contains(o1));
        assertEquals(false, ruudukko.oliotRuudussa(new Ruutu(0, 0)).contains(o2));
        assertEquals(true, ruudukko.oliotRuudussa(new Ruutu(1, 1)).contains(o2));
    }

    @Test
    public void siirraOlioToimii() {
        ruudukko.siirraOlio(o1, new Ruutu(0, 1));
        assertEquals(true, ruudukko.onOlioRuudussa(new Ruutu(0, 1), o1));
        assertEquals(false, ruudukko.onOlioRuudussa(new Ruutu(0, 0), o1));

        ruudukko.siirraOlio(o1, new Ruutu(1, 1));
        assertEquals(true, ruudukko.onOlioRuudussa(new Ruutu(1, 1), o1));
        assertEquals(false, ruudukko.onOlioRuudussa(new Ruutu(0, 1), o1));
        assertEquals(true, ruudukko.onOlioRuudussa(new Ruutu(1, 1), o2));
    }

    @Test
    public void xyRuuduksiMuuttaaOikein() {
        Ruutu r1 = ruudukko.xyRuuduksi(0, 0);
        Ruutu r2 = ruudukko.xyRuuduksi(Ruudukko.RUUDUN_KOKO * 2, Ruudukko.RUUDUN_KOKO * 2);
        Ruutu r3 = ruudukko.xyRuuduksi((int) (Ruudukko.RUUDUN_KOKO * 4.5), (int) (Ruudukko.RUUDUN_KOKO * 4.99));

        assertEquals(0, r1.getX());
        assertEquals(0, r1.getY());
        assertEquals(2, r2.getX());
        assertEquals(2, r2.getY());
        assertEquals(4, r3.getX());
        assertEquals(4, r3.getY());
    }

    @Test
    public void onKohdistettuPalauttaaOikein() {
        assertEquals(true, ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO, Ruudukko.RUUDUN_KOKO));
        assertEquals(true, ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO * 2, Ruudukko.RUUDUN_KOKO));
        assertEquals(true, ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO, Ruudukko.RUUDUN_KOKO * 5));
        assertEquals(false, ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO * 2, Ruudukko.RUUDUN_KOKO + 1));
    }
}
