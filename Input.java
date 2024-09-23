/***
 * This class has been created to read the input
 * from the user for IPL Team.
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 17 September 2024
 */
package Week_3_Assignment;

import java.io.FileReader;
import java.util.Scanner;

public class Input {

    // To read input from the user and prompt the selected team players
    // Return type - boolean
    // No parameters
    public static boolean Read(){
        Scanner userInput = new Scanner(System.in);
        PromptPlayer prompt = new PromptPlayer();
        Constant constants = new Constant();
        Error errors = new Error();
        boolean checkMembers = false;
        try {
            FileReader fileReader = new FileReader(constants.IPL_TEAM);
            int i;
            while ((i = fileReader.read()) != -1)
                System.out.print((char) i);
            fileReader.close();
        } catch (Exception e) {
            System.out.println(errors.FileNotFound);
        }
        System.out.println();
        System.out.println(constants.SelectTeam);
        int result1 = 0;
        do {
            System.out.print(constants.FirstTeam);
            CrickBuzz.Team1 = userInput.nextLine();
            if (prompt.Prompt(CrickBuzz.Team1)) {
                result1 = 1;
            }
        } while (result1 != 1);
        int result2 = 0;
        do {
            System.out.print(constants.SecondTeam);
            CrickBuzz.Team2 = userInput.nextLine();
            if (prompt.Prompt(CrickBuzz.Team2)) {
                result2 = 1;
            }
        } while (result2 != 1);
        do {
            System.out.println(constants.Members);
            CrickBuzz.members = userInput.nextInt();
            if (CrickBuzz.members > 1 && CrickBuzz.members < 12) {
                checkMembers = true;
            }
        } while (!checkMembers);
        return true;
    }
}