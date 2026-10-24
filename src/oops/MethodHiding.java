package oops;
class Parent {
    static void show() {
        System.out.println("Parent class static method");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child class static method");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
        Parent.show();
        Child.show();//cant override static method of parent class in child class(methd hiding)
    }
}

