package b_14889;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class b_14889 {
    private static int N;
    private static int[][] ability;
    private static List<Integer> startList = new ArrayList<>();
    private static List<Integer> linkList = new ArrayList<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setAbility(br);
        for (int bitNumber = 0; bitNumber < (1 << N); ++bitNumber) {
            for (int bitIdx = 0; bitIdx < N; ++bitIdx) {
                if ((bitNumber & (1 << bitIdx)) != 0) {
                    startList.add(bitIdx);
                } else {
                    linkList.add(bitIdx);
                }
            }
            if (startList.size() == linkList.size()) {
                int startListSum = getSum(startList);
                int linkListSum = getSum(linkList);
                pq.add(Math.abs(startListSum - linkListSum));
            }
            startList.clear();
            linkList.clear();
        }
        bw.write(String.valueOf(pq.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
    private static int getSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < list.size(); ++j) {
                sum += (ability[list.get(i)][list.get(j)] + ability[list.get(j)][list.get(i)]);
            }
        }
        return sum / 2;
    }

    private static void setAbility(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        for (int n = 0; n < N; ++n) {
            String[] row = br.readLine().split(" ");
            for (int r = 0; r < row.length; ++r) {
                ability[n][r] = Integer.parseInt(row[r]);
            }
        }
    }


}
