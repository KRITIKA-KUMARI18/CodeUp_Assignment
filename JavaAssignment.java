/***
 * To ask the user which operation they want to execute:
 * 1. Count Palindromes
 * 2. Nth Fibonacci
 * 3. Snake to Camel
 * 4. Count Consonants
 * 5. Binary to Decimal conversion
 * Owner name --> Kritika Kumari
 * Date --> 11 September 2024
 */
package Week_2_Assignment_2;

import java.util.*;

public class JavaAssignment {

    // To calculate the number of unique combinations in a string where a palindrome is formed
    // Return Type --> void
    // Parameters --> String, Integer
    public static void countPalindromes(String INPUT_STRING, int count) {
        if (INPUT_STRING.isEmpty()) {
            System.out.println(count);
            return;
        }
        if (INPUT_STRING.length() == 1) {
            count += 1;
            System.out.println(count);
            return;
        } else {
            if (isPalindrome(INPUT_STRING)) {
                count += 2;
            } else {
                count += 1;
            }
        }
        countPalindromes(INPUT_STRING.substring(1, INPUT_STRING.length() - 1), count);
    }

    // To check whether a given string is a palindrome or not
    // Return type --> void
    // Parameters --> String, Integer
    public static boolean isPalindrome(String string) {
        if (string.length() == 1 || string.isEmpty()) {
            return true;
        }
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            isPalindrome(string.substring(1, string.length() - 1));
        } else {
            return false;
        }
        return true;
    }

    // To find the Nth element in the Fibonacci Series
    // Return Type --> void
    // Parameters --> Integer, Integer, Integer
    public static void NthFibonacci(int prev_term, int next_term, int nth_term) {
        int sum = prev_term + next_term;
        prev_term = next_term;
        next_term = sum;
        if (nth_term == 1) {
            System.out.println(sum);
            return;
        }
        NthFibonacci(prev_term, next_term, nth_term - 1);
    }

    // To convert a String from snake_case to camelCase
    // Return Type --> void
    // Parameters --> String, String, Integer
    public static void SnakeToCamelcase(String inputString, String outputString, int index) {
        if (index == inputString.length()) {
            System.out.println(outputString);
            return;
        }
        if (inputString.charAt(index) != '_' && inputString.charAt(index) != ' ') {
            outputString = outputString + Character.toLowerCase(inputString.charAt(index));
        } else {
            if (inputString.charAt(index + 1) != '_' && inputString.charAt(index + 1) != ' ') {
                outputString = outputString + Character.toUpperCase(inputString.charAt(index + 1));
                index += 1;
            }
        }
        SnakeToCamelcase(inputString, outputString, index + 1);
    }

    // To find the number of consonants in the string
    // Return Type --> void
    // Parameters --> String, integer, integer
    public static void CountConsonants(String inputString, int startIndex, int count) {
        if (startIndex == inputString.length()) {
            System.out.println(count);
            return;
        }
        char character = inputString.charAt(startIndex);
        if (((int) character >= 97 && (int) character <= 122) || ((int) character >= 65 && (int) character <= 90)) {
            if (character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u') {
                count += 1;
            }
        }
        CountConsonants(inputString, startIndex + 1, count);
    }

    // To input an integer in binary format and convert it into Decimal Representation
    // Return Type --> void
    // Parameters --> long, long, integer
    public static void BinaryToDecimal(long binary, long decimal, int index) {
        if (binary == 0) {
            System.out.println(decimal);
            return;
        }
        long last_digit = binary % 10;
        decimal = (long) (decimal + (last_digit * Math.pow(2, index)));
        binary = binary / 10;
        BinaryToDecimal(binary, decimal, index + 1);
    }

    // To check whether a number is in Binary Form or not
    // Return Type --> boolean
    // Parameters --> long
    public static boolean isBinary(long INPUT_NUMBER) {
        if (INPUT_NUMBER <= 0) {
            return false;
        } else {
            if ((INPUT_NUMBER % 10) > 1) {
                return false;
            }
            INPUT_NUMBER = INPUT_NUMBER / 10;
            boolean check = isBinary(INPUT_NUMBER);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        Constants constants = new Constants();
        Errors errors = new Errors();
        char SELECT;
        do {
            System.out.println(constants.PROMPT_LIST);
            System.out.println(constants.TASK_1);
            System.out.println(constants.TASK_2);
            System.out.println(constants.TASK_3);
            System.out.println(constants.TASK_4);
            System.out.println(constants.TASK_5);
            System.out.println(constants.PROMPT_ENTER_CHOICE);
            String choice = user_input.nextLine();
            switch (choice) {
                case "1":
                    try {
                        System.out.println(constants.PROMPT_ENTER_STRING);
                        String INPUT_STRING = user_input.nextLine();
                        int count = 0;
                        countPalindromes(INPUT_STRING, count);
                    } catch (InputMismatchException e) {
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "2":
                    try {
                        System.out.println(constants.PROMPT_ENTER_NUMBER);
                        int Nth_term = user_input.nextInt();
                        int a = 0, b = 1;
                        NthFibonacci(a, b, Nth_term - 1);
                    } catch (Exception e) {
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "3":
                    try {
                        System.out.println(constants.PROMPT_ENTER_STRING);
                        String inputString = user_input.nextLine();
                        String input_string = inputString.trim();
                        String outputString = "";
                        int index = 0;
                        SnakeToCamelcase(input_string, outputString, index);
                    } catch (Exception e) {
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "4":
                    try {
                        System.out.println(constants.PROMPT_ENTER_STRING);
                        String INPUT_STRING = user_input.nextLine();
                        int index = 0, count = 0;
                        CountConsonants(INPUT_STRING, index, count);
                    } catch (Exception e) {
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "5":
                    try {
                        System.out.println(constants.PROMPT_BINARY);
                        long INPUT_NUMBER = user_input.nextLong();
                        if (INPUT_NUMBER == 0) {
                            System.out.println(INPUT_NUMBER);
                        } else if (isBinary(INPUT_NUMBER)) {
                            int power_value = 0;
                            long decimal_value = 0;
                            BinaryToDecimal(INPUT_NUMBER, decimal_value, power_value);
                        } else {
                            System.out.println(errors.NOT_BINARY);
                        }
                    } catch (Exception e) {
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                default:
                    System.out.println(errors.CORRECT_CHOICE);
            }
            System.out.println(constants.SELECT);
            SELECT = user_input.next().charAt(0);
            user_input.nextLine();
        } while (SELECT == 'y' || SELECT == 'Y');
    }
}