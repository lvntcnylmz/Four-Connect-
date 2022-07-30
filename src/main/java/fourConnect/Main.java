package fourConnect;

import fourConnect.models.Board;
import fourConnect.models.Token;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(6, 7);
        Token red = board.getRedToken();
        Token yellow = board.getYellowToken();

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

        board.testVictory();
        
    }
}