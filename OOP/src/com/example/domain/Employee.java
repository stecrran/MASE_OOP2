package com.example.domain;

public class Employee {

	private int empId;
	private String name;
	private String ssn;
	private double salary;

	public Employee(int empId, String name, String ssn, double salary) {
		this.empId = empId;
		this.name = name;
		this.ssn = ssn;
		this.salary = salary;
	}

	public void setName(String name) {

	}

	public void raiseSalary(double increase) {

	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getSsn() {
		return ssn;
	}

	public double getSalary() {
		return salary;
	}

}


