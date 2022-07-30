package fourConnect.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fourConnect.models.Board;
import fourConnect.models.Color;

public class ConsolePlayer extends Player {

    public ConsolePlayer(Board board, Color color) {
        super(board, color);
    }

    @Override
    public void doTurn() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            super.doDrop(Integer.parseInt(reader.readLine()));
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

}
