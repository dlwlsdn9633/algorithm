package b_1285;

import java.io.*;

// 이 문제는 많이 어려웠다...


public class b_1285_a {
    private static int ret = Integer.MAX_VALUE;
    private static int N;
    private static int[] a = new int[44];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; ++i) {
            String str = br.readLine();
            int value = 1;
            for (int j = 0; j < str.length(); ++j) {
                if (str.charAt(j) == 'T') {
                    // a[i]에는 각 행의 숫자값이 들어가있다.
                    // 비트마스킹은 boolean 벡터를 하나의 숫자 값으로 나타낼 수 있도록 도와주기 때문에
                    // 001 -> HHT 이런식으로
                    a[i] |= value;
                }
                value *= 2;
            }
        }
        // 첫 번째 행부터 시작하자
        go(1);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void go(int row) {
        if (row == N + 1) { // row가 끝 행에 도달했을 때
            int sum = 0;
            for (int i = 1; i <= (1 << (N - 1)); i *= 2) {
                int cnt = 0;
                for (int j = 1; j <= N; ++j) {
                    if ((a[j] & i) != 0) {
                        ++cnt;
                    }
                }
                sum += Math.min(cnt, N - cnt); // 만약 해당 열을 뒤집었을 때 vs 뒤집지 않았을 때 -> 최소값을 sum에 더한다.
            }
            ret = Math.min(ret, sum);
            return;
        }

        // 왜 이런식으로 구조를 만들었을 끼?
        go(row + 1);
        a[row] = ~a[row];
        go(row + 1);
    }
}
