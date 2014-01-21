package palikkapeli.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * Pelin ikkuna
 *
 * @author Janne Ruoho
 */
public class Ikkuna extends JFrame {

    private PiirtoPaneeli piirtoPaneeli;

    public Ikkuna(int leveys, int korkeus) {
        setResizable(false);
        setVisible(true);
        luoPaneeli(leveys, korkeus);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Luo ikkunaan PiirtoPaneelin
     *
     * @param leveys Paneelin leveys
     * @param korkeus Paneelin korkeus
     */
    private void luoPaneeli(int leveys, int korkeus) {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        piirtoPaneeli = new PiirtoPaneeli(leveys, korkeus);
        c.add(piirtoPaneeli, BorderLayout.CENTER);

        pack();
    }

    /**
     * Palauttaa piirtopaneelin
     *
     * @return Piirtopaneeli
     */
    public PiirtoPaneeli getPiirtoPaneeli() {
        return piirtoPaneeli;
    }

    /**
     * Lisää näppäimistönkuuntelijan ikkunaan
     *
     * @param kuuntelija Kuuntelija
     */
    public void lisaaNapaimistonKuuntelija(KeyListener kuuntelija) {
        addKeyListener(kuuntelija);
    }
}
