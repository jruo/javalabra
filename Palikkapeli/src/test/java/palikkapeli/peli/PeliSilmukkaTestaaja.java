package palikkapeli.peli;

/**
 *
 * @author Janne Ruoho
 */
public class PeliSilmukkaTestaaja extends PeliSilmukka<PeliSilmukkaTestaajaRajapinta> {

    @Override
    public void paivita() {
        for (PeliSilmukkaTestaajaRajapinta pstr : getPaivitettavat()) {
            pstr.testaa();
        }
    }
    
}
