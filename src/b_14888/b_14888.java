package b_14888;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class b_14888 {
    private static int N;
    private static List<Integer> numbers = new ArrayList<>();
    private static List<Integer> operationList = new ArrayList<>();
    private static int[] operations = new int[4];
    private static int retMax = Integer.MIN_VALUE;
    private static int retMin = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);
        dfs(0);
        bw.write(String.valueOf(retMax));
        bw.newLine();
        bw.write(String.valueOf(retMin));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int depth) {
        if (depth >= N - 1) {
            int ret = numbers.get(0);
            for (int i = 1; i < numbers.size(); ++i) {
                ret = calc(ret, numbers.get(i), operationList.get(i - 1));
            }
            retMax = Math.max(ret, retMax);
            retMin = Math.min(ret, retMin);
            return;
        }
        for (int i = 0; i < operations.length; ++i) {
            if (operations[i] == 0) {
                continue;
            }
            operationList.add(i);
            --operations[i];
            dfs(depth + 1);
            operationList.remove(operationList.size() - 1);
            ++operations[i];
        }
    }

    private static int calc(int ret, int next, int op) {
        switch (op) {
            case 0:
                return ret + next;
            case 1:
                return ret - next;
            case 2:
                return ret * next;
            case 3:
                return ret / next;
        }
        return 0;
    }


    private static void setConds(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] conds = br.readLine().split(" ");
        for (String cond : conds) {
            numbers.add(Integer.parseInt(cond));
        }
        String[] opConds = br.readLine().split(" ");
        for (int i = 0; i < opConds.length; ++i) {
            operations[i] = Integer.parseInt(opConds[i]);
        }
    }
}
