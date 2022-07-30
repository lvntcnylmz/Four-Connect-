package fourConnect.exceptions;

public class ColumnFullException extends RuntimeException {
    
    /**
     * Thrown when the column is full.
     */
    public ColumnFullException() {
        super("This column is full, try another one...");
    }

}
