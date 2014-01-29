package palikkapeli.peli.logiikka.ohjaus;

/**
 * Rajapinta liikutettaville olioille
 *
 * @author Janne Ruoho
 */
public interface Liikkuva extends Ohjautuva {

    /**
     * Liikkuu ylös
     */
    public void liikuYlos();

    /**
     * Liikkuu alas
     */
    public void liikuAlas();

    /**
     * Liikkuu vasemmalle
     */
    public void liikuVasemmalle();

    /**
     * Liikkuu oikealle
     */
    public void liikuOikealle();
}
