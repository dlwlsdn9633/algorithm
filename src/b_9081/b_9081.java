package b_9081;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class b_9081 {
    private static int N;
    private static void merge(char[] strArr, int left, int mid, int right) {
        int leftPointer = left;
        int rightPointer = mid + 1;

        int tmpIdx = 0;
        char[] tmpArr = new char[right - left + 1];

        while (leftPointer <= mid && rightPointer <= right) {
            if (strArr[leftPointer] > strArr[rightPointer]) {
                tmpArr[tmpIdx++] = strArr[leftPointer++];
            } else {
                tmpArr[tmpIdx++] = strArr[rightPointer++];
            }
        }
        if (leftPointer <= mid) {
            while (leftPointer <= mid) {
                tmpArr[tmpIdx++] = strArr[leftPointer++];
            }
        } else {
            while (rightPointer <= right) {
                tmpArr[tmpIdx++] = strArr[rightPointer++];
            }
        }

        for (int i = 0; i <= right - left; ++i) {
            strArr[left + i] = tmpArr[i];
        }
    }
    private static void mergeSort(char[] strArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(strArr, left, mid);
            mergeSort(strArr, mid + 1, right);
            merge(strArr, left, mid, right);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            char[] strArr = br.readLine().toCharArray();
            //mergeSort(strArr, 0, strArr.length - 1);
            Arrays.sort(strArr);
            for (int j = 0; j < strArr.length / 2; ++j) {
                char tmp = strArr[j];
                strArr[j] = strArr[strArr.length - j - 1];
                strArr[strArr.length - j - 1] = tmp;
            }
            bw.write(String.valueOf(strArr));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }


}
