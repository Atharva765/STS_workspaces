package gfg_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindDuplicate7 {
	
	/*
	 *  
		
	 */
	
	public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
		
		ArrayList<Integer> lst = new ArrayList<>();
		int i,j;
		
		Arrays.sort(arr);
		for(i=1;i<n;i++) {
			if(arr[i] == arr[i-1]) {
				
					lst.add(arr[i]);
					
				
			}
		}
		
		if(lst.size() == 0) {
			lst.add(-1);
			return lst;
		}
		
		Set<Integer> set = new LinkedHashSet<>();
	    set.addAll(lst);

	    lst.clear();

	    lst.addAll(set);

		return lst;
	
		
	}
	
	
	
/*	public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
		ArrayList<Integer> lst = new ArrayList<>();
		int i,j;
		boolean found = false;
		for(i=0;i<n;i++) {
			for(j=i+1;j<n;j++) {
				if(arr[i] == arr[j]) {
					if(!lst.contains(arr[i])) {
						lst.add(arr[i]);
						found = true;
					}
						
				}
			}
			
		}
		if(found ==  true) {
			Collections.sort(lst);
			return lst;
		}
		else {
			lst.add(-1);
			return lst;
		}
    } */
	
	public static void main(String[] args) {
		
		int n= 5;
		int arr[] = {0,1,4,3,2};
		System.out.println(duplicates(arr,n));
		
	}

}
