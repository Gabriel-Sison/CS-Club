import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class quadraticEquation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("Quad"));

        while (fileScan.hasNextLine()) {
            double a = fileScan.nextInt();
            double b = fileScan.nextInt();
            double c = fileScan.nextInt();

            System.out.print("Root 1 = ");
            System.out.print( (- b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            System.out.print(", ");
            System.out.print("Root 2 = ");
            System.out.print( (- b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            System.out.println();

        }

    }
}
