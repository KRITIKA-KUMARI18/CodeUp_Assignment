/***
 * This class is the Main class of the NumberConversion and Operations File.
 * In this class Input commands are decoded and further operations are executed.
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 25 September 2024
 */
package NumberConversionAndOperations;

import java.util.*;

public class Main {

    // To split the Input command in words for decoding
    // Return Type -> String Array
    // Parameter -> String
    public static String[] split(String inputString) {
        String[] command = new String[6];
        int index = 0;
        String splitString = "";
        for (int i = 0; i < inputString.length(); i++) {
            char word = inputString.charAt(i);
            if (word != ' ' && word != '.') {
                splitString = splitString + word;
            } else {
                if (inputString.charAt(i) != inputString.charAt(i + 1)) {
                    command[index] = splitString;
                    splitString = "";
                    index++;
                } else {
                    i += 2;
                }
            }
        }
        command[index] = splitString;
        return command;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Constant constant = new Constant();
        Error error = new Error();
        ValidNumber valid = new ValidNumber();
        Conversion conversion = new Conversion();
        FindBase find = new FindBase();
        char choice;
        System.out.println(constant.Operation);
        System.out.println(constant.CommandExample);
        do {
            // To handle Null Pointer and any other Exception in the code
            try {
                System.out.println(constant.Command);
                String command = userInput.nextLine();
                if (!valid.isValidCommand(command)) {
                    System.out.println(error.Invalid);
                    break;
                }
                String[] splitCommand = split(command);
                String method = splitCommand[0];
                String stringBase = splitCommand[1];
                String number = splitCommand[2];
                String changeBase = splitCommand[4];
                String nextNumber = splitCommand[5];
                String decimal, convertedNumber, nextDecimal;
                int base, newBase;
                if (valid.isValid(number)) {
                    switch (method) {
                        case "convert":
                            base = find.findBase(stringBase);
                            newBase = find.findBase(changeBase);
                            if ((valid.isBinaryOctalDecimal(number, base) || base == 16) && (newBase != -1)) {
                                decimal = conversion.otherToDecimal(number, base);
                                convertedNumber = conversion.decimalToOther(decimal, newBase);
                                System.out.println(constant.Required + convertedNumber);
                            } else {
                                if (newBase == -1){
                                    System.out.println(find.findError(newBase));
                                }
                                else {
                                    System.out.println(find.findError(base));
                                }
                            }
                            break;
                        case "add":
                            base = find.findBase(stringBase);
                            newBase = find.findBase(changeBase);
                            if (valid.isValid(nextNumber)){
                                if ((valid.isBinaryOctalDecimal(number, base) || base == 16) && (newBase != -1)) {
                                    decimal = conversion.otherToDecimal(number, base);
                                    nextDecimal = conversion.otherToDecimal(nextNumber, newBase);
                                    long number1 = Long.parseLong(decimal);
                                    long number2 = Long.parseLong(nextDecimal);
                                    long result = number1 + number2;
                                    System.out.println(constant.Addition + result);
                                } else {
                                    System.out.println(error.InvalidBaseConversion);
                                }
                            } else {
                                System.out.println(error.InvalidSecondNumber);
                            }
                            break;
                        case "subtract":
                            base = find.findBase(stringBase);
                            newBase = find.findBase(changeBase);
                            if (valid.isValid(nextNumber)) {
                                if ((valid.isBinaryOctalDecimal(number, base) || base == 16) && (newBase != -1)) {
                                    decimal = conversion.otherToDecimal(number, base);
                                    nextDecimal = conversion.otherToDecimal(nextNumber, newBase);
                                    long number1 = Long.parseLong(decimal);
                                    long number2 = Long.parseLong(nextDecimal);
                                    long result = number2 - number1;
                                    System.out.println(constant.Subtraction + result);
                                } else {
                                    System.out.println(error.InvalidBaseConversion);
                                }
                            } else {
                                System.out.println(error.InvalidSecondNumber);
                            }
                            break;
                        default:
                            System.out.println(error.InvalidCommand);
                            break;
                    }
                } else {
                    System.out.println(error.InvalidNumber);
                }
            } catch (Exception e) {
                System.out.println(error.InvalidCommand);
            }
            System.out.println(constant.Choice);
            choice = userInput.next().charAt(0);
            userInput.nextLine();
        } while (choice == '1');
    }
}