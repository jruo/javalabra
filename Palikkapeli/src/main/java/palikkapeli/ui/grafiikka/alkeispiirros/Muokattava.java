package palikkapeli.ui.grafiikka.alkeispiirros;

/**
 * Rajapinta muokattaville alkeispiirroksille (eli lähinnä tekstille)
 *
 * @author Janne Ruoho
 * @param <T> Muokkauksen tyyppi
 */
public interface Muokattava<T> {

    /**
     * Muokkausmetodi
     *
     * @param muokkaus Muokkaus
     */
    public void muokkaa(T muokkaus);
}
