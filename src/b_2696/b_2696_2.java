package b_2696;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_2696_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            test(br, bw);
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static void test(BufferedReader br, BufferedWriter bw) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf((N / 2) + 1)).append("\n");

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        int oddsNumber = 1;
        int checkNumber = 1;
        int lineLen = (N % 10 == 0) ? (N / 10) : (N / 10) + 1;
        for (int line = 0; line < lineLen; ++line) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if (maxPq.size() == minPq.size()) {
                    maxPq.add(Integer.parseInt(st.nextToken()));
                } else {
                    minPq.add(Integer.parseInt(st.nextToken()));
                }

                if (!maxPq.isEmpty() && !minPq.isEmpty()) {
                    if (maxPq.peek() > minPq.peek()) {
                        int tmp = maxPq.poll();
                        maxPq.add(minPq.poll());
                        minPq.add(tmp);
                    }
                }
                if (checkNumber % 2 != 0) {
                    sb.append(String.valueOf(maxPq.peek()));
                    if (oddsNumber % 10 == 0) {
                        sb.append("\n");
                    } else {
                        sb.append(" ");
                    }
                    ++oddsNumber;
                }
                ++checkNumber;
            }
        }

        bw.write(sb.toString());
        bw.newLine();
    }
}
