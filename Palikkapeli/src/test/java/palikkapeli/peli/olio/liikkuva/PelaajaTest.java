package palikkapeli.peli.olio.liikkuva;

import java.lang.reflect.Field;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.olio.apuolio.PelaajanVaihtaja;
import palikkapeli.peli.taso.TasonVaihtaja;

/**
 * Tämä testi testaa käytännössä myös liikutettavat laatikot
 *
 * @author Janne Ruoho
 */
public class PelaajaTest {

    private Peli peli;
    private TasonVaihtaja vaihtaja;
    private SininenPelaaja sp;
    private PunainenPelaaja pp;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        peli = Peli.INSTANSSI;
        vaihtaja = new TasonVaihtaja();
        Field vaih = Peli.class.getDeclaredField("tasonVaihtaja");
        vaih.setAccessible(true);
        vaih.set(peli, vaihtaja);
        vaihtaja.getTasot().clear();
        vaihtaja.getTasot().add("/tasot/pelaajaTestiTaso");
        vaihtaja.seuraavaTaso();
        //sininen pelaaja on ohjattavissa
        sp = peli.getOliot().getLuokanOlio(SininenPelaaja.class);
        pp = peli.getOliot().getLuokanOlio(PunainenPelaaja.class);
    }

    @Test
    public void alustettaessaLisataanPelaajanVaihtajaan() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        PelaajanVaihtaja pv = peli.getOliot().getLuokanOlio(PelaajanVaihtaja.class);
        Field pelaajat = PelaajanVaihtaja.class.getDeclaredField("pelaajat");
        pelaajat.setAccessible(true);
        List<Pelaaja> lista = (List<Pelaaja>) pelaajat.get(pv);
        assertEquals(true, lista.contains(sp));
        assertEquals(true, lista.contains(pp));
    }

    @Test
    public void eiVoiLiikkuaSeinaan() throws InterruptedException {
        Ruutu r1 = sp.omaRuutu();
        liikuta(sp, Suunta.OIKEA);
        Ruutu r2 = sp.omaRuutu();
        assertEquals(r1, r2);
    }

    @Test
    public void voiLiikkuaTyhjaan() throws InterruptedException {
        Ruutu r1 = sp.omaRuutu();
        liikuta(sp, Suunta.YLOS);
        Ruutu r2 = sp.omaRuutu();
        assertFalse(r1.equals(r2));
    }

    @Test
    public void voiLiikkuaOmanVariseenSeinaan() throws InterruptedException {
        Ruutu r1 = sp.omaRuutu();
        liikuta(sp, Suunta.ALAS);
        Ruutu r2 = sp.omaRuutu();
        assertFalse(r1.equals(r2));
    }

    @Test
    public void voiTyontaaOmanVaristaLaatikkoa() throws InterruptedException {
        SininenLaatikko laatikko = peli.getOliot().getLuokanOlio(SininenLaatikko.class, peli.getRuudukko().suodataRuudunOliot(new Ruutu(1, 3)));

        liikuta(sp, Suunta.ALAS);
        Ruutu r1 = sp.omaRuutu();
        Ruutu lr1 = laatikko.omaRuutu();
        liikuta(sp, Suunta.ALAS);
        Ruutu r2 = sp.omaRuutu();
        Ruutu lr2 = laatikko.omaRuutu();
        assertFalse(r1.equals(r2));
        assertFalse(lr1.equals(lr2));
    }

    @Test
    public void eiVoiLiikkuaEriVariseenSeinaan() throws InterruptedException {
        Ruutu r1 = sp.omaRuutu();
        liikuta(sp, Suunta.VASEN);
        Ruutu r2 = sp.omaRuutu();
        assertEquals(r1, r2);
    }

    @Test
    public void eiVoiTyontaaEriVaristaLaatikkoa() throws InterruptedException {
        SininenLaatikko laatikko = peli.getOliot().getLuokanOlio(SininenLaatikko.class, peli.getRuudukko().suodataRuudunOliot(new Ruutu(4, 1)));

        PelaajanVaihtaja pv = peli.getOliot().getLuokanOlio(PelaajanVaihtaja.class);
        pv.vaihdaPelaaja();
        Ruutu r1 = pp.omaRuutu();
        Ruutu lr1 = laatikko.omaRuutu();
        liikuta(pp, Suunta.OIKEA);
        Ruutu r2 = pp.omaRuutu();
        Ruutu lr2 = laatikko.omaRuutu();
        assertEquals(r1, r2);
        assertEquals(lr1, lr2);
    }

    @Test
    public void eiVoiTyontaaLaatikkoaToiseenLaatikkoon() throws InterruptedException {
        PelaajanVaihtaja pv = peli.getOliot().getLuokanOlio(PelaajanVaihtaja.class);
        pv.vaihdaPelaaja();
        liikuta(pp, Suunta.ALAS);
        liikuta(pp, Suunta.ALAS);
        Ruutu r1 = pp.omaRuutu();
        liikuta(pp, Suunta.ALAS);
        Ruutu r2 = pp.omaRuutu();
        assertEquals(r1, r2);
    }

    @Test
    public void eiVoiLiikkuaJosJoLiikkumassa() throws InterruptedException {
        sp.liiku(Suunta.YLOS);
        Thread.sleep(50);
        assertEquals(false, sp.voiLiikkuaSuuntaan(Suunta.YLOS));
    }

    private void liikuta(Pelaaja p, Suunta s) throws InterruptedException {
        p.liiku(s);
        Thread.sleep(500);
    }
}
