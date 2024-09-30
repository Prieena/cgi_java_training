package com;

public class TryCatchAndFinally {

	public static void main(String[] args) {
		System.out.println("Hi");
		try {
			int res=10/1;
			System.out.println("No Exception");
		} catch (Exception e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally block");
		}
		System.out.println("normal statement");
	}

}