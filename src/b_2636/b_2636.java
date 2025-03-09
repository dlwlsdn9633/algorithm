package b_2636;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class b_2636 {
    private static int map[][];
    private static boolean visited[][];
    private static ArrayList<Pos> startPositions = new ArrayList<>();
    private static ArrayList<Pos> zeroCheese = new ArrayList<>();
    private static int width;
    private static int height;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");
        height = Integer.valueOf(conds[0]);
        width = Integer.valueOf(conds[1]);

        map = new int[height][width];
        visited = new boolean[height][width];

        int ret = 0;
        int prev = 0;
        setMap(scanner);

        if (isEmptyMap() == false) {
            while (true) {
                destroyCheese();
                int zeroCheeseSize = zeroCheese.size();
                if (zeroCheeseSize == 0) {
                    break;
                } else {
                    prev = zeroCheeseSize;
                    for (Pos pos : zeroCheese) {
                        map[pos.y][pos.x] = 0;
                    }
                    ++ret;
                    clearAll();
                }
            }
        }
        System.out.println(ret);
        System.out.println(prev);
    }

    private static void destroyCheese() {
        Queue<Pos> q = new ArrayDeque<>();
        for (Pos startPos : startPositions) {
            q.add(startPos);
        }
        while (q.isEmpty() == false) {
            Pos c = q.poll();
            if (c.y < 0 || c.x < 0 || c.y >= height || c.x >= width) {
                continue;
            }
            if (visited[c.y][c.x] == true) {
                continue;
            }
            visited[c.y][c.x] = true;
            if (map[c.y][c.x] == 1) {
                zeroCheese.add(new Pos(c.y, c.x));
            } else {
                int[][] dirs = {
                        { -1, +0 },
                        { +0, -1 },
                        { +1, +0 },
                        { +0, +1 }
                };
                for (int i = 0; i < 4; ++i) {
                    int dy = dirs[i][0];
                    int dx = dirs[i][1];
                    int ny = c.y + dy;
                    int nx = c.x + dx;

                    if (ny < 0 || nx < 0 || ny >= height || nx >= width) {
                        continue;
                    }

                    if (visited[c.y + dy][c.x + dx] == true) {
                        continue;
                    }
                    q.add(new Pos(c.y + dy, c.x + dx));
                }
            }
        }
    }

    private static void clearAll() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                visited[y][x] = false;
            }
        }
        zeroCheese.clear();
    }

    private static int getCheeseNumber() {
        int sum = 0;
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (map[y][x] == 1) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    private static boolean isEmptyMap() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                if (map[y][x] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void setMap(Scanner scanner) {
        for (int y = 0; y < height; ++y) {
            String[] row = scanner.nextLine().split(" ");
            for (int x = 0; x < row.length; ++x) {
                map[y][x] = Integer.valueOf(row[x]);
                visited[y][x] = false;
            }
        }
        setStartPositions();
    }

    private static void setStartPositions() {
        for (int y = 0; y < height; ++y) {
            startPositions.add(new Pos(y, 0));
            startPositions.add(new Pos(y, width - 1));
        }
        for (int x = 0; x < width; ++x) {
            startPositions.add(new Pos(0, x));
            startPositions.add(new Pos(height - 1, x));
        }

    }


    private static void printMap() {
        System.out.println();
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                System.out.print(map[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Pos {
        public int y;
        public int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
