package gfg_array;

import java.util.Arrays;

public class PeakElement9 {
	
	
	public static int peakElement(int[] arr,int n)
    {
       //add code here.
		return peakEle(arr, 0, n-1, n);
		
    }
	
	public static int peakEle(int[] arr, int l, int h, int n) {
		
		
		
		int mid = (l+h)>>1;
		
		if( (mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || arr[mid+1] <= arr[mid])) {
			return mid;
		}
			
		
		
		else if(mid>0 && arr[mid-1] > arr[mid]) {
			return peakEle(arr,l,mid-1,n);
		}
			
		
		else {
			return peakEle(arr,mid+1,h,n);
		}
		
		
			
    }
	
	public static void main(String[] args) {
		
		int n=5;
		int arr[]= {1,2,3,5,4};
		System.out.println(peakElement(arr,n));
		
	}
	

}
