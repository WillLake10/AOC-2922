package will._2022;

import java.util.Objects;

public class Test {

    public static final String[][] expectedValues = {
            {"66487", "197301"}, //1
            {"13924", "13448"}, //2
            {"8123", "2620"}, //3
            {"453", "919"}, //4
            {"BWNCQRMDB", "NHWZCBNBF"}, //5
            {"1804", "2508"}, //6
            {"1908462", "3979145"}, //7
            {"1669", "331344"}, //8
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
