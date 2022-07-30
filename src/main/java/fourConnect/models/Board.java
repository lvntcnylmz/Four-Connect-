package fourConnect.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import fourConnect.exceptions.ColumnFullException;
import fourConnect.exceptions.IllegalMoveException;



/**
 * Creates the game board and core game loop.
 */
public class Board extends GameObject {

    private final int column;
    private final int row;
    private final ArrayList<ArrayList<Cell>> gameBoard;
    private final Token redToken;
    private final Token yellowToken;
    private final Map<Token, Integer> tokenStock;
    private int emptyRowIndex;
    private Winner winner;

    public Board(int row, int column) {
        this.column = column;
        this.row = row;
        this.gameBoard = new ArrayList<>();
        this.redToken = new Token(Color.RED);
        this.yellowToken = new Token(Color.YELLOW);
        this.tokenStock = new HashMap<>();
        tokenStock.put(redToken, 21);
        tokenStock.put(yellowToken, 21);
        this.winner = Winner.NONE;
        this.emptyRowIndex = row - 1;
        this.createGameBoard();
    }

    /**
     * Drops a coin of the desired color in a specific column on the board.
     * 
     * @param token       : {@code Color.RED} for red token,
     *                    {@code Color.YELLOW} for yellow token
     * @param columnIndex {@code int} : column index in which the token will be
     *                    dropped
     * @throws ColumnFullException if the column is full
     * @throws IllegalMoveException After a win, no more stones may be thrown in.
     */
    public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {
        if (canDrop(columnIndex)) {
            gameBoard.get(emptyRowIndex).get(columnIndex - 1).setToken(getToken(token.getColor()));
        } 
        else {
            throw new ColumnFullException();
        }

        if (this.winner != Winner.NONE) {
            throw new IllegalMoveException();
        }
    }

    /**
     * Checks if the column is full.
     * 
     * @param columnIndex : column index to which the token is to be thrown
     * @return {@code boolean} : Returns true if the column is not full.
     */
    public boolean canDrop(int columnIndex) {
        for (int i = row - 1; i >= 0; i--) {
            if (gameBoard.get(i).get(columnIndex - 1).getToken() == null) {
                this.emptyRowIndex = i;
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the game board on the console.
     * 
     * @return {@code String} : Returns the game board as string array
     */
    @Override
    public String toString() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(gameBoard.get(i).get(j));
            }
            System.out.println();
        }

        for (int i = 1; i <= row + 1; i++) {
            System.out.print("[" + i + "]");
        }
        System.out.println();
        return this.gameBoard.toString();
    }

    /**
     * Creates the game board.
     */
    private void createGameBoard() {
        for (int i = 0; i < row; i++) {
            gameBoard.add(new ArrayList<Cell>());
            for (int j = 0; j < column; j++) {
                gameBoard.get(i).add(new Cell());
            }
        }
    }

    /**
     * Checks if four tokens of the same color are on the same row.
     * 
     * @param color {@code enum} : {@code COLOR.RED} for the red token,
     *                             {@code COLOR.YELLOW} for the yellow token
     * @return {@code boolean} :  Returns true if four tokens of the same color are on the same row.
     */
    private boolean isRowVictory(Color color) {
        int colorRowCounter = 0;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                if (gameBoard.get(i).get(j).getToken() == null) {
                    colorRowCounter = 0;
                    continue;
                } 
                else if (Objects.equals(gameBoard.get(i).get(j).getToken().toString(), color.getTokenColor())) {
                    colorRowCounter++;
                    if (colorRowCounter == 4) {
                        return true;
                    }
                    continue;
                }
                colorRowCounter = 0;
            }
        }
        return false;
    }

    /**
     * Checks if four token of the same color are on the same column.
     * 
     * @param color {@code enum} : {@code COLOR.RED} for the red token,
     *                             {@code COLOR.YELLOW} for the yellow token.
     * @return {@code boolean} : Returns true if the four tokens of the same color are in the same column.
     */
    private boolean isColumnVictory(Color color) {
        int colorColumnCounter = 0;
        for (int j = 0; j < column; j++) {
            for (int i = row - 1; i >= 0; i--) {
                if (gameBoard.get(i).get(j).getToken() == null) {
                    colorColumnCounter = 0;
                    continue;
                }
                else if (Objects.equals(gameBoard.get(i).get(j).getToken().toString(), color.getTokenColor())) {
                    colorColumnCounter++;
                    if (colorColumnCounter == 4) {
                        return true;
                    }
                    continue;
                }
                colorColumnCounter = 0;
            }
        }
        return false;
    }

    /**
     * Checks if four tokens of the same color are diagonally at one point one the board.
     * 
     * @param color {@code enum} : {@code COLOR.RED} for the red token,
     *              {@code COLOR.YELLOW} for the yellow token.
     * @return {@code boolean} : Returns true if the four tokens of the same color
     *         are diagonally at one point one the board.
     */
    private boolean isDiagonalVictory(Color color) {

        int colorCounterLeftToRight = 0, colorCounterRightToLeft = 0;

        // Checks the game board from bottom left to top right
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                for (int i = row - 1, j = 0; i >= 2; i--, j++) {
                    if (gameBoard.get(i - x).get(j + y).getToken() == null) {
                        colorCounterLeftToRight = 0;
                        continue;
                    } 
                    else if (Objects.equals(gameBoard.get(i - x).get(j + y).getToken().toString(), color.getTokenColor())) {
                        colorCounterLeftToRight++;
                        if (colorCounterLeftToRight == 4) {
                            return true;
                        }
                        continue;
                    }
                    colorCounterLeftToRight = 0;
                }
                colorCounterLeftToRight = 0;
            }
        }

        // Checks the game board from bottom right to top left
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                for (int i = row - 1, j = column - 1; i >= 2; i--, j--) {
                    if (gameBoard.get(i - x).get(j - y).getToken() == null) {
                        colorCounterRightToLeft = 0;
                        continue;
                    } 
                    else if (Objects.equals(gameBoard.get(i - x).get(j - y).getToken().toString(), color.getTokenColor())) {
                        colorCounterRightToLeft++;
                        if (colorCounterRightToLeft == 4) {
                            return true;
                        }
                        continue;
                    }
                    colorCounterRightToLeft = 0;
                }
                colorCounterRightToLeft = 0;
            }
        }
        return false;
    }

    /**
     * Checks if the game is a draw.
     * 
     * @return {@code boolean} : Returns true if the game is not a draw
     */
    private boolean isTie() {
        return !hasToken(Color.RED) || !hasToken(Color.YELLOW);
    }

    /**
     * Tests all 3 win conditions to determine the winner
     * 
     * @return {@code Winner} : Returns a winner (color) based on 3 win conditions
     */
    public Winner testVictory() {
        if (isRowVictory(yellowToken.getColor()) || isColumnVictory(yellowToken.getColor()) || isDiagonalVictory(yellowToken.getColor())) {
            this.winner = Winner.YELLOW;  
        }
        else if (isRowVictory(redToken.getColor()) || isColumnVictory(redToken.getColor()) || isDiagonalVictory(redToken.getColor())) {
            this.winner = Winner.RED; 
        }
        else if (isTie()) {
            this.winner = Winner.TIE;
        }
        return this.winner;
    }

    /**
     * Removes a token of the specified color from stock
     * 
     * @param color {@code enum} : {@code Color.RED} for red token
     *              {@code Color.YELLOW} for yellow token
     * @return {@code Token} : Returns the token according to selected color
     */
    private Token getToken(Color color) {
        if (hasToken(color)) {
            if (color == this.redToken.getColor()) { 
                tokenStock.put(redToken, tokenStock.get(redToken)-1);
                return redToken;
            } 
            else {
                tokenStock.put(yellowToken, tokenStock.get(yellowToken)-1);
                return yellowToken;
            }
        }
        return null;
    }

    /**
     * Checks if there are enough coins in token stocks
     * 
     * @param color : {@code Color} The color of the token
     * @return {@code boolean} Returns true if there are enough coins in stock
     */
    private boolean hasToken(Color color) {
        return (color == redToken.getColor() && this.tokenStock.get(redToken) > 0) ||
                (color == yellowToken.getColor() && this.tokenStock.get(yellowToken) > 0);
    }

    /**
     * @return {@code Winner} : Returns the color of the winner
     */
    public Winner getWinner() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_WHITE = "\u001B[47m";
        final String ANSI_PURPLE = "\u001B[45m";
        final String ANSI_YELLOW = "\u001B[43m";
        final String ANSI_RED = "\u001B[41m";

        switch (winner) {
            case RED:
                System.out.println(ANSI_RED + ANSI_BLACK + "The winner is " + this.winner + ANSI_RESET);
                break;
            case YELLOW:
                System.out.println(ANSI_YELLOW + ANSI_BLACK + "The winner is " + this.winner + ANSI_RESET);
                break;
            case TIE:
                System.out.println(ANSI_WHITE + ANSI_BLACK + "The game is draw." + ANSI_RESET);
                break;
            default:
                System.out.println(ANSI_PURPLE + ANSI_BLACK + "The winner is " + this.winner + ANSI_RESET);
                break;
        }
        return this.winner;
    }

    public Token getRedToken() {
        return redToken;
    }

    public Token getYellowToken() {
        return yellowToken;
    }

}
