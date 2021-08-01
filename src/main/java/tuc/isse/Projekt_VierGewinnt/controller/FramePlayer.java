/**
 * @author Larissa Seiler / lse19
 *         larissa.seiler@tu-clausthal.de
 * 
 * @author Levent Can Yilmaz / lcy19
 *         levent.can.yilmaz@tu-clausthal.de
 * 
 * @version 1.0
 */

package tuc.isse.Projekt_VierGewinnt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;
import tuc.isse.Projekt_VierGewinnt.view.VierGewinntFrame;

public class FramePlayer extends Player implements ActionListener {

    private VierGewinntFrame frame;

    public FramePlayer(Color color, Bord gameBoard, VierGewinntFrame frame) {
        super(color, gameBoard);
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        e.getActionCommand();
    }

    @Override
    public void doTurn() {
       
    }

}
