/**
 * @author Larissa Seiler / lse19
 *         larissa.seiler@tu-clausthal.de
 * 
 * @author Levent Can Yilmaz / lcy19
 *         levent.can.yilmaz@tu-clausthal.de
 * 
 * @version 1.0
 */

package tuc.isse.Projekt_VierGewinnt.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.BordObserver;
import tuc.isse.Projekt_VierGewinnt.model.ObservableBord;

public class VierGewinntFrame extends JFrame implements BordObserver {

    private Bord bord;
    private JPanel panel;
    private JLabel[][] cell;
    private JButton[] buttons;
    private ActionListener listener;
    private final int row = 6;
    private final int column = 7;

    public VierGewinntFrame(Bord bord) {
        super("Vier Gewinnt");
        this.bord = bord;

        this.panel = (JPanel) this.getContentPane();
        this.panel.setLayout(new GridLayout(this.row + 1, this.column));
        this.cell = new JLabel[this.row][this.column];
        this.buttons = new JButton[this.column];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                cell[i][j] = new JLabel();
                cell[i][j].setBorder(new LineBorder(Color.BLACK));
                panel.add(cell[i][j]);
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("" + (i + 1));
            buttons[i].setActionCommand("" + i);
            this.panel.add(buttons[i]);
        }

        this.addButtonListener(this.listener);

        this.setSize(700, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Add ActionListener all the buttons in the array.
     * 
     * @param listener {@code ActionListener}
     */
    public void addButtonListener(ActionListener listener) {
        for (JButton jButton : buttons) {
            jButton.addActionListener(listener);
        }
    }

    /**
     * Remove ActionListener all the button in the array.
     * 
     * @param listener {@code ActionListener}
     */
    public void removeButtonListener(ActionListener listener) {
        for (JButton jButton : buttons) {
            jButton.removeActionListener(listener);
        }
    }

    @Override
    public void update(ObservableBord bord) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                this.bord.getTokenColor(i, j);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VierGewinntFrame frame = new VierGewinntFrame(new Bord(6, 7));
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
