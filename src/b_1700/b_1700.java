package b_1700;

import java.io.*;
import java.util.*;

public class b_1700 {
    private static int N;
    private static int K;
    private static int[] arr;
    private static List<Integer> list = new LinkedList<>();
    private static int ret;
    private static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.rank - a.rank);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Initialize Status
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        String[] conds = br.readLine().split(" ");
        for (int i = 0; i < conds.length; ++i) {
            arr[i] = Integer.parseInt(conds[i]);
        }
        for (int i = 0; i < arr.length; ++i) {
            if (list.contains(arr[i])) {
                continue;
            }
            if (list.size() < N) {
                list.add(arr[i]);
                continue;
            }
            setPq(i);
            Node popNode = pq.poll();
            ++ret;
            list.remove(list.indexOf(popNode.value));
            list.add(arr[i]);
            pq.clear();
        }


        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void setPq(int i) {
        for (int ele : list) {
            boolean isInclude = false;
            for (int nextIdx = i + 1; nextIdx < arr.length; ++nextIdx) {
                if (arr[nextIdx] == ele) {
                    isInclude = true;
                    pq.add(new Node(ele, nextIdx));
                    break;
                }
            }
            if (!isInclude) {
                pq.add(new Node(ele, Integer.MAX_VALUE));
            }
        }
    }
    static class Node {
        int value;
        int rank;
        public Node(int value, int rank) {
            this.value = value;
            this.rank = rank;
        }
    }

}
