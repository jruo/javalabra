package palikkapeli.ui;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Paneeli, johon kaikki pelin grafiikka piirretään
 *
 * @author Janne Ruoho
 */
public class PiirtoPaneeli extends JPanel {

    /**
     * Luo uuden PiirtoPaneelin annetulla leveydellä ja korkeudella
     *
     * @param leveys Leveys pikseleinä
     * @param korkeus Korkeus pikseleinä
     */
    public PiirtoPaneeli(int leveys, int korkeus) {
        setPreferredSize(new Dimension(leveys, korkeus));
    }
}
