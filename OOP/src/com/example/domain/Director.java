package com.example.domain;

public class Director extends Employee {
	
	private double budget;

	public Director(int empId, String name, String ssn, double salary) {
		super(empId, name, ssn, salary);
		this.budget = budget;
	}

	public double getBudget() {
		return budget;
	}
	
}
