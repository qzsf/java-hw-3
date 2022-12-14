/**
 * NaturalNumber class that extends ArbitraryWholeNumber
 * represents a Natural Number.
 *
 * @author Alan Zhang
 */

public class NaturalNumber extends ArbitraryWholeNumber {
    /**
     * default class constructor
     *
     */
    public NaturalNumber() {
    }

    /**
     * constructor
     *
     * @param digits - byte array Arbitrary Whole Number digits
     */
    public NaturalNumber(byte[] digits) {
        setDigits(digits);
        setNegative(false);
    }

    /**
     * constructor
     *
     * @param number - number string. for example: "-6543000"
     */
    public NaturalNumber(String number) throws Exception{
        super(number);
        if (number.charAt(0) == '-') {
            throw new Exception("NaturalNumber cannot be negative.");
        }
    }

    /**
     * overrides the base class's setNegative method
     * to make sure all NaturalNumbers are not negative.
     *
     * @param sign - negative true or not
     */
    public void setNegative(boolean sign) {
    }

    /**
     * method add
     * takes a natural number as input and returns a NaturalNumber
     * that represents the sum of the input natural number and this
     * natural number.
     *
     * @param nn - a natural number
     * @return NaturalNumber
     */
    public NaturalNumber add(NaturalNumber nn) {
        byte[] digits1;     // shorter digits
        byte[] digits2;     // longer digits
        byte[] sumDigits;
        if (this.getDigits().length <= nn.getDigits().length) {
            digits1 = this.getDigits();
            digits2 = nn.getDigits();
        } else {
            digits2 = this.getDigits();
            digits1 = nn.getDigits();
        }

        // initialize the sum digits
        sumDigits = new byte[digits2.length + 1];
        for (int i = 0; i < digits1.length; i++) {
            sumDigits[i] = (byte) (digits1[i] + digits2[i] + sumDigits[i]);
            if (sumDigits[i] > 9) {
                sumDigits[i] = (byte) (sumDigits[i] - 10);
                sumDigits[i + 1] = 1;
            }
        }
        // do the plus for the longer part since the two numbers can have different length
        for (int i = digits1.length; i < digits2.length; i++) {
            sumDigits[i] = (byte) (digits2[i] + sumDigits[i]);
            if (sumDigits[i] > 9) {
                sumDigits[i] = (byte) (sumDigits[i] - 10);
                sumDigits[i + 1] = 1;
            }
        }

        NaturalNumber sum = new NaturalNumber();
        sum.setDigits(sumDigits);
        return sum;
    }
}
