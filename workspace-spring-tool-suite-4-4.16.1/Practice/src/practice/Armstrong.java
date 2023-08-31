package practice;

public class Armstrong {
	
	public static void main(String[] args) {
		
		int i,digits =0, last=0;
		int sum=0;
		
		int  num = 153;
		
		i =num;
		System.out.println("HI");
		
		while(i>0) {
			i = i % 10;
			digits++;
			
		}
		
		
		i=num;

		while(i>0) {
			last = i%10;
			sum += (Math.pow(last, digits));
			i = i/10;
		}
		
		if(sum == num) {
			System.out.println("Armstrong");
		}
		else {
			System.out.println("not armstrong");
		}
		
	}
}
