package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.Vari;
import palikkapeli.peli.logiikka.ohjaus.Liikkuva;

/**
 * Pelaajaluokka
 *
 * @author Janne Ruoho
 */
public abstract class Pelaaja extends PeliOlio implements Liikkuva {

    private boolean liikkumassa, ohjattavissa;
    private Suunta liikkumisSuunta;
    private final Vari vari;

    public Pelaaja(Peli peli, int x, int y, Vari vari) {
        super(peli, x, y);
        liikkumassa = false;
        ohjattavissa = false;
        this.vari = vari;
    }

    /**
     * Tarkistaa pystyykö pelaaja liikkumaan annettuun suuntaan
     *
     * @param suunta Suunta
     * @return true jos pystyy, muutoin false
     */
    public boolean voiLiikkuaSuuntaan(Suunta suunta) {
        Ruutu liikuttava = omaRuutu().viereinen(suunta);
        if (!ruudukko.onKohdistettu(x, y)) {
            return false; //ei voi liikkua, jos ruutujen välissä
        }
        if (ruudukko.onTyyppiRuudussa(KiinteaSeina.class, liikuttava)) {
            return false; //jos ruudussa on seinä
        }
        if (ruudukko.onTyyppiRuudussa(Pelaaja.class, liikuttava)) {
            return false; //jos ruudussa on toinen pelaaja
        }
        return true; //voi liikkua
    }

    /**
     * Asettaa ohjattavissa-tilan
     *
     * @param ohjattavissa
     */
    public void setOhjattavissa(boolean ohjattavissa) {
        this.ohjattavissa = ohjattavissa;
    }

    @Override
    public final void liiku(Suunta suunta) {
        if (!ohjattavissa) {
            return;
        }
        if (voiLiikkuaSuuntaan(suunta)) {
            liikkumassa = true;
            liikkumisSuunta = suunta;
        }
    }

    @Override
    public final void suoritaOmaLogiikka() {
        if (liikkumassa) {
            x += liikkumisSuunta.getXSuunta() * 2;
            y += liikkumisSuunta.getYSuunta() * 2;
            if (ruudukko.onKohdistettu(x, y)) {
                liikkumassa = false;
            }
        }
    }

    @Override
    public final void alusta() {
        PelaajanVaihtaja pv = peli.getOliot().getLuokanOlio(PelaajanVaihtaja.class);
        if (pv != null) {
            pv.lisaaPelaaja(this);
        } else {
            System.out.println("Virhe pelaajaoliota alustettaessa, PelaajanVaihtajaa ei löydy");
        }
    }
}
