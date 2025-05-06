package b_17143;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_17143_a {
    private static final int MAX_N = 101;
    private static int[][] shark = new int[MAX_N][MAX_N];
    private static int[][] temp = new int[MAX_N][MAX_N];
    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { -1, 1, 0, 0 };
    private static int R;
    private static int C;
    private static int M;
    private static int ret;
    private static ArrayList<Shark> sharkList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        // t = 어부의 위치
        for (int fisherPos = 0; fisherPos < C; ++fisherPos) {
            catchShark(fisherPos);
            clearTemp();

            for (int m = 1; m <= M; ++m) {
                if (sharkList.get(m - 1).death) {
                    continue;
                }
                int y = sharkList.get(m - 1).y;
                int x = sharkList.get(m - 1).x;
                int s = sharkList.get(m - 1).s;
                int d = sharkList.get(m - 1).dir;
                int ny, nx;

                while (true) {
                    ny = y + s * dy[d];
                    nx = x + s * dx[d];
                    if (nx < C && ny < R && ny >= 0 && nx >= 0) {
                        break;
                    }
                    if (d <= 1) {
                        // 방향이 위, 아래인 경우
                        if (ny < 0) {
                            s -= y;             // speed를 남은 speed로 변경한다.
                            y = 0;              // y위치를 0으로 변경한다
                        } else {
                            s -= R - 1 - y;     // speed를 남은 speed로 변경한다.
                            y = R - 1;          // y위치를 1로 변경한다.
                        }
                    } else {
                        // 방향이 아래인 경우
                        if (nx < 0) {
                            s -= x;             // speed를 남은 speed로 변경한다.
                            x = 0;              // x위치를 0으로 변경한다.
                        } else {
                            s -= C - 1 - x;     // speed를 남은 speed로 변경한다.
                            x = C - 1;          // x 위치를 0으로 변경한다.
                        }
                    }
                    d ^= 1; // 방향이 변경되었으므로, XOR연산을 통해 direction을 수정한다.
                }

                if (temp[ny][nx] != 0) {
                    if (sharkList.get(temp[ny][nx] - 1).z < sharkList.get(m - 1).z) {
                        sharkList.get(temp[ny][nx] - 1).death = true;
                        temp[ny][nx] = m;
                    } else {
                        sharkList.get(m - 1).death = true;
                    }
                } else {
                    temp[ny][nx] = m;
                }

                sharkList.get(m - 1).y = ny;
                sharkList.get(m - 1).x = nx;
                sharkList.get(m - 1).dir = d;
            }
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    shark[r][c] = temp[r][c];
                }
            }
            //printMap();
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void clearTemp() {
        for (int r = 0; r < R; ++r) {
            Arrays.fill(temp[r], 0);
        }
    }

    private static void printMap() {
        System.out.println();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                System.out.print(shark[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void catchShark(int fisherPos) {
        for (int y = 0; y < R; ++y) {
            if (shark[y][fisherPos] != 0) {
                sharkList.get(shark[y][fisherPos] - 1).death = true;
                ret += sharkList.get(shark[y][fisherPos] - 1).z;
                shark[y][fisherPos] = 0;
                break;
            }
        }
    }

    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int m = 1; m <= M; ++m) {
            st = new StringTokenizer(br.readLine());
            sharkList.add(new Shark(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
            Shark insertedShark = sharkList.get(sharkList.size() - 1);
            insertedShark.y -= 1;
            insertedShark.x -= 1;
            insertedShark.dir -= 1;

            /**
             *  상어의 이동 속도를 맵 크기에 맞게 최적화
             *  상어는 이동 시 벽에 부딪히면 방향을 반대로 바꾸며 이동하기 때문에,
             *  일정 주기로 같은 위치로 돌아오게 된다.
             *  따라서 속도가 너무 큰 경우, 실제로 의미 있는 이동 거리만 남기기 위해
             *  위-아래 방향일 경우 2 * (R - 1), 좌-우 방향일 경우 2 * (C - 1)로 나눈 나머지를 사용한다.
             * */
            if (insertedShark.dir <= 1) {
                // 위, 아래인 경우
                insertedShark.s %= (2 * (R - 1));
            } else {
                // 왼쪽, 오른쪽인 경우
                insertedShark.s %= (2 * (C - 1));
            }
            shark[insertedShark.y][insertedShark.x] = m;
        }
    }
    static class Shark {
        int y;          // y
        int x;          // x
        int s;          // speed
        int dir;        // direction
        int z;          // size
        boolean death;
        public Shark(int y, int x, int s, int dir, int z) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.dir = dir;
            this.z = z;
            this.death = false;
        }
    }
}
