package com.accolite.demo;

import java.util.ArrayList;
import java.util.List;

public class EmpInstance {
	private static EmpInstance instance;
	private static List<Employee> data = new ArrayList<Employee>();
	
	static {
		data.add(new Employee(1, "MS Dhoni", 100000,23));
		data.add(new Employee(2, "Rohit Sharma", 200000,28));
		data.add(new Employee(3, "Sachin Tendulkar", 800000,50));
		data.add(new Employee(4, "Ishant Sharma", 500000,30));
		data.add(new Employee(5, "Virat Kohli", 600000,33));
		data.add(new Employee(6, "Shubman Gill", 250000,24));
		data.add(new Employee(7, "Ravi Shashtri", 1000000,60));
		
	}
	
	private EmpInstance() {
		
	}
	
	public static EmpInstance getInstance() {
		if (instance == null) {
			instance = new EmpInstance();
		}
		
		return instance;				
	}
	
	public List<Employee> listAll() {
		return new ArrayList<Employee>(data);
	}
	
	public int add(Employee employee) {
		int newId = data.size() + 1;
		employee.setId(newId);
		data.add(employee);
		
		return newId;
	}
	
	public Employee get(int id) {
		
		for(Employee i: data) {
			if (i.id==id) {
				return i;
			}
		}
		return null;
		
	}
	
	public boolean delete(int id) {
		for(int i=0;i<data.size();i++) {
			if (data.get(i).id==id) {
				data.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean update(Employee employee) {
		for(int i=0;i<data.size();i++) {
			if (data.get(i).id==employee.id) {
				data.set(i, employee);
				return true;
			}
		}
		return false;
	}
}
