/***
 * This class has been created to play the match
 * between the two cricket teams
 * Owner Name :- KRITIKA KUMARI
 * Date of Creation:- 17 September 2024
 */
package Week_3_Assignment;

import java.util.Scanner;

public class Match {
    public static int[] Fours = new int[11];
    public static int[] Sixes = new int[11];
    public static int[] Runs = new int[11];
    public static int[] Balls = new int[11];
    public static int target;

    // To print the scores of the First Inning like total runs, over completed, striker,etc.
    // Return Type - IntegerArray
    // Parameters - Integer, String Array, 2-D String Array
    public static int[] Inning1(int overs, String[] Batter, String[][] Table) {
        Scanner userInput = new Scanner(System.in);
        Constant constants = new Constant();
        Error errors = new Error();
        int[] score = new int[2];
        int total_runs = 0, wickets = 0, strike = 0, no_ball = 0, wide_ball = 0, fours = 0, sixes = 0, striker = 0, nonStriker = 1;
        System.out.println();
        System.out.println(constants.Instructions);
        System.out.println(constants.Ball);
        System.out.println(constants.noBall);
        System.out.println(constants.wideBall);
        for (int i = 0; i < overs; i++) {
            int j = 0;
            while (j < 6 ) {
                if (wickets == CrickBuzz.members){
                    break;
                }
                int result;
                do {
                    result = 0;
                    System.out.println(constants.ballType);
                    String BallType = userInput.nextLine();
                    switch (BallType) {
                        case "B","b":
                            System.out.println(constants.Runs);
                            int run = userInput.nextInt();
                            Runs[striker] += run;
                            Balls[striker] += 1;
                            if (run >= -1 && run <= 6 && run != 5) {
                                switch (run) {
                                    case 4:
                                        Fours[striker] += 1;
                                        fours += 1;
                                        break;
                                    case 6:
                                        Sixes[striker] += 1;
                                        sixes += 1;
                                        break;
                                    case -1:
                                        wickets += 1;
                                        if (striker > nonStriker) {
                                            striker += 1;
                                        } else {
                                            striker = nonStriker + 1;
                                        }
                                        run = 0;
                                        break;
                                    case 1, 3:
                                        striker = striker + nonStriker;
                                        nonStriker = striker - nonStriker;
                                        striker = striker - nonStriker;
                                        break;
                                }
                                total_runs += run;
                                j++;
                            } else {
                                System.out.print(errors.InvalidRun);
                                result = 1;
                            }
                            break;
                        case "NB","nb":
                            System.out.println(constants.Runs);
                            int noBallRun = userInput.nextInt();
                            switch (noBallRun) {
                                case 5:
                                    Fours[striker] += 1;
                                    fours += 1;
                                    break;
                                case 7:
                                    Sixes[striker] += 1;
                                    sixes += 1;
                                    break;
                                case 2, 4:
                                    striker = striker + nonStriker;
                                    nonStriker = striker - nonStriker;
                                    striker = striker - nonStriker;
                                    break;
                            }
                            if (noBallRun > 0 && noBallRun <= 7 && noBallRun != 6) {
                                total_runs += noBallRun;
                                no_ball += 1;
                            }
                            break;
                        case "WB","wb":
                            System.out.println(constants.Runs);
                            int wide_run = userInput.nextInt();
                            wide_ball += 1;
                            total_runs += wide_run;
                            break;
                        default:
                            System.out.println();
                            System.out.print(errors.IncorrectChoice);
                            result = 1;
                            break;
                    }
                } while (result == 1);
                System.out.print(constants.Score + total_runs + "/" + wickets);
                System.out.println(constants.Overs + i + "." + j);
                System.out.println(constants.Striker + Batter[strike]);
                System.out.print(constants.Fours + fours);
                System.out.println(constants.Six + sixes);
                strike = striker;
                userInput.nextLine();
            }
        }
        CrickBuzz.scoreTable(Fours, 1, Table);
        CrickBuzz.scoreTable(Sixes, 2, Table);
        CrickBuzz.scoreTable(Runs, 3, Table);
        CrickBuzz.scoreTable(Balls, 4, Table);
        System.out.println(constants.NoBall + no_ball);
        System.out.println(constants.WideBall + wide_ball);
        target = total_runs;
        score[0] = total_runs;
        score[1] = wickets;
        return score;
    }

    // To print the scores of the Second Inning like total runs, over completed, striker,etc.
    // Return Type - IntegerArray
    // Parameters - Integer, String Array, 2-D String Array
    public static int[] Inning2(int overs, String[] Batter, String[][] Table) {
        Scanner userInput = new Scanner(System.in);
        Constant constants = new Constant();
        Error errors = new Error();
        int[] score = new int[2];
        int total_runs = 0, wickets = 0, strike = 0, no_ball = 0, wide_ball = 0, fours = 0, sixes = 0, striker = 0, nonStriker = 1;
        System.out.println();
        System.out.println(constants.Instructions);
        System.out.println(constants.Ball);
        System.out.println(constants.noBall);
        System.out.println(constants.wideBall);
        for (int i = 0; i < overs; i++) {
            int j = 0;
            while (j < 6) {
                if (wickets == CrickBuzz.members || total_runs > target){
                    break;
                }
                int result;
                do {
                    result = 0;
                    System.out.println(constants.ballType);
                    String BallType = userInput.nextLine();
                    switch (BallType) {
                        case "B","b":
                            System.out.println(constants.Runs);
                            int run = userInput.nextInt();
                            Runs[striker] += run;
                            Balls[striker] += 1;
                            if (run >= -1 && run <= 6 && run != 5) {
                                switch (run) {
                                    case 4:
                                        Fours[striker] += 1;
                                        fours += 1;
                                        break;
                                    case 6:
                                        Sixes[striker] += 1;
                                        sixes += 1;
                                        break;
                                    case -1:
                                        wickets += 1;
                                        if (striker > nonStriker) {
                                            striker += 1;
                                        } else {
                                            nonStriker += 1;
                                        }
                                        run = 0;
                                        break;
                                    case 1, 3:
                                        striker = striker + nonStriker;
                                        nonStriker = striker - nonStriker;
                                        striker = striker - nonStriker;
                                        break;
                                }
                                total_runs += run;
                                j++;
                            } else {
                                System.out.print(errors.InvalidRun);
                                result = 1;
                            }
                            break;
                        case "NB","nb":
                            System.out.println(constants.Runs);
                            int noBallRun = userInput.nextInt();
                            switch (noBallRun) {
                                case 5:
                                    Fours[striker] += 1;
                                    fours += 1;
                                    break;
                                case 7:
                                    Sixes[striker] += 1;
                                    sixes += 1;
                                    break;
                                case 2, 4:
                                    striker = striker + nonStriker;
                                    nonStriker = striker - nonStriker;
                                    striker = striker - nonStriker;
                                    break;
                            }
                            if (noBallRun > 0 && noBallRun <= 7 && noBallRun != 6) {
                                total_runs += noBallRun;
                                no_ball += 1;
                            }
                            break;
                        case "WB","wb":
                            System.out.println(constants.Runs);
                            int wide_run = userInput.nextInt();
                            wide_ball += 1;
                            total_runs += wide_run;
                            break;
                        default:
                            System.out.println();
                            System.out.print(errors.IncorrectChoice);
                            result = 1;
                            break;
                    }
                } while (result == 1);
                System.out.print(constants.Score + total_runs + "/" + wickets);
                System.out.println(constants.Overs + i + "." + j);
                System.out.println(constants.Striker + Batter[strike]);
                System.out.print(constants.Fours + fours);
                System.out.println(constants.Six + sixes);
                strike = striker;
                userInput.nextLine();
            }
        }
        CrickBuzz.scoreTable(Fours, 1, Table);
        CrickBuzz.scoreTable(Sixes, 2, Table);
        CrickBuzz.scoreTable(Runs, 3, Table);
        CrickBuzz.scoreTable(Balls, 4, Table);
        System.out.println(constants.NoBall + no_ball);
        System.out.println(constants.WideBall + wide_ball);
        score[0] = total_runs;
        score[1] = wickets;
        return score;
    }
}