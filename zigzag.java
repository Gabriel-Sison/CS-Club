import java.util.*;
import java.io.*;

public class zigzag {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("zigzag.txt"));
        while (fileScan.hasNextLine()) {
            int x = fileScan.nextInt();
            int y = fileScan.nextInt();
            int[][] matrix = new int[y][x];
            for (int i = 0; i < y; i ++) {
                for (int j = 0; j < x; j ++) {
                    matrix[i][j] = fileScan.nextInt();
                }
            }
            int length = Arrays.toString(spiral(matrix)).length();
            System.out.println(Arrays.toString(spiral(matrix)).substring(1, length - 1));
        }
    }

    public static int[] spiral( int[][] matrix ) {
        int diag = 1, index = 0, x = 0, y = 0;
        int numNums = matrix[0].length, numArrays = matrix.length;
        int[] oneD = new int[numNums * numArrays];

        boolean inRange = index < numNums * numArrays;
        while (inRange) {

            // We're going up-right diagonally
            while (inRange) {
                oneD[index] = matrix[y][x];
                index ++;
                if (y == 0 || x == matrix[0].length - 1) break;
                else { y --; x ++;}
            }

            // We're going to move once we reach end of bound
            inRange = index < numNums * numArrays;
            y = (x == matrix[0].length - 1) ? y + 1: y;
            x = (x == matrix[0].length - 1) ? x : x + 1;

            // We're going down-left diagonally
            while (inRange) {
                oneD[index] = matrix[y][x];
                index ++;
                if (x == 0 || y == matrix.length - 1) break;
                else { y ++; x --;}
            }

            // We're going to move once we reach end of bound
            inRange = index < numNums * numArrays;
            x = (y == matrix.length - 1) ? x + 1: x;
            y = (y == matrix.length - 1) ? y: y + 1;
        }

        return oneD;
    }
}