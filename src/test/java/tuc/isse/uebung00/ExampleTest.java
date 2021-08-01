package tuc.isse.uebung00;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    @Test
    /*
      Testing the addition function implemented in uebung00 package
     */
    public void testAddition() {
        assertEquals(7, Example.addition(4, 3));
    }

    @Test
    /*
     * Testing the subtraction function implemented in uebung00 package
     */
    public void testSubtraction() {
        assertEquals(1, Example.subtraction(4, 3));
    }
}