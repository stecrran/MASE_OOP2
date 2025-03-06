package com.compare;

public class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private double marks;

    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name); // Natural sorting by name
    }
    
//    @Override // natural sorting by studentId instead of name
//    public int compareTo(Student other) {
//        return Integer.compare(this.studentId, other.studentId);
//    }

    @Override
    public String toString() {
        return String.format("%-12d %-10s %.1f", studentId, name, marks);
    }
}

