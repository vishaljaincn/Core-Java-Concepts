package java8practicequestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Predicate;

class Employee123 {
    private int id;
    private String name;
    private String gender;
    private int age;

    public Employee123(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Streams2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Employee123> employees = Arrays.asList(
                new Employee123(1, "Alice", "Female", 30),
                new Employee123(2, "Bob", "Male", 25),
                new Employee123(3, "Charlie", "Male", 35),
                new Employee123(4, "Diana", "Female", 40),
                new Employee123(5, "Eve", "Female", 28),
                new Employee123(3, "sam", "Male", 45),
                new Employee123(3, "Bobby Deol", "Male", 38),
                new Employee123(3, "charles", "Male", 31));

        //This is to print the average age of male and female
        Map<String, Double> averageAges = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee123::getGender,
                        Collectors.averagingInt(Employee123::getAge)));

        averageAges.forEach((gender, avgAge) -> System.out.println(gender + "          " + avgAge));

        //predicate chaining used in filter operation
        Predicate<Employee123> case1 = i -> i.getGender().equals("Male");
        Predicate<Employee123> case2 = i -> i.getAge()>35;
        Predicate<Employee123> combinedPredicate = case1.and(case2);


        //printing the employees who are males and age is above 35
        employees.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toMap(e -> e.getName(), e -> e.getGender()))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey() + "  " + e.getValue()));


    }
}
