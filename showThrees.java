import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class showThrees {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("showThrees"));

        while (fileScan.hasNextLine()) {
            int x = fileScan.nextInt();
            showThrees(x);
            System.out.println();
        }
    }

    public static void showThrees(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        } else if (n % 9 == 0) {
            System.out.print("3 * ");
            showThrees(n / 9);
            System.out.print(" * 3");
        } else if (n % 3 == 0) {
            System.out.print("3 * ");
            showThrees(n / 3);
        } else {
            System.out.print(n);
        }
    }
}