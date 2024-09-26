/***
 * This class has been created to convert the given number
 * from its base to any other base.
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 25 September 2024
 */
package NumberConversionAndOperations;

public class Conversion {

    // To convert the given number in decimal form
    // Return Type -> String
    // Parameters -> String, Integer
    final public String otherToDecimal(String number, int base) {
        long sum = 0;
        int length = number.length();
        if (base <= 10) {
            for (int i = 0; i < length; i++) {
                int digit = number.charAt(i) - '0';
                sum = sum + (digit * power(base, (length - i - 1)));
            }
        } else {
            for (int i = 0; i < length; i++) {
                char character = number.charAt(i);
                int digit;
                if (character >= 48 && character <= 57) {
                    digit = character - '0';
                } else if (character >= 65 && character <= 70) {
                    digit = character - 55;
                } else {
                    digit = character - 87;
                }
                sum = sum + (digit * power(base, (length - i - 1)));
            }
        }
        return Long.toString(sum);
    }

    // To convert the decimal number in another base form
    // Return Type -> String
    // Parameters -> String, Integer
    final public String decimalToOther(String number, int base) {
        StringBuilder convertedNumber = new StringBuilder();
        long Number = Long.parseLong(number);
        if (base <= 10){
            while (Number >= base){
                long digit = Number % base;
                String character = Long.toString(digit);
                convertedNumber.insert(0, character);
                Number = Number/base;
            }
            convertedNumber.insert(0, Number);
        }
        else {
            while (Number >= base){
                long digit = Number % base;
                if (digit < 10){
                    String character = Long.toString(digit);
                    convertedNumber.insert(0, character);
                }
                else {
                    char character = (char) (digit + 55);
                    convertedNumber.insert(0, character);
                }
                Number = Number/base;
            }
            convertedNumber.insert(0, Number);
        }
        return convertedNumber.toString();
    }

    // To calculate the power of the given base
    // Return Type -> Long
    // Parameters -> Integer, Integer
    public static long power(int base, int index) {
        long power = 1;
        if (index == 0) {
            return 1;
        }
        power = base * power(base, index - 1);
        return power;
    }
}