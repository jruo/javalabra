package palikkapeli.peli;

import java.util.ConcurrentModificationException;

/**
 * Yläluokka pelin komponenteille, jotka tarvitsevat tasaisen silmukan
 * toimiakseen (logiikka, grafiikka, ohjaus)
 *
 * @author Janne Ruoho
 * @param <T> Silmukkaan talletettavien päivitettävien olioiden tyyppi
 */
public abstract class PeliSilmukka<T> extends PeliKokoelma<T> implements Runnable {

    /**
     * Kuinka monta kertaa sekunnissa silmukka päivittyy
     */
    public static final int PAIVITYKSIA_SEKUNNISSA = 60;
    /**
     * Silmukan säie
     */
    private final Thread saie;
    /**
     * Silmukan tila
     */
    private boolean kaynnissa;

    /**
     * Luo uuden PeliSilmukan
     */
    public PeliSilmukka() {
        kaynnissa = false;
        saie = new Thread(this);
        saie.start();
    }

    /**
     * Käynnistää silmukan
     */
    public final void kaynnista() {
        kaynnissa = true;
    }

    /**
     * Pysäyttää silmukan
     */
    public final void pysayta() {
        kaynnissa = false;
    }

    /**
     * Palauttaa silmukan tilan
     *
     * @return true jos käynnissä, muutoin false
     */
    public final boolean onKaynnissa() {
        return kaynnissa;
    }

    /**
     * Nukkuu sellaisen ajan, että silmukan suoritus pysyisi jatkuvasti
     * mahdollisimman tasaisena
     *
     * @param paivitykseenKulunutAika Päivitykseen kulunut aika nanosekunteina
     */
    public final void nuku(long paivitykseenKulunutAika) {
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
    public final double laskeNukuttavaAika(long paivitykseenKulunutAika) {
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
    public final long laskeMilliAika(double nanoAika) {
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
    public final int laskeYlimaarainenNanoAika(double nanoAika) {
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
                try {
                    paivita();
                } catch (ConcurrentModificationException e) {
                    //listoja muokattiin kesken suorituksen...
                }
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
