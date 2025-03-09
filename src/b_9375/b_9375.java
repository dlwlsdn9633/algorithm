package b_9375;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class b_9375 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T;
        T = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < T; ++t) {
            testcase(scanner);
        }

    }

    private static void testcase(Scanner scanner) {
        int N;
        Map<String, Integer> map = new HashMap<>();
        N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; ++i) {
            String[] line = scanner.nextLine().split(" ");
            if (map.get(line[1]) == null) {
                map.put(line[1], 1);
            } else {
                map.put(line[1], map.get(line[1]) + 1);
            }
        }

        long result = 1;
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            result = result * (map.get(key) + 1);
        }
        --result;
        System.out.println(result);
    }

}
