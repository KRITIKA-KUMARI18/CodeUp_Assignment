/***
 * This class is for all the string values that has been used to
 * display to the user in the Main Class.
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 25 September 2024
 */
package NumberConversionAndOperations;

public class Constant {
    final public String Operation = """
            
            Following are the list of operations possible:
            1. Binary to Decimal, Octal, Hexadecimal Conversion and vice-versa
            2. Addition of two numbers in different or same form
            3. Subtraction of two numbers in different or same form
            
            NOTE:- Result of Addition and Subtraction will be in Decimal Form\s
            """;
    final public String CommandExample = """
            Command Format:
                convert decimal 197345 to octal
                           OR
                convert binary 1101010110 to hex
                           OR
                add binary 1101010110 to hex 7826AF
                           OR
                subtract decimal 535562 from hex 2A36B9F
                
            Remember: Command must be in lowercase letters except for the number \s
            """;
    final public String Command = "Enter your command in the above shown format: ";
    final public String Required = "Required Base Conversion value is: ";
    final public String Addition = "Required Addition is: ";
    final public String Subtraction = "Required Subtraction is: ";
    final public String Choice = "Do you want to continue. If yes press 1 else press any other character to exit.";
}