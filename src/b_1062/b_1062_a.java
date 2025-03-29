package b_1062;

import java.io.*;

public class b_1062_a {
    private static int n;
    private static int m;
    private static int[] words = new int[51];
    private static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        n = Integer.parseInt(conds[0]);
        m = Integer.parseInt(conds[1]);
        for (int i = 0; i < n; ++i) {
            String str = br.readLine(); // 단어를 집어넣는다
            for (char c : str.toCharArray()) {
                words[i] |= (1 << (c - 'a')); // a -> 1, b -> 10, c -> 100 ... 이런식으로 words에 집어넣는다.
            }
        }

        // k는 m..?
        int ret = go(0, m, 0);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
    }
    private static int go(int index, int k, int mask) {
        if (k < 0) {
            return 0;
        }
        if (index == 26) { // 여기서 index가 의미하는 것은? -> 영단어의 index (a == 0, b == 1 ...) 이런식으로
            return count(mask);
        }

        int ret = go(index + 1, k - 1, mask | (1 << index)); // 해당 영단어를 선택한 경우
        if (index != 'a' - 'a' && index != 'n' - 'a' && index != 't' - 'a' && index != 'i' - 'a' && index != 'c' - 'a') { // 이게 나온 이유는? -> 반드시 배우는 영단어이기 때문에, a,..
            ret = Math.max(ret, go(index + 1, k, mask)); // 해당 영단어를 선택하지 않는 경우
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
        return cnt; // mask에 맞는 숫자들의 총 수
    }
}
