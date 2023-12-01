package will._2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionDay6 {
    static String data = getData();

    private static String getData(){
        String data = "";
        try {
            Scanner scanner = new Scanner(new File("src/will/_2022/data/dataDay6.txt"));

            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static int getNumCharToFirstPacketMarker(){
        char[] charArray = data.toCharArray();
        int answer = 4;
        for(int i = 3; i < charArray.length; i++){
            char[] tempArray = Arrays.copyOfRange(charArray, i-3, i+1);
            boolean duplicate = false;
            for(int j = 0; j<4; j++){
                for (int k = 0; k<4; k++){
                    if(j!=k){
                        if(tempArray[j]==tempArray[k]){
                            duplicate = true;
                        }
                    }
                }
            }
            if(!duplicate){
                break;
            }else{
                answer++;
            }
        }
        return answer;
    }

    public static int getNumCharToFirstMessageMarker(){
        char[] charArray = data.toCharArray();
        int answer = 14;
        for(int i = 13; i < charArray.length; i++){
            char[] tempArray = Arrays.copyOfRange(charArray, i-13, i+1);
            boolean duplicate = false;
            for(int j = 0; j<14; j++){
                for (int k = 0; k<14; k++){
                    if(j!=k){
                        if(tempArray[j]==tempArray[k]){
                            duplicate = true;
                        }
                    }
                }
            }
            if(!duplicate){
                break;
            }else{
                answer++;
            }
        }
        return answer;
    }
}
