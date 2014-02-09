package palikkapeli.ui.syote;

import palikkapeli.peli.logiikka.ohjaus.Aktivoitava;

/**
 *
 * @author Janne Ruoho
 */
public class AktivoituvaTestiLuokka implements Aktivoitava {

    private int laskuri = 0;

    public int getLaskuri() {
        return laskuri;
    }

    @Override
    public void aktivoidu() {
        laskuri++;
    }

    @Override
    public Nappain getAktivoivaNappain() {
        return Nappain.VALILYONTI;
    }

}
