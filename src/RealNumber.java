public class RealNumber extends ArbitraryFloatingPointNumber {
    /**
     * default class constructor
     */
    public RealNumber() {
    }

    public RealNumber(byte[] digits, boolean isNegative, int precision) {
        super(digits, isNegative, precision);
    }

    public RealNumber(String number) {
        super(number);
    }

    public RealNumber add(RealNumber rn) {
        if (rn.getIsNegative() != this.getIsNegative())
            throw new UnsupportedOperationException("the input number has a different sign as this number.");
        // find the precision of the sum
        int precision = Math.max(rn.getPrecision(), this.getPrecision());
        // find the whole number part length of the sum
        int wholeNumberLength =
                Math.max(rn.getDigits().length - rn.getPrecision(), this.getDigits().length - this.getPrecision());
        if (wholeNumberLength < 0)
            wholeNumberLength = 0;

        byte[] digits = new byte[precision + wholeNumberLength + 1];
        for (int i = 0; i < digits.length-1; i++) {
            // if
            //  this    0123.456        this     123.456
            //  rn       123.4567       rn      0123.4567
            // else
            //  this     123.4567       this    0123.4567
            //  rn      0123.456        rn       123.456
            if (this.getPrecision() < precision) {
                if(this.getDigits().length + precision-this.getPrecision()>rn.getDigits().length){
                    if (i >= precision - this.getPrecision() && i < rn.getDigits().length) {
                        digits[i] = (byte) (this.getDigits()[i - (precision - this.getPrecision())] + rn.getDigits()[i] + digits[i]);
                        if (digits[i] > 9) {
                            digits[i] = (byte) (digits[i] - 10);
                            digits[i + 1] = 1;
                        }
                    }
                    if(i<precision-this.getPrecision()){
                        digits[i]= rn.getDigits()[i];
                    }
                    if(i>=rn.getDigits().length){
                        digits[i]= (byte) (this.getDigits()[i] + digits[i]);
                    }
                }else{
                    if (i >= precision - this.getPrecision() && i < this.getDigits().length + precision-this.getPrecision()) {
                        digits[i] = (byte) (this.getDigits()[i - (precision - this.getPrecision())] + rn.getDigits()[i] + digits[i]);
                        if (digits[i] > 9) {
                            digits[i] = (byte) (digits[i] - 10);
                            digits[i + 1] = 1;
                        }
                    }
                    if(i<precision-this.getPrecision()){
                        digits[i]= rn.getDigits()[i];
                    }
                    if(i>=this.getDigits().length + precision -this.getPrecision()){
                        digits[i]= (byte) (rn.getDigits()[i] + digits[i]);
                    }
                }
            } else {
                if(rn.getDigits().length + precision-rn.getPrecision()>this.getDigits().length){
                    if (i >= precision - rn.getPrecision() && i < this.getDigits().length) {
                        digits[i] = (byte) (rn.getDigits()[i - (precision - rn.getPrecision())] + this.getDigits()[i] + digits[i]);
                        if (digits[i] > 9) {
                            digits[i] = (byte) (digits[i] - 10);
                            digits[i + 1] = 1;
                        }
                    }
                    if(i<precision-rn.getPrecision()){
                        digits[i]= this.getDigits()[i];
                    }
                    if(i>=this.getDigits().length){
                        digits[i]= (byte) (rn.getDigits()[i] + digits[i]);
                    }
                }else{
                    if (i >= precision - rn.getPrecision() && i < rn.getDigits().length+precision- rn.getPrecision()) {
                        digits[i] = (byte) (rn.getDigits()[i - (precision - rn.getPrecision())] + this.getDigits()[i] + digits[i]);
                        if (digits[i] > 9) {
                            digits[i] = (byte) (digits[i] - 10);
                            digits[i + 1] = 1;
                        }
                    }
                    if(i<precision-rn.getPrecision()){
                        digits[i]= this.getDigits()[i];
                    }
                    if(i>=rn.getDigits().length + precision -rn.getPrecision()){
                        digits[i]= (byte) (this.getDigits()[i] + digits[i]);
                    }
                }
            }

        }
        RealNumber sum = new RealNumber(digits, this.getIsNegative(), precision);

        return sum;
    }

}
