package palikkapeli.peli.olio;

import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.Suunta;
import palikkapeli.peli.logiikka.ohjaus.Liikkuva;
import palikkapeli.ui.grafiikka.Piirros;

/**
 * Pelaajaluokka
 *
 * @author Janne Ruoho
 */
public class Pelaaja extends PeliOlio implements Liikkuva {

    private boolean liikkumassa;
    private Suunta liikkumisSuunta;

    public Pelaaja(Peli peli, int x, int y) {
        super(peli, x, y);
        liikkumassa = false;
    }

    public void liiku(Suunta suunta) {
        //testausta... tulee muuttumaan
        if (ruudukko.onKohdistettu(x, y)) {
            if (!ruudukko.onTyyppiRuudussa(KiinteaSeina.class, omaRuutu().viereinen(suunta))) {
                liikkumassa = true;
                liikkumisSuunta = suunta;
            }
        }
    }

    @Override
    public void suoritaOmaLogiikka() {
        if (liikkumassa) {
            x += liikkumisSuunta.getXSuunta() * 2;
            y += liikkumisSuunta.getYSuunta() * 2;
            if (ruudukko.onKohdistettu(x, y)) {
                liikkumassa = false;
            }
        }
    }

    @Override
    public void liikuYlos() {
        liiku(Suunta.YLOS);
    }

    @Override
    public void liikuAlas() {
        liiku(Suunta.ALAS);
    }

    @Override
    public void liikuVasemmalle() {
        liiku(Suunta.VASEN);
    }

    @Override
    public void liikuOikealle() {
        liiku(Suunta.OIKEA);
    }

    @Override
    public Piirros luoOmaPiirros() {
        return new Piirros(this, "/kuvat/pelaaja.png");
    }
}
