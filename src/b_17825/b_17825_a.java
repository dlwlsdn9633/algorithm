package b_17825;

import java.io.*;
import java.util.*;

public class b_17825_a {
    private static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    private static int[] horsePoses = new int[4];
    private static int[] dices = new int[10];
    private static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap();
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < 10; ++i) {
            dices[i] = Integer.parseInt(conds[i]);
        }
        int ret = dfs(0);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int depth) {
        if (depth == 10) {
            return 0;
        }
        int ret = 0;
        for (int horseIdx = 0; horseIdx < 4; ++horseIdx) {
            int currentHorsePos = horsePoses[horseIdx];
            int nextHorsePos = move(currentHorsePos, dices[depth]);
            if (isExisted(nextHorsePos, horseIdx)) {
                continue;
            }
            horsePoses[horseIdx] = nextHorsePos;
            ret = Math.max(ret, dfs(depth + 1) + scores[nextHorsePos]);
            horsePoses[horseIdx] = currentHorsePos;
        }
        return ret;
    }
    private static int move(int here, int cnt) {
        if (here == 100) {
            return 100;
        }
        if (map.get(here).size() >= 2) {
            here = map.get(here).get(1);
            --cnt;
        }
        if (cnt != 0) {
            Queue<Integer> q = new LinkedList<>();
            int there = 0;
            q.add(here);
            while (q.isEmpty() == false) {
                int currentPos = q.poll();
                there = map.get(currentPos).get(0);
                q.add(there);

                --cnt;
                if (there == 100) {
                    break;
                }
                if (cnt == 0) {
                    break;
                }
            }
            return there;
        } else {
            return here;
        }
    }

    private static boolean isExisted(int nextPos, int horseIdx) {
        if (nextPos == 100) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            if (horseIdx == i) {
                continue;
            }
            if (nextPos == horsePoses[i]) {
                return true;
            }
        }
        return false;
    }

    private static void setMap() {
        for (int node = 0; node < 32; ++node) {
            map.put(node, new ArrayList<>());
        }
        for (int node = 0; node < 20; ++node) {
            map.get(node).add(node + 1);
        }
        map.get(20).add(100);
        map.get(5).add(21);
        map.get(21).add(22);
        map.get(22).add(23);
        map.get(23).add(24);
        map.get(10).add(25);
        map.get(25).add(26);
        map.get(26).add(24);
        map.get(15).add(27);
        map.get(27).add(28);
        map.get(28).add(29);
        map.get(29).add(24);
        map.get(24).add(30);
        map.get(30).add(31);
        map.get(31).add(20);

        scores = new int[101];
        scores[1] = 2;
        scores[2] = 4;
        scores[3] = 6;
        scores[4] = 8;
        scores[5] = 10;
        scores[6] = 12;
        scores[7] = 14;
        scores[8] = 16;
        scores[9] = 18;
        scores[10] = 20;
        scores[11] = 22;
        scores[12] = 24;
        scores[13] = 26;
        scores[14] = 28;
        scores[15] = 30;
        scores[16] = 32;
        scores[17] = 34;
        scores[18] = 36;
        scores[19] = 38;
        scores[20] = 40;
        scores[21] = 13;
        scores[22] = 16;
        scores[23] = 19;
        scores[24] = 25;
        scores[25] = 22;
        scores[26] = 24;
        scores[27] = 28;
        scores[28] = 27;
        scores[29] = 26;
        scores[30] = 30;
        scores[31] = 35;
    }
}
