package b_2588;

import java.io.*;

public class b_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int mul = num1 * num2;

        while (num2 != 0) {
            int remainder = num2 % 10;
            int ret = num1 * remainder;
            System.out.println(ret);
            num2 /= 10;
        }
        System.out.println(mul);
    }
}
