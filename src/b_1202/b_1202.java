package b_1202;

import java.io.*;
import java.util.*;

public class b_1202 {
    private static int N;
    private static int K;
    private static PriorityQueue<Diamond> pq = new PriorityQueue<>(
            (d1, d2) -> {
                if (d1.value == d2.value) {
                    return Integer.compare(d1.weight, d2.weight);
                }
                return Integer.compare(d2.value, d1.value);
            }
    );
    private static Queue<Diamond> diamondQueue = new LinkedList<>();
    private static List<Integer> bagsList = new ArrayList<>();
    private static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        for (int bagIdx = 0; bagIdx < K; ++bagIdx) {
            if (pq.size() == 0) {
                continue;
            }
            while (pq.size() != 0 && (bagsList.get(bagIdx) < pq.peek().weight)) {
                diamondQueue.add(pq.poll());
            }
            if (pq.size() != 0) {
                ret += pq.poll().value;
            }
            while (diamondQueue.isEmpty() == false) {
                pq.add(diamondQueue.poll());
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void setConds (BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);
        for (int n = 0; n < N; ++n) {
            String[] diaConds = br.readLine().split(" ");
            pq.add(new Diamond(Integer.parseInt(diaConds[0]), Integer.parseInt(diaConds[1])));
        }
        for (int k = 0; k < K; ++k) {
            int bag = Integer.parseInt(br.readLine());
            bagsList.add(bag);
        }
        Collections.sort(bagsList);
    }
    static class Diamond {
        int weight;
        int value;
        public Diamond(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        @Override
        public String toString() {
            return "Diamond{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }
}
