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
    Scanner user_input = new Scanner(System.in);
    Constant constant = new Constant();
    Errors errors = new Errors();

    // To generate all valid combinations of a string
    // Return type --> void
    // Parameters --> character array, character array, integer, boolean, integer
    public static void CombinationGenerator(char[] INPUT, char[] RESULT, int INDEX, boolean[] USED, int length) {
        if (INDEX == length) {
            for (int i = 0; i < length; i++) {
                System.out.print(RESULT[i]);
            }
            System.out.print(" ");
            return;
        }
        for (int i = 0; i < INPUT.length; i++) {
            if (!USED[i]) {
                USED[i] = true;
                RESULT[INDEX] = INPUT[i];
                CombinationGenerator(INPUT, RESULT, INDEX + 1, USED, length);
                USED[i] = false;
            }
        }
    }

    // To take a number as input and replace it with the sum of its digits until the number is reduced to a single digit.
    // Return type --> void
    // No Parameter
    final public void DigitSum() {
        char SELECT;
        do {
            try {
                System.out.println(constant.PROMPT_NUMBER);
                int INPUT_NUMBER = user_input.nextInt();
                int sum;
                if (INPUT_NUMBER < 0) {
                    System.out.println(constant.PROMPT_NUMBER);
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
            } catch (InputMismatchException e) {
                System.out.println(errors.PROMPT_ERROR);
            }
            System.out.println(constant.PROMPT_USER);
            user_input.nextLine();
            SELECT = user_input.next().charAt(0);
        } while (SELECT == 'y' || SELECT == 'Y');
    }

    // To find whether a given number can be expressed as the sum of two or more consecutive natural numbers
    // Return type --> void
    // No Parameter
    final public void ConsecutiveNumberSum() {
        char SELECT;
        do {
            try {
                System.out.println(constant.PROMPT_NUMBER);
                int INPUT_NUMBER = user_input.nextInt();
                if (INPUT_NUMBER < 0) {
                    System.out.println(errors.INCORRECT_NUMBER);
                }
                int consecutive_term = 0;
                for (int i = 1; i < INPUT_NUMBER; i++) {
                    int consecutive_sum = 0;
                    for (int j = i; consecutive_sum < INPUT_NUMBER; j++) {
                        consecutive_sum = consecutive_sum + j;
                        if (consecutive_sum == INPUT_NUMBER) {
                            consecutive_term++;
                            for (int k = i; k < j; k++) {
                                System.out.print(k + "+");
                            }
                            System.out.print(j);
                            System.out.println();
                        }
                    }
                }
                if (consecutive_term == 0) {
                    System.out.println(errors.NO_CONSECUTIVE);
                }
            } catch (Exception e) {
                System.out.println(errors.PROMPT_ERROR);
            }
            System.out.println(constant.PROMPT_USER);
            user_input.nextLine();
            SELECT = user_input.next().charAt(0);
        } while (SELECT == 'y' || SELECT == 'Y');
    }

    // To apply corresponding shift value from the pattern array for each character in the string
    // Return type --> void
    // No Parameter
    final public void ShiftVariability() {
        char SELECT;
        do {
            try {
                System.out.println(constant.PROMPT_STRING);
                String INPUT_STRING = user_input.nextLine();
                System.out.println(constant.SHIFT_ARRAY_LENGTH);
                int array_length = user_input.nextInt();
                int[] SHIFT_PATTERN_ARRAY = new int[array_length];
                System.out.println(constant.SHIFT_PATTERN);
                for (int i = 0; i < array_length; i++) {
                    SHIFT_PATTERN_ARRAY[i] = user_input.nextInt();
                }
                char[] INPUT_ARRAY = INPUT_STRING.toCharArray();
                int SHIFT_PATTERN_ARRAY_INDEX = 0;
                for (char character : INPUT_ARRAY) {
                    if (character != ' ') {
                        int SHIFT = character + SHIFT_PATTERN_ARRAY[SHIFT_PATTERN_ARRAY_INDEX];
                        char SHIFT_PATTERN = (char) SHIFT;
                        System.out.print(SHIFT_PATTERN);
                        SHIFT_PATTERN_ARRAY_INDEX++;
                        if (SHIFT_PATTERN_ARRAY_INDEX == (SHIFT_PATTERN_ARRAY.length))
                            SHIFT_PATTERN_ARRAY_INDEX = 0;
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println(errors.PROMPT_ERROR);
            }
            System.out.println(constant.PROMPT_USER);
            user_input.nextLine();
            SELECT = user_input.next().charAt(0);
        } while (SELECT == 'y' || SELECT == 'Y');
    }

    // To encode the highest digits, based on the provided series, into their corresponding ASCII characters
    // Return type --> void
    // No Parameter
    final public void ASCIIConversion() {
        char SELECT;
        do {
            try {
                // INPUT ARRAY
                System.out.println(constant.ARRAY_LENGTH);
                int array_length = user_input.nextInt();
                int[] INPUT_ARRAY = new int[array_length];
                System.out.println(constant.INPUT_ARRAY);
                for (int i = 0; i < array_length; i++) {
                    INPUT_ARRAY[i] = user_input.nextInt();
                }
                // SERIES ARRAY
                System.out.println(constant.SERIES_ARRAY_LENGTH);
                int series_array_length = user_input.nextInt();
                int[] SERIES_ARRAY = new int[series_array_length];
                System.out.println(constant.SERIES_ARRAY
                );
                for (int i = 0; i < series_array_length; i++) {
                    SERIES_ARRAY[i] = user_input.nextInt();
                }
                // To Check whether the given series is valid or not
                for (int a = 0; a < series_array_length; a++) {
                    if (SERIES_ARRAY[a] > INPUT_ARRAY.length) {
                        System.out.println(errors.ERROR);
                        return;
                    }
                }
                // TO SORT INPUT ARRAY
                for (int i = 1; i < INPUT_ARRAY.length; i++) {
                    int key = INPUT_ARRAY[i];
                    int j = i - 1;
                    while (j >= 0 && INPUT_ARRAY[j] > key) {
                        INPUT_ARRAY[j + 1] = INPUT_ARRAY[j];
                        j--;
                    }
                    INPUT_ARRAY[j + 1] = key;
                }
                for (int i = 0; i < series_array_length; i++) {
                    SERIES_ARRAY[i] = INPUT_ARRAY[array_length - SERIES_ARRAY[i]];
                }
                for (int k = 0; k < series_array_length; k++) {
                    int answer = SERIES_ARRAY[k] + '0';
                    System.out.print(answer);
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println(errors.PROMPT_ERROR);
            }
            System.out.println(constant.PROMPT_USER);
            user_input.nextLine();
            SELECT = user_input.next().charAt(0);
        } while (SELECT == 'y' || SELECT == 'Y');
    }

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        Encryption object = new Encryption();
        Constant constant = new Constant();
        Errors errors = new Errors();
        System.out.println(constant.PROMPT_LIST);
        System.out.println(constant.TASK1);
        System.out.println(constant.TASK2);
        System.out.println(constant.TASK3);
        System.out.println(constant.TASK4);
        System.out.println(constant.TASK5);
        String SELECT;
        do {
            System.out.println(constant.PROMPT_CHOICE);
            String choice = user_input.nextLine();
            switch (choice) {
                case "1":
                    char ASK;
                    do {
                        System.out.println(constant.PROMPT_STRING);
                        String INPUT_STRING = user_input.nextLine();
                        char[] INPUT_ARRAY = INPUT_STRING.toCharArray();
                        boolean[] used = new boolean[INPUT_ARRAY.length];
                        char[] result = new char[INPUT_ARRAY.length];
                        for (int length = 1; length <= INPUT_ARRAY.length; length++) {
                            CombinationGenerator(INPUT_ARRAY, result, 0, used, length);
                        }
                        System.out.println();
                        System.out.println(constant.PROMPT_USER);
                        ASK = user_input.next().charAt(0);
                        user_input.nextLine();
                    } while (ASK == 'y' || ASK == 'Y');
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
                    System.out.println(errors.CORRECT_CHOICE);
                    break;
            }
            System.out.println(constant.SELECT);
            SELECT = user_input.nextLine();
        } while (SELECT == "Y" || SELECT == "y");
    }
}