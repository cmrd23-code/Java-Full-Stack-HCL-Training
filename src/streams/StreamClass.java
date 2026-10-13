package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamClass {
    public static void main(String[] args) {
        List<String> l1= Arrays.asList("Amit", "Sujit","Ramesh","Rahul","Radhika");
        List<Integer> l2 = Arrays.asList(1,4,5,6,8,9,12);
        //filter, map are intermediate operations
        l1.stream().filter(s->s.startsWith("R"))
                .map(s->"Mr. "+s)
                .forEach(e-> System.out.println(e));
        //collect,forEach, count etc are terminal operations.
        //After performing terminal operations streams can not be used further
        List<Integer> ls=l2.stream().filter(n->n%2==0)
                .map(n->n*n)
                .collect(Collectors.toList());
        System.out.println(ls);
        //sum of even numbers in the list
        Integer ls2=l2.stream().filter(n->n%2==0)
                .reduce(0,(a,b)->a+b);

        System.out.println(ls2);
    }


}
