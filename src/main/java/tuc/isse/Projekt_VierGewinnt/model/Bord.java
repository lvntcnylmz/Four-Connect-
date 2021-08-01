/**
 * @author Larissa Seiler / lse19
 *         larissa.seiler@tu-clausthal.de
 * 
 * @author Levent Can Yilmaz / lcy19
 *         levent.can.yilmaz@tu-clausthal.de
 * 
 * @version 1.0
 */

package tuc.isse.Projekt_VierGewinnt.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import tuc.isse.Projekt_VierGewinnt.ColumnFullException;
import tuc.isse.Projekt_VierGewinnt.IllegalMoveException;
import tuc.isse.Projekt_VierGewinnt.controller.Winner;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

/**
 * Class creates the game board.
 */
public class Bord extends GameObject {

    private final int column;
    private final int row;
    private String[][] gameBoard;
    private Map<Token, Integer> tokenStock;
    private Token redToken = new Token(Color.RED);
    private Token yellowToken = new Token(Color.YELLOW);

    public Bord(int row, int column) {
        this.column = column;
        this.row = row;
        this.gameBoard = new String[row][column];
        this.tokenStock = new HashMap<Token, Integer>();
        this.tokenStock.put(redToken, 21);
        this.tokenStock.put(yellowToken, 21);
    }

    /**
     * With the help of this method it is possible to drop a token into a certain
     * column on the board.
     * 
     * @param color       {@code enum} : {@code Color.RED} for red token or
     *                    {@code Color.YELLOW} for yellow token
     * @param columnIndex {@code int}: column index of array
     * @throws ColumnFullException  : Throws an exception if the column is full.
     * @throws IllegalMoveException : Thrown when an exceptional illegal move has
     *                              occurred.
     */
    public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {

        for (int i = row - 1; i >= 0; i--) {
            if (canDrop(columnIndex)) {
                if (gameBoard[i][columnIndex] == null) {
                    if (token.getColor() == Color.RED) {
                        gameBoard[i][columnIndex] = Color.RED.getTokenString();
                        break;
                    } else {
                        gameBoard[i][columnIndex] = Color.YELLOW.getTokenString();
                        break;
                    }
                }
            } else {
                throw new ColumnFullException();
            }
        }

        if (isRowVictory(token.getColor()) || isColumnVictory(token.getColor()) || isDiagonalVictory(token.getColor())) {
            toString();
            testVictory();
            throw new IllegalMoveException();
        }
    }

    /**
     * Checks the column full is.
     * 
     * @param columnIndex : column index of array
     * @return {@code bool} false if the column is full, true otherwise.
     */
    public boolean canDrop(int columnIndex) {
        for (int i = row - 1; i >= 0; i--) {
            if (gameBoard[i][columnIndex] == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the game board on the console.
     */
    public void displayGameBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (gameBoard[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + gameBoard[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

    /**
     * Displays the game board on the console.
     * 
     * @return {@code String}
     */
    @Override
    public String toString() {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (gameBoard[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + gameBoard[i][j] + "]");
                }
            }
            System.out.println();
        }

        for (int i = 0; i <= row; i++) {
            System.out.print("[" + i + "]");
        }
        System.out.println();
        return Arrays.deepToString(gameBoard);
    }

    /**
     * This method checks whether four stones of the same color are in the same row.
     * 
     * @param color {@code enum} : {@code Color.RED} for red token or
     *              {@code Color.YELLOW} for yellow token
     * @return {@code bool}
     */
    private boolean isRowVictory(Color color) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameBoard[i][j] == color.getTokenString() && gameBoard[i][j + 1] == color.getTokenString()
                        && gameBoard[i][j + 2] == color.getTokenString()
                        && gameBoard[i][j + 3] == color.getTokenString()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks whether four stones of the same color are in the same
     * column.
     * 
     * @param color {@code enum} : {@code Color.RED} for red token or
     *              {@code Color.YELLOW} for yellow token
     * @return {@code bool}
     */
    private boolean isColumnVictory(Color color) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < column; j++) {
                if (gameBoard[i][j] == color.getTokenString() && gameBoard[i + 1][j] == color.getTokenString()
                        && gameBoard[i + 2][j] == color.getTokenString()
                        && gameBoard[i + 3][j] == color.getTokenString()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks whether four stone of the same color are diagonal at one
     * point on the board.
     * 
     * @param color {@code enum} : {@code Color.RED} for red token or
     *              {@code Color.YELLOW} for yellow token
     * @return {@code bool}
     */
    private boolean isDiagonalVictory(Color color) {

        /**
         * This for loop checks the game board from top left to bottom right.
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameBoard[i][j] == color.getTokenString() && gameBoard[i + 1][j + 1] == color.getTokenString()
                        && gameBoard[i + 2][j + 2] == color.getTokenString()
                        && gameBoard[i + 3][j + 3] == color.getTokenString()) {
                    return true;
                }
            }
        }

        /**
         * This for loop checks the game board from top right to bottom left.
         */
        for (int i = 0; i < 3; i++) {
            for (int j = column - 1; j > 2; j--) {
                if (gameBoard[i][j] == color.getTokenString() && gameBoard[i + 1][j - 1] == color.getTokenString()
                        && gameBoard[i + 2][j - 2] == color.getTokenString()
                        && gameBoard[i + 3][j - 3] == color.getTokenString()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks if the game is a draw.
     * 
     * @return {@code bool}
     */
    private boolean isTie() {

        if (hasToken(Color.RED) == false || hasToken(Color.YELLOW) == false) {
            return true;
        }
        return false;
    }

    /**
     * This method tests all 3 ways a player can win the game
     * 
     * @return {@code:enum} Red, Yellow or None
     */
    public Winner testVictory() {

        Winner winner = Winner.NONE;

        if (!isTie()) {
            if (isRowVictory(Color.RED) || isColumnVictory(Color.RED) || isDiagonalVictory(Color.RED)) {
                winner = Winner.RED;
            } else if (isRowVictory(Color.YELLOW) || isColumnVictory(Color.YELLOW) || isDiagonalVictory(Color.YELLOW)) {
                winner = Winner.YELLOW;
            } else {
                winner = Winner.NONE;
            }
            System.out.println("Winner is " + winner);
        } else {
            winner = Winner.TIE;
            System.out.println("Game Draw");
            return winner;
        }
        return winner;
    }

    /**
     * The method removes a token of the specified color from stock.
     * 
     * @param color {@code enum} : {@code Color.RED} for red token or
     *              {@code Color.YELLOW} for yellow token
     * @return color {@code enum}
     */
    public Token getToken(Color color) {

        int numberOfToken;

        if (hasToken(color)) {
            if (color == Color.RED) {
                numberOfToken = this.tokenStock.get(redToken);
                numberOfToken--;
                this.tokenStock.replace(redToken, this.tokenStock.get(redToken), numberOfToken);

                return redToken;
            } else {
                numberOfToken = this.tokenStock.get(yellowToken);
                numberOfToken--;
                this.tokenStock.replace(yellowToken, this.tokenStock.get(yellowToken), numberOfToken);

                return yellowToken;
            }
        }
        return null;
    }

    /**
     * Return whether there are still tokens with the specified color int the stock.
     * 
     * @param color {@code enum} : {@code Color.RED} for red token or
     *              {@code Color.YELLOW} for yellow token
     * @return {@code bool}
     */
    private boolean hasToken(Color color) {

        if (color == Color.RED && this.tokenStock.get(redToken) > 0) {
            return true;
        } else if (color == Color.YELLOW && this.tokenStock.get(yellowToken) > 0) {
            return true;
        }
        return false;
    }

    /**
     * The Method displays tokens with the ccurrent color int the view.
     * There is no token in the requested cell, the method return null.
     * 
     * @param row    {@code int}
     * @param column {@code int}
     * @return {@code Color}
     */
    public Color getTokenColor(int row, int column) {
        Color color = null;
        if (gameBoard[row][column] == Color.RED.getTokenString()) {
            color = Color.RED;
        } else if (gameBoard[row][column] == Color.YELLOW.getTokenString()) {
            color = Color.YELLOW;
        } else {
            color = null;
        }
        return color;
    }
}
