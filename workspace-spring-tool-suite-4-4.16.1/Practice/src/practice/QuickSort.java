package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;


public class QuickSort {
	
	
	 static void quicksort(int arr[], int l, int r) {
		
		if(l<r) {
			int pivotIndex = pivot(arr,l,r);
			quicksort(arr, l, pivotIndex-1);
			quicksort(arr, pivotIndex+1, r);
		}
		
	}

	 static int pivot(int arr[],int left , int right) {
		
		int swapIndex = left;
		for(int i=swapIndex+1;i<=right;i++) {
			
			if( arr[i] < arr[left]) {
				swapIndex++;
				swap(arr,i,swapIndex);
			}
		}
		
		swap(arr,left,swapIndex);
		return swapIndex;
		
	}
	
	 static void swap(int arr[], int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {7 ,10 ,4 ,3 ,20 ,15};
		int n = arr.length;
		int l = 0;
		int r = n-1;
		int k= 3;
		
		
		quicksort(arr,l,r);
		
		for(int a : arr)
			System.out.print(a + " ");
		
	}
	
}
