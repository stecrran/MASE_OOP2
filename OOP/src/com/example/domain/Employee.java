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

	public int getId() {
		return empId;
	}

	public void setId(int id) {
		this.empId = id;
	}

	public String getSocialSecurityNo() {
		return ssn;
	}

	public void setSocialSecurityNo(String socialSecurityNo) {
		this.ssn = socialSecurityNo;
	}

	public void raiseSalary(double increase) {
		salary = salary+increase;
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


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee is " + getName() + ", id = " + getId() + ", \nSocial Security# " 
	+ getSocialSecurityNo() + ", salary = " + getSalary();
	}
}
