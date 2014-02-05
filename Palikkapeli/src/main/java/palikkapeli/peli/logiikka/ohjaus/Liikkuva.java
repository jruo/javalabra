package palikkapeli.peli.logiikka.ohjaus;

import palikkapeli.peli.logiikka.Suunta;

/**
 * Rajapinta liikutettaville olioille
 *
 * @author Janne Ruoho
 */
public interface Liikkuva extends Ohjautuva {

    /**
     * Liikkuu annettuun suuntaan
     *
     * @param suunta Suunta
     */
    public void liiku(Suunta suunta);
}
