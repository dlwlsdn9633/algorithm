package b_11653;

import java.io.*;
public class b_11653 {
    static class Parent {
        static int total = 0;
        int v = 1;

        public Parent() {
            total += (++v);
            show();
        }
        public void show() {
            total += total;
        }
    }

    static class Child extends Parent {
        int v = 10;
        public Child() {
            v += 2;
            total += v++;
            show();
        }
        @Override
        public void show() {
            total += total * 2;
        }
    }
    public static void main(String[] args) {
        new Child();
        System.out.println(Parent.total);
    }
}
