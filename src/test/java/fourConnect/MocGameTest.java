package fourConnect;

import org.junit.Test;

import fourConnect.controller.ConsoleGame;
import fourConnect.controller.MocPlayer;
import fourConnect.exceptions.ColumnFullException;
import fourConnect.exceptions.IllegalMoveException;
import fourConnect.models.Board;
import fourConnect.models.Color;

public class MocGameTest {

    /**
     * Here the game logic will be tested.
     * @throws IllegalMoveException
     * @throws ColumnFullException
     */
    @Test
    public void testMocGame() throws ColumnFullException, IllegalMoveException {

        Board gameBoard = new Board(6, 7);
        ConsoleGame game = new ConsoleGame(gameBoard);

        MocPlayer player1 = new MocPlayer(gameBoard, Color.RED, 0);
        MocPlayer player2 = new MocPlayer(gameBoard, Color.YELLOW, 1);

        game.doGame(player1, player2);
    }

}
