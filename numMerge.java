import java.util.*;
import java.io.*;

public class numMerge {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("numMerge"));
        while (fileScan.hasNextLine()) {
            int times = fileScan.nextInt();
            String num = fileScan.next();
            for (int i = 0; i < num.length(); i++) {
                int sum = 0;
                int j = 0;
                for (j = 0; j < times && i + j < num.length(); j++) {
                    int curr = num.charAt(i + j) - 48;
                    sum += curr;
                }
                i += j - 1;
                System.out.print(sum);
            }
            System.out.println();
        }
    }
}