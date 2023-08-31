package gfg_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class OverlappingInterval {
	
	
	public static int[][] overlappedInterval(int[][] intervals)
    {
        
		List<int[]> res = new ArrayList<>();
		
		if(intervals.length == 0 || intervals == null)
			return res.toArray(new int[0][]);
		
		
		Arrays.sort(intervals, (a,b)->a[0]-b[0]);
		
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		for(int[] a : intervals) {
			
			if(a[0] <= end )
				end = Math.max(end, a[1]);
			
			else {
				res.add(new int[] {start,end});
				start = a[0];
				end = a[1];
			}
			
			
		}
		
		res.add(new int[] {start,end});
		
        return res.toArray(new int[0][]);
    }
	
	
	public static void main(String[] args) {
		
		Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
//        mergeIntervals(arr);
		
	//  {{1,9},{2,4},{4,7},{6,8}}
				//  {{1,6},{2,4},{4,7},{6,8}}
//					{{1,2},{3,4},{6,8},{9,10}}
				 
		
		
			 
            // converting each row as string
            // and then printing in a separate line
           
    }
}
			
		
		
	



class Interval
{
    int start,end;
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}



/*
 * 
 

class Solution
{
    public int[][] overlappedInterval(int[][] intervals)
    {
      List<int[]> res= new ArrayList<>();
      if(intervals.length==0 || intervals==null)
       return res.toArray(new int[0][]);
       
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
       int start=intervals[0][0];
       int end=intervals[0][1];
       for(int[] i:intervals){
           if(i[0]<=end){
               end=Math.max(end,i[1]);
           }else{
               res.add(new int[]{start,end});
               start=i[0];
               end=i[1];
           }
       }
       res.add(new int[]{start,end});
       return res.toArray(new int[0][]);
    }
}
 */




/*
 * 
 * Arrays.sort(arr, (a,b)->a[0]-b[0]);
        int idx = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[idx][1] >= arr[i][0]){
                arr[idx][0] = Math.min(arr[idx][0], arr[i][0]);
                arr[idx][1] = Math.max(arr[idx][1], arr[i][1]);
            }
            else{
                idx++;
                arr[idx][0] = arr[i][0];
                arr[idx][1] = arr[i][1];
            }
        }
        
        return Arrays.copyOfRange(arr, 0, idx+1);
 */

