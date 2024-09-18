/***
 * This class has been created to display the score board of
 * two cricket teams while playing a match
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 17 September 2024
 */
package Week_3_Assignment;

import java.io.*;
import java.util.*;

public class CrickBuzz {
    // To display the score of the batting team
    // Return type - void
    // Parameters - String, StringArray
    public static void battingTeam(String Team1, String[] TeamA){
        Scanner userInput = new Scanner(System.in);
        Constants constants = new Constants();
        String[][] battersTable = new String[13][5];
        battersTable[0][0] = "Players";
        battersTable[0][1] = "Fours";
        battersTable[0][2] = "Sixes";
        battersTable[0][3] = "Total Runs";
        battersTable[0][4] = "Overs";
        for (int i = 2; i < 13; i++){
            battersTable[i][0] = TeamA[i-2];
        }
    }
    // To display the score of the bowling team
    // Return type - void
    // Parameters - String, StringArray
    public static void bowlingTeam(String Team2, String[] TeamB){
        String[][] bowlersTable = new String[13][7];
        bowlersTable[0][0] = "Players";
        bowlersTable[0][1] = "No Balls";
        bowlersTable[0][2] = "Wide Balls";
        bowlersTable[0][3] = "Fours";
        bowlersTable[0][4] = "Sixes";
        bowlersTable[0][5] = "Total Runs";
        bowlersTable[0][6] = "Overs";
        for (int i = 2; i < 13; i++){
            bowlersTable[i][0] = TeamB[i-2];
        }
    }
    // To input 11 players from the user for both the teams
    // Return type - void
    // Parameters - String, String
    public static void Playing11(String Team1, String Team2){
        Scanner userInput = new Scanner(System.in);
        Constants constants = new Constants();
        String[] TeamA = new String[11];
        String[] TeamB = new String[11];
        System.out.println("Enter 11 members in Team "+ Team1 + " with their full name:");
        for (int i = 0; i < 11; i++){
            TeamA[i] = userInput.nextLine();
        }
        System.out.println("Enter 11 members in Team "+ Team2 + " with their full name:");
        for (int i = 0; i < 11; i++){
            TeamB[i] = userInput.nextLine();
        }
        System.out.println(constants.Toss);
        String Batter = userInput.nextLine();
        if (Batter.equalsIgnoreCase(Team1)){
            battingTeam(Team1,TeamA);
            bowlingTeam(Team2,TeamB);
        }
        else{
            battingTeam(Team2,TeamB);
            bowlingTeam(Team1,TeamA);
        }
    }
   // To display the team members of different IPL Teams
   // Return type - void
   // Parameters - String
    public static void Prompt(String Team) {
        Constants constants = new Constants();
        Errors errors = new Errors();
        switch (Team) {
            case "CSK":
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
            case "DC":
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
            case "RCB":
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
            case "SRH":
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
            case "GT":
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
            case "RR":
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
            case "MI":
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
            case "PK":
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
            case "KKR":
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
            case "LSG":
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
                System.out.println(errors.InvalidInput);
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Constants constants = new Constants();
        Errors errors = new Errors();
        System.out.println();
        System.out.println(constants.welcome);
        System.out.println();
        char select;
        do {
            try {
                System.out.println(constants.promptList);
                System.out.println(constants.TeamA);
                System.out.println(constants.TeamB);
                System.out.println(constants.TeamC);
                String choice;
                System.out.println(constants.enterChoice);
                choice = userInput.nextLine();
                switch (choice) {
                    case "1":
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
                        System.out.println(constants.selectTeam);
                        String TeamA = userInput.nextLine();
                        String TeamB = userInput.nextLine();
                        Prompt(TeamA);
                        Prompt(TeamB);
                        Playing11(TeamA, TeamB);
                        break;
                    case "2":
                        try{
                            FileReader fileReader = new FileReader("C:\\Users\\kriti\\Desktop\\T20_TEAMS.txt");
                            int i;
                            while ((i = fileReader.read()) != -1)
                                System.out.print((char) i);
                            fileReader.close();
                        } catch (Exception e) {
                            System.out.println(errors.FileNotFound);
                        }
                        break;
                    case "3":
                        System.out.println(constants.createTeam);
                        System.out.println(constants.nameTeam);
                        System.out.print("Team 1:");
                        String Team1 = userInput.nextLine();
                        System.out.println("Team 2:");
                        String Team2 = userInput.nextLine();
                        Playing11(Team1, Team2);
                        break;
                    default:
                        System.out.println(errors.InvalidInput);
                }
            } catch (Exception e) {
                System.out.println(errors.IncorrectChoice);
            }
            System.out.println();
            System.out.println(constants.Select);
            select = userInput.next().charAt(0);
            userInput.nextLine();
        } while (select == '1');
    }
}