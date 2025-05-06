package b_17406;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


// 더 효율적으로 행렬을 돌리는 방법은 없을까?
public class b_17406 {
    private static int N;
    private static int M;
    private static int K;
    private static int[][] matrix;
    private static int[][] rotatedMatrix;
    private static List<RotateInfo> rotateInfoList = new ArrayList<>();
    private static boolean[] visited;
    private static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);

        dfs(0, matrix);
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void dfs(int depth, int[][] m) {
        if (depth == K) {
            ret = Math.min(ret, getMin(m));
            return;
        }
        for (int i = 0; i < rotateInfoList.size(); ++i) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int[][] copyM = rotate(rotateInfoList.get(i), m);
            dfs(depth + 1, copyM);
            visited[i] = false;
        }
    }

    private static void setConds(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        rotatedMatrix = new int[N][M];
        visited = new boolean[K];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; ++c) {
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < K; ++k) {
            st = new StringTokenizer(br.readLine());
            rotateInfoList.add(new RotateInfo(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }
    }
    private static int[][] rotate(RotateInfo rotateInfo, int[][] m) {
        int[][] rotatedMatrix = new int[N][M];
        int[][] matrix = new int[N][M];
        for (int r = 0; r < N; ++r) {
            Arrays.fill(rotatedMatrix[r], 0);
        }
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                matrix[r][c] = m[r][c];
            }
        }
        // get startPos, endPos
        Pos startPos = new Pos(
                rotateInfo.pivotR - rotateInfo.diff - 1,
                rotateInfo.pivotC - rotateInfo.diff - 1
        );
        Pos endPos = new Pos(
                rotateInfo.pivotR + rotateInfo.diff - 1,
                rotateInfo.pivotC + rotateInfo.diff - 1
        );

        int pivotCol = 0;
        int pivotRow = 0;
        while (pivotCol <= (endPos.c - startPos.c) / 2) {
            for (int col = pivotCol; col < endPos.c - startPos.c - pivotCol; ++col) {
                rotatedMatrix[startPos.r + pivotRow][startPos.c + col + 1] = m[startPos.r + pivotRow][startPos.c + col];
                rotatedMatrix[endPos.r - pivotRow][endPos.c - 1 - col] = m[endPos.r - pivotRow][endPos.c - col];
            }
            for (int row = pivotRow; row < endPos.r - startPos.r - pivotRow; ++row) {
                rotatedMatrix[startPos.r + row + 1][endPos.c - pivotCol] = m[startPos.r + row][endPos.c - pivotCol];
                rotatedMatrix[endPos.r - 1 - row][startPos.c + pivotCol] = m[endPos.r - row][startPos.c + pivotCol];
            }
            ++pivotCol;
            ++pivotRow;
        }
        // copy matrix
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                if (rotatedMatrix[r][c] != 0) {
                    matrix[r][c] = rotatedMatrix[r][c];
                }
            }
        }
        // clear rotated matrix
        for (int r = 0; r < N; ++r) {
            Arrays.fill(rotatedMatrix[r], 0);
        }
        return matrix;
    }
    private static int getMin(int[][] matrix) {
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            sum = Math.min(sum, Arrays.stream(matrix[i]).sum());
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
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
    static class RotateInfo {
        int pivotR;
        int pivotC;
        int diff;
        public RotateInfo(int pivotR, int pivotC, int diff) {
            this.pivotR = pivotR;
            this.pivotC = pivotC;
            this.diff = diff;
        }
    }
}
