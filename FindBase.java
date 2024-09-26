/***
 * This class is for finding the numeric value of the given base
 * and also to find errors related to each base.
 * Owner:- KRITIKA KUMARI
 * Date of Creation:- 25 September 2024
 */
package NumberConversionAndOperations;

public class FindBase {
    final public String NotBinary = "Given Number is not in Binary Form.";
    final public String NotDecimal = "Given Number is not in Decimal Form.";
    final public String NotOctal = "Given Number is not in Octal Form.";
    final public String InvalidBase = "Given Base is Invalid.";

    // To find the numeric value of the given base
    // @return -> Numeric Base Value
    // @param -> String value of Base
    final public int findBase(String inputBase){
        return switch (inputBase) {
            case "binary" -> 2;
            case "ternary" -> 3;
            case "quaternary" -> 4;
            case "quinary" -> 5;
            case "heximal" -> 6;
            case "septimal " -> 7;
            case "octal" -> 8;
            case "nonal" -> 9;
            case "decimal" -> 10;
            case "hex" -> 16;
            default -> -1;
        };
    }

    // To find the error related to the given base
    // @return -> Error related to the Base
    // @param -> Numeric Base value
    final public String findError(int base){
        return switch (base){
            case 2 -> NotBinary;
            case 8 -> NotOctal;
            case 10 -> NotDecimal;
            default -> InvalidBase;
        };
    }
}
