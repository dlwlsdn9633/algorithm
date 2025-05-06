package b_2632;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b_2632 {
    private static int want;
    private static int sizeA;
    private static int sizeB;
    private static int[] pizzaA = new int[2002];
    private static int[] pizzaB = new int[2002];
    private static Map<Integer, Integer> mapA = new HashMap<>();
    private static Map<Integer, Integer> mapB = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);

        makeCombinations(mapA, sizeA, pizzaA);
        makeCombinations(mapB, sizeB, pizzaB);

        int ret = 0;
        if (mapA.get(want) != null) {
            ret += mapA.get(want);
        }
        if (mapB.get(want) != null) {
            ret += mapB.get(want);
        }
        for (int pizzaSize = 0; pizzaSize <= want; ++pizzaSize) {
            if (mapA.get(pizzaSize) != null && mapB.get(want - pizzaSize) != null) {
                ret += (mapA.get(pizzaSize) * mapB.get(want - pizzaSize));
            }
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void makeCombinations(Map<Integer, Integer> map, int pizzaSize, int[] pizza) {
        for (int interval = 0; interval < pizzaSize; ++interval) {
            for (int pizzaIdx = 0; pizzaIdx < pizzaSize; ++pizzaIdx) {
                int sum = 0;
                for (int startIdx = pizzaIdx; startIdx <= pizzaIdx + interval; ++startIdx) {
                    sum += pizza[startIdx];
                }
                if (map.get(sum) == null) {
                    map.put(sum, 0);
                }
                map.put(sum, map.get(sum) + 1);
                if (interval == pizzaSize - 1) {
                    break;
                }
            }
        }
    }

    private static void setConds(BufferedReader br) throws IOException {
        want = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sizeA = Integer.parseInt(st.nextToken());
        sizeB = Integer.parseInt(st.nextToken());
        setPizza(br, pizzaA, sizeA);
        setPizza(br, pizzaB, sizeB);
    }

    private static void setPizza(BufferedReader br, int[] pizza, int pizzaSize) throws IOException {
        for (int pizzaIdx = 0; pizzaIdx < pizzaSize; ++pizzaIdx) {
            int pieceSize = Integer.parseInt(br.readLine());
            pizza[pizzaIdx] = pizza[pizzaSize + pizzaIdx] = pieceSize;
        }
    }
}
