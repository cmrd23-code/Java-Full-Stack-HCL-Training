package collectionFramework;
import java.util.*;
//make class comparable to make default sorting logic
class Student implements Comparable<Student>{
    String name;
    int rollno;
    int age;
    double marks;

    public Student(String name, int rollno, int age, double marks) {
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno=" + rollno +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        //return this.age-o.age;
        return Integer.compare(this.age,o.age);
    }
}
//custom comparator
class Comp implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.age,o2.age);
    }
}
public class Task1 {
    public static void main(String[] args) {
       List<Student> ls=new ArrayList<>(10);
       ls.add(new Student("ram",1,20,100));
       ls.add(new Student("raju",2,18,70));
       ls.add(new Student("vineet",3,25,80));
        System.out.println(ls);
        //Collections.sort(ls);
        //Collections.sort(ls,new Comp());
//lambdas can be also used for quick sort logic
        Collections.sort(ls,(a,b)->Integer.compare(a.age,b.age));
        System.out.println(ls);
    }
}
