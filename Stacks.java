import java.util.Stack;

public class Stacks {

    public static void main(String[] args) {
        checkBalance("() wrrf24f24 {} 2f323g");
    }
    public static int checkBalance(String srcCode) {
        Stack<Character> pStack = new Stack<>();

        for (int i = 0; i < srcCode.length(); i ++) {
            Character ch = srcCode.charAt(i);
            if (ch == '(' || ch == ')' || ch == '{' || ch == '}' ) {
                pStack.push(srcCode.charAt(i));
            }
        }

        while (!pStack.empty()) {
            System.out.print(pStack.pop());
        }

        return -1;
    }
}
