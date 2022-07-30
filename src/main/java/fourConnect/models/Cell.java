package fourConnect.models;

public class Cell extends GameObject {

    private Token token;

    public Cell() {
        this.token = null;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        if (token == null) {
            return "[ ]";
        } 
        else {
            return "[" + token + "]";
        }
    }

}
