package b_1202;

import java.io.*;
import java.util.*;

public class b_1202_a {
    private static int N;
    private static int K;
    private static long ret;
    private static List<Diamond> diamondList = new ArrayList<>();
    private static List<Long> bagList = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        int diamondIdx = 0;
        for (int k = 0; k < K; ++k) {
            while (diamondIdx < N && diamondList.get(diamondIdx).weight <= bagList.get(k)) {
                pq.add(diamondList.get(diamondIdx++).value);
            }
            if (pq.size() != 0) {

                ret += pq.poll();
            }
        }
        System.out.println(ret);
        bw.flush();
        bw.close();
    }

    private static void setConds(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);
        for (int n = 0; n < N; ++n) {
            String[] diaConds = br.readLine().split(" ");
            diamondList.add(new Diamond(Integer.parseInt(diaConds[0]), Integer.parseInt(diaConds[1])));
        }
        for (int k = 0; k < K; ++k) {
            bagList.add(Long.parseLong(br.readLine()));
        }
        diamondList.sort((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.value - o1.value;
            }
            return o1.weight - o2.weight;
        });
        Collections.sort(bagList);
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
