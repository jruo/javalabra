package palikkapeli.peli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Yläluokka pelin komponenteille, jotka tarvitsevat tasaisen silmukan
 * toimiakseen (logiikka, grafiikka)
 *
 * @author Janne Ruoho
 * @param <T> Silmukkaan talletettavien päivitettävien olioiden tyyppi
 */
public abstract class PeliSilmukka<T> implements Runnable {

    public static final int PAIVITYKSIA_SEKUNNISSA = 60;
    private final List<T> oliot;
    private final Thread saie;
    private boolean kaynnissa;

    public PeliSilmukka() {
        oliot = new ArrayList<>();
        kaynnissa = false;
        saie = new Thread(this);
        saie.start();
    }

    /**
     * Lisaa annetun olion päivitettävien joukkoon
     *
     * @param lisattava Lisättävä olio
     */
    public void lisaaOlio(T lisattava) {
        if (oliot.contains(lisattava)) {
            return;
        }
        oliot.add(lisattava);
    }

    /**
     * Lisää kaikki annetut oliot päivitettävien joukkoon
     *
     * @param lisattavat Lisättävät oliot
     */
    public void lisaaOliot(T... lisattavat) {
        for (T lisattava : lisattavat) {
            lisaaOlio(lisattava);
        }
    }

    /**
     * Lisää kaikki annetut oliot päivitettävien joukkoon
     *
     * @param lisattavat Lisättävät oliot
     */
    public void lisaaOliot(Collection<? extends T> lisattavat) {
        for (T t : lisattavat) {
            lisaaOlio(t);
        }
    }

    /**
     * Poistaa annetun olion päivitettävien joukkoon
     *
     * @param poistettava Poistettava olio
     */
    public void poistaOlio(T poistettava) {
        if (oliot.contains(poistettava)) {
            oliot.remove(poistettava);
        }
    }

    /**
     * Tyhjentää päivitettävien olioiden joukon
     */
    public void tyhjennaOliot() {
        oliot.clear();
    }

    /**
     * Palauttaa päivitettävien olioiden joukon
     *
     * @return Päivitettävät oliot
     */
    public List<T> getOliot() {
        return oliot;
    }

    /**
     * Käynnistää silmukan
     */
    public void kaynnista() {
        kaynnissa = true;
    }

    /**
     * Pysäyttää silmukan
     */
    public void pysayta() {
        kaynnissa = false;
    }

    /**
     * Palauttaa silmukan tilan
     *
     * @return true jos käynnissä, muutoin false
     */
    public boolean onKaynnissa() {
        return kaynnissa;
    }

    /**
     * Nukkuu sellaisen ajan, että silmukan suoritus pysyisi jatkuvasti
     * mahdollisimman tasaisena
     *
     * @param paivitykseenKulunutAika Päivitykseen kulunut aika nanosekunteina
     */
    private void nuku(long paivitykseenKulunutAika) {
        double nukuttavaAika = laskeNukuttavaAika(paivitykseenKulunutAika);
        try {
            Thread.sleep(
                    laskeMilliAika(nukuttavaAika),
                    laskeYlimaarainenNanoAika(nukuttavaAika));
        } catch (InterruptedException ex) {
        }
    }

    /**
     * Laskee optimaalisen nukkumisajan päivitykseen kuluneen ajan perusteella
     *
     * @param paivitykseenKulunutAika Päivitykseen kulunut aika
     * @return Nukuttava aika nanosekunteina
     */
    private double laskeNukuttavaAika(long paivitykseenKulunutAika) {
        double paivityksenOptimiAika = (1D / PAIVITYKSIA_SEKUNNISSA) * 1000000000D;
        return paivityksenOptimiAika - paivitykseenKulunutAika;
    }

    /**
     * Laskee kuinka monta kokonaista millisekuntia on annetussa
     * nanosekuntiajassa
     *
     * @param nanoAika Aika nanosekunneissa
     * @return Aika millisekunneissa
     */
    private long laskeMilliAika(double nanoAika) {
        long milliAika = (long) nanoAika / 1000000;
        if (milliAika < 0) {
            return 0;
        }
        return milliAika;
    }

    /**
     * Laskee kuinka monta ylimääräistä nanosekuntia jää jäljelle, kun annetusta
     * ajasta vähennetään kokonaiset millisekunnit
     *
     * @param nanoAika Aika nanosekunneissa
     * @return Ylimääräiset nanosekunnit
     */
    private int laskeYlimaarainenNanoAika(double nanoAika) {
        //jaetaan, pyöristetään alaspäin ja kerrotaan uudelleen jotta saadaan pelkät millisekunnit
        long milliAika = (long) nanoAika / 1000000;
        long pyoristettyNanoAika = milliAika * 1000000;
        int erotus = (int) ((long) nanoAika - pyoristettyNanoAika);
        if (erotus < 0) {
            return 0;
        }
        if (erotus > 999999) {
            return 999999;
        }
        return erotus;
    }

    /**
     * Säikeen suoritus
     */
    @Override
    public void run() {
        long alkuAika = System.nanoTime();
        while (true) {
            if (kaynnissa) {
                paivita();
            }
            long loppuAika = System.nanoTime();
            nuku(loppuAika - alkuAika);
            alkuAika = System.nanoTime();
        }
    }

    /**
     * Metodi, jota silmukka kutsuu <tt>PAIVITYKSIA_SEKUNNISSA</tt> kertaa
     * sekunnissa
     */
    public abstract void paivita();
}
