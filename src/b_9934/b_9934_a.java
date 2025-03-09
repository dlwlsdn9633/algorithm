package b_9934;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

// 이진 탐색을 이용해서 푸는 방식
public class b_9934_a {
    private static int K;
    private static int[] values;
    private static ArrayList<Integer>[] ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        int _end = (int)Math.pow(2, K) - 2;
        String[] conds = br.readLine().split(" ");

        values = Arrays.stream(conds).mapToInt(Integer::parseInt).toArray();
        ret = IntStream.rangeClosed(0, K + 1).mapToObj(i -> new ArrayList<Integer>()).toArray(ArrayList[]::new);

        go(0, _end, 1);
        for (int i = 1; i <= K; ++i) {
            for (int j : ret[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        bw.flush();
        bw.close();
    }
    private static void go(int start, int end, int level) {
        if (start > end) {
            return;
        }
        if (start == end) {
            ret[level].add(values[start]);
            return;
        }
        int mid = (start + end) / 2;
        ret[level].add(values[mid]);
        go(start, mid - 1, level + 1);
        go(mid + 1, end, level + 1);
        return;
    }
}
