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
    public static String[][] battersTable = new String[13][5];
    public static String[][] bowlersTable = new String[13][5];
    public static int members;

    // To display the score board of the teams
    // Return type void
    // Parameters - 2-D String Array
    public static void ScoreBoard(String[][] Table){
        for (int i = 0; i < members + 2; i++){
            for (int j = 0; j < 5; j++){
                if (i != 1){
                    System.out.print(Table[i][j]);
                    System.out.print("            ");
                } else {
                    System.out.print("-------------");
                    System.out.print("            ");
                }
            }
            System.out.println();
        }
    }

    // To enter the score of the players in the score table
    // Return type - void
    // Parameters - IntegerArray, Integer, 2-D String Array
    public static void scoreTable(int[] Feature, int index, String[][] Table) {
        for (int i = 2; i < members + 2; i++) {
            Table[i][index] = Integer.toString(Feature[i - 2]);
        }
    }

    // To enter the name of the players in the score table of the First batting team
    // Return type - void
    // Parameters - StringArray, Integer, Integer
    public static void battingTeam(String[] TeamA, int index) {
        battersTable[0][0] = "Players";
        battersTable[0][1] = "Fours";
        battersTable[0][2] = "Sixes";
        battersTable[0][3] = "Total Runs";
        battersTable[0][4] = "Balls";
        for (int i = 2; i < members + 2; i++) {
            battersTable[i][index] = TeamA[i - 2];
        }
    }

    // To enter the name of the players in the score table of the Second batting team
    // Return type - void
    // Parameters - StringArray, Integer, Integer
    public static void bowlingTeam(String[] TeamB, int index) {
        bowlersTable[0][0] = "Players";
        bowlersTable[0][1] = "Fours";
        bowlersTable[0][2] = "Sixes";
        bowlersTable[0][3] = "Total Runs";
        bowlersTable[0][4] = "Balls";
        for (int i = 2; i < members + 2; i++) {
            bowlersTable[i][index] = TeamB[i - 2];
        }
    }

    // To input 11 players from the user for both the teams
    // Return type - void
    // Parameters - String, String, Integer
    public static void Playing11(String Team1, String Team2) {
        Scanner userInput = new Scanner(System.in);
        Constant constants = new Constant();
        String[] TeamA = new String[members];
        String[] TeamB = new String[members];
        int[] FirstTeam;
        int[] SecondTeam;
        System.out.println("Enter " + members + constants.Enter + Team1 + constants.order);
        for (int i = 0; i < members; i++) {
            TeamA[i] = userInput.nextLine();
        }
        System.out.println("Enter " + members + constants.Enter + Team2 + constants.order);
        for (int i = 0; i < members; i++) {
            TeamB[i] = userInput.nextLine();
        }
        System.out.println(constants.Toss);
        String Batter = userInput.nextLine();
        System.out.println(constants.overs);
        int overs = userInput.nextInt();
        if (Batter.equalsIgnoreCase(Team1)) {
            battingTeam(TeamA, 0);
            bowlingTeam(TeamB, 0);
            System.out.println(constants.Inning1);
            FirstTeam = Match.Inning1(overs, TeamA, battersTable);
            System.out.println(constants.Inning2);
            SecondTeam = Match.Inning2(overs, TeamB, bowlersTable);
            System.out.println();
            if (FirstTeam[0] > SecondTeam[0]) {
                int run = FirstTeam[0] - SecondTeam[0];
                System.out.println(constants.team + Team1 + constants.won + run + constants.run);
            } else if (FirstTeam[0] == SecondTeam[0]) {
                System.out.println(constants.tie);
            } else {
                int wicket = members - SecondTeam[1];
                System.out.println(constants.team + Team2 + constants.won + wicket + constants.wickets);
            }
        } else {
            battingTeam(TeamB, 0);
            bowlingTeam(TeamA, 0);
            System.out.println(constants.Inning1);
            FirstTeam = Match.Inning1(overs, TeamB, battersTable);
            System.out.println(constants.Inning2);
            SecondTeam = Match.Inning2(overs, TeamA, bowlersTable);
            System.out.println();
            if (FirstTeam[0] > SecondTeam[0]) {
                int run = FirstTeam[0] - SecondTeam[0];
                System.out.println(constants.team + Team2 + constants.won + run + constants.run);
            } else if (FirstTeam[0] == SecondTeam[0]) {
                System.out.println(constants.tie);
            } else {
                int wicket = members - SecondTeam[1];
                System.out.println(constants.team + Team1 + constants.won + wicket + constants.wickets);
            }
        }
        ScoreBoard(battersTable);
        ScoreBoard(bowlersTable);
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        PromptPlayer prompt = new PromptPlayer();
        Constant constants = new Constant();
        Error errors = new Error();
        System.out.println();
        System.out.println(constants.welcome);
        System.out.println();
        char select;
        String TeamA, TeamB;
        boolean checkMembers = true;
        do {
            try {
                System.out.println(constants.promptList);
                System.out.println(constants.viewTeam);
                System.out.println(constants.createTeam);
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
                        int result1 = 0;
                        do {
                            System.out.print(constants.firstTeam);
                            TeamA = userInput.nextLine();
                            if (prompt.Prompt(TeamA)) {
                                result1 = 1;
                            }
                        } while (result1 != 1);
                        int result2 = 0;
                        do {
                            System.out.print(constants.secondTeam);
                            TeamB = userInput.nextLine();
                            if (prompt.Prompt(TeamB)) {
                                result2 = 1;
                            }
                        } while (result2 != 1);
                        do {
                            System.out.println(constants.members);
                            members = userInput.nextInt();
                            if (members > 1 && members < 12) {
                                Playing11(TeamA, TeamB);
                            } else {
                                checkMembers = false;
                            }
                        } while (!checkMembers);
                        break;
                    case "2":
                        System.out.println(constants.nameTeam);
                        System.out.print(constants.firstTeam);
                        TeamA = userInput.nextLine();
                        System.out.print(constants.secondTeam);
                        TeamB = userInput.nextLine();
                        System.out.println(constants.members);
                        members = userInput.nextInt();
                        do {
                            if (members > 1 && members < 12) {
                                Playing11(TeamA, TeamB);
                            } else {
                                checkMembers = false;
                            }
                        } while (!checkMembers);
                        break;
                    default:
                        System.out.println(errors.IncorrectChoice);
                        userInput.nextLine();
                }
            } catch (Exception e) {
                System.out.println(errors.InvalidInput);
            }
            System.out.println();
            System.out.println(constants.Select);
            select = userInput.next().charAt(0);
            userInput.nextLine();
        } while (select == '1');
    }
}