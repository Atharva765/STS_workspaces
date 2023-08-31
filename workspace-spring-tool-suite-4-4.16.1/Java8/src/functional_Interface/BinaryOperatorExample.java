package functional_Interface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
	
	static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
	
	public static void main(String[] args) {
		
		BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;
		System.out.println(binaryOperator.apply(4, 5));
		
		System.out.println("---------------------------------------------------------");
		
		BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
		
		System.out.println("Maximum : "+ maxBy.apply(3, 9));
		
		System.out.println("---------------------------------------------------------");
		
		BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
		
		System.out.println("Minimum : " + minBy.apply(3, 9));
		
		
		
		
	}
}
