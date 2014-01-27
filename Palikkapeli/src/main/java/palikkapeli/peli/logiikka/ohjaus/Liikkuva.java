package palikkapeli.peli.logiikka.ohjaus;

/**
 *
 * @author Janne Ruoho
 */
public interface Liikkuva extends Ohjautuva {

    public void liikuYlos();

    public void liikuAlas();

    public void liikuVasemmalle();

    public void liikuOikealle();
}
