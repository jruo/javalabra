package palikkapeli.peli.taso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import palikkapeli.peli.Peli;

/**
 * Lataa tasot tiedostosta
 *
 * @author Janne Ruoho
 */
public class TasonLataaja {

    private final Peli peli;

    public TasonLataaja(Peli peli) {
        this.peli = peli;
    }

    /**
     * Lataa tason annetusta tiedostosta
     *
     * @param tiedostonimi Tason tiedostonimi
     * @return Taso
     */
    public Taso lataaTaso(String tiedostonimi) {
        try {
            BufferedReader lukija = luoLukija(tiedostonimi);
            String tiedostonSisalto = lueTiedosto(lukija);
            int[][] tasonIDt = luoTaulukkoMerkkijonosta(tiedostonSisalto);
            return new Taso(peli, tasonIDt);
        } catch (NullPointerException | NumberFormatException | IOException ex) {
            System.out.println("Virhe yritettäessä ladata tasoa " + tiedostonimi);
            System.exit(1);
            return null;
        }
    }

    /**
     * Luo lukijan tasotiedoston lukemiseen
     *
     * @param tiedostonimi Tason tiedostonimi
     * @return Lukija
     * @throws NullPointerException Heittää virheen jos tiedostoa ei ole
     * olemassa tai sitä ei voi lukea tjs
     */
    public BufferedReader luoLukija(String tiedostonimi) throws NullPointerException {
        InputStream striimi = getClass().getResourceAsStream(tiedostonimi);
        BufferedReader lukija = new BufferedReader(new InputStreamReader(striimi));
        return lukija;
    }

    /**
     * Lukee tiedoston sisällön ja tallentaa sen sellaisenaan merkkijonoon
     *
     * @param lukija Lukija tiedoston lukemiseen
     * @return Tiedoston sisältä
     * @throws IOException Heittää virheen, jos tiedostoa ei voi lukea
     */
    public String lueTiedosto(BufferedReader lukija) throws IOException {
        StringBuilder teksti = new StringBuilder();
        String rivi;
        while ((rivi = lukija.readLine()) != null) {
            teksti.append(rivi);
            teksti.append("\n");
        }
        lukija.close();
        return teksti.toString();
    }

    /**
     * Muuttaa merkkijonomuotoisena olevan taulukon int[][]-tyyppiseksi
     *
     * @param merkkijono Merkkijono
     * @return Taulukko
     * @throws NumberFormatException Jos merkkijono sisältää jotain joka ei ole
     * numero niin heittää virheen
     */
    public int[][] luoTaulukkoMerkkijonosta(String merkkijono) throws NumberFormatException {
        String[] merkkijonoRivit = merkkijono.split("\n");
        int korkeus = merkkijonoRivit.length;

        int[][] taulukko = new int[korkeus][];

        for (int i = 0; i < korkeus; i++) {
            StringTokenizer st = new StringTokenizer(merkkijonoRivit[i]);
            int leveys = st.countTokens();

            int[] rivi = new int[leveys];

            for (int j = 0; j < leveys; j++) {
                rivi[j] = Integer.parseInt(st.nextToken());
            }

            taulukko[i] = rivi;
        }

        return taulukko;
    }
}
