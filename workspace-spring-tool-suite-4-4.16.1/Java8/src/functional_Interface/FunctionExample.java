package functional_Interface;

import java.util.function.Function;

public class FunctionExample {

	
	static Function<String, String> f = name -> name.toUpperCase();
	static Function<String , String> f2 = name -> name.concat("functions Example");
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("To upperCase : " + f.apply("java8"));
		
		System.out.println("---------------------------------------------------------");
		
		System.out.println("And then Example : " + f.andThen(f2).apply("java8 "));
		
		System.out.println("---------------------------------------------------------");
		
		System.out.println("Compose example :" + f.compose(f2).apply("java8 "));
		
	}
}
