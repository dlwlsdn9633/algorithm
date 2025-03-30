import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int N;
    private static int lisLen;
    private static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        lis = new int[N];
        arr = new int[N];
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            int num = Integer.parseInt(conds[i]);
            int lowerIdx = lowerBound(0, lisLen, num);
            if (lowerIdx >= lisLen) {
                ++lisLen;
            }
            lis[lowerIdx] = num;
        }
        bw.write(String.valueOf(lisLen));
        bw.flush();
        bw.close();
    }

    private static int lowerBound(int left, int right, int target) {
        int l = left;
        int r = right;
        while (l < r) {
            int mid = (l + r) / 2;
            if (lis[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}