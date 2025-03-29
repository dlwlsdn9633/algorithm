package b_5430;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class b_5430 {
    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            testcase(br, bw);
        }
        bw.flush();
        bw.close();
    }

    private static void testcase(BufferedReader br, BufferedWriter bw) throws IOException {
        String cmd = br.readLine();
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> list = new ArrayDeque<>();
        String input = br.readLine();

        int value = 0;
        for (char c : input.toCharArray()) {
            if (c == '[' || c == ']') {
                continue;
            }
            if (c != ',') {
                value = value * 10 + (int)(c - '0');
            } else {
                list.add(value);
                value = 0;
            }
        }
        if (value != 0) {
            list.add(value);
        }

        boolean reverseFlag = false;
        for (char c : cmd.toCharArray()) {
            switch (c) {
                case 'R':
                    reverseFlag = !reverseFlag;
                    break;
                case 'D':
                    if (list.size() == 0) {
                        bw.write("error");
                        bw.write("\n");
                        return;
                    } else {
                        if (reverseFlag == false) {
                            list.pollFirst();
                        } else {
                            list.pollLast();
                        }
                    }
                    break;
            }
        }

        bw.write("[");
        if (reverseFlag == false) {
            while (list.isEmpty() == false) {
                int ele = list.pollFirst();
                bw.write(String.valueOf(ele));
                if (list.size() > 0) {
                    bw.write(",");
                }
            }
        } else {
            while (list.isEmpty() == false) {
                int ele = list.pollLast();
                bw.write(String.valueOf(ele));
                if (list.size() > 0) {
                    bw.write(",");
                }
            }
        }

        bw.write("]");
        bw.write("\n");
    }
}
