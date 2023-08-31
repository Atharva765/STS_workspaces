package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;




public class Stream1 {
	
	static List<Integer> evenNo(List<Integer> lst){
		
		/*
		 * Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
		 */
		
		List<Integer> nlst = lst.stream()
 				.filter(p-> p%2 == 0)
 				.sorted()
 				.collect(Collectors.toList());

			
			return lst;
	}
	
	static List<Integer> startWithNo(List<Integer> lst){
		/*
		 * Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		 */
		
		lst.stream().map(p-> p + "").filter(p->p.startsWith("1"));
		return lst;
	}
	
	
	static void findDuplicate(List<Integer> lst){
		/*
		 * How to find duplicate elements in a given integers list in java using Stream functions?
		 */
		Set<Integer> s = new HashSet<>();
		
		lst.stream().filter(p-> !s.add(p)).collect(Collectors.toList()).forEach(System.out::println);;
		
	}
	
	
	static void findFirstEle(List<Integer> lst) {
		/*
		
	 * Given the list of integers, find the first element of the list using Stream functions?
	 */
		
		lst.stream().findFirst().get();
		
	}
	
	static void findMinMax(List<Integer> lst) {
	
	/*
	 * Given a list of integers, find the maximum value element present in it using Stream functions? 
	 */
		
		lst.stream().max(Integer::compare).get();
		
		lst.stream().min(Integer::compare).get();
	
	}
	
	static void findStringCharCount() {
		/*
		 * Write a program to print the count of each character in a String?
		 */
		
		String s = " program to count each character";
		
		HashMap<String,Long> m = Arrays.stream(s.split(""))
										.map(String::toLowerCase)
										.collect(Collectors.groupingBy(
												p->p,LinkedHashMap::new,Collectors.counting()));
		
		System.out.println(m);
		
		
	}
	
	public static void main(String[] args) {
		
		
		List<Integer> lst = Arrays.asList(10,15,28,31,23,18,10,12,28);
		
		System.out.println("Even = " + evenNo(lst));
		
		 
		
	} 

}
