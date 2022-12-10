package will;

import java.util.Objects;

public class Test {

    public static final String[][] expectedValues = {
            {"66487", "197301"}, //1
            {"13924", "13448"}, //2
            {"8123", "2620"}, //3
            {"", ""}, //4
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
