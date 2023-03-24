import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class window {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("window"));

        while (fileScan.hasNextLine()) {
            int times = fileScan.nextInt();
            window(times);
        }
    }

    public static void window(int SIZE) {
        System.out.print("+");
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("=");
            }
            System.out.print("+");
        }
        System.out.println();

        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("|");
                for (int k = 0; k < SIZE - 1; k++) {
                    for (int l = 0; l < SIZE; l++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                System.out.println();
            }

            System.out.print("+");
            for (int j = 0; j < SIZE - 1; j++) {
                for (int k = 0; k < SIZE; k++) {
                    System.out.print("=");
                }
                System.out.print("+");
            }
            System.out.println();
        }


    }



}