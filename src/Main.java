public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        ArbitraryWholeNumber wn = new ArbitraryWholeNumber("-006543000");
        System.out.println(wn);
        ArbitraryFloatingPointNumber fpn = new ArbitraryFloatingPointNumber("-065.43000");
        System.out.println(fpn);

        System.out.println("");
        byte[] digits = {0, 0, 6, 7, 1, 0};
        ArbitraryWholeNumber wn2 = new ArbitraryWholeNumber();
        wn2.setDigits(digits);
//        wn2.setNegative(true);
        System.out.println(wn2);
        System.out.println(wn2.getDigits()[2]);

        byte[] digits1 = {0, 0, 6, 7, 1, 0};
        ArbitraryWholeNumber wn3 = new ArbitraryWholeNumber();
        wn3.setDigits(digits1);
//        wn3.setNegative(true);
        System.out.println(wn2);
        System.out.println(wn3);
        System.out.println("Equals");
        System.out.println(wn2.equals(wn3));
        System.out.println(wn3.equals(wn2));
        System.out.println("");

        ArbitraryFloatingPointNumber fpn2 = new ArbitraryFloatingPointNumber();
        fpn2.setPrecision(10);
        fpn2.setDigits(digits);
        fpn2.setNegative(true);
        System.out.println(fpn2);

        NaturalNumber nn1 = new NaturalNumber();
        byte[] digits3 = {5, 4, 3, 2, 1, 6};
        nn1.setDigits(digits3);
//        nn1.setNegative(true);
        System.out.println(nn1);

        byte a = 5;
        byte b = 6;
        byte s = (byte) (a + b);
        System.out.println(s);

        System.out.println("NaturalNumber add");
        NaturalNumber nn2 = new NaturalNumber();
        byte[] digits4 = {5, 4, 3, 2, 1, 6, 1};
        nn2.setNegative(true);
        nn2.setDigits(digits4);
        System.out.println(nn1);
        System.out.println(nn2);
        System.out.println(nn2.add(nn1));

        NaturalNumber nn3 = new NaturalNumber("012345");
        System.out.println(nn3);

        System.out.println("000000");
        byte[] digits5 = {0,0,0,0,0,0};
        ArbitraryFloatingPointNumber afpn = new ArbitraryFloatingPointNumber(digits5,true,3);
        afpn.trimDigits(digits5);
        System.out.println(afpn);

        byte[] digits6 = {0,0,0,3,4,5,6,0,0,0};
        byte[] digits7 = {3,4,5,6};
        ArbitraryFloatingPointNumber afpn1 = new ArbitraryFloatingPointNumber(digits6,true,5);
        ArbitraryFloatingPointNumber afpn2 = new ArbitraryFloatingPointNumber(digits7,true,2);
        System.out.println(afpn1.equals(afpn2));

    }

}
