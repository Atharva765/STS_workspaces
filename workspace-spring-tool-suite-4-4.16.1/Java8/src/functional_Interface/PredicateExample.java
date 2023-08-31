package functional_Interface;

import java.util.function.Predicate;

public class PredicateExample {
	
	static Predicate<Integer> s1 = (i) -> i%2==0;
	
	static Predicate<Integer> s2 = i -> i%5==0;
	
	
	public static void main(String[] args) {
		
		System.out.println(s1.test(3));
		
		System.out.println(s2.test(10));
		
		predicateAnd();

        predicateOr();

        predicateNegate();
	}


	 public static void predicateOr(){

	        System.out.println("Result in predicateOr : " + s1.and(s2).test(4));
	    }

	    public static void predicateNegate(){

	        System.out.println("Result in predicateNegate : " + s1.and(s2).negate().test(4)); //equivalent to reversing the result
	    }



	private static void predicateAnd() {
		
		System.out.println("Result in predicateAnd : " + s1.and(s2).test(10));
		
	}
	
}
