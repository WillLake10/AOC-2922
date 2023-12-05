package will;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        Days days = new Days("2023");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int day;
        String input;
        String year = "2023";
        boolean breakLoop = false;
        do {
            System.out.print("What day do you want the answer for: Day ");
            input = reader.readLine();
            try {
                day = Integer.parseInt(input);
                days.outputDay(day, false);
            } catch (Exception e) {
                if (Objects.equals(input, "n")) {
                    for (int i = 1; i <= 25; i++) {
                        days.outputDay(i, false);
                    }
                } else if (Objects.equals(input, "t")){
                    for (int i = 1; i <= 25; i++) {
                        days.outputDay(i, true);
                    }
                }
                else {
                    breakLoop = true;
                }
            }
        }
        while (!breakLoop);
    }
}