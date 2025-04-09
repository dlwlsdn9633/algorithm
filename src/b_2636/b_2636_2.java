package b_2636;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class b_2636_2 {
    private static int R;
    private static int C;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Pos> nextMeltingPosQueue = new LinkedList<>();
    private static Queue<Pos> meltingPosQueue = new LinkedList<>();
    private static List<Integer> cheeseList = new ArrayList<>();
    private static int cheeseNumber = 0;
    private static int[][] dirs = {
            { +1, +0 },
            { -1, +0 },
            { +0, +1 },
            { +0, -1 }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setMap(br);

        int day = 0;
        visited[0][0] = true;
        meltingPosQueue.add(new Pos(0, 0));
        cheeseList.add(cheeseNumber);

        while (check() == false) {
            melt();
            cheeseList.add(cheeseNumber);
            qCopy();
            ++day;
        }
        
        bw.write(String.valueOf(day));
        bw.write("\n");
        if (cheeseList.size() >= 1) {
            bw.write(String.valueOf(cheeseList.get(cheeseList.size() - 2)));
        } else {
            bw.write(String.valueOf(cheeseList.get(0)));
        }
        bw.flush();
        bw.close();
    }
    private static void qCopy() {
        while (nextMeltingPosQueue.isEmpty() == false) {
            meltingPosQueue.add(nextMeltingPosQueue.poll());
        }
    }
    private static boolean check() {
        for (int y = 0; y < R; ++y) {
            for (int x = 0; x < C; ++x) {
                if (map[y][x] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void melt() {
        while (meltingPosQueue.isEmpty() == false) {
            Pos currentPos = meltingPosQueue.poll();
            for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                int ny = currentPos.y + dirs[dirIdx][0];
                int nx = currentPos.x + dirs[dirIdx][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = 0;
                    --cheeseNumber;
                    nextMeltingPosQueue.add(new Pos(ny, nx));
                    continue;
                }
                visited[ny][nx] = true;
                meltingPosQueue.add(new Pos(ny, nx));
            }
        }
    }
    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        map = new int[R][C];
        visited = new boolean[R][C];
        for (int y = 0; y < R; ++y) {
            String[] row = br.readLine().split(" ");
            for (int x = 0; x < row.length; ++x) {
                map[y][x] = Integer.parseInt(row[x]);
                if (map[y][x] == 1) {
                    ++cheeseNumber;
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
