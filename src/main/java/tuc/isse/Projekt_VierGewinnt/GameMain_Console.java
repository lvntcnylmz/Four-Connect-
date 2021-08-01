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

import tuc.isse.Projekt_VierGewinnt.controller.ConsoleGame;
import tuc.isse.Projekt_VierGewinnt.controller.Game;
import tuc.isse.Projekt_VierGewinnt.model.Bord;

/**
 * The main class that runs the game.
 */
public class GameMain_Console {

    public static void main(String[] args) {

        Bord gameBoard = new Bord(6, 7);

        Game game = new ConsoleGame(gameBoard);

        game.doGame(game.getPlayerRed(), game.getPlayerYellow());

    }
}
