package b_15650;

import java.util.Scanner;

public class b_15650 {
    private static boolean selectTable[];
    private static int selectedNumbers[];
    private static int N;
    private static int M;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        selectTable = new boolean[N + 1];
        selectedNumbers = new int[M];

        dfs(1, 0);
    }
    private static void dfs(int selectedNum, int depth) {
        if (depth >= M) {
            for (int i = 0; i < M; ++i) {
                System.out.print(selectedNumbers[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int num = selectedNum; num <= N; ++num) {
            selectedNumbers[depth] = num;
            dfs(num + 1, depth + 1);
        }
    }
}
