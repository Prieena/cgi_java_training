package com;

public class TryWithMultipleCatch {

	public static void main(String[] args) {
		System.out.println("Hi");
		try {
		String info[]= {"10","0","10a"};
		int res1 = Integer.parseInt(info[0])/Integer.parseInt(info[2]);
		}
		catch (ArithmeticException e) {
			System.out.println("divided by zero");
		}catch(ArrayIndexOutOfBoundsException c) {
			System.out.println("wrong index position");
		}catch(Exception e) {
			System.out.println("Generic exception "+e);
		} 
		System.out.println("normal work!");
	}

}