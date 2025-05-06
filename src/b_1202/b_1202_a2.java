package b_1202;

import java.io.*;
import java.util.*;

public class b_1202_a2 {
    private static int N;
    private static int K;
    private static long ret = 0;
    private static List<Diamond> diamondList = new ArrayList<>();
    private static List<Integer> bagList = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());
            diamondList.add(new Diamond(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int k = 0; k < K; ++k) {
            bagList.add(Integer.parseInt(br.readLine()));
        }
        diamondList.sort(
                (o1, o2) -> {
                    if (o1.weight == o2.weight) {
                        return o2.value - o1.value;
                    }
                    return Integer.compare(o1.weight, o2.weight);
                }
        );
        Collections.sort(bagList);

        for (int k = 0, diaIdx = 0; k < K; ++k) {
            while (diaIdx < N && diamondList.get(diaIdx).weight <= bagList.get(k)) {
                pq.add(diamondList.get(diaIdx++).value);
            }
            if (pq.size() != 0) {
                ret += pq.poll();
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
    static class Diamond {
        int weight;
        int value;
        public Diamond(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
