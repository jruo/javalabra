package palikkapeli.peli.olio.apuolio;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import palikkapeli.ui.syote.Nappain;

/**
 *
 * @author Janne Ruoho
 */
public class TasonResetoijaTest {

    TasonResetoija tr;

    @Before
    public void setUp() {
        tr = new TasonResetoija(0, 0);
    }

    @Test
    public void aktivoivaNappainOnR() {
        assertEquals(Nappain.R, tr.getAktivoivaNappain());
    }

}
