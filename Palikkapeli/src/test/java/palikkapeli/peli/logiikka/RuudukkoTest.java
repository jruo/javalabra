package palikkapeli.peli.logiikka;

import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.Peli;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.peli.olio.PeliOlioTestiLuokka;

/**
 *
 * @author Janne Ruoho
 */
public class RuudukkoTest {

    private PeliOlioTestiLuokka o1, o2, o3;

    @Before
    public void setUp() {
        o1 = new PeliOlioTestiLuokka(new Peli(), 0, 0);
        o2 = new PeliOlioTestiLuokka(new Peli(), 20, 20);
        o3 = new PeliOlioTestiLuokka(new Peli(), 50, 50);
    }

    @Test
    public void lisaaOlioToimii() {
        //o1 : [0][0]
        //o2 : [1][1]
        //o3 : [2][2]
        Set<PeliOlio> oliot1 = o1.getPeli().getRuudukko().getOlioListat()[0][0];
        Set<PeliOlio> oliot2 = o2.getPeli().getRuudukko().getOlioListat()[1][1];
        Set<PeliOlio> oliot3 = o3.getPeli().getRuudukko().getOlioListat()[2][2];
        assertEquals(true, oliot1.contains(o1));
        assertEquals(true, oliot2.contains(o2));
        assertEquals(true, oliot3.contains(o3));
    }

    @Test
    public void poistaOlioToimii() {
        o1.getPeli().getRuudukko().poistaOlio(o1);
        assertEquals(false, o1.getPeli().getRuudukko().onOlioRuudussa(new Ruutu(0, 0), o1));
    }

    @Test
    public void onTyhjaToimii() {
        assertEquals(false, o1.getPeli().getRuudukko().onTyhja(new Ruutu(0, 0)));
        assertEquals(true, o1.getPeli().getRuudukko().onTyhja(new Ruutu(0, 1)));
        assertEquals(true, o1.getPeli().getRuudukko().onTyhja(new Ruutu(1, 0)));
        assertEquals(true, o1.getPeli().getRuudukko().onTyhja(new Ruutu(1, 1)));
        assertEquals(true, o1.getPeli().getRuudukko().onTyhja(new Ruutu(2, 2)));
        assertEquals(true, o1.getPeli().getRuudukko().onTyhja(new Ruutu(5, 2)));

        assertEquals(false, o2.getPeli().getRuudukko().onTyhja(new Ruutu(1, 1)));
        assertEquals(true, o2.getPeli().getRuudukko().onTyhja(new Ruutu(0, 0)));
    }

    @Test
    public void onOlioRuudussaToimii() {
        assertEquals(true, o1.getPeli().getRuudukko().onOlioRuudussa(new Ruutu(0, 0), o1));
        assertEquals(false, o1.getPeli().getRuudukko().onOlioRuudussa(new Ruutu(0, 1), o1));
    }

    @Test
    public void olioRuudussaPalauttaaOikeanListan() {
        assertEquals(true, o1.getPeli().getRuudukko().oliotRuudussa(new Ruutu(0, 0)).contains(o1));
        assertEquals(false, o1.getPeli().getRuudukko().oliotRuudussa(new Ruutu(1, 0)).contains(o1));
    }

    @Test
    public void xyRuuduksiMuuttaaOikein() {
        Ruutu r1 = Ruudukko.xyRuuduksi(0, 0);
        Ruutu r2 = Ruudukko.xyRuuduksi(Ruudukko.RUUDUN_KOKO * 2, Ruudukko.RUUDUN_KOKO * 2);
        Ruutu r3 = Ruudukko.xyRuuduksi((int) (Ruudukko.RUUDUN_KOKO * 4.5), (int) (Ruudukko.RUUDUN_KOKO * 4.5));

        assertEquals(0, r1.getX());
        assertEquals(0, r1.getY());
        assertEquals(2, r2.getX());
        assertEquals(2, r2.getY());
        assertEquals(4, r3.getX());
        assertEquals(4, r3.getY());
    }

    @Test
    public void onKohdistettuPalauttaaOikein() {
        assertEquals(true, Ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO, Ruudukko.RUUDUN_KOKO));
        assertEquals(true, Ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO * 2, Ruudukko.RUUDUN_KOKO));
        assertEquals(true, Ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO, Ruudukko.RUUDUN_KOKO * 5));
        assertEquals(false, Ruudukko.onKohdistettu(Ruudukko.RUUDUN_KOKO * 2, Ruudukko.RUUDUN_KOKO + 1));
    }
}
