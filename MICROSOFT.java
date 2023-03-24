import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MICROSOFT {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        String word = io.next();
        String range = io.next();

        int r1 = -1;
        int r2 = -1;
        if (range.contains("-")) {
            r1 = Integer.parseInt(range.substring(0, range.indexOf('-')));
            r2 = Integer.parseInt(range.substring(range.indexOf('-') + 1));
        } else {
            r1 = Integer.parseInt(range);
        }

        ArrayList<String> arrayList = new ArrayList<>();
        int pos = 0;
        int index = 0;
        while (pos < word.length()) {
            int currRange = (index % 2 == 0 || r2 == -1) ? r1 : r2;
            arrayList.add(word.substring(pos, Math.min(pos + currRange, word.length())));
            pos += currRange;
            index ++;
        }
        String[] array = new String[arrayList.size()];
        arrayList.toArray(array);
        System.out.println(Arrays.toString(array));
    }

}
