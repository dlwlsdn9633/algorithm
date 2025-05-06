package b_17143;

import java.io.*;
import java.util.*;

public class b_17143 {
    private static int R;
    private static int C;
    private static int M;
    private static int[][] map;
    private static int[][] nextMap;
    private static List<Shark> sharkList = new ArrayList<>();
    private static int fisherPos = 0;
    private static int ret = 0;
    private static Map<Pos, ArrayList<Shark>> posMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);


        for (int i = 0; i < C; ++i) {
            catchShark();
            sharksMove();
            eatThem();
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void eatThem() {
        for (Map.Entry<Pos, ArrayList<Shark>> entry : posMap.entrySet()) {
            Pos pos = entry.getKey();
            ArrayList<Shark> sharks = entry.getValue();
            if (sharks.size() <= 1) {
                continue;
            }
            sharks.sort((a, b) -> b.size - a.size);
            nextMap[pos.r][pos.c] = sharks.get(0).sharkNumber;
            for (int i = 1; i < sharks.size(); ++i) {
                sharks.get(i).isDead = true;
            }
        }
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                map[r][c] = nextMap[r][c];
            }
        }
        posMap.clear();
        for (int r = 0; r < R; ++r) {
            Arrays.fill(nextMap[r], 0);
        }
    }
    private static void catchShark() {
        Shark catchShark = null;
        for (Shark shark : sharkList) {
            if (shark.c != fisherPos || shark.isDead) {
                continue;
            }
            if (catchShark == null) {
                catchShark = shark;
            } else {
                if (catchShark.r > shark.r) {
                    catchShark = shark;
                }
            }
        }
        if (catchShark != null) {
            map[catchShark.r][catchShark.c] = 0;
            catchShark.isDead = true;
            ret += catchShark.size;
        }
        ++fisherPos;
    }

    private static void sharksMove() {
        for (Shark shark : sharkList) {
            if (shark.isDead) {
                continue;
            }
            moveShark(shark);
        }
    }

    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        nextMap = new int[R][C];
        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            sharkList.add(new Shark(
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    m + 1
            ));
            Shark insertedShark = sharkList.get(sharkList.size() - 1);
            map[insertedShark.r][insertedShark.c] = m + 1;
        }
    }

    private static void moveShark(Shark shark) {
        if (shark.isDead) {
            return;
        }
        if (shark.direction <= 2) {
            // 위, 아래
            int remainMove = (shark.speed) % ((R - 1) * 2);
            int currentRow = shark.r;
            for (int i = 0; i < remainMove; ++i) {
                if (currentRow == R - 1) {
                    currentRow = R - 2;
                    shark.direction = 1;
                } else if (currentRow == 0) {
                    currentRow = 1;
                    shark.direction = 2;
                } else {
                    if (shark.direction == 1) {
                        --currentRow;
                    } else {
                        ++currentRow;
                    }
                }
            }
            map[shark.r][shark.c] = 0;
            nextMap[currentRow][shark.c] = shark.sharkNumber;
            shark.r = currentRow;
            Pos sharkPos = new Pos(shark.r, shark.c);
            if (posMap.get(sharkPos) == null) {
                posMap.put(sharkPos, new ArrayList<>());
            }
            posMap.get(sharkPos).add(shark);
        } else {
            // 왼쪽, 오른쪽
            int remainMove = (shark.speed) % ((C - 1) * 2);
            int currentColumn = shark.c;
            for (int i = 0; i < remainMove; ++i) {
                if (currentColumn == C - 1) {
                    currentColumn = C - 2;
                    shark.direction = 4;
                } else if (currentColumn == 0) {
                    currentColumn = 1;
                    shark.direction = 3;
                } else {
                    if (shark.direction == 3) {
                        ++currentColumn;
                    } else {
                        --currentColumn;
                    }
                }
            }
            map[shark.r][shark.c] = 0;
            nextMap[shark.r][currentColumn] = shark.sharkNumber;
            shark.c = currentColumn;
            Pos sharkPos = new Pos(shark.r, shark.c);
            if (posMap.get(sharkPos) == null) {
                posMap.put(sharkPos, new ArrayList<>());
            }
            posMap.get(sharkPos).add(shark);
        }
    }


    private static void printMap() {
        System.out.println();
        for (int r = 0 ; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                System.out.print(map[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Pos {
        int r;
        int c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Pos pos = (Pos) object;
            return r == pos.r && c == pos.c;
        }
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    static class Shark {
        int r;
        int c;
        int speed;
        int direction;
        int size;
        boolean isDead;
        int sharkNumber;
        public Shark(
                int r,
                int c,
                int speed,
                int direction,
                int size,
                int sharkNumber
        ) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
            this.isDead = false;
            this.sharkNumber = sharkNumber;
        }
    }
}
