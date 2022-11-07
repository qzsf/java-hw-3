import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.TextParsingException;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberTest {

    @Test
    public void addNaturalNumberTest() {
        // setup
        NaturalNumber nn1 = new NaturalNumber();
        NaturalNumber nn2 = new NaturalNumber();
        NaturalNumber sum = new NaturalNumber();
        byte[] digits1 = {5, 4, 3, 2, 1, 6};
        byte[] digits2 = {5, 4, 3, 2, 1, 7};
        nn1.setDigits(digits1);
        nn2.setDigits(digits2);

        // execute
        sum = nn1.add(nn2);

        // verify
        byte[] sumExpected = {0, 9, 6, 4, 2, 3, 1};
        // loop through values to verify the result
        for (int i = 0; i < sum.getDigits().length; i++) {
            assertEquals(sumExpected[i], sum.getDigits()[i]);
        }
    }
}