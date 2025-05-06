package b_17825;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class b_17825 {
    private static HashMap<Integer, ArrayList<Integer>> map;
    private static int[] scores = new int[35];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, Board board) {
        if (depth >= 10) {
            return;
        }
        for (int horseIdx = 0; horseIdx < 4; ++horseIdx) {
            if (map.get(board.horse[horseIdx]).size() == 2) {
                // 파란색으로 이동
                int nextMovePos = map.get(board.horse[horseIdx]).get(1);
                if (board.isExisted(nextMovePos)) {
                    continue;
                }
                Board nextBoard = new Board(board);
                nextBoard.horse[horseIdx] = nextMovePos;
                nextBoard.sum += board.sum + scores[nextMovePos];
                dfs(depth + 1, nextBoard);
            } else {
                // 검은색으로 이동
                int nextMovePos = map.get(board.horse[horseIdx]).get(0);
                if (board.isExisted(nextMovePos)) {
                    continue;
                }
                Board nextBoard = new Board(board);
                nextBoard.horse[horseIdx] = nextMovePos;
                nextBoard.sum += board.sum + scores[nextMovePos];
                dfs(depth + 1, nextBoard);
            }
        }
    }

    static class Board {
        int[] horse;
        int sum;

        public Board() {

        }
        public Board(Board board) {

        }
        boolean isExisted(int nextPos) {
            for (int horsePos : horse) {
                if (nextPos == horsePos) {
                    return true;
                }
            }
            return false;
        }
    }

}
