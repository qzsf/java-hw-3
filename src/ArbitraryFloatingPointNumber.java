public class ArbitraryFloatingPointNumber extends ArbitraryWholeNumber {
    private int precision;

    public ArbitraryFloatingPointNumber(){}
    /**
     * constructor
     *
     * @param number - number string
     */
    public ArbitraryFloatingPointNumber(String number) {
        if(number.indexOf('.')>=0){
            setPrecision(number.length() - number.indexOf('.') - 1);
            number = number.replace(".","");
        }
        if (number.charAt(0)=='-'){
            super.setNegative(true);
            number = number.substring(1);
        }
        byte[] digits = new byte[number.length()];
        for (int i = 0; i < number.length() ; i++) {
            digits[number.length() - 1 - i] = (byte) Character.getNumericValue(number.charAt(i));
        }
        super.setDigits(digits);
    }

    public int getPrecision(){
        return precision;
    }

    public void setPrecision(int precision){
        this.precision = precision;
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

        if(digits.length > precision){
            for (int i = digits.length-1; i >= 0; i--) {
                if (digits[i]!=0 || i == precision)
                    start = true;
                if (start){
                    // insert dot
                    if (i == precision-1)
                        sb.append('.');
                    sb.append(digits[i]);
                }
            }
        }else{
            sb.append("0.");
            for (int i =0; i < precision - digits.length; i++){
                sb.append('0');
            }
            for (int i = digits.length-1; i >= 0; i--) {
                    sb.append(digits[i]);
            }
        }

        return sign + sb.toString();
    }
}
