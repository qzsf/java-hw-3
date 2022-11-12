public class IntegerNumber extends ArbitraryWholeNumber {

    public IntegerNumber() {
    }

    public IntegerNumber(byte[] digits, boolean isNegative){
        super(digits, isNegative);
    }

    public IntegerNumber(String number){
        super(number);
    }

    public IntegerNumber add(IntegerNumber in) throws Exception {
        byte[] digits1;
        byte[] digits2;
        byte[] sumDigits;

        if(in.getIsNegative() != this.getIsNegative()){
            throw new UnsupportedOperationException("the input number has a different sign as this number.");
        }
        if (this.getDigits().length <= in.getDigits().length) {
            digits1 = this.getDigits();
            digits2 = in.getDigits();
        } else {
            digits2 = this.getDigits();
            digits1 = in.getDigits();
        }

        sumDigits = new byte[digits2.length + 1];
        for (int i = 0; i < digits1.length; i++) {
            sumDigits[i] = (byte) (digits1[i] + digits2[i] + sumDigits[i]);
            if (sumDigits[i] > 9) {
                sumDigits[i] = (byte) (sumDigits[i] - 10);
                sumDigits[i + 1] = 1;
            }
        }
        //
        for (int i = digits1.length; i < digits2.length; i++) {
            sumDigits[i] = (byte) (digits2[i] + sumDigits[i]);
            if (sumDigits[i] > 9) {
                sumDigits[i] = (byte) (sumDigits[i] - 10);
                sumDigits[i + 1] = 1;
            }
        }

        IntegerNumber sum = new IntegerNumber();
        sum.setDigits(sumDigits);
        sum.setNegative(this.getIsNegative());
        return sum;
    }
}
