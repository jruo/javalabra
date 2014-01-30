package palikkapeli;

import palikkapeli.peli.Peli;

/**
 * Main-luokka, huolehtii pelin käynnistämisestä
 *
 * @author Janne Ruoho
 */
public class Main {

    public static void main(String[] args) {
        Peli peli = new Peli();
        peli.getTasonVaihtaja().seuraavaTaso();
    }
}
