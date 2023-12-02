package will._2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolutionDay2 {

    static List<Game> games = getAllGames();

    private static List<Game> getAllGames() {
        List<Game> values = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/will/_2023/data/dataDay2.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLines = line.split(":");
                int gameNumber = Integer.parseInt(splitLines[0].replace("Game ", ""));
                String[] draws = splitLines[1].replace(" ", "").split(";");
                List<Draw> gameDraws = new ArrayList<>();
                for (String draw : draws) {
                    String[] colours = draw.split(",");
                    int red = 0;
                    int green = 0;
                    int blue = 0;
                    for (String colour : colours) {
                        if (colour.contains("red")) {
                            red = Integer.parseInt(colour.replace("red", ""));
                        }
                        if (colour.contains("green")) {
                            green = Integer.parseInt(colour.replace("green", ""));
                        }
                        if (colour.contains("blue")) {
                            blue = Integer.parseInt(colour.replace("blue", ""));
                        }
                    }
                    gameDraws.add(new Draw(red, green, blue));
                }
                values.add(new Game(gameNumber, gameDraws));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static int getPossibleGames() {
        int redLimit = 12;
        int greenLimit = 13;
        int blueLimit = 14;
        int total = 0;
        for (Game game : games) {
            boolean validGame = true;
            for (Draw draw : game.draws) {
                if (draw.red > redLimit || draw.green > greenLimit || draw.blue > blueLimit) {
                    validGame = false;
                }
            }
            if (validGame){
                total += game.gameNumber;
            }
        }
        return total;
    }

    public static int getFewestCubePower() {
        int total = 0;
        for (Game game : games) {
            int redMin = 0;
            int greenMin = 0;
            int blueMin = 0;
            for (Draw draw : game.draws) {
                if (redMin < draw.red){
                    redMin = draw.red;
                }
                if (greenMin < draw.green){
                    greenMin = draw.green;
                }
                if (blueMin < draw.blue){
                    blueMin = draw.blue;
                }
            }
            total += (redMin * blueMin * greenMin);
        }
        return total;
    }

    private record Game(int gameNumber, List<Draw> draws) {
    }

    private record Draw(int red, int green, int blue) {
    }
}
