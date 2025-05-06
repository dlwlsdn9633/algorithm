
public class Main {
    public static void main(String[] args) {
        int[] data = { 3, 5, 8, 12, 17 };
        System.out.println(func(data, 0, data.length - 1));
    }

    static int func(int[] a, int st, int end) {
        if (st >= end) return 0;
        int mid = (st + end) / 2;
        System.out.println("mid: " + mid);
        int ret = a[mid] + Math.max(func(a, st, mid), func(a, mid + 1, end));
        System.out.println(ret);
        return ret;
    }
}