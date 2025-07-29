import java.io.*;
import java.util.PriorityQueue;
/**
 *
 * 우선순위 큐로 풀 생각을 못했다.
 * */
public class Main {
    private static final String[] elements = { "13", "4" };
    private static final PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dfs("", 0, 19);
        long number = 0;
        for (int i = 0; i < N; ++i) {
            number = pq.poll();
        }
        bw.write(String.valueOf(number));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(String currentNumber, int depth, int maxDepth) {
        if (depth >= maxDepth) {
            return;
        }
        if (depth >= 1) {
            pq.add(Long.parseLong(currentNumber));
        }
        for (String ele : elements) {
            dfs(currentNumber + ele, depth + ele.length(), maxDepth);
        }
    }
}