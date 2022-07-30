package fourConnect.models;

/**
 * The enum class represents the color symbol of the tokens.
 */
public enum Color {

    RED("X"),
    YELLOW("O");

    private final String tokenColor;

    Color(String tokenColor) {
        this.tokenColor = tokenColor;
    }

    /**
     * @return {@code String} "X" for red token or "O" for yellow token.
     */
    public String getTokenColor() {
        return tokenColor;
    }

}
