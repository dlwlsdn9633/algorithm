package b_20920;

import java.io.*;
import java.util.*;

public class b_20920 {
    private static final Map<String, Integer> wordMap = new HashMap<>();
    private static List<String> wordList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; ++n) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        wordList = new ArrayList<>(wordMap.keySet());

        wordList.sort((word1, word2) -> {
            if (Objects.equals(wordMap.get(word1), wordMap.get(word2))) {
                if (word1.length() == word2.length()) {
                    return word1.compareTo(word2);
                }
                return word2.length() - word1.length();
            }
            return wordMap.get(word2) - wordMap.get(word1);
        });

        for (String word : wordList) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
