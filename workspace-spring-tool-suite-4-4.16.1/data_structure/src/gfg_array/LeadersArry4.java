package gfg_array;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersArry4 {
	
	/*
	 * First declare 2 variables i and max .
	 * iterate through array from right to left
	 * as we iterate we update the max element;
	 * reverse the final max lst 
	 */
	
	static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		int i,max=arr[n-1];
		lst.add(arr[n-1]);
		for(i=n-2;i>=0;i--) {
			
			if(arr[i]>= max) {
				lst.add(arr[i]);
				max=arr[i];
			}
			
		}
		
		Collections.reverse(lst);
		return lst;
		
		// ANOTHER APPROACH TO REVERSE :
		
//		ArrayList<Integer> ans = new ArrayList<Integer>();
//		for(int a = lst.size()-1; a>=0;a-- ) {
//			ans.add(lst.get(a));
//			
//		}
//		
//		 return ans;
        
    }
	
	
	public static void main(String[] args) {
		
		int n=5;
		int arr[]= {16, 17, 3,5,2};
		System.out.println(leaders(arr,n));
		
	}
	

}
