package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseString {
	
	public static void main(String[] args) {
		
		String s = "Hello";
				
		StringBuilder s1 = new StringBuilder(s);
		
		String str = new String(s1.reverse());
		System.out.println(str);
		
		
		
		
		String a = "my name is";
		
		 ArrayList<String> lst = new ArrayList<>();
		 
		 String[] arr = a.split(" ");
		 
		for(String z : arr) {
			System.out.println(z);
			
		}
	}
	
	

}
