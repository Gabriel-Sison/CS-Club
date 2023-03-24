import java.util.*;
import java.io.*;

public class spellingBee {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("spellingbee.txt"));
        int numBees = fileScan.nextInt();
        String [][] beeAnswers = new String[numBees][];
        int pointTracker [][] = new int[numBees][];
        int contestantTracker [][] = new int[numBees][];

        for (int beeIndex = 0; beeIndex < numBees; beeIndex++) {
            fileScan.nextInt();
            int numPeeps = fileScan.nextInt();
            String wordsInCont = fileScan.nextLine().substring(1).toUpperCase();
            String[] ans = wordsInCont.split(" ");
            beeAnswers[beeIndex] = ans;
            pointTracker[beeIndex] = new int[numPeeps];
            contestantTracker[beeIndex] = new int[numPeeps];
        }

        for (int beeIndex = 0; beeIndex < numBees; beeIndex++) {
            for (int contIndex = 0; contIndex < contestantTracker[beeIndex].length; contIndex++) {
                fileScan.nextInt();
                int contNumb = fileScan.nextInt();
                contestantTracker[beeIndex][contIndex] = contNumb;
                String theirAnswer = fileScan.nextLine().substring(1);
                String answerWithoutHyphen = "";
                for (int i = 0; i < theirAnswer.length(); i++) {
                    if (theirAnswer.charAt(i) != '-') {
                        answerWithoutHyphen += theirAnswer.charAt(i);
                    }
                }
                String [] answersArray = answerWithoutHyphen.split(" ");
                for (int i = 0; i < answersArray.length; i++) {
                    if (answersArray[i].equals(beeAnswers[beeIndex][i])) {
                        pointTracker[beeIndex][contIndex] ++;
                    }
                }
                int x = 39103223;
            }
        }

        for (int beeIndex = 0; beeIndex < pointTracker.length; beeIndex++) {
            int highScore = 0;
            int winnerNumber = 0;
            for (int contIndex = 0; contIndex < pointTracker[beeIndex].length; contIndex++) {
                if (pointTracker[beeIndex][contIndex] > highScore) {
                    winnerNumber = contestantTracker[beeIndex][contIndex];
                    highScore = pointTracker[beeIndex][contIndex];
                }
            }
            System.out.printf("The winner of spelling bee %d is contestant number %d\n", beeIndex + 1, winnerNumber);
        }
    }
}
