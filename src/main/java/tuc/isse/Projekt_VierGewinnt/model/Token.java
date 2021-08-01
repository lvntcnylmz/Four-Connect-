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

public class Token extends GameObject {

    private Color color;

    public enum Color {

        RED("X"), YELLOW("O");

        private final String colorToken;

        Color(String colorToken) {
            this.colorToken = colorToken;
        }

        /**
         * @return {@code String} "X" for red token or "O" for yellow token.
         */
        public String getTokenString() {
            return colorToken;
        }
    }

    public Token(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return null;
    }
}
