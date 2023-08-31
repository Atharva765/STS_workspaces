package practice;

public class PrimeNo {
	
	public static void main(String[] args) {
		
		int num = 1;
		int i;
		boolean j = true;
		
		if(num == 0 || num == 1) {
			j = false;
		}
		else {
		
			for(i=2;i<num/2;i++) {
			
				if((num % i) == 0) {
					j = false;
				}
				
			}
		}
		if(j == true)
			System.out.println("prime");
		else
			System.out.println("Not Prime");
		
	}

}
