package fourConnect.controller;

import fourConnect.models.Board;
import fourConnect.models.Color;
import fourConnect.models.Token;

public abstract class Player {

    private final Board board;
    private final Color color;
    private final Token token;

    public Player(Board board, Color color) {
        this.board = board;
        this.color = color;
        this.token = new Token(this.color);
    }

    /**
     * Drops a token of the desired color in a specific column on the board.
     * 
     * @param columnIndex {@code int} : column index to drop the token
     */
    protected void doDrop(int columnIndex) {
        this.board.dropToken(this.token, columnIndex);
    }

    public Token getToken() {
        return token;
    }

    public abstract void doTurn();

}
