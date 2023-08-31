package functional_Interface;

import java.util.List;
import java.util.function.Consumer;

import data.Student;
import data.StudentDataBase;


/*
 * It represents a function which takes in one argument and produces a result.
 *  However these kind of functions don’t return any value.
 *  
 */
public class ConsumerExample {
	
	
	//c1 contains all students 
	static Consumer<Student> c1 = p-> System.out.println(p);
	
	//c2 contains all names in uppercase
	static Consumer<Student>  c2= p -> System.out.print(p.getName().toUpperCase());

	///c3 contains all students activites
    static Consumer<Student>  c3= p -> System.out.println(p.getActivities());
    
    
	
	public static void main(String[] args) {
		
		Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
		
		c1.accept("java8");
		
		System.out.println("---------------------------------------------------------");
		
		printName();
		
		System.out.println("---------------------------------------------------------");
		printNameAndActivities();
		
		System.out.println("---------------------------------------------------------");
        printNameAndActivitiesUsingCondition();
	}

	


	
	private static void printName() {
		
		List<Student> pList = StudentDataBase.getAllStudents();
		
		pList.forEach(c1);
		
		
	}
	
	private static void printNameAndActivities() {
		
		List<Student> pList = StudentDataBase.getAllStudents();
		
		pList.forEach(c2.andThen(c3));
		
	}
	
	
	
	private static void printNameAndActivitiesUsingCondition() {
		
		List<Student> pList = StudentDataBase.getAllStudents();
		
		pList.forEach(s ->  {
			if(s.getGradeLevel()>=3 && s.getGpa()>3.9) {
				c2.andThen(c3).accept(s);
			}
		});
	}
}
