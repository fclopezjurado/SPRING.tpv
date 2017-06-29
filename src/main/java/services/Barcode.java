package services;

public class Barcode {

    public int ean13ControlCodeCalculator(String code) {
        char[] charDigits = code.toCharArray();
        int[] ean13 = {1, 3};
        int sum = 0;
        for (int i = 0; i < charDigits.length; i++) {
            sum += Character.getNumericValue(charDigits[i]) * ean13[i % 2];
        }
        return (10 - sum % 10)%10;
    }

    public static void main(String[] args) {
        System.out.println(new Barcode().ean13ControlCodeCalculator("841444510123"));
        System.out.println(new Barcode().ean13ControlCodeCalculator("848000067015"));
    }
}
