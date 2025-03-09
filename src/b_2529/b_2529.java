package b_2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_2529 {
    private static long minValue = Long.MAX_VALUE;
    private static long maxValue = Long.MIN_VALUE;
    private static char[] inequality;
    private static boolean[] visited = new boolean[10];
    private static String minValueStr = null;
    private static String maxValueStr = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String str = br.readLine();
        str = " " + str + " ";
        inequality = str.toCharArray();
        Arrays.fill(visited, false);

        for (int num = 0; num <= 9; ++num) {
            visited[num] = true;
            inequality[0] = (char)(num + '0');
            dfs(2);
            visited[num] = false;
        }

        System.out.println(maxValueStr);
        System.out.println(minValueStr);
    }
    private static void dfs(int depth) {
        if (depth > inequality.length) {
            String num = "";
            for (int i = 0; i <= (inequality.length / 2); ++i) {
                int numIdx = (i * 2);
                num += inequality[numIdx];
            }
            if (maxValue < Long.valueOf(num)) {
                maxValue = Math.max(maxValue, Long.valueOf(num));
                maxValueStr = num;
            }
            if (minValue > Long.valueOf(num)) {
                minValue = Math.min(minValue, Long.valueOf(num));
                minValueStr = num;
            }
            return;
        }
        for (int num = 0; num <= 9; ++num) {
            if (visited[num] == true) {
                continue;
            }
            inequality[depth] = (char)(num + '0');
            if (checkInequality(depth) == false) {
                continue;
            }
            visited[num] = true;
            dfs(depth + 2);
            visited[num] = false;
        }
    }

    private static boolean checkInequality(int depth) {
        int b = inequality[depth] - '0';
        char op = inequality[depth - 1];
        int a = inequality[depth - 2] - '0';
        if (op == '>') {
            return a > b;
        } else if (op == '<') {
            return a < b;
        }
        return false;
    }
}
