package will;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static will._2022.Days.output2022Day;
import static will._2023.Days.output2023Day;

public class Main {
    public static void main(String[] args) throws IOException {
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
                if(year == "2022") {
                    output2022Day(day, false);
                } else if (year == "2023") {
                    output2023Day(day, false);
                }
            } catch (Exception e) {
                if (Objects.equals(input, "n")) {
                    for (int i = 1; i <= 25; i++) {
                        if(year == "2022") {
                            output2022Day(i, false);
                        } else if (year == "2023") {
                            output2023Day(i, false);
                        }
                    }
                } else if (Objects.equals(input, "t")){
                    for (int i = 1; i <= 25; i++) {
                        if(year == "2022") {
                            output2022Day(i, true);
                        } else if (year == "2023") {
                            output2023Day(i, true);
                        }
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