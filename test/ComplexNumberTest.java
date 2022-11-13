import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexNumberTest {
    // setup
    byte[] digits6 = {0, 0, 0, 3, 4, 5, 6, 0};
    byte[] digits7 = {3, 4, 5, 6};

    RealNumber rn1 = new RealNumber(digits6, false, 5);
    RealNumber rn2 = new RealNumber(digits7, true, 2);

    ComplexNumber cn1 = new ComplexNumber(rn1, rn2);

    @Test
    public void addComplexNumberTest() {

    }

    @Test
    public void equalsComplexNumberTest() {

    }

    @Test
    public void toStringComplexNumberTest() {
        assertEquals("65.43000 - 65.43i", cn1.toString());
    }

}
