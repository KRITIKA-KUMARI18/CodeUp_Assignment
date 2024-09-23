/***
 * This class has been created to display the score board of
 * two cricket teams while playing a match
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 17 September 2024
 */
package Week_3_Assignment;

import java.util.*;
public class CrickBuzz {
    public static String[][] FirstInningTable = new String[13][5];
    public static String[][] SecondInningTable = new String[13][5];
    public static int members;
    public static String Team1 = "";
    public static String Team2 = "";

    // To display the score board of the teams
    // Return type void
    // Parameters - 2-D String Array
    public static void ScoreBoard(String[][] Table) {
        for (int i = 0; i < members + 1; i++) {
            for (int j = 0; j < 5; j++) {
                String player = Table[i][j];
                int length = player.length();
                System.out.print(player);
                if (j == 0) {
                    for (int l = length; l < 25; l++) {
                        System.out.print(" ");
                    }
                } else {
                    for (int l = length; l < 15; l++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    // To enter the score of the players in the score table
    // Return type - void
    // Parameters - IntegerArray, Integer, 2-D String Array
    public static void scoreTable(int[] Feature, int index, String[][] Table) {
        for (int i = 1; i < members + 1; i++) {
            Table[i][index] = Integer.toString(Feature[i - 1]);
        }
    }

    // To enter the name of the players in the score table of the First batting team
    // Return type - void
    // Parameters - StringArray, Integer, Integer
    public static void FirstInningTeam(String[] TeamA, int index) {
        FirstInningTable[0][0] = "Players";
        FirstInningTable[0][1] = "Fours";
        FirstInningTable[0][2] = "Sixes";
        FirstInningTable[0][3] = "Total Runs";
        FirstInningTable[0][4] = "Balls";
        for (int i = 1; i < members + 1; i++) {
            FirstInningTable[i][index] = TeamA[i - 1];
        }
    }

    // To enter the name of the players in the score table of the Second batting team
    // Return type - void
    // Parameters - StringArray, Integer, Integer
    public static void SecondInningTeam(String[] TeamB, int index) {
        SecondInningTable[0][0] = "Players";
        SecondInningTable[0][1] = "Fours";
        SecondInningTable[0][2] = "Sixes";
        SecondInningTable[0][3] = "Total Runs";
        SecondInningTable[0][4] = "Balls";
        for (int i = 1; i < members + 1; i++) {
            SecondInningTable[i][index] = TeamB[i - 1];
        }
    }

    // To input members from the user and play the match
    // Return Type - void
    // Parameters - Integer
    public static void Play(int teamType) {
        Scanner userInput = new Scanner(System.in);
        Constant constants = new Constant();
        Error errors = new Error();
        String[] TeamA = new String[members];
        String[] TeamB = new String[members];
        int[] FirstTeam;
        int[] SecondTeam;
        switch (teamType){
            case 1:
                System.out.println("Select " + members + constants.Select + Team1 + constants.Order);
                for (int i = 0; i < members; i++) {
                    int index = userInput.nextInt();
                    TeamA[i] = PlayerList.Team(index-1, Team1);
                }
                System.out.println("Enter " + members + constants.Enter + Team2 + constants.Order);
                for (int i = 0; i < members; i++) {
                    int index = userInput.nextInt();
                    TeamB[i] = PlayerList.Team(index-1, Team2);
                }
                userInput.nextLine();
                break;
            case 2:
                System.out.println("Enter " + members + constants.Enter + Team1 + constants.Order);
                for (int i = 0; i < members; i++) {
                    TeamA[i] = userInput.nextLine();
                }
                System.out.println("Enter " + members + constants.Enter + Team2 + constants.Order);
                for (int i = 0; i < members; i++) {
                    TeamB[i] = userInput.nextLine();
                }
                break;
        }
        boolean toss;
        do {
            System.out.println(constants.Toss);
            String TossWinner = userInput.nextLine();
            if (TossWinner.equalsIgnoreCase(Team1)) {
                boolean over;
                do {
                    try {
                        System.out.println(constants.Over);
                        int overs = userInput.nextInt();
                        FirstInningTeam(TeamA, 0);
                        SecondInningTeam(TeamB, 0);
                        System.out.println(constants.Inning1);
                        FirstTeam = Match.Inning1(overs, TeamA, FirstInningTable);
                        System.out.println(constants.Inning2);
                        SecondTeam = Match.Inning2(overs, TeamB, SecondInningTable);
                        System.out.println();
                        if (FirstTeam[0] > SecondTeam[0]) {
                            int run = FirstTeam[0] - SecondTeam[0];
                            System.out.println(constants.Team + Team1 + constants.Won + run + constants.Run);
                        } else if (FirstTeam[0] == SecondTeam[0]) {
                            System.out.println(constants.Tie);
                        } else {
                            int wicket = members - SecondTeam[1] - 1;
                            System.out.println(constants.Team + Team2 + constants.Won + wicket + constants.Wickets);
                        }
                        System.out.println();
                        System.out.println(constants.Design + Team1.toUpperCase());
                        ScoreBoard(FirstInningTable);
                        System.out.println();
                        System.out.println(constants.Design + Team2.toUpperCase());
                        ScoreBoard(SecondInningTable);
                        over = false;
                    } catch (InputMismatchException e){
                        System.out.println(errors.InvalidInput);
                        userInput.nextLine();
                        over = true;
                    }
                } while(over);
                toss = false;
            }
            else if (TossWinner.equalsIgnoreCase(Team2)) {
                boolean over;
                do {
                    try {
                        System.out.println(constants.Over);
                        int overs = userInput.nextInt();
                        FirstInningTeam(TeamB, 0);
                        SecondInningTeam(TeamA, 0);
                        System.out.println(constants.Inning1);
                        FirstTeam = Match.Inning1(overs, TeamB, FirstInningTable);
                        System.out.println();
                        System.out.println(constants.Inning2);
                        SecondTeam = Match.Inning2(overs, TeamA, SecondInningTable);
                        System.out.println();
                        if (FirstTeam[0] > SecondTeam[0]) {
                            int run = FirstTeam[0] - SecondTeam[0];
                            System.out.println(constants.Team + Team2.toUpperCase() + constants.Won + run + constants.Run);
                        } else if (FirstTeam[0] == SecondTeam[0]) {
                            System.out.println(constants.Tie);
                        } else {
                            int wicket = members - SecondTeam[1] - 1;
                            System.out.println(constants.Team + Team1.toUpperCase() + constants.Won + wicket + constants.Wickets);
                        }
                        System.out.println();
                        System.out.println(constants.Design + Team2.toUpperCase());
                        ScoreBoard(FirstInningTable);
                        System.out.println();
                        System.out.println(constants.Design + Team1.toUpperCase());
                        ScoreBoard(SecondInningTable);
                        over = false;
                    } catch (InputMismatchException e){
                        System.out.println(errors.InvalidInput);
                        userInput.nextLine();
                        over = true;
                    }
                } while (over);
                toss = false;
            } else {
                System.out.println(errors.IncorrectTeamName);
                toss = true;
            }
        } while (toss);
    }
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Constant constants = new Constant();
        Error errors = new Error();
        System.out.println();
        System.out.println(constants.Welcome);
        System.out.println();
        char select;
        boolean checkMembers;
        do {
            System.out.println(constants.PromptList);
            System.out.println(constants.ViewTeam);
            System.out.println(constants.CreateTeam);
            String choice;
            System.out.println(constants.EnterChoice);
            choice = userInput.nextLine();
            switch (choice) {
                case "1":
                    if (Input.Read()){
                        Play(1);
                    }
                    break;
                case "2":
                    System.out.println(constants.NameTeam);
                    System.out.print(constants.FirstTeam);
                    Team1 = userInput.nextLine();
                    System.out.print(constants.SecondTeam);
                    Team2 = userInput.nextLine();
                    do {
                        try {
                            System.out.println(constants.Members);
                            members = userInput.nextInt();
                            if (members > 1 && members < 12) {
                                Play(2);
                                checkMembers = true;
                            } else {
                                checkMembers = false;
                            }
                        } catch (InputMismatchException e){
                            System.out.println(errors.InvalidInput);
                            userInput.nextLine();
                            checkMembers = false;
                        }
                    } while (!checkMembers);
                    break;
                default:
                    System.out.println(errors.IncorrectChoice);
            }
            System.out.println();
            System.out.println(constants.select);
            select = userInput.next().charAt(0);
            userInput.nextLine();
        } while (select == '1');
    }
}