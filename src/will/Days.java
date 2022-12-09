package will;

import java.util.Objects;

import static will.GetElfCaloriesData.getCaloriesForNthMostCarriedElf;
import static will.GetElfCaloriesData.getHigestCalorieElf;

public class Days {

    static String[][] answers = settupAnswersArray();

    public static void outputDay(int day) {
        for (int i =0 ; i < 2; i++){
            if (!Objects.equals(answers[day - 1][i], "null")){
                printAnswer(day, i+1, answers[day-1][i]);
                if (i == 1){
                    System.out.println();
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
                {String.valueOf(getHigestCalorieElf().getNumCalories()), String.valueOf(total1part2)}, //1
                {String.valueOf(RockPaperScissors.getFinalScore()), String.valueOf(RockPaperScissors.getFinalScorePart2())}, //2
                {String.valueOf(Rucksack.getSectionsPriorityScore()), String.valueOf(Rucksack.getElfIdPriority())}, //3
                {"null", "null"}, //4
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
    }

    private static void printAnswer(int day, int part, String value) {
        System.out.println("Day " + day + " part " + part + " answer is: " + value);
    }
}
