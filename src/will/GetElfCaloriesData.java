package will;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GetElfCaloriesData {
    static List<Elf> values = getAllElves();

    public static List<Elf> getAllElves() {
        int i = 0;
        int value = 0;
        List<Elf> values = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/will/data.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (Objects.equals(line, "")) {
                    values.add(new Elf(i, value));
                    value = 0;
                    i++;
                } else {
                    value += Integer.parseInt(line);
                }
            }
            System.out.println("File Read");
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static Elf getHigestCalorieElf() {
        Elf highest = values.get(0);
        int highest_pos = 0;
        for (int x = 0; x < values.size(); x++) {
            if (values.get(x).getNumCalories() > highest.getNumCalories()) {
                highest = values.get(x);
                highest_pos = x;
            }
        }
        return values.get(highest_pos);
    }

    private static List<Elf> sortElvesByCalories() {
        List<Elf> sortedValues = values;
        sortedValues.sort((o1, o2) -> {
            if (o1.getNumCalories() == o2.getNumCalories())
                return 0;
            return o1.getNumCalories() > o2.getNumCalories() ? -1 : 1;
        });
        return sortedValues;
    }

    public static int getCaloriesForNthMostCarriedElf(int n) {
        List<Elf> sorted = sortElvesByCalories();
        return sorted.get(n).getNumCalories();
    }
}
