/**
 * @author Larissa Seiler / lse19
 *         larissa.seiler@tu-clausthal.de
 * 
 * @author Levent Can Yilmaz / lcy19
 *         levent.can.yilmaz@tu-clausthal.de
 * 
 * @version 1.0
 */

package tuc.isse.Projekt_VierGewinnt;

import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

public class Main {

    public static void main(String[] args) {

        Bord gameBoard = new Bord(6, 7);

        try {

            gameBoard.dropToken(gameBoard.getToken(Color.RED), 0);
            gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 1);
            gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 2);
            gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
            gameBoard.dropToken(gameBoard.getToken(Color.RED), 1);
            gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 2);
            gameBoard.dropToken(gameBoard.getToken(Color.RED), 2);
            gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
            gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
            gameBoard.dropToken(gameBoard.getToken(Color.RED), 3);

            gameBoard.toString();

        } catch (ColumnFullException e) {
            e.printStackTrace();
        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }
    }
}
