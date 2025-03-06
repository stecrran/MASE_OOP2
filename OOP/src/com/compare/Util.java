package com.compare;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<Student> getStudents() {
        return Arrays.asList(
            new Student(3, "Alice", 85.5),
            new Student(1, "David", 92.3),
            new Student(5, "Bob", 75.0),
            new Student(2, "Charlie", 88.8),
            new Student(4, "Eve", 95.0)
        );
    }
}
