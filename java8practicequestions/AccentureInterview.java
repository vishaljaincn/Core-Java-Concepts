package java8practicequestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private String firstName;
    private String lastName;
    private int deptId;
    private int rollNumber;  // Added rollNumber field

    // Constructor
    public Student(String firstName, String lastName, int deptId, int rollNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptId = deptId;
        this.rollNumber = rollNumber;  // Initialize rollNumber
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public int getDeptId() {
        return deptId;
    }

    public int getRollNumber() {
        return rollNumber;  // Getter for rollNumber
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deptId=" + deptId +
                ", rollNumber=" + rollNumber +  // Include rollNumber in toString
                '}';
    }
}

public class AccentureInterview {
    public static void main(String[] args) {
        // Sample list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", "Smith", 1, 101),
                new Student("Bob", "Johnson", 2, 102),
                new Student("Alex", "Williams", 1, 103),
                new Student("Aaron", "Brown", 3, 104),
                new Student("John", "Davis", 2, 105),
                new Student("Anna", "Garcia", 3, 106)
        );


        // Filtering students whose first name starts with "A" and grouping them by department ID using lambda expressions
        Map<Integer, List<Student>> groupedStudents1 = students.stream()
                .filter(student -> student.getFirstName().startsWith("A"))
                .collect(Collectors.groupingBy(Student::getDeptId));

        // Filtering students whose first name starts with "A" and grouping them by department ID using method references
        Map<Integer, List<Student>> groupedStudents2 = students.stream()
                .filter(student -> student.getFirstName().startsWith("A"))
                .collect(Collectors.groupingBy(Student::getDeptId));

        // Printing the grouped students without using method references
        groupedStudents1.forEach((deptId, studentList) -> {
            System.out.println("Department ID: " + deptId);
            studentList.forEach(System.out::println);
        });

        // Printing the grouped students using method references
        groupedStudents2.forEach((deptId, studentList) -> {
            System.out.println("Department ID: " + deptId);
            studentList.forEach(System.out::println);
        });

    }
}
