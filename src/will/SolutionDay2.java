package will;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionDay2 {
    static List<Game> games = getAllPairs();
    public static List<Game> getAllPairs() {
        List<Game> games = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/will/data/dataDay2.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                games.add(new Game(line.charAt(0), line.charAt(2)));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return games;
    }

    public static int getFinalScore(){
        int score = 0;
        for (Game game : games) {
            switch (game.y()) {
                case 'X' -> {
                    score += 1;
                    switch (game.x()) {
                        case 'A' -> score += 3;
                        case 'C' -> score += 6;
                    }
                }
                case 'Y' -> {
                    score += 2;
                    switch (game.x()) {
                        case 'B' -> score += 3;
                        case 'A' -> score += 6;
                    }
                }
                case 'Z' -> {
                    score += 3;
                    switch (game.x()) {
                        case 'C' -> score += 3;
                        case 'B' -> score += 6;
                    }
                }
            }
        }
        return score;
    }

    public static int getFinalScorePart2(){
        int score = 0;
        for (Game game : games) {
            switch (game.y()) {
                case 'X' -> {
                    switch (game.x()) {
                        case 'A' -> score += 3;
                        case 'B' -> score += 1;
                        case 'C' -> score += 2;
                    }
                }
                case 'Y' -> {
                    score += 3;
                    switch (game.x()) {
                        case 'A' -> score += 1;
                        case 'B' -> score += 2;
                        case 'C' -> score += 3;
                    }
                }
                case 'Z' -> {
                    score += 6;
                    switch (game.x()) {
                        case 'A' -> score += 2;
                        case 'B' -> score += 3;
                        case 'C' -> score += 1;
                    }
                }
            }
        }
        return score;
    }

    public record Game(char x, char y) {

        @Override
            public String toString() {
                return "Game{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }
        }

}
