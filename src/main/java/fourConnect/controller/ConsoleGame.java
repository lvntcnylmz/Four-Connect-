package fourConnect.controller;

import fourConnect.models.Board;
import fourConnect.models.Winner;

public class ConsoleGame extends Game {

    public ConsoleGame(Board board) {
        super(board);
    }

    /**
     * The method implements the core gameplay loop of the game. A random player is
     * chosen to start. After the game board is displayed, players are asked for a move,
     * until there is a winner or game ends in a draw.
     * 
     * @param player1 {@code Player} : Red or Yellow Player
     * @param player2 {@code Player} : Red or Yellow Player
     */
    @Override
    public void doGame(Player player1, Player player2) {

        chooseRandomPlayer();

        while (board.testVictory() == Winner.NONE) {
            board.toString();
            System.out.print("Player " + currentPlayer.getToken().toString() + ", what is your next move?\nInput : ");
            currentPlayer.doTurn();
            swapPlayer();
        }

        board.toString();

        board.getWinner();

    }

}
