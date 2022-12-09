package will;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GetElfCaloriesData {

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

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static Elf getHigestCalorieElf() {
        List<Elf> values = getAllElves();
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
}
