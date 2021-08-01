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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tuc.isse.Projekt_VierGewinnt.ColumnFullException;
import tuc.isse.Projekt_VierGewinnt.IllegalMoveException;
import tuc.isse.Projekt_VierGewinnt.model.Bord;
import tuc.isse.Projekt_VierGewinnt.model.Token.Color;

public class ConsolePlayer extends Player {

    private BufferedReader consoleReader;
    public static boolean doTurn = true;

    public ConsolePlayer(Color color, Bord gameBoard) {
        super(color, gameBoard);
    }

    /**
     * Here, input from the player is used in the doDrop function.
     */
    @Override
    public void doTurn() {

        this.consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            super.doDrop(Integer.parseInt(this.consoleReader.readLine()));
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        } catch (ColumnFullException e) {
            System.out.println(e.getMessage());
        } catch (IllegalMoveException e) {
            System.exit(1);
        }
    }
}
