package b_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  입력: 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *  출력: 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
 *  중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 *  총 M개까지 선택할 수 있는 것을 인지시켜야 한다.
 * */
public class b_15649_2 {
    private static int M; // 총 깊이가 되는 것이다.
    private static int N;
    private static boolean lookupTable[];
    private static int selectedNumbers[];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        lookupTable = new boolean[N + 1]; // 4
        selectedNumbers = new int[M]; // 1

        dfs(0);
        System.out.println(sb);
    }
    private static void dfs(int depth) {
        if (depth >= M) {
            // m이 M보다 크면, M만큼 전부 다 숫자를 선택을 했다는 의미이므로 출력을 진행한다.
            for (int i = 0; i < selectedNumbers.length; ++i) {
                sb.append(selectedNumbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for (int num = 1; num <= N; ++num) {
                if (lookupTable[num]) {
                    continue;
                }
                lookupTable[num] = true;
                selectedNumbers[depth] = num;
                dfs(depth + 1);
                lookupTable[num] = false;
            }
        }
    }
}
