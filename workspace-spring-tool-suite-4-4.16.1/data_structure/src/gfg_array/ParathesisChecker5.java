package gfg_array;

import java.util.Stack;

public class ParathesisChecker5 {
	
	/*
	 * solve the probelm using stack
	 * check stack top if match found then pop
	 */
	
	
	static boolean ispar(String x)
    {
        // add your code here
		Stack<Character> s = new Stack<>();
		for(int i=0 ; i<x.length() ; i++) {
			
			if(x.charAt(i) == '[' || x.charAt(i) == '{' || x.charAt(i) == '(') {
				s.push(x.charAt(i));
				
			}
			
			else if(x.charAt(i) == ']' || x.charAt(i) == '}' || x.charAt(i) == ')') {
				s.pop();
			}
			else {
				return false;
				
			}
		}
		if(s.isEmpty())
			return true;
		else
			return false;
    }
	
	public static void main(String[] args) {
		
		String x = "[(])";
		System.out.println(ispar(x));
		
	}

}
