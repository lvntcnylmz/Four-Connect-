package fourConnect.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fourConnect.models.Board;
import fourConnect.models.Color;

public abstract class Game {

    protected final Board board;
    private final Player playerRed;
    private final Player playerYellow;
    protected Player currentPlayer;
    private final List<Player> players;

    public Game(Board board) {
        this.board = board;
        this.players = new ArrayList<>(2);
        this.playerRed = new ConsolePlayer(board, Color.RED);
        this.playerYellow = new ConsolePlayer(board, Color.YELLOW);
        this.players.add(this.playerRed);
        this.players.add(this.playerYellow);
    }

    /**
     * Chooses a random player to start the game
     */
    protected void chooseRandomPlayer() {
        Random random = new Random();
        this.currentPlayer = players.get(random.nextInt(2));
    }

    /**
     * Changes the current player
     */
    protected void swapPlayer() {
        if (this.currentPlayer == playerRed) {
            this.currentPlayer = playerYellow;
        }
        else if (this.currentPlayer == playerYellow) {
            this.currentPlayer = playerRed;
        }
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public Player getPlayerYellow() {
        return playerYellow;
    }

    public abstract void doGame(Player player1, Player player2);

}
