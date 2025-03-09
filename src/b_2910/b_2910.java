package b_2910;

import java.lang.reflect.Array;
import java.util.*;

public class b_2910 {
    // map의 Key는 숫자, Value는 나온 빈도
    private static Map<Integer, Integer> map = new HashMap<>();
    // firstMap의 Key는 숫자, Value는 순서
    private static Map<Integer, Integer> firstMap = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");

        int N = Integer.valueOf(conds[0]);
        int C = Integer.valueOf(conds[1]);

        String[] numbers = scanner.nextLine().split(" ");

        int firstIdx = 0;
        for (String number : numbers) {
            int num = Integer.valueOf(number);
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (firstMap.get(num) == null) {
                firstMap.put(num, firstIdx);
            }
            ++firstIdx;
        }

        ArrayList<Element> vec = new ArrayList<>();
        for (Integer key : map.keySet()) {
            vec.add(new Element(map.get(key), key));
        }

        Collections.sort(vec, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if (o1.quantity == o2.quantity) {
                    return firstMap.get(o1.number).compareTo(firstMap.get(o2.number));
                }
                return o2.quantity - o1.quantity;
            }
        });

        for (Element ele : vec) {
            int quantity = ele.quantity;
            int number = ele.number;
            for (int i = 0; i < quantity; ++i) {
                System.out.print(number + " ");
            }
        }
    }

    static class Element {
        int quantity;
        int number;
        public Element(int quantity, int number) {
            this.quantity = quantity;
            this.number = number;
        }
    }
}
