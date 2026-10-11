package collectionFramework;

import java.util.*;

public class ArrayListClass {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(5);
        System.out.println(al);
        Iterator<Integer> itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
