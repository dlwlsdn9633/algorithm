package b_2798;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_2798 {
    private static int N;
    private static int M;
    private static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];

        String[] cardsArr = br.readLine().split(" ");
        for (int i = 0; i < cardsArr.length; ++i) {
            cards[i] = Integer.parseInt(cardsArr[i]);
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < cards.length; ++i) {
            for (int j = i + 1; j < cards.length; ++j) {
                for (int k = j + 1; k < cards.length; ++k) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M) {
                        ret = Math.max(ret, sum);
                    }
                }
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
