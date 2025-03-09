package b_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b_15649 {
    private static int N;
    private static int M;
    private static boolean lookupTable[];
    private static int selectedNumbers[];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        lookupTable = new boolean[N + 1];
        selectedNumbers = new int[M];
        recur(0);
        System.out.println(sb);
    }

    private static void recur(int m) {
        if (m < M) {
            for (int num = 1; num <= N; ++num) {
                if (lookupTable[num] == true) {
                    continue;
                }
                lookupTable[num] = true;
                selectedNumbers[m] = num;
                recur(m + 1);
                lookupTable[num] = false;
            }
        } else {
            for (int i = 0; i < selectedNumbers.length; ++i) {
                sb.append(selectedNumbers[i]).append(" ");
            }
            sb.append("\n");
        }
    }
}
