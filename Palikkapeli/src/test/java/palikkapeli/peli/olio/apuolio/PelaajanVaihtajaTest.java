package palikkapeli.peli.olio.apuolio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.peli.olio.liikkuva.PunainenPelaaja;
import palikkapeli.peli.olio.liikkuva.SininenPelaaja;
import palikkapeli.ui.syote.Nappain;

/**
 *
 * @author Janne Ruoho
 */
public class PelaajanVaihtajaTest {

    PelaajanVaihtaja pv;
    SininenPelaaja sp;
    PunainenPelaaja pp;

    @Before
    public void setUp() {
        pv = new PelaajanVaihtaja(0, 0);
        sp = new SininenPelaaja(20, 20);
        pp = new PunainenPelaaja(40, 40);
    }

    @Test
    public void aktivoivaNappainOnValilyonti() {
        assertEquals(Nappain.VALILYONTI, pv.getAktivoivaNappain());
    }

    @Test
    public void lisaaPelaajaAntaaOhjauksenEnsimmaiselleLisattavalle() {
        pv.lisaaPelaaja(pp);
        pv.lisaaPelaaja(sp);
        assertEquals(true, pp.onOhjattavissa());
        assertEquals(false, sp.onOhjattavissa());
    }

    @Test
    public void vaihdaPelaajaToimii() {
        pv.lisaaPelaaja(pp);
        pv.lisaaPelaaja(sp);
        assertEquals(true, pp.onOhjattavissa());
        assertEquals(false, sp.onOhjattavissa());
        pv.vaihdaPelaaja();
        assertEquals(false, pp.onOhjattavissa());
        assertEquals(true, sp.onOhjattavissa());
        pv.vaihdaPelaaja();
        assertEquals(true, pp.onOhjattavissa());
        assertEquals(false, sp.onOhjattavissa());
    }

    @Test
    public void seuraaValittuaPelaajaa() {
        pv.suoritaLogiikka();
        assertEquals(0, pv.getX());
        assertEquals(0, pv.getY());
        pv.lisaaPelaaja(pp);
        pv.suoritaLogiikka();
        assertEquals(40, pv.getX());
        assertEquals(40, pv.getY());
        pv.lisaaPelaaja(sp);
        pv.vaihdaPelaaja();
        pv.suoritaLogiikka();
        assertEquals(20, pv.getX());
        assertEquals(20, pv.getY());
    }

    @Test
    public void poistaPelaajaVaihtaaPelaajanJosPoistettavaValittuna() {
        pv.lisaaPelaaja(pp);
        pv.lisaaPelaaja(sp);
        pv.poistaPelaaja(pp);
        assertEquals(true, sp.onOhjattavissa());
        assertEquals(false, pp.onOhjattavissa());
    }

    @Test
    public void poistaPelaajaPoistaaPelaajan() {
        pv.lisaaPelaaja(pp);
        pv.lisaaPelaaja(sp);
        pv.poistaPelaaja(pp);
        assertEquals(true, sp.onOhjattavissa());
        pv.vaihdaPelaaja();
        assertEquals(true, sp.onOhjattavissa());
    }

    @Test
    public void aktivoiduEiVoiAktivoituaLiianUsein() throws InterruptedException {
        pv.lisaaPelaaja(pp);
        pv.lisaaPelaaja(sp);
        assertEquals(true, pp.onOhjattavissa());
        pv.aktivoidu();
        assertEquals(true, sp.onOhjattavissa());
        pv.aktivoidu();
        assertEquals(true, sp.onOhjattavissa());
        pv.aktivoidu();
        assertEquals(true, sp.onOhjattavissa());
        Thread.sleep(550);
        pv.aktivoidu();
        assertEquals(true, pp.onOhjattavissa());
        pv.aktivoidu();
        assertEquals(true, pp.onOhjattavissa());
    }

    @Test
    public void piirrosEiOleNull() {
        assertTrue(pv.luoOmaPiirros() != null);
    }

}
