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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

/**
 * The class coordinates the two players and determines a winner.
 */
public abstract class Game {

    protected Bord gameBoard;
    private Player playerRed;
    private Player playerYellow;
    protected Player currentPlayer;
    protected List<Player> players;

    public Game(Bord gameBoard) {
        this.gameBoard = gameBoard;
        this.players = new ArrayList<>();
        this.setPlayerRed(new ConsolePlayer(Color.RED, gameBoard));
        this.setPlayerYellow(new ConsolePlayer(Color.YELLOW, gameBoard));
    }

    public Player getPlayerYellow() {
        return playerYellow;
    }

    public void setPlayerYellow(Player playerYellow) {
        this.playerYellow = playerYellow;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public void setPlayerRed(Player playerRed) {
        this.playerRed = playerRed;
    }

    /**
     * Method chooses a random player.
     * 
     * @return {@code Player}
     */
    protected Player firstPlayer() {
        Random random = new Random();
        this.currentPlayer = this.players.get(random.nextInt(this.players.size()));
        return currentPlayer;
    }

    /**
     * The method changes the current player.
     */
    protected void swapPlayer() {
        if (this.currentPlayer == this.getPlayerRed()) {
            this.currentPlayer = this.getPlayerYellow();
        } else {
            currentPlayer = this.getPlayerRed();
        }
    }

    public abstract void doGame(Player player1, Player player2);
}
