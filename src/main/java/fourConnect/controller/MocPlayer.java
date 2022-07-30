package fourConnect.controller;

import fourConnect.models.Board;
import fourConnect.models.Color;

public class MocPlayer extends Player {

    private int move;

    public MocPlayer(Board board, Color color, int move) {
        super(board, color);
        this.move = move;
    }

    @Override
    public void doTurn() {
        super.doDrop(this.move);
    }
    
}
