package gfg_array;

import java.util.ArrayList;

public class Subarray1 {
	
	/*
	 * take 2 variables start and sum
	 * create a list lst to add indexes
	 * start i from 0 index using for loop 
	 * for sum keep adding all the integers till sum == s
	 * if(sum>s) - subtract the first no. using start till 
	 * 			------------	(start<i && sum>s)	----------------
	 * if (sum == s) add start+1 and i to lst final ans
	 * 
	 */
	
	
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
			
		int start=0, sum=0;
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			
			sum= sum + arr[i];
			
			if(sum>s) {
				while(sum>s && i>start) {
					sum= sum - arr[start];
					start++;
				}	
			}
			if(sum == s) {
				lst.add(start+1);
				lst.add(i+1);
				return lst;
			}
				
		}
		
		lst.add(-1);
			
		return lst;
		
		
    }
	
	public static void main(String[] args) {

		int n = 5, s = 12;
		int	arr[] = {1,2,3,7,5};
		
		System.out.println(" output : " + subarraySum(arr,n,s));
		
	}

}


