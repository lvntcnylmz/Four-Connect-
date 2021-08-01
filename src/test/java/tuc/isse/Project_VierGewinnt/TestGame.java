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
import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

/**
 * Test class
 */
public class TestGame {

	/**
	 * Creating object from class
	 */
	Bord gameBoard = new Bord(6, 7);

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
