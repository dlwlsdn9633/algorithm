package b_9935;

import java.io.*;
import java.util.Stack;
public class b_9935_2 {
    private static String str;
    private static String bombStr;
    private static Stack<Character> stack = new Stack<>();
    private static Stack<Character> reversedStack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        bombStr = br.readLine();
        for (int strIdx = 0; strIdx < str.length(); ++strIdx) {
            stack.add(str.charAt(strIdx));
        }

        while (stack.isEmpty() == false) {
            char topChar = stack.pop();
            reversedStack.add(topChar);
            if (reversedStack.size() >= bombStr.length()) {
                boolean isSame = true;
                for (int reversedStackIdx = 0; reversedStackIdx < bombStr.length(); ++reversedStackIdx) {
                    if (bombStr.charAt(reversedStackIdx) != reversedStack.get(reversedStack.size() - 1 - reversedStackIdx)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int bombIdx = 0; bombIdx < bombStr.length(); ++bombIdx) {
                        reversedStack.pop();
                    }
                }
            }
        }
        if (reversedStack.size() == 0) {
            bw.write("FRULA");
        } else {
            while (reversedStack.isEmpty() == false) {
                bw.write(String.valueOf(reversedStack.pop()));
            }
        }
        bw.flush();
        bw.close();
    }
}
