package com.example.domain;

public class Manager extends Employee {

	private String deptName;
	private Employee[] staff;
	private int employeeCount = 0;

	public Manager(int empId, String name, String ssn, double salary, String deptName) {
		super(empId, name, ssn, salary);
		this.deptName = deptName;
		staff = new Employee[20];
	}

	public String getDeptName() {
		return deptName;
	}
	
	public int findEmployee(Employee employee) {
		for (int i = 0; i < staff.length; i++) {
			if (staff[i].getId() == employee.getId()) {
				return i;
			}
		}
		return -1;
	}
	
}
