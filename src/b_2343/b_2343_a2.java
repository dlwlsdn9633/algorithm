package b_2343;

import java.io.*;
import java.util.Arrays;

public class b_2343_a2 {
    private static int N;
    private static int M;
    private static int[] lectures;
    private static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);
        lectures = new int[N];
        String[] lecturesCond = br.readLine().split(" ");
        for (int i = 0; i < lecturesCond.length; ++i) {
            lectures[i] = Integer.parseInt(lecturesCond[i]);
            maxValue = Math.max(maxValue, lectures[i]);
        }

        int ret = 0;
        int leftPointer = maxValue;
        int rightPointer = Arrays.stream(lectures).sum();
        while (leftPointer <= rightPointer) {
            int estimatedBlueRaySize = (leftPointer + rightPointer) / 2;
            if (check(estimatedBlueRaySize)) {
                rightPointer = estimatedBlueRaySize - 1;
                ret = estimatedBlueRaySize;
            } else {
                leftPointer = estimatedBlueRaySize + 1;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }

    private static boolean check(int estimatedBlueRaySize) {
        if (maxValue > estimatedBlueRaySize) {
            return false;
        }
        int cnt = 0; // 총 몇개의 blueRay가 생성되는가?
        int temp = estimatedBlueRaySize;
        for (int i = 0; i < lectures.length; ++i) {
            if (estimatedBlueRaySize - lectures[i] < 0) {
                estimatedBlueRaySize = temp;
                ++cnt;
            }
            estimatedBlueRaySize -= lectures[i];
        }
        if (temp != estimatedBlueRaySize) {
            ++cnt;
        }
        return cnt <= M;
    }
}
