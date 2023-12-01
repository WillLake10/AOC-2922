package will._2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class SolutionDay5 {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    static List<Move> moves = getAllPairs().moves;

    public static ReturnValues getAllPairs() {
        List<Stacks> stacks = new ArrayList<>();
        List<Move> moves = new ArrayList<>();
        Stack<Character>[] tempStacks = new Stack[]{new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>()};
        int[] charPos = {1, 5, 9, 13, 17, 21, 25, 29, 33};
        boolean beforeMoves = true;
        try {
            Scanner scanner = new Scanner(new File("src/will/_2022/data/dataDay5.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (Objects.equals(line, "")) {
                    beforeMoves = false;

                    for (Stack<Character> s : tempStacks) {
                        Stack<Character> temp = new Stack<>();
                        int stackNum;
                        stackNum = s.pop() - '0';
                        while (s.size() > 0) {
                            temp.push(s.pop());
                        }
                        stacks.add(new Stacks(stackNum, temp));
                    }
                }
                else if (beforeMoves) {
                    for (int i = 0; i < charPos.length; i++) {
                        if (!Character.toString(line.toCharArray()[charPos[i]]).equals(" ")) {
                            tempStacks[i].add(line.toCharArray()[charPos[i]]);
                        }
                    }
                }
                else {
                    String[] splits = line.split("\\s+");
                    moves.add(new Move(Integer.parseInt(splits[1]), Integer.parseInt(splits[3]), Integer.parseInt(splits[5])));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ReturnValues(stacks, moves);
    }

    public static String getFinalTopCrates(boolean debug) {
        List<Stacks> ship = getAllPairs().ship;
        if (debug) visualiseStacks(ship);
        for (Move move : moves){
            if (debug) System.out.println(move);
            for (int i = 0; i < move.numberToMove; i++){
                ship.get(move.to-1).stackItems.push(ship.get(move.from-1).stackItems.pop());
            }
            if (debug) visualiseStacks(ship);
        }
        StringBuilder answer = new StringBuilder();
        for (Stacks stack: ship){
            answer.append(stack.stackItems.peek());
        }
        return String.valueOf(answer);
    }

    public static String getFinalTopCrates9001(boolean debug) {
        List<Stacks> ship = getAllPairs().ship;
        if (debug) visualiseStacks(ship);
        for (Move move : moves){
            Stack<Character> temp = new Stack<>();
            if (debug) System.out.println(move);
            for (int i = 0; i < move.numberToMove; i++){
                temp.push(ship.get(move.from-1).stackItems.pop());
            }
            while (temp.size() > 0){
                ship.get(move.to-1).stackItems.push(temp.pop());
            }
            if (debug) visualiseStacks(ship);
        }
        StringBuilder answer = new StringBuilder();
        for (Stacks stack: ship){
            answer.append(stack.stackItems.peek());
        }
        return String.valueOf(answer);
    }

    public static void visualiseStacks(List<Stacks> stacks) {
        int largestStack = 0;
        for (Stacks stack : stacks) {
            if (stack.stackItems.size() > largestStack) {
                largestStack = stack.stackItems.size();
            }
        }
        for (int i = largestStack - 1; i >= 0; i--) {
            for (Stacks stack : stacks) {
                try {
                    System.out.print("|" + ANSI_PURPLE + stack.stackItems.get(i) + ANSI_RESET);
                } catch (Exception e) {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println("|-|-|-|-|-|-|-|-|-|");
        for (Stacks stack : stacks) {
            System.out.print("|" + ANSI_PURPLE + stack.stackNumber + ANSI_RESET);
        }
        System.out.println("|");
    }

    public record Stacks(int stackNumber, Stack<Character> stackItems) {
    }

    public record Move(int numberToMove, int from, int to) {
    }

    public record ReturnValues(List<Stacks> ship, List<Move> moves) {
    }
}
