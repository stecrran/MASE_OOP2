package com.compare;

import java.util.Comparator;

public class StudentSortByMarks implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getMarks(), s1.getMarks()); // Descending
    }
}
