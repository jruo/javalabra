package palikkapeli.peli.olio.apuolio;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import palikkapeli.peli.Peli;
import palikkapeli.peli.logiikka.ohjaus.Aktivoitava;
import palikkapeli.peli.olio.PeliOlio;
import palikkapeli.peli.olio.liikkuva.Pelaaja;
import palikkapeli.ui.grafiikka.Piirros;
import palikkapeli.ui.syote.Nappain;

/**
 * Pitää huolen pelaajien välisen ohjauksen vaihtamisesta ja siitä, että vain
 * yhtä pelaajaa ohjataan kerrallaan
 *
 * @author Janne Ruoho
 */
public class PelaajanVaihtaja extends PeliOlio implements Aktivoitava {

    private final List<Pelaaja> pelaajat;
    private Pelaaja nykyinenOhjattava;
    private long viimeksiVaihdettu;

    public PelaajanVaihtaja(int x, int y) {
        super(x, y);
        pelaajat = new ArrayList<>();
        viimeksiVaihdettu = 0;
    }

    /**
     * Lisää pelaajan ohjauslistaan
     *
     * @param pelaaja Lisättävä pelaaja
     */
    public void lisaaPelaaja(Pelaaja pelaaja) {
        if (pelaajat.isEmpty()) {
            nykyinenOhjattava = pelaaja; //ensimmäinen pelaaja saa ohjauksen
            nykyinenOhjattava.setOhjattavissa(true);
        }
        pelaajat.add(pelaaja);
    }

    public void poistaPelaaja(Pelaaja pelaaja) {
        if (pelaajat.size() > 1 && nykyinenOhjattava.equals(pelaaja)) {
            vaihdaPelaaja();
        }
        if (pelaajat.size() == 1) {
            //jos poistettava pelaaja on viimeinen kentällä, niin taso läpi
            Peli.INSTANSSI.getTasonVaihtaja().seuraavaTaso();
        } else {
            pelaajat.remove(pelaaja);
        }
    }

    @Override
    public void suoritaLogiikka() {
        if (nykyinenOhjattava != null) {
            x = nykyinenOhjattava.getX();
            y = nykyinenOhjattava.getY();
        }
    }

    @Override
    public Piirros luoOmaPiirros() {
        //Valintaboxi, joka seuraa valittuna olevaa pelaajaa
        Piirros piirros = new Piirros(this);
        piirros.lisaaViiva(-2, -2, 1, -2, Color.darkGray);
        piirros.lisaaViiva(-2, -2, -2, 1, Color.darkGray);
        piirros.lisaaViiva(-2, 21, -2, 18, Color.darkGray);
        piirros.lisaaViiva(-2, 21, 1, 21, Color.darkGray);
        piirros.lisaaViiva(21, 21, 21, 18, Color.darkGray);
        piirros.lisaaViiva(21, 21, 18, 21, Color.darkGray);
        piirros.lisaaViiva(21, -2, 21, 1, Color.darkGray);
        piirros.lisaaViiva(21, -2, 18, -2, Color.darkGray);
        return piirros;
    }

    @Override
    public void aktivoidu() {
        if (pelaajat.isEmpty() || System.currentTimeMillis() - viimeksiVaihdettu < 500) {
            return;
        }
        vaihdaPelaaja();
        viimeksiVaihdettu = System.currentTimeMillis();
    }

    public void vaihdaPelaaja() {
        int koko = pelaajat.size();
        int nykyisenIndeksi = pelaajat.indexOf(nykyinenOhjattava);

        nykyinenOhjattava.setOhjattavissa(false);
        if (nykyisenIndeksi < koko - 1) {
            nykyinenOhjattava = pelaajat.get(nykyisenIndeksi + 1);
        } else {
            nykyinenOhjattava = pelaajat.get(0);
        }
        nykyinenOhjattava.setOhjattavissa(true);
    }

    @Override
    public Nappain getAktivoivaNappain() {
        return Nappain.VALILYONTI;
    }
}
