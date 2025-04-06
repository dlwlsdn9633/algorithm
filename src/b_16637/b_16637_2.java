package b_16637;

import java.io.*;
import java.util.ArrayList;

public class b_16637_2 {
    private static int N;
    private static String str;
    private static ArrayList<Integer> numberList = new ArrayList<>();
    private static ArrayList<Character> operationList = new ArrayList<>();
    private static int ret = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numberList.add(str.charAt(i) - '0');
            } else {
                operationList.add(str.charAt(i));
            }
        }
        dfs(0, numberList.get(0));
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static void dfs(int here, int num) {
        // 종료 조건을 이렇게 설정한 이유?
        if (here >= numberList.size() - 1) {
            ret = Math.max(ret, num);
            return;
        }
        dfs(here + 1, getResult(operationList.get(here), num, numberList.get(here + 1)));
        if (here + 2 <= numberList.size() - 1) { // 세개의 항을 계산할 수 있는지 체크한다.
            int secondThirdCalc = getResult(operationList.get(here + 1), numberList.get(here + 1), numberList.get(here + 2));
            dfs(here + 2, getResult(operationList.get(here), num, secondThirdCalc));
        }
    }
    // getResult 에서 here은 operationList의 index를 의미한다.
    private static int getResult(char op, int num1, int num2) {
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
