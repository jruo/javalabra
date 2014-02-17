package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.peli.logiikka.Varillinen;
import palikkapeli.peli.olio.PeliOlio;

/**
 * PeliOlio, joka pystyy liikkumaan ruudukossa. Liikkuvan PeliOlion täytyy olla
 * myös värillinen
 *
 * @author Janne Ruoho
 */
public abstract class LiikkuvaPeliOlio extends PeliOlio {

    /**
     * Onko olio liikkumassa tällä hetkellä
     */
    private boolean liikkumassa;
    /**
     * Suunta, johon olio on liikkumassa
     */
    private Suunta liikkumissuunta;

    /**
     * Luo uuden LiikkuvaPeliOlio-olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
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
        return liikkumassa;
    }

    /**
     * Tarkistaa, pystyykö olio liikkumaan annettuun suuntaan. Liikkuminen on
     * mahdollista vain jos ruudussa, johon yritetään liikkua ei ole liikkumista
     * estäviä muita olioita
     *
     * @param suunta Liikuttava suunta
     * @return false jos ei pysty liikkumaan, true muutoin
     */
    public final boolean voiLiikkuaSuuntaan(Suunta suunta) {
        final Ruutu siirryttava = omaRuutu().viereinen(suunta);

        if (!ruudukko.onKohdistettu(x, y)) {
            return false; //ei voi liikkua, jos ruutujen välissä
        }
        if (!hyvaksySiirryttavaRuutu(siirryttava)) {
            return false; //tarkistetaan aliluokan omat liikkumisrajoitukset
        }
        if (ruudukko.onTyyppiRuudussa(Varillinen.class, siirryttava)) {
            Varillinen varillinen = oliot.getLuokanOlio(Varillinen.class, ruudukko.suodataRuudunOliot(siirryttava));
            if (varillinen.getVari() != getVari() || varillinen.getVari() == Vari.EI_MIKAAN) {
                return false;
                //ei voi liikkua, jos ruudussa on jokin olio, jonka väri eroaa
                //liikutettavan olion väristä, tai olio on väritön (esim.
                //kiinteä seinä tai liikkuva piikkiseinä)
            }
        }

        return true; //voi liikkua
    }

    @Override
    public final void suoritaLogiikka() {
        suoritaLiikkuvaLogiikka();
        if (liikkumassa) {
            x += liikkumissuunta.getX() * 2;
            y += liikkumissuunta.getY() * 2;
            if (ruudukko.onKohdistettu(x, y)) {
                liikkumassa = false;
            }
        }
        if (omaRuutu() != null && !omaRuutu().equals(sijaintiRuuduksi())) {
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
     * @return false jos ei pysty liikkumaan, muutoin true
     */
    public abstract boolean hyvaksySiirryttavaRuutu(Ruutu siirryttava);

}
