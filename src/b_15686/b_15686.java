package b_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b_15686 {
    private static int N;
    private static int M;
    private static int map[][];
    private static ArrayList<Pos> homes = new ArrayList<>();
    private static ArrayList<Pos> chickens = new ArrayList<>();
    private static ArrayList<Pos> selectedChickens = new ArrayList<>();
    private static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = bf.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        setMap(bf);
        dfs(-1, 0);
        System.out.println(minVal);
    }
    private static void dfs(int startIdx, int depth) {
        if (depth == M) {
            // 여기서 minChickenValue 구하기
            int chickenLen = getAllChickenLen();
            minVal = Math.min(chickenLen, minVal);
            return;
        }
        for (int i = startIdx + 1; i < chickens.size(); ++i) {
            selectedChickens.add(new Pos(chickens.get(i).y, chickens.get(i).x));
            dfs(i, depth + 1);
            selectedChickens.remove(selectedChickens.size() - 1);
        }
    }
    private static int getAllChickenLen() {
        int ret = 0;
        for (Pos home : homes) {
            int minLen = Integer.MAX_VALUE;
            for (Pos selectedChicken : selectedChickens) {
                int len = Math.abs(home.x - selectedChicken.x) + Math.abs(home.y - selectedChicken.y);
                minLen = Math.min(minLen, len);
            }
            ret += minLen;
        }
        return ret;
    }

    private static void setMap(BufferedReader bf) throws IOException {
        map = new int[N + 1][N + 1];
        for (int y = 1; y <= N; ++y) {
            String[] row = bf.readLine().split(" ");
            for (int x = 1; x <= N; ++x) {
                map[y][x] = Integer.parseInt(row[x - 1]);
                if (map[y][x] == 1) {
                    homes.add(new Pos(y, x));
                }
                if (map[y][x] == 2) {
                    chickens.add(new Pos(y, x));
                }
            }
        }
    }

    static class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
