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
 * Thrown when the column is full.
 */
public class ColumnFullException extends Exception {

    public ColumnFullException() {
        super("This column is full, try another one...");
    }

}
