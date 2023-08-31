package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
	
	 int id;
	 String name;
	 int salary;
	 String role;
	
	
	public Employee(int id, String name, int salary, String role) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.role = role;
	}

	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getSalary() {
		return salary;
	}




	public void setSalary(int salary) {
		this.salary = salary;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", role=" + role + "]";
	}
	
	
}


public class Streamfilter {
		public static void main(String[] args) {
			
			
			
			List<String> lst = Arrays.asList("abc", "xyz", "lmnqs" , "", "asd", "alkd");
			
			System.out.println("----------Starts with-------------");
			
			lst.stream().filter(p->p.startsWith("a")).forEach(System.out::println);
			
			System.out.println("----------Not empty strings-------------");
			
			lst.stream().filter(p-> !p.isEmpty()).forEach(System.out::println);
			
			System.out.println("----------Sorted string-------------");
			
			lst.stream().sorted((x,y)-> x.compareTo(y)).forEach(System.out::println);
			
			System.out.println("----------Length-------------");
			
			lst.stream().filter(p->p.length()>3).forEach(System.out::println);
			
			
			
			System.out.println("----------Deal with Objects-------------");
			
			
			List<Employee> emp = Arrays.asList(
						 new Employee(1,"harry",20000,"HR" ),
								new Employee(2,"ron",10000,"consultant" ),
										new Employee(3,"naruto",30000,"manager" ),
												 new Employee(4,"drako",22000,"HR" ),
														 new Employee(5,"sasuke",25000,"manager" )
					);
			
			
			System.out.println("----------Salary-------------");
			emp.stream().filter(e->e.getSalary()>25000).forEach(p->System.out.println(p));
			
			System.out.println("----------Sorted Salary-------------");
					
			emp.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).forEach(System.out::println);
			
			System.out.println("----------Sorted by Name-------------");
			
			emp.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
			
			System.out.println("----------Role-------------");
			
			emp.stream().filter(p->p.getRole().equalsIgnoreCase("manager")).forEach(System.out::println);
			
		}
}
