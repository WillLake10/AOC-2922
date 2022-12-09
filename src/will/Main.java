package will;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("What day do you want the answer for: Day ");
        int day = Integer.parseInt(reader.readLine());
        if (day == 1) {
            System.out.println("Day 1 answer is: " + Day1.getElf());
        }
    }
}