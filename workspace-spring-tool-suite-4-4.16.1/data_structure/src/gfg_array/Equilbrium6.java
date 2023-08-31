package gfg_array;

public class Equilbrium6 {
	
	/*
	 * take 4 variables i, sumL, sumR,sum
	 * iterate through the whole array and calculate sum of all nos.
	 * iterate array again
	 * check if sumL == sum-arr[i]
	 * else add sumL=arr[i] & sum-arr[i]
	 */
	
	public static int equilibriumPoint(long arr[], int n) {
		
        // Your code here
		
		long sumL = 0;
		long sum = 0;
		int i;
		
		for(i =0; i<n;i++) {
			sum += arr[i];
			//System.out.println("sum = " + sum);
		}
		
		for(i =0; i<n;i++) {
			if(sumL == sum-arr[i]) {   // 1 3 1
				
				return i+1;
			}
			else {
				sumL += arr[i];
				sum -= arr[i];
			}
		}
				
		return -1;
    }
	
	public static void main(String[] args) {
		
		int n = 5;
		long arr[] = {1,3,5,2,2};
		System.out.println(equilibriumPoint(arr,n));
		
	}

}
