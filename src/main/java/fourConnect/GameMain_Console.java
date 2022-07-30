package fourConnect;

import fourConnect.controller.ConsoleGame;
import fourConnect.controller.Game;

import fourConnect.models.Board;

public class GameMain_Console {

    public static void main(String[] args) {

        Board board = new Board(6, 7);

        Game game = new ConsoleGame(board);

        game.doGame(game.getPlayerRed(), game.getPlayerYellow());

    }

}
