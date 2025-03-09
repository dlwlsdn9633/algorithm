package b_2870;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class b_2870 {
    private static ArrayList<String> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        for (int n = 0; n < N; ++n) {
            String str = scanner.nextLine();
            test(str);
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) {
                    for (int i = 0; i < o1.length(); ++i) {
                        if (o2.charAt(i) > o1.charAt(i)) {
                            return -1;
                        } else if(o2.charAt(i) < o1.charAt(i)) {
                            return 1;
                        }
                    }
                    return 0;
                }
                return (o2.length() > o1.length() ? -1 : 1);
            }
        });

        for (int i = 0; i < arr.size(); ++i) {
            System.out.println(arr.get(i));
        }


    }
    private static void test(String str) {
        String number = "";
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (isNumber(c)) {
                number += c;
            } else {
                if (number.length() > 0) {
                    int subIdx = 0;
                    while (subIdx < number.length() && number.charAt(subIdx) == '0') {
                        ++subIdx;
                    }
                    number = number.substring(subIdx, number.length());
                    if (number.length() == 0) {
                        number = "0";
                    }
                    arr.add(number);
                    number = "";
                }
            }
        }

        if (number.length() > 0) {
            int subIdx = 0;
            while (subIdx < number.length() && number.charAt(subIdx) == '0') {
                ++subIdx;
            }
            number = number.substring(subIdx, number.length());
            if (number.length() == 0) {
                number = "0";
            }
            arr.add(number);
            number = "";
        }
    }

    private static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }
}
