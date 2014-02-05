package palikkapeli.peli;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Testaa samalla PeliKokoelma-yläluokan metodit
 *
 * @author Janne Ruoho
 */
public class PeliSilmukkaTest {

    private PeliSilmukkaTestaaja silmukka;
    private PeliSilmukkaTestaajaToteutus o1;
    private PeliSilmukkaTestaajaToteutus o2;
    private PeliSilmukkaTestaajaToteutus o3;

    @Before
    public void setUp() {
        silmukka = new PeliSilmukkaTestaaja();
        o1 = new PeliSilmukkaTestaajaToteutus();
        o2 = new PeliSilmukkaTestaajaToteutus();
        o3 = new PeliSilmukkaTestaajaToteutus();
    }

    @Test
    public void getOliotToimii() {
        assertTrue(silmukka.getOliot() != null);
    }

    @Test
    public void lisaaOlioToimii() {
        olioita(0);
        silmukka.lisaa(o1);
        olioita(1);
        silmukka.lisaa(o2);
        olioita(2);
        silmukka.lisaa(o2);
        olioita(2);
    }

    @Test
    public void lisaaOliotToimii1() {
        silmukka.lisaa(o1, o2);
        olioita(2);
        silmukka.lisaa(o2, o3);
        olioita(3);
    }

    @Test
    public void lisaaOliotToimii2() {
        List<PeliSilmukkaTestaajaToteutus> lista = new ArrayList<>();
        lista.add(o1);
        silmukka.lisaa(lista);
        olioita(1);
        lista.add(o2);
        lista.add(o3);
        silmukka.lisaa(lista);
        olioita(3);
    }

    @Test
    public void poistaOlioToimii() {
        silmukka.lisaa(o1, o2, o3);
        olioita(3);
        silmukka.poista(o1);
        olioita(2);
        silmukka.poista(o2);
        olioita(1);
        silmukka.poista(o1);
        olioita(1);
        silmukka.poista(o3);
        olioita(0);
    }

    @Test
    public void tyhjennaOliotToimii() {
        silmukka.lisaa(o1, o2, o3);
        olioita(3);
        silmukka.tyhjenna();
        olioita(0);
        silmukka.tyhjenna();
        olioita(0);
        silmukka.lisaa(o1);
        olioita(1);
        silmukka.tyhjenna();
        olioita(0);
    }

    @Test
    public void kaynnistysToimii() throws InterruptedException {
        assertEquals(0, o1.getLaskuri());
        silmukka.lisaa(o1);
        silmukka.kaynnista();
        Thread.sleep(50);
        assertTrue(o1.getLaskuri() > 1);
    }

    @Test
    public void pysaytysToimii() throws InterruptedException {
        silmukka.lisaa(o1);
        silmukka.kaynnista();
        Thread.sleep(50);
        silmukka.pysayta();
        int laskuri = o1.getLaskuri();
        Thread.sleep(50);
        assertEquals(laskuri, o1.getLaskuri());
    }

    @Test
    public void onKaynnissaPalauttaaOikein() {
        assertEquals(false, silmukka.onKaynnissa());
        silmukka.kaynnista();
        assertEquals(true, silmukka.onKaynnissa());
        silmukka.pysayta();
        assertEquals(false, silmukka.onKaynnissa());
        silmukka.pysayta();
        assertEquals(false, silmukka.onKaynnissa());
    }

    @Test
    public void nukkuuSuunnilleenOikeanAjan() throws InterruptedException {
        //testi säädetty arvolle PAIVITYKSIA_SEKUNNISSA = 60
        silmukka.lisaa(o1);
        silmukka.kaynnista();
        Thread.sleep(50);
        assertTrue(o1.getLaskuri() < 5);
    }

    @Test
    public void laskeNukuttavaAikaLaskeeOikein() {
        //PAIVITYKSIA_SEKUNNISSA = 60
        assertEquals(16666666.66666, silmukka.laskeNukuttavaAika(0), 1);
        assertEquals(10000000.00000, silmukka.laskeNukuttavaAika(6666667), 1);
        assertEquals(06666666.66666, silmukka.laskeNukuttavaAika(10000000), 1);
    }

    @Test
    public void laskeMilliAikaLaskeeOikein() {
        assertEquals(16, silmukka.laskeMilliAika(16666666.66666));
        assertEquals(10, silmukka.laskeMilliAika(10000000));
        assertEquals(1, silmukka.laskeMilliAika(1000000));
        assertEquals(0, silmukka.laskeMilliAika(500000));
        assertEquals(0, silmukka.laskeMilliAika(-10000000));
    }

    @Test
    public void laskeYlimaarainenNanoAikaLaskeeOikein() {
        assertEquals(666666, silmukka.laskeYlimaarainenNanoAika(16666666.66666));
        assertEquals(0, silmukka.laskeYlimaarainenNanoAika(10000000));
        assertEquals(1, silmukka.laskeYlimaarainenNanoAika(10000001));
        assertEquals(0, silmukka.laskeYlimaarainenNanoAika(-16666666.66666));
        assertEquals(999999, silmukka.laskeYlimaarainenNanoAika(19999999.99999));
    }

    public void olioita(int oikeaMaara) {
        assertEquals(oikeaMaara, silmukka.getOliot().size());
    }
}
