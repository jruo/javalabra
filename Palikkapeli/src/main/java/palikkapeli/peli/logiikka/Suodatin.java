package palikkapeli.peli.logiikka;

/**
 * Suodatin, jolla voi tarkistaa mitkä oliot hyväksytään tietyissä tilanteissa
 * ja mitkä ei
 *
 * @author Janne Ruoho
 * @param <T> Suodatettavan olion tyyppi
 */
public interface Suodatin<T> {

    /**
     * Tarkistaa, suodatetaanko vai hyväksytäänkö annettu olio
     *
     * @param suodatettava Tarkistettava olio
     * @return true jos hyväkytään, false jos suodatetaan
     */
    public boolean hyvaksy(T suodatettava);

}
