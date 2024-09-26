/***
 * This class is to check whether the given number is valid or not.
 * Owner:- KRITIKA KUMARI
 * Date of Creation:- 25 September 2024
 */
package NumberConversionAndOperations;

public class ValidNumber {

    // To check whether the Input Number is valid or not
    // @return -> true if number is valid else false
    // @param -> Given Input Number
    final public boolean isValid(String Number) {
        for (int i = 0; i < Number.length(); i++) {
            char digit = Number.charAt(i);
            if ((digit >= 48 && digit <= 57) || (digit >= 97 && digit <= 102) || (digit >= 65 && digit <= 70) || (digit == '.')) {
                continue;
            }
            return false;
        }
        return true;
    }

    // To check whether the Input Number is in Binary/Octal/Decimal form or not
    // @return -> true if it is binary/octal/decimal/etc.
    // @param -> Given Input Number, base
    final public boolean isBinaryOctalDecimal(String INPUT_NUMBER, int base) {
        try {
            long Number = Long.parseLong(INPUT_NUMBER);
            if (Number <= 0) {
                return false;
            }
            while (Number > 0) {
                if ((Number % 10) >= base) {
                    return false;
                }
                Number = Number / 10;
            }
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    // To check whether the Input Command is valid or not
    // @return -> true if given command is valid
    // @param -> Input Command
    final public boolean isValidCommand(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            if ((character >= 48 && character <= 57) || (character >= 97 && character <= 122) || (character >= 65 && character <= 90) || (character == ' ') || (character == '.')) {
                continue;
            }
            return false;
        }
        return true;
    }
}
