package palikkapeli.ui;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Paneeli, johon kaikki pelin grafiikka piirretään
 *
 * @author Janne Ruoho
 */
public class PiirtoPaneeli extends JPanel {

    public PiirtoPaneeli(int leveys, int korkeus) {
        setPreferredSize(new Dimension(leveys, korkeus));
    }
}
