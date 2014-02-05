package palikkapeli.ui.syote;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Näppäimistönkäsittelijä, pitää kirjaa mitkä näppäimet on painettu ja mitkä ei
 *
 * @author Janne Ruoho
 */
public final class Nappaimisto {

    private final KeyListener kuuntelija;
    private final Map<Integer, Boolean> nappaintenTodellinenTila, nappaintenSynkronoituTila;

    public Nappaimisto() {
        kuuntelija = new NappaimistonKuuntelija();
        nappaintenTodellinenTila = new HashMap<>();
        nappaintenSynkronoituTila = new HashMap<>();
    }

    /**
     * Palauttaa näppäimistönkuuntelijan
     *
     * @return Näppäimistönkuuntelija
     */
    public KeyListener getKuuntelija() {
        return kuuntelija;
    }

    /**
     * Synkronoi näppäimistön tilan tarkistuksia varten. Ilman synkronointia
     * saattaisi tulla tilanne, että saman silmukan päivityssyklin aikana eri
     * oliot saisivat ristiriitaista informaatiota näppäinten tiloista
     */
    public void synkronoi() {
        nappaintenSynkronoituTila.putAll(nappaintenTodellinenTila);
    }

    /**
     * Asettaa annetun näppäimen tilan joko painetuksi tai vapautetuksi
     *
     * @param nappainKoodi Näppäin
     * @param painettu Tila (true = painettu, false = vapautettu)
     */
    public void asetaNappaimenTila(int nappainKoodi, boolean painettu) {
        nappaintenTodellinenTila.put(nappainKoodi, painettu);
    }

    /**
     * Tarkistaa onko annettu näppäin painettu
     *
     * @param nappainKoodi Näppäimen koodi
     * @return true jos painettu, muutoin false
     */
    public boolean onPainettu(int nappainKoodi) {
        if (!nappaintenSynkronoituTila.containsKey(nappainKoodi)) {
            return false;
        }
        return nappaintenSynkronoituTila.get(nappainKoodi);
    }

    /**
     * Palauttaa koko kartan nappainten todellisista tiloista
     *
     * @return Näppäinten tilakartta
     */
    public Map<Integer, Boolean> getNappaintenTodellinenTila() {
        return nappaintenTodellinenTila;
    }

    /**
     * Palauttaa koko kartan näppäinten synkronoiduista tiloista
     *
     * @return Näppäinten rilakartta
     */
    public Map<Integer, Boolean> getNappaintenSynkronoituTila() {
        return nappaintenSynkronoituTila;
    }

    /**
     * Näppäimistönkuuntelijaluokka
     */
    public class NappaimistonKuuntelija implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            asetaNappaimenTila(e.getKeyCode(), true);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            asetaNappaimenTila(e.getKeyCode(), false);
        }
    }
}
