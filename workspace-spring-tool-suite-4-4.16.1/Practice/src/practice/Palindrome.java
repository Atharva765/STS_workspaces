package practice;

public class Palindrome {
	
	public static void main(String[] args) {
		
		int i,remainder,reverse;
		reverse=0;
		int num = 414;
		int ans = num;
		
		while(num != 0) {
			
			remainder = num % 10;
			reverse = (reverse*10) + remainder;
			num = num/10;
			
			System.out.println(reverse);
		}
		
		
		
		if(reverse == ans) {
			System.out.println("Number is palindrome");
		}
		else {
			System.out.println("Number is not a Palindrome");
		}
		
	}

}
