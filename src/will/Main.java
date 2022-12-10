package will;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static will.Days.outputDay;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int day;
        String input;
        boolean breakLoop = false;
        do {
            System.out.print("What day do you want the answer for: Day ");
            input = reader.readLine();
            try {
                day = Integer.parseInt(input);
                outputDay(day, false);
            } catch (Exception e) {
                if (Objects.equals(input, "n")) {
                    for (int i = 1; i <= 25; i++) {
                        outputDay(i, false);
                    }
                } else if (Objects.equals(input, "t")){
                    for (int i = 1; i <= 25; i++) {
                        outputDay(i, true);
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