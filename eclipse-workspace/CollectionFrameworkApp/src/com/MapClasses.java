package com;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapClasses {

	public static void main(String[] args) {
	// HashMap 
	//Map mm = new HashMap();
		Map mm = new TreeMap();
	mm.put(2, "Ravi");
	mm.put(1, "Ramesh");
	//mm.put("a", "b");
	mm.put(3, "Ajay");
	mm.put(4, "Balaji");
	mm.put(4, "Yogesh");
	System.out.println(mm);
	System.out.println("key present "+mm.containsKey(4));
	System.out.println("key present "+mm.containsKey(40));
	System.out.println("value present "+mm.containsValue("Ravi"));
	System.out.println("value present "+mm.containsValue("Raju"));
	System.out.println("get value "+mm.get(1));
	}

}