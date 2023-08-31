package gfg_array;

import java.util.Arrays;

public class PairsWithSum8 {
	
	
	public static void main(String[] args) {
		
		int a = 123;
		
		//123 = 100*1 + 10*2 + 1*3 // 
		
		// 123 % 10 = 3    // 
		
		// 123/10 = 12.3 = 12
		
		int b =0;
		
		while(a != 0) {
			
			int remainder = a % 10;  
			
			b = b * 10 + remainder;  
			System.out.println(b);
			a=a/10;  
			System.out.println("a : " + a);
		}
		
		
	}

}
