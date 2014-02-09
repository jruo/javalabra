package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.Varillinen;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.peli.olio.liikkumaton.KiinteaSeina;
import palikkapeli.peli.olio.liikkumaton.LapaisevaSeina;

/**
 * PeliOlio, joka pystyy liikkumaan ruudukossa. Liikkuvan PeliOlion täytyy olla
 * myös värillinen
 *
 * @author Janne Ruoho
 */
public abstract class LiikkuvaPeliOlio extends PeliOlio implements Varillinen {

    private boolean liikkumassa;
    private Suunta liikkumissuunta;

    public LiikkuvaPeliOlio(int x, int y) {
        super(x, y);
    }

    /**
     * Liikuttaa oliota annettuun suuntaan, jos se on mahdollista
     *
     * @param suunta Liikuttava suunta
     * @return true jos mahdollista, false muutoin
     */
    public final boolean liikuSuuntaan(Suunta suunta) {
        if (voiLiikkuaSuuntaan(suunta)) {
            liikkumassa = true;
            liikkumissuunta = suunta;
            return true;
        }
        return false;
    }

    /**
     * Tarkistaa, pystyykö olio liikkumaan annettuun suuntaan. Liikkuminen on
     * mahdollista vain jos ruudussa, johon yritetään liikkua ei ole liikkumista
     * estäviä muita olioita
     *
     * @param suunta Liikuttava suunta
     * @return true jos pystyy liikkumaan, false muutoin
     */
    public final boolean voiLiikkuaSuuntaan(Suunta suunta) {
        final Ruutu siirryttava = omaRuutu().viereinen(suunta);

        if (!ruudukko.onKohdistettu(x, y)) {
            return false; //ei voi liikkua, jos ruutujen välissä
        }
        if (ruudukko.onTyyppiRuudussa(KiinteaSeina.class, siirryttava)) {
            return false; //jos ruudussa on seinä
        }
        if (ruudukko.onTyyppiRuudussa(Pelaaja.class, siirryttava)) {
            return false; //jos ruudussa on pelaaja
        }
        if (ruudukko.onTyyppiRuudussa(LapaisevaSeina.class, siirryttava)) {
            LapaisevaSeina seina = oliot.getLuokanOlio(LapaisevaSeina.class, ruudukko.suodataRuudunOliot(siirryttava));
            if (seina.getVari() != getVari()) {
                return false; //jos ruudussa on läpäisevä seinä, mutta väärän värinen
            }
        }
        if (!hyvaksySiirryttavaRuutu(siirryttava)) {
            return false; //jos jotain muuta mitä aliluokan olio ei hyväksy
        }

        return true; //voi liikkua
    }

    @Override
    public final void suoritaLogiikka() {
        suoritaLiikkuvaLogiikka();
        if (liikkumassa) {
            x += liikkumissuunta.getXSuunta() * 2;
            y += liikkumissuunta.getYSuunta() * 2;
            if (ruudukko.onKohdistettu(x, y)) {
                liikkumassa = false;
            }
        }
        if (!omaRuutu().equals(sijaintiRuuduksi())) {
            ruudukko.siirraOlio(this, sijaintiRuuduksi());
        }
    }

    /**
     * Metodi, jossa aliluokan olio voi tarvittaessa suorittaa oman logiikkansa.
     * Tämä suoritetaan ennen liikkumista.
     */
    public void suoritaLiikkuvaLogiikka() {
    }

    /**
     * Tarkistaa pystyykö aliluokan olio siirtymään annettuun ruutuun
     *
     * @param siirryttava Tarkistettava ruutu
     * @return true, jos pystyy siirtymään, false muutoin
     */
    public abstract boolean hyvaksySiirryttavaRuutu(Ruutu siirryttava);

}
