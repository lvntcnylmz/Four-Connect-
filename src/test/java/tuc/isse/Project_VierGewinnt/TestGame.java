package tuc.isse.Project_VierGewinnt;

import org.junit.Test;

import fourConnect.exceptions.ColumnFullException;
import fourConnect.exceptions.IllegalMoveException;
import fourConnect.models.Board;
import fourConnect.models.Color;

/**
 * Test class
 */
public class TestGame {

	/**
	 * Creating object from class
	 */
	Board gameBoard = new Board(6, 7);

	@Test
	public void testGameBoard() {

		try {
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 5);

			gameBoard.toString();
			gameBoard.testVictory();

		} catch (ColumnFullException e) {
			e.printStackTrace();
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGameBoard2() {

		try {
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 1);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 0);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);

			gameBoard.toString();
			gameBoard.testVictory();

		} catch (ColumnFullException e) {
			e.printStackTrace();
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGameBoard3() {

		try {
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 3);

			gameBoard.toString();
			gameBoard.testVictory();

		} catch (ColumnFullException e) {
			e.printStackTrace();
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGameBoard4() {

		try {
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 1);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 0);

			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 1);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 0);

			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 1);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 0);

			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 1);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 0);

			gameBoard.dropToken(gameBoard.getToken(Color.RED), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 1);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 0);

			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 6);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 5);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 4);
			gameBoard.dropToken(gameBoard.getToken(Color.RED), 3);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 2);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 1);
			gameBoard.dropToken(gameBoard.getToken(Color.YELLOW), 0);

			gameBoard.toString();
			gameBoard.testVictory();

		} catch (ColumnFullException e) {
			e.printStackTrace();
		} catch (IllegalMoveException e) {
			e.printStackTrace();
		}
	}
}
