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

public class ConsoleGame extends Game {

    public ConsoleGame(Bord gameBoard) {
        super(gameBoard);
    }

    /**
     * The method implements the core game loop of the game. A random player is
     * chosen to start. After the game board is displayed, the player is asked for a
     * move, until there is a winner or a draw in a the game.
     * 
     * @param player1 {@code Player}
     * @param player2 {@code Player}
     */
    @Override
    public void doGame(Player player1, Player player2) {

        players.add(player1);
        players.add(player2);

        firstPlayer();

        while (ConsolePlayer.doTurn) {
            gameBoard.toString();
            System.out.print("Player " + this.currentPlayer.color.getTokenString() + ", what is your next move?\nInput : ");
            this.currentPlayer.doTurn();
            swapPlayer();
        }
    }

}
