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

import static java.lang.Math.pow;

public class JavaAssignment {

    // To calculate the number of unique combinations in a string where a palindrome is formed
    // Return Type --> void
    // Parameters --> String
    public static void countPalindromes(String INPUT_STRING) {

    }

    // To find the Nth element in the Fibonacci Series
    // Return Type --> void
    // Parameters --> integer, integer, integer
    public static void NthFibonacci( int a, int b, int n ){
        int sum = a + b;
        a = b;
        b = sum;
        if( n == 1){
            System.out.println(sum);
            return;
        }
        NthFibonacci(a,b,n-1);
    }

    // To convert a String from snake_case to camelCase
    // Return Type --> void
    // Parameters --> String
    public static void SnakeToCamelcase( String INPUT_STRING){

    }

    // To find the number of consonants in the string
    // Return Type --> void
    // Parameters --> String, integer, integer
    public static void CountConsonants(String INPUT_STRING, int index, int count){
        if( index == INPUT_STRING.length() ){
            System.out.println(count);
            return;
        }
        char character = INPUT_STRING.charAt(index);
        if( ((int) character >=97 && (int) character <=122 ) || ( (int) character >=65 && (int) character <= 90) ){
            if(character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u'){
                count+=1;
            }
        }
        CountConsonants(INPUT_STRING, index+1, count);
    }

    // To input an integer in binary format and convert it into Decimal Representation
    // Return Type --> void
    // Parameters --> long, double, double
    public static void BinaryToDecimal( long INPUT_NUMBER, double decimal_value, double index ){
        if(INPUT_NUMBER == 0){
            System.out.println(decimal_value);
            return;
        }
        long last_digit = INPUT_NUMBER % 10;
        decimal_value = decimal_value + (last_digit*pow(2,index));
        INPUT_NUMBER = INPUT_NUMBER/10;
        BinaryToDecimal(INPUT_NUMBER,decimal_value,index+1);
    }

    // To check whether a number is in Binary Form or not
    // Return Type --> boolean
    // Parameters --> long
    public static boolean isBinary( long INPUT_NUMBER ){
        if(INPUT_NUMBER <= 0 ){
            return false;
        }
        else {
            if( (INPUT_NUMBER % 10) > 1){
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
        do{
            System.out.println(constants.PROMPT_LIST);
            System.out.println(constants.TASK_1);
            System.out.println(constants.TASK_2);
            System.out.println(constants.TASK_3);
            System.out.println(constants.TASK_4);
            System.out.println(constants.TASK_5);
            System.out.println(constants.PROMPT_CHOICE);
            String choice = user_input.nextLine();
            switch (choice){
                case "1":
                    try{

                    }
                    catch (Exception e){
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "2":
                    try{
                        System.out.println(constants.PROMPT_NUMBER);
                        int Nth_term = user_input.nextInt();
                        int a = 0, b = 1;
                        NthFibonacci( a, b, Nth_term-1);
                    }
                    catch (Exception e){
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "3":
                    try{
                        System.out.println(constants.PROMPT_STRING);
                        String INPUT_STRING = user_input.nextLine();
                        SnakeToCamelcase(INPUT_STRING);
                    }
                    catch (Exception e){
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "4":
                    try{
                        System.out.println(constants.PROMPT_STRING);
                        String INPUT_STRING = user_input.nextLine();
                        int index = 0, count = 0;
                        CountConsonants(INPUT_STRING, index, count);
                    }
                    catch (Exception e){
                        System.out.println(errors.PROMPT_ERROR);
                    }
                    break;
                case "5":
                    try{
                        System.out.println(constants.PROMPT_BINARY);
                        long INPUT_NUMBER = user_input.nextLong();
                        if( isBinary(INPUT_NUMBER) ){
                            double power_value = 0;
                            double decimal_value =0;
                            BinaryToDecimal(INPUT_NUMBER, decimal_value, power_value);
                        }
                        else{
                            System.out.println(errors.NOT_BINARY);
                        }
                    }
                    catch (Exception e){
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