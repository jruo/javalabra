package palikkapeli.peli.olio.liikkumaton;

import palikkapeli.peli.logiikka.Varillinen;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.peli.olio.apuolio.PelaajanVaihtaja;
import palikkapeli.peli.olio.liikkuva.Pelaaja;

/**
 * Pelaajien maali
 *
 * @author Janne Ruoho
 */
public abstract class TasonMaali extends PeliOlio implements Varillinen {

    /**
     * Onko pelaaja jo käsitelty
     */
    private boolean pelaajaPoistettu;

    /**
     * Luo uuden TasonMaalin annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public TasonMaali(int x, int y) {
        super(x, y);
        pelaajaPoistettu = false;
    }

    @Override
    public void suoritaLogiikka() {
        if (ruudukko.onTyyppiRuudussa(Pelaaja.class, omaRuutu())) {
            Pelaaja pelaaja = oliot.getLuokanOlio(Pelaaja.class, ruudukko.suodataRuudunOliot(omaRuutu()));
            if (pelaaja.getVari() == getVari() && !pelaajaPoistettu && ruudukko.onKohdistettu(pelaaja.getX(), pelaaja.getY())) {
                PelaajanVaihtaja pv = oliot.getLuokanOlio(PelaajanVaihtaja.class);
                pv.poistaPelaaja(pelaaja);
                pelaajaPoistettu = true;
            }
        }
    }
}
