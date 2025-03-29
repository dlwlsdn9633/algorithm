package b_1062;

import java.io.*;
import java.util.ArrayList;

public class b_1062 {
    private static int N;
    private static int K;
    private static ArrayList<Character> characters = new ArrayList<>();
    private static ArrayList<Character> basicCharacters = new ArrayList<>();
    private static ArrayList<String> strs = new ArrayList<>();
    private static boolean[] visited = new boolean[26];
    private static int maxValue = Integer.MIN_VALUE;
    private static int maxSelectedSize = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setStrs(br);

        if (K < 5) {
            bw.write(String.valueOf(0));
        } else {
            setVisited();
            for (int i = 0; i < (1 << characters.size()); ++i) {
                ArrayList<Character> selected = new ArrayList<>();
                for (int j = 0; j < characters.size(); ++j) {
                    if ((i & (1 << j)) != 0) {
                        selected.add(characters.get(j));
                    }
                }

                maxSelectedSize = Math.max(maxSelectedSize, selected.size());
                if (selected.size() == K - 5) {
                    setMaxValue(selected);
                }
            }

            if (maxSelectedSize < K - 5) {
                bw.write(String.valueOf(strs.size()));
            } else {
                bw.write(String.valueOf(maxValue));
            }
        }



        bw.flush();
        bw.close();
    }
    private static void setStrs(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        K = Integer.parseInt(conds[1]);

        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            strs.add(str);
        }
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        basicCharacters.add('a');
        basicCharacters.add('n');
        basicCharacters.add('t');
        basicCharacters.add('c');
        basicCharacters.add('i');
    }
    private static void setVisited() {
        for (String str : strs) {
            for (int i = 0; i < str.length(); ++i) {
                if (visited[str.charAt(i) - 'a']) {
                    continue;
                }
                visited[str.charAt(i) - 'a'] = true;
                characters.add(str.charAt(i));
            }
        }
    }
    private static void setMaxValue(ArrayList<Character> selected) {
        int value = 0;
        for (String str : strs) {
            boolean isAllContains = true;
            for (int strIdx = 0; strIdx < str.length(); ++strIdx) {
                if (basicCharacters.contains(str.charAt(strIdx))) {
                    continue;
                }
                if (selected.contains(str.charAt(strIdx)) == false) {
                    isAllContains = false;
                    break;
                }
            }
            if (isAllContains) {
                ++value;
            }
        }
        maxValue = Math.max(maxValue, value);
    }
}
