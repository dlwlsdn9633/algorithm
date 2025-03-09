package b_1629;

import java.util.Scanner;

public class b_1629 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");

        long A = Integer.valueOf(conds[0]);
        long B = Integer.valueOf(conds[1]);
        long C = Integer.valueOf(conds[2]);

        System.out.println(dfs(A, B, C));
    }

    private static long dfs(long A, long B, long C) {
        if (B == 1) {
            return (A % C);
        }

        if (B % 2 == 0) {
            return (dfs(A, B / 2, C) * dfs(A, B / 2, C)) % C;
        } else {
            return (A * dfs(A, B / 2, C) * dfs(A, B / 2, C)) % C;
        }

        /*
        if (B % 2 == 0) {
            return ((dfs(A, B / 2, C) % C) * (dfs(A, B / 2, C) % C)) % C;
        } else {
            return ((A % C) * (dfs(A, B / 2, C) % C) * (dfs(A, B / 2, C) % C)) % C;
        }
        */
    }
}
