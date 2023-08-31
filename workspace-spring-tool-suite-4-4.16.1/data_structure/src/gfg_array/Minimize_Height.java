package gfg_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Minimize_Height {
	
	public static void main(String[] args) {
		
		int n=10;
		
		int arr[] = {8, 1, 5, 4, 7, 5, 7, 9, 4, 6};
		
		int k = 5;
		
		Arrays.sort(arr);
		
		for(int a :arr)
			System.out.print(" " + a);
		
		System.out.println();
		
		int maxHeight = arr[n-1];
		int minHeight = arr[0];
		
		int ans = maxHeight - minHeight;
		
		for(int i=1;i<n;i++) {
			
			if(arr[i]-k <0)
				continue;
			System.out.println(arr[i]);
			
			System.out.println("Min = " + (arr[0]+k) + "----" + (arr[i]-k));
			minHeight = Math.min( arr[0]+k,arr[i]-k);
			
			
			System.out.println("Max = " + (arr[i-1]+k) + "----" + (arr[n-1]-k));
			maxHeight = Math.max(arr[i-1]+k,arr[n-1]-k);
			ans =  Math.min(ans,maxHeight - minHeight);
			System.out.println(maxHeight +  "-" + minHeight + " = Answeer == " + ans);
			System.out.println("-------------------------------------");
			
		}
		
		System.out.println(ans);
		
	}
	
	
//	5
//	10
//	8 1 5 4 7 5 7 9 4 6

}
