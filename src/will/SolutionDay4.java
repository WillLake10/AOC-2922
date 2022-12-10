package will;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionDay4 {
    static List<Job> jobs = getAllJobs();
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public static List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/will/data/dataDay4.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String[] leftParts = parts[0].split("-");
                String[] rightParts = parts[1].split("-");
                jobs.add(
                        new Job(
                                Integer.parseInt(leftParts[0]),
                                Integer.parseInt(leftParts[1]),
                                Integer.parseInt(rightParts[0]),
                                Integer.parseInt(rightParts[1])
                        )
                );
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public static int getNumbPairsContained(boolean debug) {
        int count = 0;
        for (Job job : jobs) {
            boolean containd = false;
            if (job.start1() <= job.start2() && job.end1() >= job.end2()) {
                if (debug)
                    System.out.println("T:" + job.start1() + "-" + job.end1() + ", " + "" + job.start2() + "-" + job.end2());
                count += 1;
                containd = true;
            }
            if (job.start2() <= job.start1() && job.end2() >= job.end1() && !containd) {
                if (debug)
                    System.out.println("B:" + job.start1() + "-" + job.end1() + ", " + "" + job.start2() + "-" + job.end2());
                count += 1;
                containd = true;
            }
            if (containd && debug) {
                for (int i = 0; i < 100; i++) {
                    if (i < job.start1()) {
                        System.out.print("-");
                    } else if (i <= job.end1()) {
                        System.out.print(ANSI_GREEN + "*" + ANSI_RESET);
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
                for (int i = 0; i < 100; i++) {
                    if (i < job.start2()) {
                        System.out.print("-");
                    } else if (i <= job.end2()) {
                        System.out.print(ANSI_GREEN + "*" + ANSI_RESET);
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
                System.out.println(containd);
                System.out.println(ANSI_RED + "---------" + ANSI_RESET);
            }
        }
        return count;
    }
    public static int getNumbPairsOverlap(boolean debug) {
        int count = 0;
        for (Job job : jobs) {
            boolean containd = false;
            if (job.start1() <= job.end2() && job.start1() >= job.start2()) {
                if (debug)
                    System.out.println("A:" + job.start1() + "-" + job.end1() + ", " + "" + job.start2() + "-" + job.end2());
                count += 1;
                containd = true;
            } else if (job.start2() <= job.end1() && job.start2() >= job.start1()) {
                if (debug)
                    System.out.println("B:" + job.start1() + "-" + job.end1() + ", " + "" + job.start2() + "-" + job.end2());
                count += 1;
                containd = true;
            }
            if (containd && debug) {
                for (int i = 0; i < 100; i++) {
                    if (i < job.start1()) {
                        System.out.print("-");
                    } else if (i <= job.end1()) {
                        System.out.print(ANSI_GREEN + "*" + ANSI_RESET);
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
                for (int i = 0; i < 100; i++) {
                    if (i < job.start2()) {
                        System.out.print("-");
                    } else if (i <= job.end2()) {
                        System.out.print(ANSI_GREEN + "*" + ANSI_RESET);
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
                System.out.println(containd);
                System.out.println(ANSI_RED + "---------" + ANSI_RESET);
            }
        }
        return count;
    }

    public record Job(int start1, int end1, int start2, int end2) {
    }
}
