public class RationalNumber {

    private IntegerNumber numerator;
    private IntegerNumber denominator;
    public  RationalNumber(){
    }

    public RationalNumber(IntegerNumber numerator, IntegerNumber denominator) throws Exception {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public void setNumerator(IntegerNumber in){
        this.numerator = in;
    }

    public void setDenominator(IntegerNumber in) throws Exception{
        // make sure it's not zero
        boolean allZero = true;
        for (byte b : in.getDigits()) {
            if (b != 0) {
                allZero = false;
            }
        }
        if (allZero){
            throw new Exception("Denominator cannot be zero.");
        }
        this.denominator = in;
    }

    public boolean getIsNegative(){
        if(numerator.getIsNegative() == denominator.getIsNegative())
            return false;
        else
            return true;
    }
    public IntegerNumber getNumerator(){
        return numerator;
    }

    public IntegerNumber getDenominator(){
        return denominator;
    }

    public RationalNumber add(RationalNumber rn) throws Exception{
        if(rn.getNumerator().getIsNegative() != this.getNumerator().getIsNegative()){
            throw new UnsupportedOperationException("input number's numerator does not have the same sign as this number's numerator.");
        }
        if(rn.getDenominator() != this.getDenominator()){
            throw new UnsupportedOperationException("input number and this number do not have the same denominator.");
        }

        IntegerNumber sumNumerator = this.getNumerator().add(rn.getNumerator());
        RationalNumber sum = new RationalNumber(sumNumerator, this.denominator);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RationalNumber))
            return false;
        RationalNumber rn = (RationalNumber) o;
        return this.getNumerator().equals(rn.getNumerator())
                && this.getDenominator().equals(rn.getDenominator());
    }

    @Override
    public String toString() {
        String numerator = this.numerator.toString();
        String denominator = this.denominator.toString();
        if(numerator.charAt(0)=='-')
            numerator = numerator.substring(1);
        if(denominator.charAt(0)=='-')
            denominator = denominator.substring(1);
        if(this.numerator.getIsNegative()!=this.denominator.getIsNegative())
            return "-" + numerator + "/" + denominator;
        return numerator + "/" + denominator;
    }
}
