import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GaussianIntegerTest {
    // setup
    byte[] digits1 = {1, 3, 5};
    byte[] digits2 = {2, 4, 6};
    byte[] digits3 = {7};
    byte[] digits4 = {8, 9};
    IntegerNumber in1 = new IntegerNumber(digits1, false);
    IntegerNumber in2 = new IntegerNumber(digits2, false);
    IntegerNumber in3 = new IntegerNumber(digits3, false);
    IntegerNumber in4 = new IntegerNumber(digits4, false);
    IntegerNumber in5 = new IntegerNumber(digits4, true);
    GaussianInteger gi1 = new GaussianInteger(in1, in2);
    GaussianInteger gi2 = new GaussianInteger(in3, in4);
    GaussianInteger gi3 = new GaussianInteger(in1, in2);
    GaussianInteger gi4 = new GaussianInteger(in3, in5);

    @Test
    public void addGaussianIntegerTest() throws Exception {
        // setup
        GaussianInteger sum;

        // execute
        sum = gi1.add(gi2);

        // verify
        assertEquals(in1.add(in3), sum.getRealPart());
        assertEquals(in2.add(in4), sum.getImaginaryPart());
    }

    @Test
    public void equalsGaussianIntegerTest() {
        assertEquals(false, gi1.equals(gi2));
        assertEquals(true, gi1.equals(gi3));
    }

    @Test
    public void toStringGaussianIntegerTest() {
        assertEquals("531 + 642i", gi1.toString());
        // will not pass the test
        assertEquals("7 + 642i", gi4.toString());
        assertEquals("7 + 98i", gi4.toString());
    }
}
