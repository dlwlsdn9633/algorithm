package b_1062;

import java.io.*;

// 워메 비트마스킹으로 하니 더 빠르게 문제를 해결하네...
public class b_1062_a_2 {
    private static int N; // 단어의 갯수
    private static int K; // 배워야 할 단어의 수
    private static int[] words = new int[51]; // 영어 단어 모음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);
        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                words[i] |= (1 << (c - 'a')); // 영어 단어를 저장할 때, 비트 마스킹으로 저장한다.
            }
        }
        int ret = go(0, K, 0);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
    private static int go(int index, int k, int mask) {
        if (k < 0) {
            return 0;
        }
        if (index == 26) { // 일단 전부 다 영단어를 훑어봤다면
            return count(mask);
        }

        int ret = go(index + 1, k - 1, mask | (1 << index)); // 현재 영단어를 선택한 경우
        if (index != 'a' - 'a' && index != 'n' - 'a' && index != 't' - 'a' && index != 'i' - 'a' && index != 'c' - 'a') {
            ret = Math.max(ret, go(index + 1, k, mask)); // 현재 영단어를 선택하지 않는 경우
        }
        return ret;
    }
    private static int count(int mask) {
        int cnt = 0;
        for (int word : words) {
            if ((word != 0) && ((word & mask) == word)) {
                ++cnt;
            }
        }
        return cnt;
    }
}
