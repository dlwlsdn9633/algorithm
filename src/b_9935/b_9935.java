package b_9935;

import java.io.*;
import java.util.Stack;

public class b_9935 {
    private static Stack<Character> stack = new Stack<>();
    private static Stack<Character> boobStack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String boobStr = br.readLine();
        for (char c : str.toCharArray()) {
            stack.add(c);
        }

        while (stack.isEmpty() == false) {
            char stackTop = stack.pop();
            boobStack.push(stackTop);
            if (boobStack.size() >= boobStr.length()) {
                boolean isSame = true;
                for (int boobStrIdx = 0; boobStrIdx < boobStr.length(); ++boobStrIdx) {
                    if (boobStr.charAt(boobStrIdx) != boobStack.elementAt(boobStack.size() - boobStrIdx - 1)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int boobStrIdx = 0; boobStrIdx < boobStr.length(); ++boobStrIdx) {
                        boobStack.pop();
                    }
                }
            }
        }

        if (boobStack.size() <= 0) {
            bw.write("FRULA");
        } else {
            for (int boobStackIdx = 0; boobStackIdx < boobStack.size(); ++boobStackIdx) {
                bw.write(String.valueOf(boobStack.elementAt(boobStack.size() - 1 - boobStackIdx)));
            }
        }
        bw.flush();
        bw.close();
    }
}
