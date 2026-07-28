package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractise {

    public static void main(String[] args){
        //Q1
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(4);
        nums.add(6);
        nums.add(8);
        nums.add(10);
        nums.add(5);
        nums.add(4);
        nums.add(24);
        nums.add(17);
        nums.add(23);

        nums.stream().forEach(x-> System.out.println(x));

        //Q2
        List<Integer> q2 = nums.stream().filter(x->x%2 == 0).collect(Collectors.toList());
        System.out.println(q2);

        //Q3
        List<Integer> q3 = nums.stream().map(x -> {
            return 5 * x;
        }).collect(Collectors.toList());
        System.out.println(q3);


        //Q4
        List<Integer> q4 = nums.stream().filter(x->x%2==0)
                .map(x->x*10)
                .collect(Collectors.toList());
        System.out.println(q4);


        //Q5
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Tom");

        List<String> q5 = names.stream()
                .filter(x -> x.length() > 4)
                .map(x-> x.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(q5);
    }
    
}
