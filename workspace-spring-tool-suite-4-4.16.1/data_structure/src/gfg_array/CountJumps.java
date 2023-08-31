package gfg_array;

public class CountJumps {
	
	
	static int MinJumps(int arr[],int n) {
		
		if(arr.length < 1)
			return 0;
		
		if(arr[0] >= arr.length-1)
			return 1;
		
		if(arr[0] == 0)
			return -1;
		
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;
		
		
		for(int i=1; i < arr.length-1; i++) {
			
			if(i == arr.length)
				return 1;
			
			if(arr[i] >= (arr.length-1)-i)
				return jump+1;
			
			maxReach = Math.max(maxReach,  i + arr[i]);
			
			step--;
			
			if(step==0) {
				
				jump++;
				
				if(i >= maxReach)
					return -1;
				
				step = maxReach - i;
//				step = arr[i];
				
			}
				
		}
		
		
		return -1;
	}

	
public static void main(String[] args) {
		
		
		int arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1 ,2};
		
		//2->3->2->4
		
		int n=arr.length;
		
		
		System.out.println(MinJumps(arr,n));
			
			
		
	}
}
