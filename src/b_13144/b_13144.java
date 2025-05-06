package b_13144;

import java.io.*;
import java.util.Arrays;

public class b_13144 {
    private static int N;
    private static int[] arr;
    private static boolean[] visit = new boolean[100_001];
    private static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);

        for (int selectNum = 1; selectNum <= N; ++selectNum) {
            for (int idx = 0; idx < N - selectNum + 1; ++idx) {
                Arrays.fill(visit, false);
                int[] slicedArr = Arrays.copyOfRange(arr, idx, idx + selectNum);
                boolean isVisit = false;
                for (int slicedNum : slicedArr) {
                    if (visit[slicedNum]) {
                        isVisit = true;
                        break;
                    }
                    visit[slicedNum] = true;
                }
                if (!isVisit) {
                    ++ret;
                }
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void setConds(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            arr[i] = Integer.parseInt(conds[i]);
        }
    }
}
