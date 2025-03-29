package b_1062;

import java.io.*;

/**
 *  첫째 줄에 단어의 개수 N과 K가 주어진다.
 *  N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0 (아예 가르칠 단어가 없는 경우)
 * */
/**
 *  내가 매개변수를 비트마스킹을 활용해서 문제를 푸는 능력이 약하다. -> 이거 키울것
 * */
public class b_1062_a_3 {
    private static int N;
    private static int K;
    private static int[] words = new int[51]; // N은 50보다 작거나 같은 자연수이므로, 사이즈를 50으로 잡는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);
        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }

        int ret = dfs(0, K, 0);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    private static int dfs(int alphabetIdx, int k, int mask) {
        if (k < 0) {
            return 0;
        }
        if (alphabetIdx == 26) {
            return count(mask);
        }
        int ret = 0;
        // 해당 알파벳을 배웠을 때의 사용할 수 있는 단어의 수 리턴
        ret = dfs(alphabetIdx + 1, k - 1, mask | (1 << alphabetIdx));
        // 해당 알파벳을 배우지 않았을 때의 사용할 수 있는 단어의 수 리턴
        // 그러나 a, n, t, i, c는 반드시 배워야 하므로, 해당 단어가 아닐 때만 해당 dfs 함수를 사용할 수 있다.
        if (alphabetIdx != 'a' - 'a' && alphabetIdx != 'n' - 'a' && alphabetIdx != 't' - 'a' && alphabetIdx != 'i' - 'a' && alphabetIdx != 'c' - 'a') {
            // 사용했을 때와 사용하지 않았을 때를 비교해서 가장 큰 값을 리턴하는 것을 최종 ret으로 선정한다.
            // ret = dfs(alphabetIdx + 1, k, mask);
            ret = Math.max(ret, dfs(alphabetIdx + 1, k, mask));
        }
        return ret;
    }
    private static int count(int mask) {
        int cnt = 0;
        for (int word : words) {
            boolean isWordExisted = (word != 0); // 단어가 존재하는지 여부
            boolean isMaskCorrect = (word & mask) == word; // word와 mask끼리 and연산을 했을 때, word가 나온다면, mask에 있는 단어가 모두 존재한다는 뜻
            if (isWordExisted && isMaskCorrect) {
                ++cnt;
            }
        }
        return cnt;
    }
}
