package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionWithGenerics {

	public static void main(String[] args) {
		// Collection framework without generics 
//List ll = new ArrayList();
//	ll.add(10);
//	ll.add("Ravi");
//	ll.add(20.20);
//	ll.add(true);
//	
//	Object obj = ll.get(0);
//	Integer i = (Integer)obj;		// type casting 
//	int n = i.intValue();
//	System.out.println(n);
		// collection framework with generics 
	List<Integer> ll = new LinkedList<Integer>();
	ll.add(10);
	ll.add(20);
	ll.add(30);
	ll.add(10);
	
	int n = ll.get(2);		// auto-unboxing : converting object to primitive 
	System.out.println(n);
	}

}