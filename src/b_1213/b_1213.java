package b_1213;

import java.util.Scanner;

public class b_1213 {
    private static int alps[] = new int[26];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        char[] nameArr = name.toCharArray();

        for (int i = 0; i < nameArr.length; ++i) {
            int alpIdx = Integer.valueOf(nameArr[i] - 'A');
            ++alps[alpIdx];
        }

        int oddNumber = 0;
        for (int i = 0; i < alps.length; ++i) {
            if (alps[i] % 2 != 0) {
                ++oddNumber;
            }
        }

        if (oddNumber >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            int answerIdx = 0;
            char[] answer = new char[name.length()];

            for (int i = 0; i < alps.length; ++i) {
                if (alps[i] % 2 == 0) {
                    for (int j = 0; j < alps[i] / 2; ++j) {
                        answer[answerIdx] = (char)(i + 'A');
                        answer[nameArr.length - 1 - answerIdx] = (char)(i + 'A');
                        ++answerIdx;
                    }
                } else {
                    for (int j = 0; j < alps[i] / 2; ++j) {
                        answer[answerIdx] = (char)(i + 'A');
                        answer[nameArr.length - 1 - answerIdx] = (char)(i + 'A');
                        ++answerIdx;
                    }
                    answer[answer.length / 2] = (char)(i + 'A');

                }
            }

            System.out.println(answer);
        }
    }
}
