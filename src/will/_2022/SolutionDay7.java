package will._2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionDay7 {

    static List<String> data = getData();
    static HashMap<String, Integer> dirSizes = new HashMap<>();

    private static List<String> getData() {
        List<String> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/will/_2022/data/dataDay7.txt"));

            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void cleanData() {
        data.removeIf(d -> (d.equals("$ ls")));
        data.removeIf(d -> (d.contains("dir ")));
    }

    static Stack<String> currentDir = new Stack<>();

    public static int getTotalSizeUnder100000(boolean debug) {
        cleanData();
        if (debug) {
            for (String d : data) {
                System.out.println(d);
            }
        }
        Directory root = getDirContent(new Directory("/", new ArrayList<>(), new ArrayList<>(), new Stack<>(), 0), 0);

        getDirContent(root, 0);
        if (debug) pPrintDir(root, 0);
        getDirSize(root);
        AtomicInteger answer = new AtomicInteger();

        dirSizes.forEach((key, value) -> {
            if (value <= 100000) {
                answer.addAndGet(value);
            }
        });
        if (debug) System.out.println(dirSizes);
        return answer.intValue();
    }

    public static int getFileSizeToDelete(boolean debug) {
        int currentLarge = 70000000;
        for (String key : dirSizes.keySet()) {
            if (dirSizes.get(key) >= 30000000 - (70000000 - 43956976)) {
                if (dirSizes.get(key) < currentLarge) {
                    currentLarge = dirSizes.get(key);
                    if (debug) System.out.println("        inner " + dirSizes.get(key));
                }
                if (debug) System.out.println("    outer " + dirSizes.get(key));
            }

            if (debug) System.out.println("top " + dirSizes.get(key));
            if (debug) System.out.println("current " + currentLarge);
        }

        return currentLarge;
    }

    private static Directory getDirContent(Directory directory, int dataPos) {
        for (int i = dataPos; i < data.size(); i++) {
//            System.out.println(data.get(i) + "," + currentDir);
            if (data.get(i).length() > 0) {
                if (data.get(i).startsWith("$")) {
                    String dir = data.get(i).substring(5);
                    if (dir.equals("..")) {
                        currentDir.pop();
                    } else {
                        currentDir.push(dir);
                        directory.directories.add(getDirContent(new Directory(dir, new ArrayList<>(), new ArrayList<>(), currentDir, 0), i + 1));
                    }
                } else {
                    String[] split = data.get(i).split(" ");
                    directory.files.add(new Files(split[1], Integer.parseInt(split[0])));
                }
                data.set(i, "");
            }
            if (!currentDir.contains(directory.name)) {
                break;
            }
        }
        return directory;
    }

    public static void pPrintDir(Directory dir, int depth) {
        indent(depth);
        System.out.println("- " + dir.name + " (dir)");
        for (Directory d : dir.directories) {
            pPrintDir(d, depth + 1);
        }
        for (Files f : dir.files) {
            indent(depth + 1);
            System.out.println("- " + f.name + " (file, size=" + f.size + ")");
        }
    }

    public static void indent(int depth) {
        if (depth != 0) {
            for (int i = 0; i < depth - 1; i++) {
                System.out.print("|     ");
            }
            System.out.print("|---");
        }
    }

    static int cnt = 0;

    public static int getDirSize(Directory dir) {
        int size = 0;
        for (Directory d : dir.directories) {
            int tempSize = getDirSize(d);
            size += tempSize;
        }
        for (Files f : dir.files) {
            size += f.size;
        }
        dirSizes.put(dir.name + "-" + cnt, size);
        cnt++;
        return size;
    }

    public record Directory(String name, List<Files> files, List<Directory> directories, Stack<String> trace,
                            int size) {
    }

    public record Files(String name, int size) {
    }
}
