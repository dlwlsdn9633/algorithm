package b_16637;

import java.io.*;
import java.util.ArrayList;

// 차근차근 함수를 풀어가면서 풀기
public class b_16637_3 {
    private static int N;
    private static ArrayList<Integer> numList = new ArrayList<>();
    private static ArrayList<Character> opList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setList(br);
        int ret = dfs(0, numList.get(0));
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static int dfs(int here, int ret) {
        if (here >= numList.size() - 1) {
            return ret;
        }
        int ans = dfs(here + 1, calc(ret, numList.get(here + 1), opList.get(here)));
        if (here < numList.size() - 2) {
            int tmp = calc(numList.get(here + 1), numList.get(here + 2), opList.get(here + 1));
            int ans2 = dfs(here + 2, calc(ret, tmp, opList.get(here)));
            ans = Math.max(ans2, ans);
        }
        return ans;
    }

    private static void setList(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numList.add(c - '0');
            } else {
                opList.add(c);
            }
        }
    }
    private static int calc(int num1, int num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return 0;
    }
}
