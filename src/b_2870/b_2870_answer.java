package b_2870;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class b_2870_answer {
    private static ArrayList<String> vec = new ArrayList<>();
    private static String ret = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < n; ++i) {
            String str = scanner.nextLine();
            ret = "";
            for (int j = 0; j < str.length(); ++j) {
                if (str.charAt(j) < 65) {
                    ret += str.charAt(j); // 숫자일 때, ret에 더하기
                } else if (ret.length() > 0) {
                    go();
                }
            }
            if (ret.length() > 0) {
                go();
            }
        }

        Collections.sort(vec, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    for (int i = 0; i < o1.length(); ++i) {
                        if (o1.charAt(i) < o2.charAt(i)) {
                            return -1;
                        } else if (o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        }
                    }
                    return 0;
                }
                return (o1.length() < o2.length()) ? -1 : 1;
            }
        });

        for (String num : vec) {
            System.out.println(num);
        }
    }



    // go는 ret에 쌓인 문자열에서 숫자를 뽑아내 vec에 집어넣는 함수
    private static void go() {
        int subIdx = 0;
        while (ret.length() > subIdx && ret.charAt(subIdx) == '0') {
            ++subIdx;
        }
        ret = ret.substring(subIdx, ret.length());
        if (ret.length() == 0) {
            ret = "0";
        }
        vec.add(ret);
        ret = "";
    }
}
