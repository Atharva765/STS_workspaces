package functional_Interface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	
	static UnaryOperator<String> uo = unaryOperator -> unaryOperator.concat("how r u"); 
	
	public static void main(String[] args) {
		
		System.out.println(uo.apply("Hi "));
		
		 
	}

}
