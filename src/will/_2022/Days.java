package will._2022;

import java.util.Objects;

import static will._2022.SolutionDay1.*;
import static will._2022.SolutionDay2.*;
import static will._2022.SolutionDay3.*;
import static will._2022.SolutionDay4.*;
import static will._2022.SolutionDay5.*;
import static will._2022.SolutionDay6.*;
import static will._2022.SolutionDay7.*;
import static will._2022.SolutionDay8.*;

public class Days {

    static String[][] answers = settupAnswersArray();
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    public static void output2022Day(int day, boolean test) {
        if (!test) {
            for (int i = 0; i < 2; i++) {
                if (!Objects.equals(answers[day - 1][i], "null")) {
                    printAnswer(day, i + 1, answers[day - 1][i]);
                    if (i == 1) {
                        System.out.println();
                    }
                }
            }
        } else {
            for (int i = 0; i < 2; i++) {
                if (!Objects.equals(answers[day - 1][i], "null")) {
                    if (Test.valuesPassesTest(day - 1, i, answers[day - 1][i])) {
                        System.out.println("Day: " + ANSI_BLUE + day + ANSI_RESET + ", Part " + ANSI_BLUE + (i + 1) + ANSI_RESET + ": " + ANSI_GREEN + "Test Passed" + ANSI_RESET);
                    } else {
                        System.out.println("Day: " + ANSI_BLUE + day + ANSI_RESET + ", Part " + ANSI_BLUE + (i + 1) + ANSI_RESET + ": " + ANSI_RED + "Test Failed" + ANSI_RESET);
                        System.out.println("    Value Got:      " + answers[day - 1][i]);
                        System.out.println("    Value Expected: " + Test.expectedValues[day - 1][i]);
                    }
                    if (i == 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    private static String[][] settupAnswersArray() {
        int total1part2 = 0;
        for (int i = 0; i < 3; i++) {
            total1part2 += getCaloriesForNthMostCarriedElf(i);
        }

        return new String[][]{
                {String.valueOf(getHigestCalorieElf()), String.valueOf(total1part2)}, //1
                {String.valueOf(getFinalScore()), String.valueOf(getFinalScorePart2())}, //2
                {String.valueOf(getSectionsPriorityScore()), String.valueOf(getElfIdPriority())}, //3
                {String.valueOf(getNumbPairsContained(false)), String.valueOf(getNumbPairsOverlap(false))}, //4
                {getFinalTopCrates(false),getFinalTopCrates9001(false)}, //5
                {String.valueOf(getNumCharToFirstPacketMarker()), String.valueOf(getNumCharToFirstMessageMarker())}, //6
                {String.valueOf(getTotalSizeUnder100000(false)), String.valueOf(getFileSizeToDelete(false))}, //7
                {String.valueOf(getVisibleTrees(false)), String.valueOf(getHighAppeal(false))}, //8
                {"null", "null"}, //9
                {"null", "null"}, //10
                {"null", "null"}, //11
                {"null", "null"}, //12
                {"null", "null"}, //13
                {"null", "null"}, //14
                {"null", "null"}, //15
                {"null", "null"}, //16
                {"null", "null"}, //17
                {"null", "null"}, //18
                {"null", "null"}, //19
                {"null", "null"}, //20
                {"null", "null"}, //21
                {"null", "null"}, //22
                {"null", "null"}, //23
                {"null", "null"}, //24
                {"null", "null"}, //25
        };
    }

    private static void printAnswer(int day, int part, String value) {
        System.out.println("Day " + ANSI_BLUE + day + ANSI_RESET + ", Part " + ANSI_BLUE + part + ANSI_RESET + " answer is: " + ANSI_PURPLE + value + ANSI_RESET);
    }
}
