package palikkapeli.peli;

/**
 *
 * @author Janne Ruoho
 */
public class PeliSilmukkaTestaajaToteutus implements PeliSilmukkaTestaajaRajapinta {

    private int laskuri;

    public PeliSilmukkaTestaajaToteutus() {
        laskuri = 0;
    }

    public int getLaskuri() {
        return laskuri;
    }

    @Override
    public void testaa() {
        laskuri++;
    }

}
