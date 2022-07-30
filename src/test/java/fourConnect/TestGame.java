package fourConnect;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fourConnect.models.Board;
import fourConnect.models.Color;
import fourConnect.models.Token;
import fourConnect.models.Winner;

/**
 * Test class
 */
public class TestGame {

    Board board;
    Token red;
    Token yellow;
    Winner yellowWinner;
    Winner redWinner;
    Winner tie;
    
    @Before
    public void setUp() {
        this.board = new Board(6, 7);
        this.red = new Token(Color.RED);
        this.yellow = new Token(Color.YELLOW);
        this.redWinner = Winner.RED;
        this.yellowWinner = Winner.YELLOW;
        this.tie = Winner.TIE;
    }

    @Test
    public void test_WinnerYellow_RowVictory() {

        board.dropToken(yellow, 3);
        board.dropToken(red, 3);
        board.dropToken(yellow, 4);
        board.dropToken(yellow, 5);
        board.dropToken(yellow, 5);
        board.dropToken(red, 5);
        board.dropToken(yellow, 6);
        board.dropToken(red, 6);
        board.dropToken(red, 7);
        board.dropToken(red, 7);
        board.dropToken(red, 7);
        board.dropToken(yellow, 7);

        board.toString();

        assertEquals(this.yellowWinner, board.testVictory());

    }

    @Test
    public void test_WinnerRed_ColumnVictory() {

        board.dropToken(yellow, 1);
        board.dropToken(red, 2);
        board.dropToken(yellow, 3);
        board.dropToken(red, 3);
        board.dropToken(red, 4);
        board.dropToken(yellow, 5);
        board.dropToken(red, 5);
        board.dropToken(red, 5);
        board.dropToken(red, 5);
        board.dropToken(red, 5);
        board.dropToken(yellow, 6);
        board.dropToken(red, 6);
        board.dropToken(yellow, 7);
        board.dropToken(yellow, 7);
        board.dropToken(yellow, 7);

        board.toString();

        assertEquals(this.redWinner, board.testVictory());

    }

    @Test
    public void test_WinnerRed_DiagonalVictory() {

        board.dropToken(yellow, 4);
        board.dropToken(yellow, 4);
        board.dropToken(red, 4);
        board.dropToken(red, 4);
        board.dropToken(yellow, 5);
        board.dropToken(yellow, 5);
        board.dropToken(red, 5);
        board.dropToken(yellow, 6);
        board.dropToken(red, 6);
        board.dropToken(red, 7);
        board.dropToken(red, 7);
        board.dropToken(red, 7);
        board.dropToken(yellow, 7);

        board.toString();

        assertEquals(this.redWinner, board.testVictory());

    }

    @Test
    public void test_WinnerTie_GameDraw() {

        for (int i = 1; i < 8; i++) {
            if (i == 4) {
                board.dropToken(yellow, i);
                board.dropToken(red, i);
                board.dropToken(yellow, i);
                board.dropToken(red, i);
                board.dropToken(yellow, i);
                board.dropToken(red, i);

                i++;
            }

            board.dropToken(red, i);
            board.dropToken(yellow, i);
            board.dropToken(red, i);
            board.dropToken(yellow, i);
            board.dropToken(red, i);
            board.dropToken(yellow, i);
        }

        board.toString();
        
        assertEquals(this.tie, board.testVictory());

    }

}
