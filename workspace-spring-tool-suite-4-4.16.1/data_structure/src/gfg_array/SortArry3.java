package gfg_array;

public class SortArry3 {
	
	/*
	 * take two var i & j & temp
	 * iterate through whole array and
	 * compare which is greater and replace
	 * 
	 */
	

	//User function template for Java

	
	    public static void sort012(int a[], int n)
	    {
	            int count0=0;
	            int count1=0;
	            int count2=0;
	            for(int i=0;i<n;i++){
	                if(a[i]==0){
	                    count0++;
	                }
	                else if(a[i]==1){
	                    count1++;
	                }
	                else{
	                    count2++;
	                }
	            }
	            for(int i=0;i<n;i++){
	                if(count0!=0){
	                    a[i]=0;
	                    count0--;
	                }
	                else if(count1!=0){
	                    a[i]=1;
	                    count1--;
	                }
	                else{
	                    a[i]=2;
	                    count2--;
	                }
	            }
	    }

	
//	  static void sort012(int a[], int n)
//	    {
//	        // code here 
//		 int i, j,temp;
//		 boolean swapped;
//		 
//		 for(i=0;i<a.length;i++) {
//			 swapped = false;
//			 
//			 for(j=0; j<n-i-1;j++) {
//				 if(a[j]> a[j+1]) {
//					 temp = a[j];
//					 a[j] = a[j+1];
//					 a[j+1]= temp;
//					 swapped = true;
//				 }
//			 }
//			 
//			 if(swapped == false) {
//				 break;
//			 }
//			 
//		 }
//		 int k;
//	        for (k = 0; k < n; k++)
//	            System.out.print(a[k] + " ");
//	        System.out.println();
//	    }
	 
	 public static void main(String[] args) {
		 
		 int n= 5;
		 int a[] = {0 ,2, 1, 2, 0};
		 
		 sort012(a,n);
		
	}

 

}
