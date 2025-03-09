package b_16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b_16637 {
    private static ArrayList<Integer> nums = new ArrayList<>();
    private static ArrayList<Character> opers = new ArrayList<>();
    private static int ret = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                nums.add(str.charAt(i) - '0');
            } else {
                opers.add(str.charAt(i));
            }
        }
        dfs(0, nums.get(0));
        System.out.println(ret);
    }
    private static void dfs(int here, int num) {
        if (here >= nums.size() - 1) {
            ret = Math.max(num, ret);
            return;
        }
        // 누적합을 이용해서 풀기
        // here는 계산이 모두 끝난 위치를 의미한다.
        // 첫 번째 요소와 두 번째 요소를 계산한 후 넘기기 -> here는 1이 된다.
        dfs(here + 1, getResult(opers.get(here), num, nums.get(here + 1)));
        // 첫 번째 요소와 두 번쨰 요소 그리고 세번 째 요소까지 모두 계산한 후에 넘기기 -> here은 2가 된다.
        if (here + 2 <= nums.size() - 1) { // 세번 째 요소가 없는 가능성이 있으므로, 이를 방지하기 위해 해당 조건을 넣어준다.
            int temp = getResult(opers.get(here + 1), nums.get(here + 1), nums.get(here + 2)); // 두 번째 요소와 세 번째 요소를 먼저 계산한다.
            dfs(here + 2, getResult(opers.get(here), num, temp)); // 첫 번째 요소와 (두번째 요소와 세번째 요소를 모두 계산한 요소)와 계산한다.
        }
    }
    private static int getResult(char a, int b, int c) {
        if (a == '+') {
            return b + c;
        } else if (a == '-') {
            return b - c;
        } else if (a == '*') {
            return b * c;
        }
        return 0;
    }
}
