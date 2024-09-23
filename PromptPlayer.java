/***
 * This class is used to display the team members of IPL Team
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 17 September 2024
 */
package Week_3_Assignment;
import java.io.FileReader;
public class PromptPlayer {

    // To display the team members of different IPL Teams
    // Return type - void
    // Parameters - String
    final public boolean Prompt(String Team) {
        Constant constants = new Constant();
        Error errors = new Error();
        switch (Team) {
            case "CSK","csk":
                try {
                    FileReader fileReader = new FileReader(constants.Team_CSK);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "DC","dc" :
                try {
                    FileReader fileReader = new FileReader(constants.Team_DC);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "RCB","rcb":
                try {
                    FileReader fileReader = new FileReader(constants.Team_RCB);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "SRH","srh":
                try {
                    FileReader fileReader = new FileReader(constants.Team_SRH);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "GT","gt":
                try {
                    FileReader fileReader = new FileReader(constants.Team_GT);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "RR","rr":
                try {
                    FileReader fileReader = new FileReader(constants.Team_RR);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "MI","mi":
                try {
                    FileReader fileReader = new FileReader(constants.Team_MI);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "PK","pk":
                try {
                    FileReader fileReader = new FileReader(constants.Team_PK);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "KKR","kkr":
                try {
                    FileReader fileReader = new FileReader(constants.Team_KKR);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            case "LSG","lsg":
                try {
                    FileReader fileReader = new FileReader(constants.Team_LSG);
                    int i;
                    while ((i = fileReader.read()) != -1)
                        System.out.print((char) i);
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println(errors.FileNotFound);
                }
                System.out.println();
                break;
            default:
                System.out.println(errors.IncorrectTeamName);
                return false;
        }
        return true;
    }
}
