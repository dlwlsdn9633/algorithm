import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static PriorityQueue<Double> q = new PriorityQueue<>(Collections.reverseOrder()); // 가장 작은 것부터 하나씩 빼낸다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            Double score = Double.parseDouble(br.readLine());
            if (q.size() == 5) {
                double peek = q.peek();
                if (q.peek() > score) {
                    q.poll();
                    q.offer(score);
                }
            } else {
                q.offer(score);
            }
        }

        ArrayList<Double> scores = new ArrayList<>();
        while (q.isEmpty() == false) {
            scores.add(q.poll());
        }
        List<Double> reversed = scores.reversed();
        for (Double score : reversed) {
            bw.write(String.valueOf(score));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}