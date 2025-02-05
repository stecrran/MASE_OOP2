package com.example;

import java.text.NumberFormat;

import com.example.domain.*;

public class EmployeeTest {

	public static void main(String[] args) {
		//Employee jim = new Employee();
//		jim.setId(101);
//		jim.setName("Jim-Bob Smith");
//		jim.setSocialSecurityNo("012-34-4567");
//		jim.setSalary(120_345.27);
		Engineer jim = new Engineer(101, "Jim-Bob Smith", "012-34-4567", 120_345.27);
		System.out.println(jim);
		
		Manager barbara = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing");
		System.out.println("\nEmployee Id: " + barbara.getEmpId() + ", Name: " + barbara.getName() + ", SSN# " + barbara.getSocialSecurityNo() + 
				", \nSalary = " + barbara.getSalary() + ", Department: " + barbara.getDeptName());
		
		barbara.setSalary(109_501.36 + (109_501.36*0.10));
		System.out.println("\nEmployee Id: " + barbara.getEmpId() + ", Name: " + barbara.getName() + ", SSN# " + barbara.getSocialSecurityNo() + 
				", \nSalary = " + barbara.getSalary() + ", Department: " + barbara.getDeptName());
		
		barbara.raiseSalary(1650.50);
		System.out.println("\nEmployee Id: " + barbara.getEmpId() + ", Name: " + barbara.getName() + ", SSN# " + barbara.getSocialSecurityNo() + 
				", \nSalary = " + barbara.getSalary() + ", Department: " + barbara.getDeptName());
		
		String salary = NumberFormat.getCurrencyInstance().format(barbara.getSalary()); // get output using € symbol and ','
		System.out.println("Barbara final salary = " + salary);
	}
}
