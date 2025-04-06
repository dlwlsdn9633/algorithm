package b_1316;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class b_1316 {
    private static boolean[] visited = new boolean[26];
    private static ArrayList<String> strList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            String str = br.readLine();
            strList.add(str);
        }

        int ret = 0;
        for (String str : strList) {
            boolean isSequential = isSequentialWord(str);
            if (isSequential) {
                ++ret;
            }
            Arrays.fill(visited, false);
        }

        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    private static boolean isSequentialWord(String str) {
        visited[str.charAt(0) - 'a'] = true;
        for (int i = 0; i < str.length() - 1; ++i) {
            char currentChar = str.charAt(i);
            char nextChar = str.charAt(i + 1);
            if (currentChar == nextChar) {
                if (visited[currentChar - 'a'] == false) {
                    visited[currentChar - 'a'] = true;
                }
            } else {
                if (visited[nextChar - 'a']) {
                    return false;
                }
                visited[nextChar - 'a'] = true;
            }
        }
        return true;
    }
}
