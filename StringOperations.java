/***
 * To ask the user which operation they want to execute on the string.
 * The available operations are listed below:
 * Append, CountWords, Replace, isPalindrome, Splice, Split,
 * MaxRepeatingCharacter, Sort, Shift, and Reverse.
 * Owner name --> Kritika Kumari
 * Date --> 4 September 2024
 */
package Assignment_2;

import java.util.*;

public class StringOperations {

    Scanner input = new Scanner(System.in);

    final public void Append() {         // To add two or more strings
        Constant constant = new Constant();
        char choice;

        System.out.println(constant.FIRST_STRING);
        String str = input.nextLine();

        do {
            System.out.println(constant.NEXT_STRING);

            String str2 = input.next();
            str = str + " " + str2;
            System.out.println(str);
            System.out.println(constant.APPEND_STRING);
            choice = input.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    final public void WordsCount() {        // To count the words in a string

        Constant constant = new Constant();
        System.out.println(constant.CAUTION);
        System.out.println(constant.ENTER_STRING);
        String str = input.nextLine();
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (i > 0 && str.charAt(i) == ' ') {
                if (str.charAt(i) == str.charAt(i + 1)) {

                } else {
                    count++;
                }
            }
        }
        count += 1;
        System.out.println("It has " + count + " word");
    }

    final public void Replace() {         // To replace some characters in a string with another characters

        Constant constant = new Constant();

        System.out.println(constant.ENTER_STRING);
        String text = input.nextLine();

        System.out.println(constant.PREV_STRING);
        char old_char = input.next().charAt(0);

        System.out.println(constant.REPLACE_STRING);
        char new_char = input.next().charAt(0);

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == old_char) {
                text = text.substring(0, i) + new_char + text.substring(i + 1);
            }
        }
        System.out.println(text);
    }

    final public void isPalindrome() {       // To check whether a string is palindrome or not

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String str = input.nextLine();

        int n = str.length();
        int c = 0;
        for (int i = 0; i < n; i++) {
            int j = n - i - 1;
            if (str.charAt(i) == str.charAt(j)) {
                c++;
            } else {
                break;
            }
        }
        if (c == n) {
            System.out.println(str + constant.PALINDROME);
        } else {
            System.out.println(str + constant.NOT_PALINDROME);
        }
    }

    final public void Splice() {      // To remove some strings from a given string

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String text = input.nextLine();
        System.out.println(constant.START_INDEX);
        int start_index = input.nextInt();
        System.out.println(constant.LENGTH);
        int length = input.nextInt();

        String spliced_text = text.substring(0, start_index) + text.substring(start_index + length);
        System.out.println(spliced_text);

    }

    final public void Split() {        // To split a string into words

        Constant constant = new Constant();
        System.out.println(constant.EXCEPTION);
        System.out.println(constant.TEXT);
        String text = input.nextLine();

        char[] words = text.toCharArray();

        System.out.print(" [ ");

        for (char word : words) {
            String str = "";
            if (word != ' ') {
                str = str + word;
            }
            System.out.print(str);
            if (word == ' ') {
                System.out.print(" , ");
            }
        }
        System.out.print(" ] ");
        System.out.println();
    }

    final public void MaxRepeatChar() {       // To find the maximum repeating character in the string

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String string = input.nextLine();

        int length = string.length();
        int count1 = 0;
        char maxChar = ' ';
        for (int i = 0; i < length; i++) {
            int count2 = 0;
            for (int j = i; j < length; j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    count2++;
                }
            }
            if (count2 > count1) {
                count1 = count2;
                maxChar = string.charAt(i);
            }
        }
        System.out.print(maxChar);
        System.out.print("->");
        System.out.println(count1);
    }

    final public void Sort() {         // To sort the alphabets of the string as per their ASCII value

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String text = input.nextLine();

        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length - 1; i++) {
            for (int j = i + 1; j < textArray.length; j++) {
                if (textArray[i] > textArray[j]) {
                    char temp = textArray[i];
                    textArray[i] = textArray[j];
                    textArray[j] = temp;
                }
            }
        }
        for (char c : textArray) {
            System.out.print(c);
        }
        System.out.println();
    }

    final public void Shift() {        // To shift the starting characters of a string at the end

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String text = input.nextLine();
        System.out.println(constant.SHIFT_INDEX);
        int index = input.nextInt();

        String shifted_text = text.substring(index) + text.substring(0, index);
        System.out.println(shifted_text);
    }

    final public void Reverse() {       // To reverse the string

        Constant constant = new Constant();
        System.out.println(constant.ENTER_STRING);
        String str = input.nextLine();
        int n = str.length();
        String reversestring = "";

        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            reversestring = reversestring + ch;
        }
        System.out.println(constant.REVERSE_STRING + reversestring);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringOperations obj = new StringOperations();

        Constant constant = new Constant();
        System.out.println(constant.INPUT_STRING);

        System.out.println(" 1:  Append ");
        System.out.println(" 2:  CountWords ");
        System.out.println(" 3:  Replace ");
        System.out.println(" 4:  isPalindrome ");
        System.out.println(" 5:  Splice ");
        System.out.println(" 6:  Split ");
        System.out.println(" 7:  MaxRepeatingCharacter ");
        System.out.println(" 8:  Sort ");
        System.out.println(" 9:  Shift ");
        System.out.println("10:  Reverse ");

        char SELECT;

        do {

            System.out.println(constant.CHOICE);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    obj.Append();
                    break;
                case 2:
                    obj.WordsCount();
                    break;
                case 3:
                    obj.Replace();
                    break;
                case 4:
                    obj.isPalindrome();
                    break;
                case 5:
                    obj.Splice();
                    break;
                case 6:
                    obj.Split();
                    break;
                case 7:
                    obj.MaxRepeatChar();
                    break;
                case 8:
                    obj.Sort();
                    break;
                case 9:
                    obj.Shift();
                    break;
                case 10:
                    obj.Reverse();
                    break;
                default:
                    System.out.println(constant.OPTION);
                    break;
            }
            System.out.println(constant.ANOTHER_INPUT);
            SELECT = input.next().charAt(0);

        } while (SELECT == 'y' || SELECT == 'Y');


    }
}
