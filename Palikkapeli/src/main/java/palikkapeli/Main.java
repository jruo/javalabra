package palikkapeli;

import palikkapeli.peli.Peli;

/**
 * Main-luokka, huolehtii pelin käynnistämisestä
 *
 * @author Janne Ruoho
 */
public class Main {

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        Peli.INSTANSSI.getTasonVaihtaja().seuraavaTaso();
    }
}
