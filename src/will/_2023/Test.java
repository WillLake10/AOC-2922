package will._2023;

import java.util.Objects;

public class Test {

    public static final String[][] expectedValues = {
            {"54990", "54473"}, //1
            {"2685", "83707"}, //2
            {"514969", "78915902"}, //3
            {"26426", "6227972"}, //4
            {"", ""}, //5
            {"", ""}, //6
            {"", ""}, //7
            {"", ""}, //8
            {"", ""}, //9
            {"", ""}, //10
            {"", ""}, //11
            {"", ""}, //12
            {"", ""}, //13
            {"", ""}, //14
            {"", ""}, //15
            {"", ""}, //16
            {"", ""}, //17
            {"", ""}, //18
            {"", ""}, //19
            {"", ""}, //20
            {"", ""}, //21
            {"", ""}, //22
            {"", ""}, //23
            {"", ""}, //24
            {"", ""}, //25
    };

    public static boolean valuesPassesTest(int day, int part, String value) {
        return Objects.equals(expectedValues[day][part], value);
    }

}
