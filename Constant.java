/***
 * This class contains the string values that has been used to
 * display to the user in the Main Class.
 * Owner:- KRITIKA KUMARI
 * Date of Creation:- 25 September 2024
 */
package NumberConversionAndOperations;

public class Constant {
    final public String Operation = """
            
            Following are the list of operations possible:
            1. Base Conversion
            2. Addition
            3. Subtraction
            4. Multiplication
            5. Division
            
            NOTE:- Result of Addition, Subtraction, Multiplication and Division will be in Decimal Form\s
            """;
    final public String CommandExample = """
            Command Format:
                convert decimal 197345 to octal
                           OR
                add binary 1101010110 to hex 7826AF
                           OR
                subtract decimal 535562 from hex 2A36B9F
                           OR
                multiply decimal 535562 to hex 2A36B9F
                           OR
                divide hex 2A36B9F by decimal 53556
                
            Remember: Command must be in lowercase letters except for the number. \s
            """;
    final public String CommandList = """
            String values for different bases are as follows:-
            Base 2 -> binary
            Base 3 -> ternary
            Base 4 -> quaternary
            Base 5 -> quinary
            Base 6 -> heximal
            Base 7 -> septimal
            Base 8 -> octal
            Base 9 -> nonal
            Base 10 -> decimal
            Base 16 -> hex
            
            """;
    final public String Command = "Enter your command in the above shown format: ";
    final public String Required = "Required Base Conversion value is: ";
    final public String Addition = "Required Addition is: ";
    final public String Subtraction = "Required Subtraction is: ";
    final public String Choice = "Do you want to continue. If yes press 1 else press any other character to exit.";
}