package java8practicequestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 70000),
                new Employee("Alice", 80000),
                new Employee("Bob", 75000),
                new Employee("David", 60000),
                new Employee("Carol", 90000)
        );

        // 1. Sort employees based on their salaries in descending order
        List<Employee> sortedEmployees = employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .toList();

        System.out.println("Sorted Employees:");
        sortedEmployees.forEach(System.out::println);

        // 2. Fetch top 3 salaried employees' details
        List<Employee> top3SalariedEmployees = sortedEmployees.stream()
                .limit(3)
                .toList();

        System.out.println("Top 3 Salaried Employees:");
        top3SalariedEmployees.forEach(System.out::println);

        // 3. Fetch all employees having salary less than the 3rd highest salary
        double thirdHighestSalary = sortedEmployees.get(2).getSalary();

        List<Employee> employeesLessThanThirdHighest = employees.stream()
                .filter(employee -> employee.getSalary() < thirdHighestSalary)
                .toList();

        System.out.println("Employees with salary less than the 3rd highest salary:");
        employeesLessThanThirdHighest.forEach(System.out::println);

        // 4. Find the sum of all elements in an array using Java 8
        int[] array = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(array).sum();

        System.out.println("Sum of all elements in the array: " + sum);
    }
}
