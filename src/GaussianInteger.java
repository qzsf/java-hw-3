public class GaussianInteger {
    private IntegerNumber realPart;
    private IntegerNumber imaginaryPart;

    /**
     * default constructor
     */
    public GaussianInteger(){
    }

    /**
     * constructor
     * @param realPart - real part of the Gaussian Integer.
     * @param imaginaryPart - imaginary part of the Gaussian Integer.
     */
    public GaussianInteger(IntegerNumber realPart, IntegerNumber imaginaryPart ){
        setRealPart(realPart);
        setImaginaryPart(imaginaryPart);
    }

    /**
     * getter - get the real part
     * @return real part
     */
    public IntegerNumber getRealPart(){
        return realPart;
    }

    /**
     * getter - get the imaginary part
     * @return imaginary part
     */
    public IntegerNumber getImaginaryPart(){
        return imaginaryPart;
    }

    /**
     * setter - set the real part
     * @param realPart - a integer
     */
    public void setRealPart(IntegerNumber realPart) {
        this.realPart = realPart;
    }

    /**
     * setter - set the imaginary part
     * @param imaginaryPart - a integer
     */
    public void setImaginaryPart(IntegerNumber imaginaryPart){
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * add method takes any Gaussian integer as input and returns a GaussianInteger that is the result of adding the input number to this number.
     * @param gi - GaussianInteger
     * @return - a GaussianInteger represents the sum
     */
    public GaussianInteger add(GaussianInteger gi) throws Exception {
        IntegerNumber sumReal = realPart.add(gi.getRealPart());
        IntegerNumber sumImaginary = imaginaryPart.add(gi.getImaginaryPart());
        return new GaussianInteger(sumReal,sumImaginary);
    }

    /**
     * equals method compare this with another GaussianInteger
     * @param gi - GaussianInteger
     * @return - a boolean.
     */
    public boolean equals(GaussianInteger gi){
        if(this.realPart.equals(gi.getRealPart()) && this.imaginaryPart.equals(gi.getImaginaryPart())){
            return true;
        }
        return false;
    }

    /**
     * method Override the default toString method
     * @return - String represents the GaussianInteger
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (imaginaryPart.toString().charAt(0)=='-'){
            sb.append(" - ");
            sb.append(imaginaryPart.toString().replace("-", ""));
            sb.append("i");
        }else {
            sb.append(" + ");
            sb.append(imaginaryPart.toString());
            sb.append("i");
        }

        return realPart.toString() + sb;
    }
}
