package palikkapeli.peli.taso;

import java.awt.Color;
import java.util.ArrayList;
import palikkapeli.peli.Peli;
import palikkapeli.peli.oliot.FPSLaskuri;
import palikkapeli.peli.oliot.KiinteaSeina;
import palikkapeli.peli.oliot.Pelaaja;
import palikkapeli.peli.oliot.PeliOlio;
import palikkapeli.ui.grafiikka.Piirros;
import palikkapeli.ui.grafiikka.alkeispiirros.Teksti;

/**
 * Huolehtii tasojen vaihtamisesta
 *
 * @author Janne Ruoho
 */
public class TasonVaihtaja {

    private final Peli peli;

    public TasonVaihtaja(Peli peli) {
        this.peli = peli;
        luoTestiTaso();
    }

    /**
     * testausmetodi
     */
    private void luoTestiTaso() {
        ArrayList<PeliOlio> oliot = new ArrayList<>();
        ArrayList<Piirros> piirrokset = new ArrayList<>();

        Pelaaja pelaaja = new Pelaaja(peli, 20, 20);
        Piirros pelaajanPiirros = new Piirros(pelaaja);
        pelaajanPiirros.lisaaSuorakulmio(0, 0, 20, 20, Color.red, true);
        pelaajanPiirros.lisaaSuorakulmio(0, 20, 20, 20, Color.blue, true);
        oliot.add(pelaaja);
        piirrokset.add(pelaajanPiirros);

        for (int i = 0; i < 10; i++) {
            KiinteaSeina seina = new KiinteaSeina(peli, 0, i * 20);
            Piirros seinanPiirros = new Piirros(seina);
            seinanPiirros.lisaaSuorakulmio(0, 0, 20, 20, Color.gray, true);
            oliot.add(seina);
            piirrokset.add(seinanPiirros);
        }

        FPSLaskuri laskuri = new FPSLaskuri(peli);
        Piirros laskurinPiirros = new Piirros(laskuri);
        Teksti laskurinTeksti = laskurinPiirros.lisaaTeksti(10, 20, "FPS: 0", Color.black);
        laskuri.asetaMuokattavaTeksti(laskurinTeksti);

        oliot.add(laskuri);
        piirrokset.add(laskurinPiirros);

        peli.getLogiikka().lisaaOliot(oliot);
        peli.getGrafiikka().lisaaOliot(piirrokset);

        peli.getLogiikka().kaynnista();
        peli.getGrafiikka().kaynnista();
    }
}
