/**
 * @author Larissa Seiler / lse19
 *         larissa.seiler@tu-clausthal.de
 * 
 * @author Levent Can Yilmaz / lcy19
 *         levent.can.yilmaz@tu-clausthal.de
 * 
 * @version 1.0
 */

package tuc.isse.Project_VierGewinnt;

import org.junit.Test;

import tuc.isse.Projekt_VierGewinnt.ColumnFullException;
import tuc.isse.Projekt_VierGewinnt.IllegalMoveException;
import tuc.isse.Projekt_VierGewinnt.controller.ConsoleGame;
import tuc.isse.Projekt_VierGewinnt.controller.MocPlayer;
import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

public class MocGameTest {

    /**
     * Here the game logic will be tested.
     * @throws IllegalMoveException
     * @throws ColumnFullException
     */
    @Test
    public void testMocGame() throws ColumnFullException, IllegalMoveException {

        Bord gameBoard = new Bord(6, 7);
        ConsoleGame game = new ConsoleGame(gameBoard);

        MocPlayer player1 = new MocPlayer(Color.RED, gameBoard, 0);
        MocPlayer player2 = new MocPlayer(Color.YELLOW, gameBoard, 1);

        game.doGame(player1, player2);
    }

}
