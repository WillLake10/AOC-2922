package will;

import static will.GetElfCaloriesData.getCaloriesForNthMostCarriedElf;
import static will.GetElfCaloriesData.getHigestCalorieElf;

public class Days {

    public static void outputDay(int day){
        switch (day) {
            case 1:
                outputDay1();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    private static void outputDay1(){
        printAnswer("1 part 1", String.valueOf(getHigestCalorieElf().getNumCalories()));
        int total1 = 0;
        for (int i = 0; i < 3; i++){
            total1 += getCaloriesForNthMostCarriedElf(i);
        }
        printAnswer("1 part 2", String.valueOf(total1));
    }

    private static void outputDay2(){

    }

    private static void printAnswer(String day, String value){
        System.out.println("Day " + day + " answer is: " + value);
    }
}
