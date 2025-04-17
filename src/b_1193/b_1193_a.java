package b_1193;


import java.util.Scanner;

public class b_1193_a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int floor = 1; // 몇 번째 층에 있을까?
        while (number - floor > 0) {
            number -= floor;
            ++floor;
        }
        
        int box = number; // 몇 번째 박스
        int hap = floor + 1;

        int a = 0; // 분모
        int b = 0; // 분자

        // 홀수층
        if (floor % 2 == 1) {
            a = box;
            b = hap - box;
        }
        // 짝수층
        if (floor % 2 == 0) {
            b = box;
            a = hap - box;
        }

        System.out.println(b + "/" + a);
    }
}
