package b_15818;

import java.util.Scanner;

public class b_15818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cond = scanner.nextLine().split(" ");
        int N = Integer.valueOf(cond[0]);
        long M = Long.valueOf(cond[1]);


        long arr[] = new long[N];
        String[] str = scanner.nextLine().split(" ");
        for (int i = 0; i < str.length; ++i) {
            arr[i] = Long.valueOf(str[i]);
        }

        long ret = 1;
        for (int i = 0; i < arr.length; ++i) {
            ret = (ret * arr[i]) % M;
        }
        System.out.println(ret);
    }
}
