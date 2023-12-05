package will._2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionDay3 {

    static char[][] schematic = getSchematic();

    private static char[][] getSchematic() {
        try {
            Scanner scanner = new Scanner(new File("src/will/_2023/data/dataDay3.txt"));
            int count = 0;
            while (scanner.hasNextLine()) {
                count++;
                scanner.nextLine();
            }

            char[][] values = new char[count][];
            int i = 0;

            scanner = new Scanner(new File("src/will/_2023/data/dataDay3.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] row = line.toCharArray();
                values[i] = row;
                i++;
            }
            scanner.close();

            return values;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getPartNumSum() {
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;

        String currentNum = "";
        boolean part = false;

        int total = 0;

        for (int i = 0; i < schematic.length; i++) {
            for (int j = 0; j < schematic[0].length; j++) {
                top = i == 0;
                bottom = i == schematic.length - 1;
                left = j == 0;
                right = j == schematic.length - 1;
                if (Character.isDigit(schematic[i][j])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(currentNum).append(schematic[i][j]);
                    currentNum = sb.toString();
                    if (!top) {
                        if (schematic[i - 1][j] != '.' && !Character.isDigit(schematic[i - 1][j])) {
                            part = true;
                        }
                        if (!left) {
                            if (schematic[i - 1][j - 1] != '.' && !Character.isDigit(schematic[i - 1][j - 1])) {
                                part = true;
                            }
                        }
                        if (!right) {
                            if (schematic[i - 1][j + 1] != '.' && !Character.isDigit(schematic[i - 1][j + 1])) {
                                part = true;
                            }
                        }
                    }
                    if (!bottom) {
                        if (schematic[i + 1][j] != '.' && !Character.isDigit(schematic[i + 1][j])) {
                            part = true;
                        }
                        if (!left) {
                            if (schematic[i + 1][j - 1] != '.' && !Character.isDigit(schematic[i + 1][j - 1])) {
                                part = true;
                            }
                        }
                        if (!right) {
                            if (schematic[i + 1][j + 1] != '.' && !Character.isDigit(schematic[i + 1][j + 1])) {
                                part = true;
                            }
                        }
                    }
                    if (!left) {
                        if (schematic[i][j - 1] != '.' && !Character.isDigit(schematic[i][j - 1])) {
                            part = true;
                        }
                    }
                    if (!right) {
                        if (schematic[i][j + 1] != '.' && !Character.isDigit(schematic[i][j + 1])) {
                            part = true;
                        }
                    }
                } else if (currentNum != "") {
                    if (part) {
                        total += Integer.parseInt(currentNum);
                        part = false;
                    }
                    currentNum = "";
                }
            }
            if (part) {
                total += Integer.parseInt(currentNum);
                part = false;
            }
            currentNum = "";
        }
        return total;
    }


    public static int getGearRatio() {
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;

        int[][][] gears = new int[schematic.length][schematic[0].length][2];

        String currentNum = "";
        boolean part = false;

        int total = 0;

        int starLoc = 0;

        Integer x = null;
        Integer y = null;

        for (int i = 0; i < schematic.length; i++) {
            for (int j = 0; j < schematic[0].length; j++) {
                top = i == 0;
                bottom = i == schematic.length - 1;
                left = j == 0;
                right = j == schematic.length - 1;
                if (Character.isDigit(schematic[i][j])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(currentNum).append(schematic[i][j]);
                    currentNum = sb.toString();
                    if (!top) {
                        if (schematic[i - 1][j] == '*') {
                            part = true;
                            starLoc = 1;
                            x = i-1;
                            y = j;
                        }
                        if (!left) {
                            if (schematic[i - 1][j - 1] == '*') {
                                part = true;
                                starLoc = 2;
                                x = i-1;
                                y = j-1;
                            }
                        }
                        if (!right) {
                            if (schematic[i - 1][j + 1] == '*') {
                                part = true;
                                starLoc = 3;
                                x = i-1;
                                y = j+1;
                            }
                        }
                    }
                    if (!bottom) {
                        if (schematic[i + 1][j] == '*') {
                            part = true;
                            starLoc = 6;
                            x = i+1;
                            y = j;
                        }
                        if (!left) {
                            if (schematic[i + 1][j - 1] == '*') {
                                part = true;
                                starLoc = 7;
                                x = i+1;
                                y = j-1;
                            }
                        }
                        if (!right) {
                            if (schematic[i + 1][j + 1] == '*') {
                                part = true;
                                starLoc = 8;
                                x = i+1;
                                y = j+1;
                            }
                        }
                    }
                    if (!left) {
                        if (schematic[i][j - 1] == '*') {
                            part = true;
                            starLoc = 4;
                            x = i;
                            y = j-1;
                        }
                    }
                    if (!right) {
                        if (schematic[i][j + 1] == '*') {
                            part = true;
                            starLoc = 5;
                            x = i;
                            y = j+1;
                        }
                    }
                } else if (currentNum != "") {
                    if (part) {
                        if (gears[x][y][0] == 0) {
                            gears[x][y][0] = Integer.parseInt(currentNum);
                        } else {
                            gears[x][y][1] = Integer.parseInt(currentNum);
                        }
                        x = null;
                        y = null;
                        part = false;
                    }
                    currentNum = "";
                }
            }
            if (part) {
                if (gears[x][y][0] == 0) {
                    gears[x][y][0] = Integer.parseInt(currentNum);
                } else {
                    gears[x][y][1] = Integer.parseInt(currentNum);
                }
            }
            x = null;
            y = null;
            part = false;
            currentNum = "";
        }


        for (int i = 0; i < gears.length; i++) {
            for (int j = 0; j < gears[0].length; j++) {
                if (gears[i][j][0] != 0 && gears[i][j][1] != 0) {
                    total += (gears[i][j][0] * gears[i][j][1]);
                }
            }
        }
        return total;
    }

}
