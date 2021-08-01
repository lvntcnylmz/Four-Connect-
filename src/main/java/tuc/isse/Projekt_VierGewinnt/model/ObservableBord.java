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

import java.util.ArrayList;
import java.util.List;

import tuc.isse.Projekt_VierGewinnt.ColumnFullException;
import tuc.isse.Projekt_VierGewinnt.IllegalMoveException;

public class ObservableBord extends Bord {

    private List<BordObserver> bordObservers;

    public ObservableBord(int row, int column) {
        super(row, column);
        this.bordObservers = new ArrayList<>();
    }

    public void addObserver(BordObserver bordObserver) {
        if (bordObserver == null)
            throw new NullPointerException();
        if (!this.bordObservers.contains(bordObserver))
            this.bordObservers.add(bordObserver);
    }

    public void removeObserver(BordObserver bordObserver) {
        this.bordObservers.remove(bordObserver);
    }

    public void notifyObserver() {
        for (BordObserver bordObserver : bordObservers) {
            bordObserver.update(this);
        }
    }

    @Override
    public void dropToken(Token token, int columnIndex) throws ColumnFullException, IllegalMoveException {
        super.dropToken(token, columnIndex);
        this.notifyObserver();
    }
}
