public class ArbitraryFloatingPointNumber extends ArbitraryWholeNumber {
    private int precision;

    /**
     * default class constructor
     */
    public ArbitraryFloatingPointNumber() {
    }

    /**
     * constructor
     *
     * @param digits     - byte array Arbitrary Whole Number digits
     * @param isNegative - boolean indicates the number is isNegative or not
     * @param precision  - int that indicates the number of digits to the right of the decimal point
     */
    public ArbitraryFloatingPointNumber(byte[] digits, boolean isNegative, int precision) {
        super(digits, isNegative);
        setPrecision(precision);
    }

    /**
     * constructor
     *
     * @param number - number string
     */
    public ArbitraryFloatingPointNumber(String number) {
        if (number.indexOf('.') >= 0) {
            setPrecision(number.length() - number.indexOf('.') - 1);
            number = number.replace(".", "");
        }
        if (number.charAt(0) == '-') {
            super.setNegative(true);
            number = number.substring(1);
        }
        byte[] digits = new byte[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[number.length() - 1 - i] = (byte) Character.getNumericValue(number.charAt(i));
        }
        super.setDigits(digits);
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    /**
     * method remove front and trailing 0s from digits byte array
     * @param digits - byte array
     * @return trimmed byte array
     */
    public byte[] trimDigits(byte[] digits) {
        int start=-1;
        int end=-1;
        for (int i = 0; i < digits.length; i++) {
            if(digits[i] != 0)
                end = i;
        }
        for (int i = digits.length - 1; i >=0; i--) {
            if(digits[i] != 0)
                start = i;
        }
//        System.out.println("trim:");
//        System.out.println(start);
//        System.out.println(end);
        byte[] trimmed;


        if (start != -1) {
            trimmed = new byte[end - start + 1];
            for (int i = 0; i <= end - start; i++) {
                trimmed[i] = digits[i + start];
                System.out.println(trimmed[i]);
            }
        } else {
            trimmed = new byte[0];
        }

        return trimmed;
    }


    public boolean compareValues(ArbitraryFloatingPointNumber afpn1,ArbitraryFloatingPointNumber afpn2){
        int precisionOffset1 = 0;
        int precisionOffset2 = 0;
        int adjustedPrecision1;
        int adjustedPrecision2;
        byte[] digits1 = trimDigits(afpn1.getDigits());
        byte[] digits2 = trimDigits(afpn2.getDigits());
        // return true if both numbers' digits are only 0s
        if (digits1.length ==0 && digits2.length==0)
            return true;

        for (int i = afpn1.getDigits().length - 1; i >=0; i--) {
            if(afpn1.getDigits()[i] != 0)
                precisionOffset1 = i;
        }
        for (int i = afpn2.getDigits().length - 1; i >=0; i--) {
            if(afpn2.getDigits()[i] != 0)
                precisionOffset2 = i;
        }
        // adjust the precision
        adjustedPrecision1 = afpn1.getPrecision() -precisionOffset1;
        adjustedPrecision2 = afpn2.getPrecision() -precisionOffset2;

        // return true if adjust precision, isNegative, and digits are same
        return adjustedPrecision1==adjustedPrecision2
                && afpn1.getIsNegative() == afpn2.getIsNegative()
                && super.compareValues(digits1,digits2);
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArbitraryFloatingPointNumber))
            return false;
        ArbitraryFloatingPointNumber afpn = (ArbitraryFloatingPointNumber) o;


        // return true if both numbers have the same +/- sign
        // and value of digits are equal. else return false.
        return this.compareValues(this, afpn);
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
        boolean isNegative = super.getIsNegative();
        byte[] digits = super.getDigits();
        boolean start = false;

        if (isNegative)
            sign = "-";

        if (digits.length > precision) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 0 || i == precision)
                    start = true;
                if (start) {
                    // insert dot
                    if (i == precision - 1)
                        sb.append('.');
                    sb.append(digits[i]);
                }
            }
        } else {
            sb.append("0.");
            for (int i = 0; i < precision - digits.length; i++) {
                sb.append('0');
            }
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }
        }

        return sign + sb;
    }
}
