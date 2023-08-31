package practice;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		int i=0, j=1;
		int k=0;
		int num=10;
		
		
		for(int a=0;a<num;a++) {
			System.out.println(i + " ");
			
			k = i+j;
			i =j;
			j =k;
			 
			
		}
		
		
	}

}
