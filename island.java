import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class island {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("island"));
        while (fileScan.hasNextLine()) {
            int x = fileScan.nextInt();
            int y = fileScan.nextInt();
            int[][] matrix = new int[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    matrix[i][j] = fileScan.nextInt();
                }
            }
            System.out.println(mapMaker(matrix));
            System.out.println();
        }

        Scanner input = new Scanner(System.in);
    }



    public static String mapMaker(int[][] map) {
        if (map.length == 0 || map[0].length == 0) return "There are no islands";

        int numIslands = 0;
        int[] sizeList = new int[Math.max(map.length, map[0].length)];
        int[][] foundIslands = new int[map.length * map[0].length][2];
        foundIslands[0][0] = map.length;
        foundIslands[0][1] = map[0].length;
        int[] coordinate = new int[2];

        // Going down the map
        for (int down = 0; down < map.length; down ++) {
            // Going right the map
            for (int right = 0; right < map[0].length; right ++) {
                // Start of our journey once we encounter our first 1
                if (map[down][right] == 1) {
                    int size = 1;
                    coordinate[0] = down;
                    coordinate[1] = right;

                    // We're gonna go right as much as we can
                    while (coordinate[1] < map[0].length - 1) {
                        if (map[down][coordinate[1] + 1] == 1) {
                            coordinate[1] ++;
                            size ++;
                        } else break;
                    } // End of going right

                    while (coordinate[0] < map.length - 1) {
                        if (map[coordinate[0] + 1][coordinate[1]] == 1) {
                            coordinate[0] ++;
                            size ++;
                        } else break;
                    }

                    // Final coordinates is the most right and down we can go
                    boolean alreadyFound = false;
                    for (int i = 0; i < numIslands + 1; i ++) {
                        if (coordinate[0] == foundIslands[i][0] && coordinate[1] == foundIslands[i][1]) {
                            alreadyFound = true;
                        }
                    }

                    if (!alreadyFound) {
                        foundIslands[numIslands][0] = coordinate[0];
                        foundIslands[numIslands][1] = coordinate[1];
                        numIslands ++;
                        sizeList[size-1] ++;
                    }

                } // End of our journey
            } // End of going right
        } // End of going down

        if (numIslands == 0) return "There are no islands";

        String output = "There" ;
        output += (numIslands > 1) ? (" are " + numIslands + " distinct islands with the following sizes:")
                : (" is 1 island with the following size:");
        for (int i = 0; i < sizeList.length; i ++) {
            if (sizeList[i] > 0) {
                output += "\nSize of " + (i + 1) + ": " + sizeList[i];
            }
        }
        return output;
    }
}
