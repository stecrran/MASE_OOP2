package com.compare;

import java.util.Collections;
import java.util.List;

public class TestStudentSort {

    public static void main(String[] args) {
        List<Student> students;

        System.out.println("Sorted by Name:");
        students = Util.getStudents();
        Collections.sort(students); // Natural order (by name)
        printList(students);

        System.out.println("\nSorted by Student ID:");
        students = Util.getStudents();
        Collections.sort(students, new StudentSortById());
        printList(students);

        System.out.println("\nSorted by Marks (Descending):");
        students = Util.getStudents();
        Collections.sort(students, new StudentSortByMarks());
        printList(students);
        
        // Sort by studentId using Comparator (second overload)
        students = Util.getStudents();
        Collections.sort(students, (s1, s2) -> Integer.compare(s1.getStudentId(), s2.getStudentId()));
    }

    private static void printList(List<Student> students) {
        System.out.println("StudentId   Name       Marks");
        for (Student s : students) {
            System.out.println(s);
        }
    }
    
//    Example of Ordinal Sort using Enums:
//    	The ordinal position is simply the zero-based index of the enum constant in the order it's declared.
//    	enum Student {
//        JIM,   // ordinal = 0
//        SALLY,  // ordinal = 1
//        GWEN // ordinal = 2
//    }
    

}
