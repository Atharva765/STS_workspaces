package practice;

public class Factorial {
	
	public static void main(String[] args) {
		
		int num = 6;
		int i;
		int factorial = 1;
		
		for(i = num;i>0 ; i--) {
			factorial = factorial * i;
		}
		
		System.out.println(factorial);
		
	}
}
