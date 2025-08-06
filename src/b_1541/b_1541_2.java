package b_1541;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  9-9+1+5
 *  0-8+22+4
 *  => 그 문제와 차이점은 뭘까?
 * */

public class b_1541_2 {
    private final static List<Integer> numberList = new ArrayList<>();
    private final static List<Character> opList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        setConds(input);
        int ret = dfs(0, numberList.get(0));
        bw.write(String.valueOf(ret));


        bw.flush();
        bw.close();
        br.close();
    }
    private static int dfs(int idx, int ret) {
        if (idx >= numberList.size() - 1) {
            return ret;
        }
        int ans = dfs(idx + 1, calc(ret, numberList.get(idx + 1), opList.get(idx)));
        if (idx < numberList.size() - 2) {
            int tmp = calc(numberList.get(idx + 1), numberList.get(idx + 2), opList.get(idx + 1));
            int ans2 = dfs(idx + 2, calc(ret, tmp, opList.get(idx)));
            ans = Math.min(ans, ans2);
        }
        return ans;
    }
    private static int calc(int num1, int num2, char op) {
        if (op == '+') {
            return num1 + num2;
        }
        return num1 - num2;
    }
    private static void setConds(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ele : input.toCharArray()) {
            if (ele == '+' || ele == '-') {
                numberList.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                opList.add(ele);
                continue;
            }
            sb.append(ele);
        }
        if (!"".equals(sb.toString())) {
            numberList.add(Integer.parseInt(sb.toString()));
        }
    }
}
