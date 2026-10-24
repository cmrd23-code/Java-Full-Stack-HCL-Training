package oops;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Dog dog = new Dog();
       // Dog dog1=new Animal() //not allowed to create object of parent class in child class reference variable
        Animal animal1=new Animal();
        animal.makeSound();
        dog.makeSound();
        animal1.makeSound(); // parent method will execute because reference variable is of parent class
    }
}
