package b_1062;

import java.io.*;

// N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0
public class b_1062_a4 {
    private static int N;
    private static int K;
    private static int[] words = new int[51];
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
        int ret = dfs(alphabetIdx + 1, k - 1, mask | (1 << alphabetIdx));
        if (alphabetIdx != 'a' - 'a' && alphabetIdx != 'n' - 'a' && alphabetIdx != 't' - 'a' && alphabetIdx != 'i' - 'a' && alphabetIdx != 'c' - 'a') {
            ret = Math.max(ret, dfs(alphabetIdx + 1, k, mask));
        }
        return ret;
    }
    private static int count(int mask) {
        int cnt = 0;
        for (int word : words) {
            boolean isWordExsited = (word != 0); // 단어가 존재하는가?
            boolean isMaskCorrect = (word & mask) == word; // word와 mask끼리 and 연산을 했을 때 word가 나오면 mask에 있는 단어가 모두 존재한다는 의미를 가진다.
            if (isWordExsited && isMaskCorrect) {
                ++cnt;
            }
        }
        return cnt;
    }
}
