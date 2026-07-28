package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private int age;
    private double salary;

    public Employee(int id, String name, String department, int age, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " - " + department + " - " + salary;
    }
}

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

        //q6
        List<Integer> q6 = nums.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(q6);


        List<Employee> employees = new ArrayList<>();

                employees.add(new Employee(1, "Alice", "IT", 24, 50000));
                employees.add(new Employee(2, "Bob", "HR", 30, 45000));
                employees.add(new Employee(3, "Charlie", "IT", 29, 70000));
                employees.add(new Employee(4, "David", "Finance", 35, 80000));
                employees.add(new Employee(5, "Eva", "HR", 28, 60000));
                employees.add(new Employee(6, "Frank", "IT", 40, 90000));

                //Q7
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .forEach(System.out::println);

                //Q8
        List<String> q8 = employees.stream()
                .filter(employee ->
                    employee.getDepartment().equalsIgnoreCase("IT"))
                .map(employee-> employee.getName())
                .collect(Collectors.toList());
        System.out.println(q8);

        List<String> q9 = employees.stream()
                .filter(employee->
                    employee.getSalary() > 60000
                )
                .map(employee->employee.getName())
                .collect(Collectors.toList());
        System.out.println(q9);
    }
    
}
