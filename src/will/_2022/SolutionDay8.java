package will._2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SolutionDay8 {
    static ArrayList<ArrayList<Integer>> table = getTable();

    static ArrayList<ArrayList<Integer>> getTable() {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        try {
//            boolean first = true;
            Scanner scanner = new Scanner(new File("src/will/_2022/data/dataDay8.txt"));

            while (scanner.hasNextLine()) {
                char[] charArr = scanner.nextLine().toCharArray();
                ArrayList<Integer> t = new ArrayList<>();
                for (char c : charArr) {
                    t.add(Character.getNumericValue(c));
                }
                temp.add(t);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static int getVisibleTrees(boolean debug) {
        int visCnt = 0;
        visCnt += 2 * (table.size() - 1);
        visCnt += 2 * (table.get(0).size() - 1);
        if (debug) System.out.println(visCnt);
        for (int i = 1; i < table.size() - 1; i++) {
            for (int j = 1; j < table.get(0).size() - 1; j++) {
                if (debug) System.out.print(table.get(i).get(j));
                boolean visibleL = true;
                boolean visibleR = true;
                boolean visibleT = true;
                boolean visibleB = true;
                for (int x = 0; x < i; x++) {
                    if (table.get(i).get(j) <= table.get(x).get(j)) {
                        visibleL = false;
                        break;
                    }
                }
                for (int x = i + 1; x < table.size(); x++) {
                    if (table.get(i).get(j) <= table.get(x).get(j)) {
                        visibleR = false;
                        break;
                    }
                }
                for (int y = 0; y < j; y++) {
                    if (table.get(i).get(j) <= table.get(i).get(y)) {
                        visibleT = false;
                        break;
                    }
                }
                for (int y = j + 1; y < table.get(0).size(); y++) {
                    if (table.get(i).get(j) <= table.get(i).get(y)) {
                        visibleB = false;
                        break;
                    }
                }

                if (visibleL || visibleR || visibleT || visibleB) visCnt++;
            }
            if (debug) System.out.println();
        }
        return visCnt;
    }

    public static int getHighAppeal(boolean debug) {
        ArrayList<ArrayList<Integer>> scenicScoreMatrix = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < table.get(0).size(); j++) {
                if (debug) System.out.print(table.get(i).get(j));
                int visibleL = 0;
                int visibleR = 0;
                int visibleT = 0;
                int visibleB = 0;
                for (int x = i - 1; x >= 0; x--) {
                    visibleL++;
                    if (table.get(i).get(j) <= table.get(x).get(j)) break;
                }
                for (int x = i + 1; x < table.size(); x++) {
                    visibleR++;
                    if (table.get(i).get(j) <= table.get(x).get(j)) break;
                }
                for (int y = j - 1; y >= 0; y--) {
                    visibleT++;
                    if (table.get(i).get(j) <= table.get(i).get(y)) break;
                }
                for (int y = j + 1; y < table.get(0).size(); y++) {
                    visibleB++;
                    if (table.get(i).get(j) <= table.get(i).get(y)) break;
                }
                temp.add(visibleR * visibleL * visibleB * visibleT);
            }
            scenicScoreMatrix.add(temp);
            if (debug) System.out.println();
        }
        if (debug) {
            System.out.println();
            for (ArrayList<Integer> line : scenicScoreMatrix) System.out.println(line);
        }

        int answer = 0;
        for (ArrayList<Integer> one : scenicScoreMatrix) for (int two : one) if (two > answer) answer = two;
        return answer;
    }
}
