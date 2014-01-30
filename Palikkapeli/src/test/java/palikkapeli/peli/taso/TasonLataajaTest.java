package palikkapeli.peli.taso;

import java.io.BufferedReader;
import java.io.IOException;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import palikkapeli.peli.Peli;

/**
 *
 * @author Janne Ruoho
 */
public class TasonLataajaTest {

    @Rule
    public ExpectedException virhe = ExpectedException.none();

    private TasonLataaja lataaja;
    private final String tiedosto = "/tasot/taso";
    private final String huonoTiedosto = "/tasot/tasoJokaEiOleOlemassa";
    private final String tiedostonSisalto
            = "1  0  0  0  0\n"
            + "1  0  0  0  0\n"
            + "0  0  10 0  0\n"
            + "0  0  0  0  0\n"
            + "0  0  0  0  0\n";
    private final String huonoTiedostonSisalto
            = "1  a  0  0  0\n"
            + "1  0  0  X  +\n"
            + "0  @  10 0  0\n"
            + "/  C  0  0  0\n"
            + "0  0  #  Ö  0\n";
    private final int[][] tiedostonSisaltoTaulukko = {
        {1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0},
        {0, 0, 10, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},};

    @Before
    public void setUp() {
        lataaja = new TasonLataaja(new Peli());
    }

    @Test
    public void luoLukijaToimii() {
        assertEquals(true, lataaja.luoLukija(tiedosto) != null);
    }

    @Test
    public void luoLukijaHeittaaVirheenJosHuonoTiedostonimi() {
        virhe.expect(NullPointerException.class);
        lataaja.luoLukija(huonoTiedosto);
    }

    @Test
    public void luoLukijaHeittaaVirheenJosNullTiedostonimi() {
        virhe.expect(NullPointerException.class);
        lataaja.luoLukija(null);
    }

    @Test
    public void lueTiedostoToimii() throws IOException {
        BufferedReader lukija = lataaja.luoLukija(tiedosto);
        String sisalto = lataaja.lueTiedosto(lukija);
        assertEquals(tiedostonSisalto, sisalto);
    }

    @Test
    public void lueTiedostoSulkeeLukijan() throws IOException {
        BufferedReader lukija = lataaja.luoLukija(tiedosto);
        lataaja.lueTiedosto(lukija);
        virhe.expect(IOException.class);
        lukija.readLine();
    }

    @Test
    public void luoTaulukkoMerkkijonostaToimii() {
        Assert.assertArrayEquals(tiedostonSisaltoTaulukko, lataaja.luoTaulukkoMerkkijonosta(tiedostonSisalto));
    }

    @Test
    public void luoTaulukkoMerkkijonostaHiettaaVirheenJosHuonoSyote() {
        virhe.expect(NumberFormatException.class);
        lataaja.luoTaulukkoMerkkijonosta(huonoTiedostonSisalto);
    }

    @Test
    public void lataaTasoPalauttaaTasoOlion() {
        assertEquals(true, lataaja.lataaTaso(tiedosto) instanceof Taso);
    }
}
