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

import tuc.isse.Projekt_VierGewinnt.ColumnFullException;
import tuc.isse.Projekt_VierGewinnt.IllegalMoveException;
import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

public class MocPlayer extends Player {

    private int move;

    public MocPlayer(Color color, Bord gameBoard, int move) {
        super(color, gameBoard);
        this.move = move;
    }

    /**
     * Here, input from the player is used in the doDrop function.
     */
    @Override
    public void doTurn() {
        try {
            super.doDrop(this.move);
        } catch (ColumnFullException e) {
            System.out.println(e.getMessage());
        } catch (IllegalMoveException e) {
            System.exit(1);
        }
    }
}
