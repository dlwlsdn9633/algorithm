package b_10828;

import java.io.*;
import java.util.StringTokenizer;

public class b_10828 {
    private static MyStack stack = new MyStack();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push": {
                    int number = Integer.parseInt(st.nextToken());
                    stack.push(number);
                    break;
                }
                case "pop": {
                    bw.write(String.valueOf(stack.pop()));
                    bw.newLine();
                    break;
                }
                case "size": {
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;
                }
                case "empty": {
                    bw.write(String.valueOf(stack.empty()));
                    bw.newLine();
                    break;
                }
                case "top": {
                    bw.write(String.valueOf(stack.top()));
                    bw.newLine();
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class MyStack {
        MyNode first;
        MyNode last;
        int size;
        public MyStack() {
            this.first = new MyNode(-1, null, null);
            this.last = new MyNode(-1, null, null);
            this.first.front = this.last;
            this.last.back = this.first;
            this.size = 0;
        }
        public void push(int value) {
            MyNode newNode = new MyNode(value, this.last, this.last.back);
            this.last.back.front = newNode;
            this.last.back = newNode;
            ++this.size;
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }
            MyNode popNode = this.last.back;
            popNode.back.front = popNode.front;
            popNode.front.back = popNode.back;
            --this.size;
            return popNode.value;
        }

        public int size() {
            return size;
        }
        public int empty() {
            return size == 0 ? 1 : 0;
        }
        public int top() {
            if (size == 0) {
                return -1;
            }
            return last.back.value;
        }
    }

    static class MyNode {
        int value;
        MyNode front;
        MyNode back;
        public MyNode(int value, MyNode front, MyNode back) {
            this.value = value;
            this.front = front;
            this.back = back;
        }
    }
}
