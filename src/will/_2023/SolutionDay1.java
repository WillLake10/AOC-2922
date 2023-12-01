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
        return 1;
    }
}
