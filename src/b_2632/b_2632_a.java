package b_2632;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b_2632_a {
    private static int[] a = new int[1001];
    private static int[] b = new int[1001];
    private static int ret;
    private static int[] psum_a = new int[2002];
    private static int[] psum_b = new int[2002];
    private static int want;
    private static int n;
    private static int m;
    private static Map<Integer, Integer> aCnt = new HashMap<>();
    private static Map<Integer, Integer> bCnt = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        want = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; ++i) {
            int size = Integer.parseInt(br.readLine());
            a[i] = size;
            psum_a[i] = psum_a[i - 1] + a[i];
        }
        for (int i = n + 1; i <= 2 * n; ++i) {
            psum_a[i] = psum_a[i - 1] + a[i - n];
        }

        for (int i = 1; i <= m; ++i) {
            int size = Integer.parseInt(br.readLine());
            b[i] = size;
            psum_b[i] = psum_b[i - 1] + b[i];
        }
        for (int i = m + 1; i <= 2 * m; ++i) {
            psum_b[i] = psum_b[i - 1] + b[i - m];
        }

        make(n, psum_a, aCnt);
        make(m, psum_b, bCnt);

        if (aCnt.get(want) != null) {
            ret += aCnt.get(want);
        }
        if (bCnt.get(want) != null) {
            ret += bCnt.get(want);
        }
        for (int i = 0; i <= want; ++i) {
            if (aCnt.get(i) != null && bCnt.get(want - i) != null) {
                ret += (aCnt.get(i) * bCnt.get(want - i));
            }
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void make(int n, int psum[], Map<Integer, Integer> map) {
        for (int interval = 1; interval <= n; ++interval) {
            // 여기서 n + interval - 1은 누적합의 끝을 의미한다.
            for (int start = interval; start <= n + interval - 1; ++start) {
                int sum = psum[start] - psum[start - interval];
                if (map.get(sum) == null) {
                    map.put(sum, 0);
                }
                map.put(sum, map.get(sum) + 1);
                if (interval == n) {
                    break;
                }
            }
        }
    }
}
