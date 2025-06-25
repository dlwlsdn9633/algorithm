package b_26069;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b_26069 {
    private static Map<String, Boolean> personMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a1 = st.nextToken();
            String b1 = st.nextToken();

            personMap.computeIfAbsent(a1, k -> false);
            personMap.computeIfAbsent(b1, k -> false);

            if ("ChongChong".equals(a1) || "ChongChong".equals(b1)) {
                personMap.put(a1, true);
                personMap.put(b1, true);
            }

            if (personMap.get(a1) || personMap.get(b1)) {
                personMap.put(a1, true);
                personMap.put(b1, true);
            }
        }

        int ret = 0;
        for (Map.Entry<String, Boolean> ele : personMap.entrySet()) {
            if (ele.getValue()) {
                ++ret;
            }
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
}
