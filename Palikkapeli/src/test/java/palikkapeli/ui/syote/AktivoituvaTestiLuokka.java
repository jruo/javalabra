package palikkapeli.ui.syote;

import palikkapeli.peli.logiikka.ohjaus.Aktivoituva;

/**
 *
 * @author Janne Ruoho
 */
public class AktivoituvaTestiLuokka implements Aktivoituva {

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
