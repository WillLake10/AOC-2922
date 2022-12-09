package will;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static will.Days.outputDay;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int day;
        do {
            System.out.print("What day do you want the answer for: Day ");
            day = Integer.parseInt(reader.readLine());
            outputDay(day);
        }
        while (day >= 1);
    }
}