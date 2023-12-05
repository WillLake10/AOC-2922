package will._2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SolutionDay4 {

    static List<Card> cards = getCards();

    private static List<Card> getCards() {
        List<Card> values = new ArrayList<>();
        int cardNo = 0;
        try {
            Scanner scanner = new Scanner(new File("src/will/_2023/data/dataDay4.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                cardNo = Integer.parseInt(line.split(":")[0].replace("Card ", "").trim());
                String[] nums = line.split(":")[1].split("\\|");
//                System.out.println(nums);
                String[] winningNums = nums[0].trim().split(" ");
                List<Integer> winningInts = new ArrayList<>();
                for (String num : winningNums) {
                    if (!Objects.equals(num.trim(), "")) {
                        winningInts.add(Integer.parseInt(num));
                    }
                }
                String[] myNums = nums[1].trim().split(" ");
                List<Integer> myInts = new ArrayList<>();
                for (String num : myNums) {
                    if (!Objects.equals(num.trim(), "")) {
                        myInts.add(Integer.parseInt(num));
                    }
                }

                values.add(new Card(cardNo, winningInts, myInts));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }

    public static int getPoints() {
        int total = 0;
        for (Card card : cards) {
            int numWins = 0;
            for (int myNum : card.myNo) {
                if (card.winningNo.contains(myNum)) {
                    numWins += 1;
                }
            }
            total += Math.pow(2, numWins-1);
        }
        return total;
    }

    public static int getNumberOfCards(){
        int[] count = new int[cards.size()];
        Arrays.fill(count, 1);
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                int numWins = 0;
                for (int myNum : cards.get(i).myNo) {
                    if (cards.get(i).winningNo.contains(myNum)) {
                        numWins += 1;
                    }
                }
                for (int k = 1; k <= numWins; k++) {
                    count[i+k] += 1;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            total += count[i];
        }
        return total;
    }

    record Card(int cardNo, List<Integer> winningNo, List<Integer> myNo) {
    }
}
