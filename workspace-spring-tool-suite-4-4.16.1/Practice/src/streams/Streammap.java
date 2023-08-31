package streams;

import java.util.ArrayList;
import static java.util.stream.Collectors.toMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;



public class Streammap {
	
	public static void main(String[] args) {
		
		List<Integer> lst = Arrays.asList(2,6,3,5,7,3,2,5,6,3);
		
		List<Integer> lst1 = lst.stream().map(p->p*3).collect(Collectors.toList());
		System.out.println(lst1);
		
		
		
		System.out.println("----------Deal with Objects-------------");
		
		
		List<Employee> emp = Arrays.asList(
					 new Employee(1,"harry",20000,"HR" ),
							new Employee(2,"ron",10000,"consultant" ),
									new Employee(3,"naruto",30000,"manager" ),
											 new Employee(4,"drako",22000,"HR" ),
													 new Employee(5,"sasuke",25000,"manager" )
				);

		emp.stream()
				.filter(p->p.getRole().equalsIgnoreCase("HR"))
							.map(p-> p.getSalary()*2);
		
		
		 ArrayList<String> names = new ArrayList<>();
	        names.add("adam");
	        names.add("dan");
	        names.add("jenny");
	        
	        
	        names.stream().map(String::toString).forEach(System.out::println);
	        
	        System.out.println("----------To map-------------");
			
	        
//	       emp.stream().map(Employee::getName).map(String::toUpperCase).forEach(System.out::println);
	       emp.stream().map(p->p.getName().toUpperCase()).forEach(System.out::println);
	       
	       
		
	}

	

}
