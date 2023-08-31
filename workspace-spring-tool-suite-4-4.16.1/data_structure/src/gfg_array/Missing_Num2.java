package gfg_array;

import java.util.Arrays;
import java.util.Collections;

public class Missing_Num2 {
	
	
	/*
	 * addition of first n nos = n*(n+1)/2
	 * first we will find total using above formula
	 * using for loop we iteratee through array and subtarct each no. from total
	 * the result will be the required missing number.
	 */
	
	
	static int missingNumber(int array[], int n) {
        // Your Code Here
		
		int total = n*(n+1)/2;
		
		for(int i =0; i<array.length;i++) {
			total = total - array[i];
		}
		
		return total;
		
		
	}
	
	
	public static void main(String[] args) {
		
		int n = 2;
		int array[] = {2};
		System.out.println(missingNumber(array,n));
		
	}
	

}
