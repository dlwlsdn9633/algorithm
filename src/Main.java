
public class Main {
    public static void main(String[] args) {
        Parent parent = new Child(10);
        System.out.println(parent.getX());

    }
    static class Parent {
        int x, y;
        public Parent(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x * y;
        }
    }
    static class Child extends Parent {
        int x;
        public Child(int x) {
            super(x + 1, x);
        }
        int getX(int n) {
            return super.getX() + n;
        }
    }
}