/**
 * @author Larissa Seiler / lse19
 *         larissa.seiler@tu-clausthal.de
 * 
 * @author Levent Can Yilmaz / lcy19
 *         levent.can.yilmaz@tu-clausthal.de
 * 
 * @version 1.0
 */

package tuc.isse.Projekt_VierGewinnt;

/**
 * Thrown when an exceptional illegal move has occurred.
 */
public class IllegalMoveException extends Exception {

    public IllegalMoveException() {
        super("After a victory no more tokens may be thrown in.");
    }

}
