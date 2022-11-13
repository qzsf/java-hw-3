public class ComplexNumber {
    private RealNumber realPart;
    private RealNumber imaginaryPart;

    public ComplexNumber() {
    }

    public ComplexNumber(RealNumber realPart, RealNumber imaginaryPart) {
        setRealPart(realPart);
        setImaginaryPart(imaginaryPart);
    }

    public RealNumber getRealPart() {
        return realPart;
    }

    public RealNumber getImaginaryPart() {
        return imaginaryPart;
    }

    public void setRealPart(RealNumber realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(RealNumber imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber add(ComplexNumber cn) {
        RealNumber sumReal = realPart.add(cn.getRealPart());
        RealNumber sumImaginary = imaginaryPart.add(cn.getImaginaryPart());
        return new ComplexNumber(sumReal, sumImaginary);
    }

    public boolean equals(ComplexNumber cn) {
        if (this.realPart.equals(cn.getRealPart()) && this.imaginaryPart.equals(cn.getImaginaryPart())) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (imaginaryPart.toString().charAt(0) == '-') {
            sb.append(" - ");
            sb.append(imaginaryPart.toString().replace("-", ""));
            sb.append("i");
        } else {
            sb.append(" + ");
            sb.append(imaginaryPart.toString());
            sb.append("i");
        }
        return realPart.toString() + sb;
    }

}
