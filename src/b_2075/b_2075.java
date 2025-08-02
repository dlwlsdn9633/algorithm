package b_2075;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b_2075 {
    private static int N;
    private static int[][] map;
    private final static PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> num2 - num1);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(map[i][j]);
            }
        }
        Integer num = -1;
        for (int i = 0; i < N; ++i) {
            num = pq.poll();
        }
        bw.write(String.valueOf(num));

        bw.flush();
        bw.close();
        br.close();
    }
}
