package fourConnect.exceptions;

public class IllegalMoveException extends RuntimeException{
    
    public IllegalMoveException() {
        super("No more tokens can be dropped after victory.");
    }

}
