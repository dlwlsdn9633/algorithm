package b_15662;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b_15562 {
    private static int N;
    private static int K;
    private static ArrayList<LinkedList<Integer>> cogWheelsList = new ArrayList<>();
    private static ArrayList<RotateInfo> rotateInfoList = new ArrayList<>();
    private static int[] rotateDp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setConds(br);

        for (RotateInfo rotateInfo : rotateInfoList) {
            rotate(rotateInfo);
        }

        int ret = 0;
        for (LinkedList<Integer> cogWheel : cogWheelsList) {
            if (cogWheel.get(0) == 1) {
                ++ret;
            }
        }
        bw.write(String.valueOf(ret));

        bw.flush();
        bw.close();
        br.close();
    }
    private static void rotate(RotateInfo rotateInfo) {
        Arrays.fill(rotateDp, 0);
        rotateDp[rotateInfo.cogWheelIdx] = rotateInfo.rotate;
        // 현재 rotate하는 톱니바퀴 기준, 오른쪽 톱니바퀴들을 회전
        for (int cogWheelIdx = rotateInfo.cogWheelIdx; cogWheelIdx < cogWheelsList.size() - 1; ++cogWheelIdx) {
            if (cogWheelsList.get(cogWheelIdx).get(2) == cogWheelsList.get(cogWheelIdx + 1).get(6)) {
                break;
            }
            rotateDp[cogWheelIdx + 1] = rotateDp[cogWheelIdx] == 1 ? -1 : 1;
        }
        // 현재 rotate하는 톱니바퀴 기준, 왼쪽 톱니바퀴들을 회전
        for (int cogWheelIdx = rotateInfo.cogWheelIdx; cogWheelIdx >= 1; --cogWheelIdx) {
            if (cogWheelsList.get(cogWheelIdx).get(6) == cogWheelsList.get(cogWheelIdx - 1).get(2)) {
                break;
            }
            rotateDp[cogWheelIdx - 1] = rotateDp[cogWheelIdx] == 1 ? -1 : 1;
        }
        for (int cogWheelIdx = 0; cogWheelIdx < rotateDp.length; ++cogWheelIdx) {
            switch (rotateDp[cogWheelIdx]) {
                case 1:
                    int lastElement = cogWheelsList.get(cogWheelIdx).pollLast();
                    cogWheelsList.get(cogWheelIdx).addFirst(lastElement);
                    break;
                case -1:
                    int firstElement = cogWheelsList.get(cogWheelIdx).pollFirst();
                    cogWheelsList.get(cogWheelIdx).addLast(firstElement);
                    break;
                default:
                    break;
            }
        }
    }
    private static void setConds(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        rotateDp = new int[N];
        for (int n = 0; n < N; ++n) {
            LinkedList<Integer> cogWheel = new LinkedList<>();
            String str = br.readLine();
            for (char ele : str.toCharArray()) {
                cogWheel.add(ele - '0');
            }
            cogWheelsList.add(cogWheel);
        }
        K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; ++k) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotateInfoList.add(new RotateInfo(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }
    }
    static class RotateInfo {
        int cogWheelIdx;
        int rotate;
        public RotateInfo(int cogWheelIdx, int rotate) {
            this.cogWheelIdx = cogWheelIdx;
            this.rotate = rotate;
        }
    }
}
