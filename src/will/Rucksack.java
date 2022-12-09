package will;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rucksack {
    static List<Bag> bags = getAllPairs();

    public static List<Bag> getAllPairs() {
        List<Bag> sections = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/will/data/dataDay3.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sections.add(new Bag(line.substring(0, line.length() / 2), line.substring(line.length() / 2), line));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sections;
    }

    public static int getSectionsPriorityScore() {
        int score = 0;
        for (Bag bag : bags) {
            char[] charArray1 = bag.a.toCharArray();
            char[] charArray2 = bag.b.toCharArray();
            outerLoop:
            for (char char1 : charArray1) {
                for (char char2 : charArray2) {
                    if (char1 == char2) {
                        score += getCharValue(char1);
                        break outerLoop;
                    }
                }
            }
        }
        return score;
    }

    public static int getElfIdPriority() {
        int score = 0;
        for (int i = 0; i < bags.size(); i += 3) {
            char[] charArray1 = bags.get(i).all.toCharArray();
            char[] charArray2 = bags.get(i + 1).all.toCharArray();
            char[] charArray3 = bags.get(i + 2).all.toCharArray();
            outerLoop:
            for (char char1 : charArray1) {
                for (char char2 : charArray2) {
                    for (char char3 : charArray3) {
                        if (char1 == char2 && char2 == char3) {
                            score += getCharValue(char1);
                            break outerLoop;
                        }
                    }
                }
            }
        }
        return score;
    }

    private static int getCharValue(char character) {
        int asciiValue = character;
        if (asciiValue >= 97) {
            asciiValue -= 96;
        } else {
            asciiValue -= 38;
        }
        return asciiValue;
    }

    private record Bag(String a, String b, String all) {
    }
}
