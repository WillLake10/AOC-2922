package will._2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionDay1 {
    static List<String> values = getAllElves();

    public static List<String> getAllElves() {
        List<String> values = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/will/_2023/data/dataDay1.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                values.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static int getCalibrationSum() {
        return getAnswer(values);
    }

    public static int getCalibrationSumPart2(){
        List<String> newVals = new ArrayList<>();

        for (String entry : values) {
            newVals.add(subNumbers(entry));
        }

        return getAnswer(newVals);
    }

    private static int getAnswer(List<String> arr){
        int total = 0;
        for (String entry : arr) {
            var charArray = entry.toCharArray();
            char first = '0';
            char last = '0';
            boolean doneFirst = false;
            for (Character c : charArray) {
                if (Character.isDigit(c)) {
                    last = c;
                    if(!doneFirst){
                        first = c;
                        doneFirst = true;
                    }
                }
            }
            String value = String.valueOf(first) + last;

            int calVal = Integer.parseInt(value);

            total += calVal;
        }
        return total;
    }

    private static String subNumbers(String input){
        return input
                .replace("one", "one1one")
                .replace("two", "two2two")
                .replace("three", "three3three")
                .replace("four", "four4four")
                .replace("five", "five5five")
                .replace("six", "six6six")
                .replace("seven", "seven7seven")
                .replace("eight", "eight8eight")
                .replace("nine", "nine9nine");
    }
}
