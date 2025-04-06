package b_5622;

import java.io.*;
import java.util.HashMap;

public class b_5622 {
    private static HashMap<Character, Integer> phoneMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (char c = 'A'; c <= 'C'; ++c) {
            phoneMap.put(c, 3);
        }
        for (char c = 'D'; c <= 'F'; ++c) {
            phoneMap.put(c, 4);
        }
        for (char c = 'G'; c <= 'I'; ++c) {
            phoneMap.put(c, 5);
        }
        for (char c = 'J'; c <= 'L'; ++c) {
            phoneMap.put(c, 6);
        }
        for (char c = 'M'; c <= 'O'; ++c) {
            phoneMap.put(c, 7);
        }
        for (char c = 'P'; c <= 'S'; ++c) {
            phoneMap.put(c, 8);
        }
        for (char c = 'T'; c <= 'V'; ++c) {
            phoneMap.put(c, 9);
        }
        for (char c = 'W'; c <= 'Z'; ++c) {
            phoneMap.put(c, 10);
        }
        String str = br.readLine();
        int ret = 0;
        for (char c : str.toCharArray()) {
            ret += phoneMap.get(c);
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
