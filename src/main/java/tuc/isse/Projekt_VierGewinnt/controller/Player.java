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

import tuc.isse.Projekt_VierGewinnt.ColumnFullException;
import tuc.isse.Projekt_VierGewinnt.IllegalMoveException;
import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

/**
 * The class takes input from the user and applies it.
 */
public abstract class Player {

    protected Color color;
    protected Bord gameBoard;
    protected Token token;

    public Player(Color color, Bord gameBoard) {
        this.color = color;
        this.gameBoard = gameBoard;
        this.token = new Token(this.color);
    }

    /**
     * Here a matching color token is taken from the board and placed in the
     * specified column.
     * 
     * @param columnIndex {@code int} The number of the column
     * @throws ColumnFullException  : Throws an exception if the column is full.
     * @throws IllegalMoveException : Thrown when an exceptional illegal move has
     *                              occurred.
     */
    protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException {
        gameBoard.dropToken(this.token, columnIndex);
    }

    /**
     * Here, input from the player is used in the doDrop function.
     */
    public abstract void doTurn();
}
