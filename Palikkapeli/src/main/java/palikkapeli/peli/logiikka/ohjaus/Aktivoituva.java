package palikkapeli.peli.logiikka.ohjaus;

import palikkapeli.ui.syote.Nappain;

/**
 * Rajapinta näppäimistön tiettyyn näppäimeen reagoivalle oliolle
 *
 * @author Janne Ruoho
 */
public interface Aktivoituva extends Ohjautuva {

    /**
     * Metodi, jota kutsutaan kun näppäin on painettu
     */
    public void aktivoidu();

    /**
     * Palauttaa näppäimen, johon olio reagoi
     *
     * @return Nappain
     */
    public Nappain getAktivoivaNappain();

}
