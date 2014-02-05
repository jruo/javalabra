package palikkapeli.peli.olio;

import palikkapeli.peli.PeliKokoelma;

/**
 * Kokoelma koko pelin PeliOlioista. Sisältää hyödyllisiä metodeita muiden
 * olioiden kanssa toimimiseen
 *
 * @author Janne Ruoho
 */
public final class Oliot extends PeliKokoelma<PeliOlio> {

    /**
     * Alustaa kaikki kokoelman oliot
     */
    public void alustaOliot() {
        for (PeliOlio olio : getOliot()) {
            olio.alusta();
        }
    }

    /**
     * Etsii pelin olioista annetuntyyppistä luokkaa edustavan olion ja
     * palauttaa sen. Jos olioita on useampia, niin palauttaa niistä
     * ensimmäisen.
     *
     * @param <T> Luokka
     * @param luokka Luokka
     * @return Luokan olio, tai null jos sellaista ei löytynyt
     */
    public <T extends PeliOlio> T getLuokanOlio(Class<T> luokka) {
        for (PeliOlio olio : getOliot()) {
            if (olio.getClass().isAssignableFrom(luokka)) {
                return (T) olio;
            }
        }
        return null;
    }
}
