/**
 * ArbitraryWholeNumber class
 * represents an Arbitrary Whole Number.
 *
 * @author Alan Zhang
 */

public class ArbitraryWholeNumber {
    // boolean that indicates whether the number is less than 0
    private boolean isNegative;
    // a byte array that stores the digits of the whole number
    private byte[] digits;

    /**
     * default class constructor
     *
     */
    public ArbitraryWholeNumber() {
    }

    /**
     * constructor
     *
     * @param digits - byte array Arbitrary Whole Number digits
     * @param isNegative - boolean for isNegative
     */
    public ArbitraryWholeNumber(byte[] digits, boolean isNegative) {
        setDigits(digits);
        setNegative(isNegative);
    }

    /**
     * constructor
     *
     * @param number - number string. for example: "-6543000"
     */
    public ArbitraryWholeNumber(String number) {
        // works with the "-" sign
        if (number.charAt(0) == '-') {
            setNegative(true);
            number = number.substring(1);
        }

        digits = new byte[number.length()];
        // populates the digits
        for (int i = 0; i < number.length(); i++) {
            digits[number.length() - 1 - i] = (byte) Character.getNumericValue(number.charAt(i));
        }
    }

    /**
     * method setNegative
     * sets whether the number is less than 0
     *
     * @param sign - negative true or not
     */
    public void setNegative(boolean sign) {
        isNegative = sign;
    }

    /**
     * method setDigits
     * sets digits of the whole number
     *
     * @param digits - digits of the whole number
     */
    public void setDigits(byte[] digits) {
        this.digits = digits;
    }

    /**
     * method getIsNegative
     * gets isNegative
     *
     * @return boolean
     */
    public boolean getIsNegative() {
        return isNegative;
    }

    public byte[] getDigits() {
        return digits;
    }

    /**
     * method compareValue
     * compare two byte array's value.
     *
     * @return boolean
     */
    public boolean compareValues(byte[] val1, byte[] val2) {
        byte[] first;
        byte[] second;
        // val1 and val2 can be different in length.
        // sorts val1 and val2 and assigns to variable first and second.
        // result of the following operation - first is shorter of same length as second
        if (val1.length <= val2.length) {
            first = val1;
            second = val2;
        } else {
            first = val2;
            second = val1;
        }
        // compares the same length part
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i])
                return false;
        }
        // if the second whole number digits' extra part is not all '0'
        // then returns false.
        for (int i = first.length; i < second.length; i++) {
            if (second[i] != 0)
                return false;
        }

        return true;
    }

    /**
     * method equals
     * Override the default equals method with a customized function.
     *
     * @return string
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArbitraryWholeNumber))
            return false;
        ArbitraryWholeNumber awn = (ArbitraryWholeNumber) o;
        // return true if both whole numbers have the same +/- sign
        // and value of digits are equal. else return false.
        return isNegative == awn.getIsNegative() && compareValues(digits, awn.digits);
    }

    /**
     * method toString
     * Override the default toString method with a customized string message.
     *
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String sign = "";
        boolean firstNoneZeroFound = false;

        if (isNegative)
            sign = "-";

        // loop through digits to generate string output.
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 0)
                firstNoneZeroFound = true;
            if (firstNoneZeroFound)
                sb.append(digits[i]);
        }

        // if all digits are 0 then output 0.
        if (!firstNoneZeroFound) {
            sb.append('0');
        }

        return sign + sb;
    }

}
