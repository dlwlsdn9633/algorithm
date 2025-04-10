import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dfs(0);

        bw.flush();
        bw.close();
    }
    private static void dfs(int idx) {
        if (idx == 3) {
            print();
            return;
        }
        dfs(idx + 1);
        arr[idx] = ~arr[idx];
        dfs(idx + 1);
    }
    private static void print() {
        for (int num : arr) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }
}