/***
 * To ask the user which operation they want to execute:
 * 1. Combination Generator
 * 2. Digit Sum
 * 3. Consecutive Number Sum
 * 4. Shift Variability
 * 5. ASCII Conversion of the highest digits
 * Owner name --> Kritika Kumari
 * Date --> 09 September 2024
 */
package Assignment_3;

import java.util.*;

public class Encryption {
    Scanner input = new Scanner(System.in);
    Constant constant = new Constant();

    // To generate all valid combinations of a string
    public static void CombinationGenerator(String INPUT_STRING, String OUTPUT_STRING, int INDEX) {
        if (INDEX >= INPUT_STRING.length()) {
            System.out.println(" ' " + OUTPUT_STRING + " ' ");
        }
        char ch = INPUT_STRING.charAt(INDEX);
        CombinationGenerator(INPUT_STRING, OUTPUT_STRING, INDEX + 1);
        CombinationGenerator(INPUT_STRING, OUTPUT_STRING + ch, INDEX + 1);
    }

    // To take a number as input and replace it with the sum of its digits until the number is reduced to a single digit.
    final public void DigitSum() {
        System.out.println(constant.ENTER_NUMBER);
        int INPUT_NUMBER = input.nextInt();
        int sum;
        if (INPUT_NUMBER < 0) {
            System.out.println(constant.ENTER_NUMBER);
        } else {
            do {
                sum = 0;
                while (INPUT_NUMBER > 0) {
                    int remainder = INPUT_NUMBER % 10;
                    sum = sum + remainder;
                    INPUT_NUMBER = INPUT_NUMBER / 10;
                }
                INPUT_NUMBER = sum;
            } while (INPUT_NUMBER > 9);
            System.out.println(sum);
        }
    }

    // To find whether a given number can be expressed as the sum of two or more consecutive natural numbers
    final public void ConsecutiveNumberSum() {
        System.out.println(constant.ENTER_NUMBER);
        int INPUT_NUMBER = input.nextInt();
        if (INPUT_NUMBER < 0) {
            System.out.println(constant.INCORRECT_NUMBER);
        }
        int count = 0;
        for (int i = 1; i < INPUT_NUMBER; i++) {
            int sum = 0;
            for (int j = i; sum < INPUT_NUMBER; j++) {
                sum = sum + j;
                if (sum == INPUT_NUMBER) {
                    count++;
                    for (int k = i; k < j; k++) {
                        System.out.print(k + "+");
                    }
                    System.out.print(j);
                    System.out.println();
                }
            }
        }
        if (count == 0) {
            System.out.println(constant.NO_CONSECUTIVE);
        }
    }

    // To apply corresponding shift value from the pattern array for each character in the string
    final public void ShiftVariability() {
        System.out.println(constant.ENTER_STRING);
        String INPUT_STRING = input.nextLine();
        System.out.println(constant.ARRAY_LENGTH);
        int array_length = input.nextInt();
        int[] SHIFT_PATTERN_ARRAY = new int[array_length];
        System.out.println(constant.SHIFT_PATTERN);
        for (int i = 0; i < array_length; i++) {
            SHIFT_PATTERN_ARRAY[i] = input.nextInt();
        }
        char[] INPUT_ARRAY = INPUT_STRING.toCharArray();
        int k = 0;
        for (char c : INPUT_ARRAY) {
            if (c != ' ') {
                int SHIFT = c + SHIFT_PATTERN_ARRAY[k];
                char SHIFT_PATTERN = (char) SHIFT;
                System.out.print(SHIFT_PATTERN);
                k++;
                if (k == (SHIFT_PATTERN_ARRAY.length))
                    k = 0;
            } else {
                System.out.print(" ");

            }

        }
        System.out.println();
    }

    // To encode the highest digits, based on the provided series, into their corresponding ASCII characters
    final public void ASCIIConversion() {
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Encryption object = new Encryption();
        Constant constant = new Constant();
        System.out.println(constant.OUTPUT_STRING);
        System.out.println(constant.TASK1);
        System.out.println(constant.TASK2);
        System.out.println(constant.TASK3);
        System.out.println(constant.TASK4);
        System.out.println(constant.TASK5);

        char SELECT;
        do {
            System.out.println(constant.ENTER_CHOICE);
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println(constant.ENTER_STRING);
                    String INPUT_STRING = input.nextLine();
                    String OUTPUT_STRING = " ";
                    int INDEX = 0;
                    object.CombinationGenerator(INPUT_STRING, OUTPUT_STRING, INDEX);
                    break;
                case "2":
                    object.DigitSum();
                    break;
                case "3":
                    object.ConsecutiveNumberSum();
                    break;
                case "4":
                    object.ShiftVariability();
                    break;
                case "5":
                    object.ASCIIConversion();
                    break;
                default:
                    System.out.println(constant.CORRECT_CHOICE);
                    break;
            }
            System.out.println(constant.SELECT);
            SELECT = input.next().charAt(0);
            input.nextLine();
        } while (SELECT == 'y' || SELECT == 'Y');
    }
}