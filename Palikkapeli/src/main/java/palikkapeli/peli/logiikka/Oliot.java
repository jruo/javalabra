package palikkapeli.peli.logiikka;

import palikkapeli.peli.PeliKokoelma;
import palikkapeli.peli.olio.PeliOlio;

/**
 * Kokoelma koko pelin PeliOlioista. Sisältää hyödyllisiä metodeita muiden
 * olioiden kanssa toimimiseen
 *
 * @author Janne Ruoho
 */
public final class Oliot extends PeliKokoelma<PeliOlio> {

    /**
     * Suodatin, joka hyväksyy aina kaikki PeliOliot
     */
    private final Suodatin<PeliOlio> HYVAKSY_KAIKKI_SUODATIN = new Suodatin<PeliOlio>() {
        @Override
        public boolean hyvaksy(PeliOlio p) {
            return true;
        }
    };

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
    public <T> T getLuokanOlio(Class<T> luokka) {
        return getLuokanOlio(luokka, HYVAKSY_KAIKKI_SUODATIN);
    }

    /**
     * Etsii pelion olioista annetuntyyppistä luokkaa edustavan, suodatinta
     * vastaavan olion ja palauttaa sen. Jos olioita on useampia, niin palauttaa
     * niistä ensimmäisen
     *
     * @param <T> Luokka
     * @param luokka Luokka
     * @param suodatin Suodatin
     * @return Luokan olio, tai null jos sellaista ei löytynyt
     */
    public <T> T getLuokanOlio(Class<T> luokka, Suodatin<PeliOlio> suodatin) {
        for (PeliOlio olio : getOliot()) {
            if (luokka.isAssignableFrom(olio.getClass()) && suodatin.hyvaksy(olio)) {
                return (T) olio;
            }
        }
        return null;
    }
}
