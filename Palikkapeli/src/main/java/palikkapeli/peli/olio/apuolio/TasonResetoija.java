package palikkapeli.peli.olio.apuolio;

import palikkapeli.peli.logiikka.ohjaus.Aktivoitava;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.ui.syote.Nappain;

/**
 * Resetoi tason, kun käyttäjä painaa R-näppäintä
 *
 * @author Janne Ruoho
 */
public class TasonResetoija extends PeliOlio implements Aktivoitava {

    /**
     * Luo uuden TasonResetoijan, koordinaateilla ei ole merkitystä
     *
     * @param x
     * @param y
     */
    public TasonResetoija(int x, int y) {
        super(x, y);
    }

    @Override
    public void aktivoidu() {
        peli.getTasonVaihtaja().resetoiNykyinenTaso();
    }

    @Override
    public Nappain getAktivoivaNappain() {
        return Nappain.R;
    }

}
