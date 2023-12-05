package will;

import will._2023.Test;

import java.util.Objects;

import static will._2022.SolutionDay1.getCaloriesForNthMostCarriedElf;
import static will._2022.SolutionDay1.getHigestCalorieElf;
import static will._2022.SolutionDay2.getFinalScore;
import static will._2022.SolutionDay2.getFinalScorePart2;
import static will._2022.SolutionDay3.getElfIdPriority;
import static will._2022.SolutionDay3.getSectionsPriorityScore;
import static will._2022.SolutionDay4.getNumbPairsContained;
import static will._2022.SolutionDay4.getNumbPairsOverlap;
import static will._2022.SolutionDay5.getFinalTopCrates;
import static will._2022.SolutionDay5.getFinalTopCrates9001;
import static will._2022.SolutionDay6.getNumCharToFirstMessageMarker;
import static will._2022.SolutionDay6.getNumCharToFirstPacketMarker;
import static will._2022.SolutionDay7.getFileSizeToDelete;
import static will._2022.SolutionDay7.getTotalSizeUnder100000;
import static will._2022.SolutionDay8.getHighAppeal;
import static will._2022.SolutionDay8.getVisibleTrees;
import static will._2023.SolutionDay1.getCalibrationSum;
import static will._2023.SolutionDay1.getCalibrationSumPart2;
import static will._2023.SolutionDay2.getFewestCubePower;
import static will._2023.SolutionDay2.getPossibleGames;
import static will._2023.SolutionDay3.getGearRatio;
import static will._2023.SolutionDay3.getPartNumSum;
import static will._2023.SolutionDay4.getNumberOfCards;
import static will._2023.SolutionDay4.getPoints;

public class Days {

    public Days(String year) {
        this.answers = settupAnswersArray(year);
    }

    private String[][] answers;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    public void outputDay(int day, boolean test) {
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

    private String[][] settupAnswersArray(String year) {
        if(year == "2023") {
            return new String[][]{
                    {String.valueOf(getCalibrationSum()), String.valueOf(getCalibrationSumPart2())}, //1
                    {String.valueOf(getPossibleGames()), String.valueOf(getFewestCubePower())}, //2
                    {String.valueOf(getPartNumSum()), String.valueOf(getGearRatio())}, //3
                    {String.valueOf(getPoints()), String.valueOf(getNumberOfCards())}, //4
                    {"null", "null"}, //5
                    {"null", "null"}, //6
                    {"null", "null"}, //7
                    {"null", "null"}, //8
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
        } else {
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
    }

    private static void printAnswer(int day, int part, String value) {
        System.out.println("Day " + ANSI_BLUE + day + ANSI_RESET + ", Part " + ANSI_BLUE + part + ANSI_RESET + " answer is: " + ANSI_PURPLE + value + ANSI_RESET);
    }
}
