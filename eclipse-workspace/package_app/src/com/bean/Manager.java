package com.bean;

public class Manager extends Employee{

	public void disMgr() {
		//System.out.println("id "+id);		// private 
		System.out.println("name "+name);
		System.out.println("salary "+salary);
		System.out.println("desg "+designation);
	}
}