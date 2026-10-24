package oops;

public class Overloading {

    void display(int a) {
        System.out.println("Integer: " + a);
    }

    void display(String s) {
        System.out.println("String: " + s);
    }

    void display(int a, String s) {
        System.out.println("Integer: " + a + ", String: " + s);
    }

    public static void main(String[] args) {
        Overloading obj = new Overloading();
        obj.display(10);
        obj.display("Hello");
        obj.display(20, "World");
    }
}
