package b_4659;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class b_4659 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            if (str.equals("end")) {
                break;
            }
            boolean result = test(str);
            if (result) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }
        }

    }

    private static boolean test(String str) {
        char[] strArr = str.toCharArray();

        boolean isVowelExisted = false;

        Queue<StringElement> q = new ArrayDeque<>();

        // 1. a, e, i, o, u가 들어가있는지 확인하기
        for (char ele : strArr) {
            if (ele == 'a' || ele == 'e' || ele == 'i' || ele == 'o' || ele == 'u') {
                q.add(new StringElement(ele, true));
                isVowelExisted = true;
            } else {
                q.add(new StringElement(ele, false));
            }
        }

        if (isVowelExisted == false) {
            return isVowelExisted;
        }

        boolean isNotSequential = true;
        Queue<StringElement> q2 = new ArrayDeque<>();

        // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다.
        Stack<StringElement> t1Stack = new Stack<>();
        while (q.isEmpty() == false) {
            StringElement ele = q.poll();
            if (t1Stack.isEmpty()) {
                t1Stack.push(ele);
            } else {
                StringElement topEle = t1Stack.peek();
                if (topEle.isVowel == ele.isVowel) {
                    t1Stack.push(ele);
                } else {
                    t1Stack.clear();
                    t1Stack.push(ele);
                }
            }

            if (t1Stack.size() == 3) {
                isNotSequential = false;
                break;
            }
            q2.add(ele);
        }

        if (isNotSequential == false) {
            return isNotSequential;
        }

        boolean isNotDuplicated = true;
        Stack<StringElement> t2Stack = new Stack<>();
        while (q2.isEmpty() == false) {
            StringElement ele = q2.poll();
            if (t2Stack.isEmpty()) {
                t2Stack.push(ele);
            } else {
                StringElement topEle = t2Stack.peek();
                if (topEle.element == ele.element) {
                    if (ele.element == 'e' || ele.element == 'o') {
                        if (t2Stack.size() >= 3) {
                            StringElement firstPop = t2Stack.pop();
                            StringElement secondPop = t2Stack.pop();

                            if (secondPop.element == ele.element) {
                                isNotDuplicated = false;
                                break;
                            } else {
                                t2Stack.push(secondPop);
                                t2Stack.push(firstPop);
                                t2Stack.push(ele);
                            }
                        } else {
                            t2Stack.push(ele);
                        }
                    } else {
                        isNotDuplicated = false;
                        break;
                    }
                } else {
                    t2Stack.push(ele);
                }
            }
        }

        if (isNotDuplicated == false) {
            return isNotDuplicated;
        }

        return true;
    }

    static class StringElement {
        char element;
        boolean isVowel;
        public StringElement(char element, boolean isVowel) {
            this.element = element;
            this.isVowel = isVowel;
        }
    }
}
