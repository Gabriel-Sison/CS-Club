import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class ExpressionInWords {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("Exp"));
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            String[] data = line.split(" ");
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals("times") || data[i].equals("dividedBy")) {
                    int prevNum = 0;
                    for (prevNum = i - 1; prevNum >= 0; prevNum -= 2) {
                        if (!data[prevNum].equals("")) {
                            break;
                        }
                    }

                    if (data[i].equals("times")) {
                        data[prevNum] = (Double.parseDouble(data[prevNum]) * Double.parseDouble(data[i + 1])) + "";
                    } else {
                        data[prevNum] = (Double.parseDouble(data[prevNum]) / Double.parseDouble(data[i + 1])) + "";
                    }
                    data[i] = "";
                    data[i + 1] = "";
                }
            }
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals("plus") || data[i].equals("minus")) {
                    int prevNum = 0;
                    for (prevNum = i - 1; prevNum >= 0; prevNum -= 2) {
                        if (!data[prevNum].equals("")) {
                            break;
                        }
                    }

                    if (data[i].equals("plus")) {
                        data[prevNum] = (Double.parseDouble(data[prevNum]) + Double.parseDouble(data[i + 1])) + "";
                    } else {
                        data[prevNum] = (Double.parseDouble(data[prevNum]) - Double.parseDouble(data[i + 1])) + "";
                    }
                    data[i] = "";
                    data[i + 1] = "";
                }
            }
            System.out.println(Math.round(Double.parseDouble(data[0])));
        }
    }
}
