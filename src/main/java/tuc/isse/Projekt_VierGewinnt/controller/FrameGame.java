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

import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.BordObserver;
import tuc.isse.Projekt_VierGewinnt.model.ObservableBord;
import tuc.isse.Projekt_VierGewinnt.view.VierGewinntFrame;

public class FrameGame extends Game implements BordObserver{

    private VierGewinntFrame frame;

    public FrameGame(Bord gameBoard, VierGewinntFrame frame) {
        super(gameBoard);
        this.frame = frame;
    }

    @Override
    public void update(ObservableBord bord) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doGame(Player player1, Player player2) {
        this.players.add(player1);
        this.players.add(player2);

        this.firstPlayer();

    }
    
}
