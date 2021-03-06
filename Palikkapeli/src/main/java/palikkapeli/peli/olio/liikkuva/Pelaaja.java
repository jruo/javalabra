package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.ohjaus.Liikutettava;
import palikkapeli.peli.olio.apuolio.PelaajanVaihtaja;

/**
 * Pelaajaluokka
 *
 * @author Janne Ruoho
 */
public abstract class Pelaaja extends LiikkuvaPeliOlio implements Liikutettava {

    /**
     * Onko pelaaja ohjattavissa
     */
    private boolean ohjattavissa;
    /**
     * Suunta, johon pelaaja on liikkumassa
     */
    private Suunta liikkumissuunta;

    /**
     * Luo uuden Pelaajan annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public Pelaaja(int x, int y) {
        super(x, y);
        ohjattavissa = false;
    }

    /**
     * Asettaa ohjattavissa-tilan
     *
     * @param ohjattavissa
     */
    public void setOhjattavissa(boolean ohjattavissa) {
        this.ohjattavissa = ohjattavissa;
    }

    /**
     * Palauttaa ohjattavissa-tilan
     *
     * @return true jos ohjattavissa, false muutoin
     */
    public boolean onOhjattavissa() {
        return ohjattavissa;
    }

    @Override
    public final void liiku(Suunta suunta) {
        if (ohjattavissa) {
            liikkumissuunta = suunta;
            liikuSuuntaan(suunta);
        }
    }

    @Override
    public final void alusta() {
        PelaajanVaihtaja pv = oliot.getLuokanOlio(PelaajanVaihtaja.class);

        if (pv != null) {
            pv.lisaaPelaaja(this);
        } else {
            System.out.println("Virhe pelaajaoliota alustettaessa, PelaajanVaihtajaa ei löydy");
        }
    }

    @Override
    public boolean hyvaksySiirryttavaRuutu(final Ruutu siirryttava) {
        if (ruudukko.onTyyppiRuudussa(Laatikko.class, siirryttava)) {
            Laatikko laatikko = oliot.getLuokanOlio(Laatikko.class, ruudukko.suodataRuudunOliot(siirryttava));
            if (laatikko.getVari() != getVari()) {
                return false;
            }
            if (!laatikko.liikuSuuntaan(liikkumissuunta)) {
                return false;
            }
        }
        return true;
    }
}
