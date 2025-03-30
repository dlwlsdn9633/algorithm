package b_4179;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b_4179_2 {
    private static int R;
    private static int C;
    private static boolean isEdgeNow = false;
    private static char[][] map;
    private static int[][] fireMoveMap;
    private static int[][] personMoveMap;
    private static Queue<Pos> fireQ = new LinkedList<>();
    private static Queue<Pos> personQ = new LinkedList<>();
    private static Queue<Pos> finalPosQ = new LinkedList<>();
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

        if (isEdgeNow) {
            bw.write("1");
        } else {
            setFireMoveMap();
            setPersonMoveMap();
            int ret = Integer.MAX_VALUE;
            while (finalPosQ.isEmpty() == false) {
                Pos exitPos = finalPosQ.poll();
                if (personMoveMap[exitPos.y][exitPos.x] == Integer.MAX_VALUE) {
                    continue;
                }
                if (fireMoveMap[exitPos.y][exitPos.x] > personMoveMap[exitPos.y][exitPos.x]) {
                    ret = Math.min(personMoveMap[exitPos.y][exitPos.x], ret);
                }
            }
            if (ret == Integer.MAX_VALUE) {
                bw.write("IMPOSSIBLE");
            } else {
                ret += 1;
                bw.write(String.valueOf(ret));
            }
        }

        bw.flush();
        bw.close();
    }

    private static void setMap(BufferedReader br) throws IOException {
        String[] conds = br.readLine().split(" ");
        R = Integer.parseInt(conds[0]);
        C = Integer.parseInt(conds[1]);
        map = new char[R][C];
        fireMoveMap = new int[R][C];
        personMoveMap = new int[R][C];
        for (int r = 0; r < R; ++r) {
            Arrays.fill(fireMoveMap[r], Integer.MAX_VALUE);
            Arrays.fill(personMoveMap[r], Integer.MAX_VALUE);
        }
        for (int r = 0; r < R; ++r) {
            String row = br.readLine();
            for (int c = 0; c < row.length(); ++c) {
                map[r][c] = row.charAt(c);
                if (map[r][c] == 'J') {
                    personMoveMap[r][c] = 0;
                    personQ.add(new Pos(r, c));
                }
                if (map[r][c] == 'F') {
                    fireMoveMap[r][c] = 0;
                    fireQ.add(new Pos(r, c));
                }
                if (r == 0 || r == R - 1 || c == 0 || c == C - 1) {
                    if (map[r][c] == '.') {
                        finalPosQ.add(new Pos(r, c));
                    }
                    if (map[r][c] == 'J') {
                        isEdgeNow = true;
                    }
                }
            }
        }
    }
    private static void setPersonMoveMap() {
        while (personQ.isEmpty() == false) {
            Pos personPos = personQ.poll();
            for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                int ny = personPos.y + dirs[dirIdx][0];
                int nx = personPos.x + dirs[dirIdx][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >=C) {
                    continue;
                }
                if (map[ny][nx] == '#') {
                    continue;
                }
                if (personMoveMap[ny][nx] <= personMoveMap[personPos.y][personPos.x] + 1) {
                    continue;
                }
                personMoveMap[ny][nx] = personMoveMap[personPos.y][personPos.x] + 1;
                personQ.add(new Pos(ny, nx));
            }
        }
    }
    private static void setFireMoveMap() {
        while (fireQ.isEmpty() == false) {
            Pos firePos = fireQ.poll();
            for (int dirIdx = 0; dirIdx < 4; ++dirIdx) {
                int ny = firePos.y + dirs[dirIdx][0];
                int nx = firePos.x + dirs[dirIdx][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
                    continue;
                }
                if (map[ny][nx] == '#') {
                    continue;
                }
                if (fireMoveMap[ny][nx] <= fireMoveMap[firePos.y][firePos.x] + 1) {
                    continue;
                }
                fireMoveMap[ny][nx] = fireMoveMap[firePos.y][firePos.x] + 1;
                fireQ.add(new Pos(ny, nx));
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
