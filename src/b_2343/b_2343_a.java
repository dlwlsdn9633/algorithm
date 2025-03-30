package b_2343;

import java.io.*;
import java.util.Arrays;

public class b_2343_a {
    private static int N; // 강의의 수
    private static int M; // 최대 블루레이 크기
    private static int low;
    private static int high;
    private static int ret;
    private static int[] lectures;
    private static int sum;
    private static int maxValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] conds = br.readLine().split(" ");
        N = Integer.parseInt(conds[0]);
        M = Integer.parseInt(conds[1]);

        String[] lecturesCond = br.readLine().split(" ");
        lectures = new int[N];
        for (int i = 0; i < lecturesCond.length; ++i) {
            lectures[i] = Integer.parseInt(lecturesCond[i]);
            maxValue = Math.max(maxValue, lectures[i]);
        }
        sum = Arrays.stream(lectures).sum();

        low = 0;
        high = sum;
        while (low <= high) {
            int estimatedBlueRaysSize = (low + high) / 2;
            if (check(estimatedBlueRaysSize)) {
                // 더 작은 blueRaysSize를 구하기 위해 high를 줄인다.
                high = estimatedBlueRaysSize - 1;
                ret = estimatedBlueRaysSize;
            } else {
                // 답이 나올 때까지 blueRaysSize를 키워본다.
                low = estimatedBlueRaysSize + 1;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
    private static boolean check(int estimatedBlueRaysSize) {
        if (maxValue > estimatedBlueRaysSize) {
            // 강의 시간 중에 가장 큰 값이 estimatedBlueRaysSize보다 크다면 해당 maxValue는 blueray에 담지 조차 못하게 된다.
            // 따라서, estimated Blue Rays Size를 키워 maxValue도 blueRay에 담을 수 있게 만들어야 한다.
            return false;
        }
        int cnt = 0; // 총 blueray수
        int temp = estimatedBlueRaysSize;
        for (int lectureIdx = 0; lectureIdx < lectures.length; ++lectureIdx) {
            if (estimatedBlueRaysSize - lectures[lectureIdx] < 0) {
                // 만약 estimatedBlueRaysSize를 계속 차감하고 있다가, estimatedBlueRaysSize가 음의 값이 되면
                // 충분히 강의를 담았다는 의미이므로, estimatedBlueRays를 원상복구하고, 다음 blueRay를 담을 준비를 한다.
                estimatedBlueRaysSize = temp;
                ++cnt;
            }
            estimatedBlueRaysSize -= lectures[lectureIdx];
        }
        if (temp != estimatedBlueRaysSize) {
            // 만약 마지막 blueRay에 담은 강의가 있으면, 현재 마지막 blueRay에 남은 공간 크기와 estimatedBlueRay크기는 다를것이다.
            // 따라서, 마지막 blueRay 남은 크기와 estimatedBlueRay크기가 다르다면, 마지막 blueRay를 사용 중인 blueRay라 생각하고 ++1를 한다.
            ++cnt;
        }
        return cnt <= M;
    }
}
