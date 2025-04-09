package b_10798;

import java.io.*;
public class b_10798 {
    private static int maxLen = Integer.MIN_VALUE;
    private static String[] strMap;
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        strMap = new String[5];
        for (int y = 0; y < 5; ++y) {
            strMap[y] = br.readLine();
            maxLen = Math.max(strMap[y].length(), maxLen);
        }
        map = new char[5][maxLen];
        for (int y = 0; y < strMap.length; ++y) {
            for (int x = 0; x < strMap[y].length(); ++x) {
                map[y][x] = strMap[y].charAt(x);
            }
        }
        for (int x = 0; x < maxLen; ++x) {
            for (int y = 0; y < 5; ++y) {
                if (map[y][x] == '\0') {
                    continue;
                }
                bw.write(map[y][x]);
            }
        }
        bw.flush();
        bw.close();
    }
}
