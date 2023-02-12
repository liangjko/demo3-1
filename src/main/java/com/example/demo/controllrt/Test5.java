package com.example.demo.controllrt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test5 {
	public static void main(String[] args) {
//		String aa = "001";
//
//		Integer bb =  Integer.valueOf(aa);
//		System.out.println(bb);
//
		
		
		List<String> friends = Arrays.asList("CSS", "HTML", "Oracle", "Dart");
		
		Comparator<String> compByLength = (aName, bName) -> aName.length() - bName.length();
		friends.stream().sorted(compByLength).forEach(System.out::println);
	}
}
