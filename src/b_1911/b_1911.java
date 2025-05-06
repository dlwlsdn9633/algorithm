package b_1911;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_1911 {
    private static int N;
    private static int L;
    private static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.startPos - b.startPos);
    private static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        for (long n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            if (pq.isEmpty()) {
                break;
            }
            if (pq.peek().startPos <= i) {
                i += (L - 1);
                ++ret;
                while (!pq.isEmpty() && pq.peek().endPos - 1 <= i) {
                    pq.poll();
                }
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    static class Node {
        int startPos;
        int endPos;
        public Node(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }
    }
}
