package fourConnect.models;

public class Token extends GameObject {

    private Color color;

    public Token(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color.getTokenColor();
    }

}
