package b_10845;

import org.w3c.dom.Node;

import java.io.*;
import java.util.StringTokenizer;

public class b_10845 {
    private static final MyQueue q = new MyQueue();
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
                    if (number == 3) {
                        int a = 3;
                    }
                    q.push(number);
                    break;
                }
                case "pop": {
                    int pop = q.pop();
                    bw.write(String.valueOf(pop));
                    bw.newLine();
                    break;
                }
                case "size": {
                    int size = q.size();
                    bw.write(String.valueOf(size));
                    bw.newLine();
                    break;
                }
                case "empty": {
                    if (q.empty()) {
                        bw.write(String.valueOf(1));
                    } else {
                        bw.write(String.valueOf(0));
                    }
                    bw.newLine();
                    break;
                }
                case "front": {
                    int number = q.front();
                    bw.write(String.valueOf(number));
                    bw.newLine();
                    break;
                }
                case "back": {
                    int number = q.back();
                    bw.write(String.valueOf(number));
                    bw.newLine();
                    break;
                }

            }
        }


        bw.flush();
        bw.close();
        br.close();
    }
    static class MyQueue {
        MyNode first;
        MyNode last;
        int size;
        public MyQueue() {
            this.first = new MyNode(-1, null, null);
            this.last = new MyNode(-1, null, null);
            first.backNode = last;
            last.frontNode = first;
            this.size = 0;
        }
        public void push(int val) {
            MyNode myNode = new MyNode(val, this.last.frontNode, this.last);
            this.last.frontNode.backNode = myNode;
            this.last.frontNode = myNode;
            ++this.size;
        }
        public int pop() {
            if (empty()) {
                return -1;
            }
            MyNode popNode = first.backNode;
            first.backNode = popNode.backNode;
            popNode.backNode.frontNode = first;
            --this.size;
            return popNode.value;
        }
        public int size() {
            return size;
        }
        public boolean empty() {
            return size == 0;
        }
        public int front() {
            if (empty()) {
                return -1;
            }
            return first.backNode.value;
        }
        public int back() {
            if (empty()) {
                return -1;
            }
            return last.frontNode.value;
        }

        @Override
        public String toString() {
            MyNode cursor = first.backNode;
            StringBuilder sb = new StringBuilder();
            while (cursor.backNode != null) {
                sb.append(cursor.value).append(",");
                cursor = cursor.backNode;
            }
            return sb.toString();
        }
    }
    static class MyNode {
        int value;
        MyNode frontNode;
        MyNode backNode;
        public MyNode(int value, MyNode frontNode, MyNode backNode) {
            this.value = value;
            this.frontNode = frontNode;
            this.backNode = backNode;
        }
    }
}
