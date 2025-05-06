package b_15683;

import java.io.*;
import java.util.*;

public class b_15683 {
    private static Board originBoard;
    private static int[][] dirs = {
            { +0, +1 },
            { -1, +0 },
            { +0, -1 },
            { +1, +0 }
    };
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        originBoard = new Board(br);
        Board newBoard = new Board(originBoard);
        dfs(0, newBoard);
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int cameraDepth, Board board) {
        if (cameraDepth == board.cameraList.size()) {
            board.draw();
            ret = Math.min(board.getEmptySpace(), ret);
            return;
        }

        Camera currentCamera = board.cameraList.get(cameraDepth);
        if (currentCamera.cameraType == 1) {
            for (int rotateIdx = 0; rotateIdx < 4; ++rotateIdx) {
                Board newBoard = new Board(board);
                newBoard.cameraList.get(cameraDepth).rotate = rotateIdx;
                dfs(cameraDepth + 1, newBoard);
            }
        } else if (currentCamera.cameraType == 2) {
            for (int rotateIdx = 0; rotateIdx < 2; ++rotateIdx) {
                Board newBoard = new Board(board);
                newBoard.cameraList.get(cameraDepth).rotate = rotateIdx;
                dfs(cameraDepth + 1, newBoard);
            }
        } else if (currentCamera.cameraType == 3) {
            for (int rotateIdx = 0; rotateIdx < 4; ++rotateIdx) {
                Board newBoard = new Board(board);
                newBoard.cameraList.get(cameraDepth).rotate = rotateIdx;
                dfs(cameraDepth + 1, newBoard);
            }
        } else if (currentCamera.cameraType == 4) {
            for (int rotateIdx = 0; rotateIdx < 4; ++rotateIdx) {
                Board newBoard = new Board(board);
                newBoard.cameraList.get(cameraDepth).rotate = rotateIdx;
                dfs(cameraDepth + 1, newBoard);
            }
        } else {
            for (int rotateIdx = 0; rotateIdx < 1; ++rotateIdx) {
                Board newBoard = new Board(board);
                newBoard.cameraList.get(cameraDepth).rotate = rotateIdx;
                dfs(cameraDepth + 1, newBoard);
            }
        }
    }
    static class Board {
        int R;
        int C;
        int map[][];
        List<Camera> cameraList;
        public Board(BufferedReader br) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            cameraList = new ArrayList<>();
            for (int r = 0; r < R; ++r) {
                String[] rows = br.readLine().split(" ");
                for (int c = 0; c < C; ++c) {
                    map[r][c] = Integer.parseInt(rows[c]);
                    if (map[r][c] >= 1 && map[r][c] <= 5) {
                        cameraList.add(
                                new Camera(r, c, map[r][c], 0)
                        );
                    }
                }
            }

        }
        public Board(Board board) {
            this.R = board.R;
            this.C = board.C;
            this.map = new int[board.R][board.C];
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    this.map[r][c] = board.map[r][c];
                }
            }
            this.cameraList = new ArrayList<>();
            for (Camera camera : board.cameraList) {
                Camera newCamera = new Camera(camera.r, camera.c, camera.cameraType, camera.rotate);
                cameraList.add(newCamera);
            }
        }
        public void draw() {
            for (Camera camera : cameraList) {
                if (camera.cameraType == 1) {
                    camera.straight(this, camera.rotate);
                } else if (camera.cameraType == 2) {
                    if (camera.rotate == 0) {
                        camera.straight(this, 0);
                        camera.straight(this, 2);
                    } else {
                        camera.straight(this, 1);
                        camera.straight(this, 3);
                    }
                } else if (camera.cameraType == 3) {
                    if (camera.rotate == 0) {
                        camera.straight(this, 0);
                        camera.straight(this, 1);
                    } else if (camera.rotate == 1) {
                        camera.straight(this, 1);
                        camera.straight(this, 2);
                    } else if (camera.rotate == 2) {
                        camera.straight(this, 2);
                        camera.straight(this, 3);
                    } else if (camera.rotate == 3) {
                        camera.straight(this, 3);
                        camera.straight(this, 0);
                    }
                } else if (camera.cameraType == 4) {
                    if (camera.rotate == 0) {
                        camera.straight(this, 0);
                        camera.straight(this, 1);
                        camera.straight(this, 2);
                    } else if (camera.rotate == 1) {
                        camera.straight(this, 1);
                        camera.straight(this, 2);
                        camera.straight(this, 3);
                    } else if (camera.rotate == 2) {
                        camera.straight(this, 2);
                        camera.straight(this, 3);
                        camera.straight(this, 0);
                    } else if (camera.rotate == 3) {
                        camera.straight(this, 3);
                        camera.straight(this, 0);
                        camera.straight(this, 1);
                    }
                } else {
                    camera.straight(this, 0);
                    camera.straight(this, 1);
                    camera.straight(this, 2);
                    camera.straight(this, 3);
                }
            }
        }

        public void printMap() {
            System.out.println();
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    System.out.print(map[r][c] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        public int getEmptySpace() {
            int sum = 0;
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (map[r][c] == 0) {
                        ++sum;
                    }
                }
            }
            return sum;
        }
    }
    static class Camera {
        int r;
        int c;
        int cameraType;
        int rotate;
        public Camera(int r, int c, int cameraType, int rotate) {
            this.r = r;
            this.c = c;
            this.cameraType = cameraType;
            this.rotate = rotate;
        }
        private void straight(Board board, int dir) {
            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(this.r, this.c));
            while (q.isEmpty() == false) {
                Pos currentPos = q.poll();
                int nextY = currentPos.r + dirs[dir][0];
                int nextX = currentPos.c + dirs[dir][1];
                if (nextY < 0 || nextX < 0 || nextY >= board.R || nextX >= board.C) {
                    continue;
                }
                if (board.map[nextY][nextX] == 6) {
                    continue;
                }
                if (board.map[nextY][nextX] >= 1 && board.map[nextY][nextX] <= 5) {
                    q.add(new Pos(nextY, nextX));
                } else {
                    board.map[nextY][nextX] = -1;
                    q.add(new Pos(nextY, nextX));
                }
            }
        }
    }

    static class Pos {
        int r;
        int c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
