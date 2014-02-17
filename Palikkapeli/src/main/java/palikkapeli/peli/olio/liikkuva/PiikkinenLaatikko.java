package palikkapeli.peli.olio.liikkuva;

import palikkapeli.peli.logiikka.Ruutu;
import palikkapeli.peli.logiikka.Suunta;

/**
 * Piikkinen vaaka- tai pystysuuunnassa liikkuva laatikko, johon pelaaja ei saa
 * osua
 *
 * @author Janne Ruoho
 */
public abstract class PiikkinenLaatikko extends LiikkuvaPeliOlio {

    /**
     * Pysty/vaakasuuntainen suunta.
     */
    public enum Liikkumissuunta {

        VAAKA, PYSTY;
    }

    /**
     * Suunta, johon piikkinen laatikko on liikkumassa
     */
    private Suunta todellinenSuunta;

    /**
     * Luo uuden PiikkinenLaatikko -olion annettuihin koordinaatteihin
     *
     * @param x X
     * @param y Y
     */
    public PiikkinenLaatikko(int x, int y) {
        super(x, y);
    }

    @Override
    public void suoritaLiikkuvaLogiikka() {
        if (todellinenSuunta == null) {
            switch (getLiikkumissuunta()) {
                case VAAKA:
                    todellinenSuunta = Suunta.VASEN;
                    break;
                case PYSTY:
                    todellinenSuunta = Suunta.YLOS;
                    break;
            }
        }
        if (!liikuSuuntaan(todellinenSuunta)) {
            switch (todellinenSuunta) {
                case YLOS:
                    todellinenSuunta = Suunta.ALAS;
                    break;
                case ALAS:
                    todellinenSuunta = Suunta.YLOS;
                    break;
                case VASEN:
                    todellinenSuunta = Suunta.OIKEA;
                    break;
                case OIKEA:
                    todellinenSuunta = Suunta.VASEN;
                    break;
            }
        }
    }

    @Override
    public boolean hyvaksySiirryttavaRuutu(Ruutu siirryttava) {
        if (ruudukko.onTyyppiRuudussa(Pelaaja.class, siirryttava)) {
            peli.getTasonVaihtaja().resetoiNykyinenTaso();
        }
        return true;
    }

    /**
     * Palauttaa Liikkumissuunnan
     *
     * @return Liikkumissuunta, PYSTY/VAAKA
     */
    public abstract Liikkumissuunta getLiikkumissuunta();

}
