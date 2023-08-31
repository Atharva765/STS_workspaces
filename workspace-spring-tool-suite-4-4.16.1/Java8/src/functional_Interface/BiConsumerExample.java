package functional_Interface;

import java.util.List;
import java.util.function.BiConsumer;

import data.Student;
import data.StudentDataBase;

/*
 * Biconsumer takes two inputs and returns nothing
 * 
 * Interface BiConsumer<T,U>
	Type Parameters:
	T - the type of the first argument to the operation
	U - the type of the second argument to the operation
 */

public class BiConsumerExample {
	
	public static void main(String[] args) {
		
		BiConsumer<String, String> biConsumer = (a,b) -> {
			System.out.println(a + " : " + b );
		};
		biConsumer.accept("java7", "java8");
		
		System.out.println("---------------------------------------------------------");
		
		BiConsumer<Integer, Integer> biC = (a,b) -> {
			System.out.println("addition : " + (a+b));
		};
		biC.accept(5, 6); // accept tp pass the inputs
		
		
		
		
		
		BiConsumer<Integer, Integer> biMultiply = (a,b) -> {
			System.out.println("multiplication : " + (a*b));
		};
		
		
		
		
		BiConsumer<Integer, Integer> biDivision = (a,b) -> {
			System.out.println("Division : " + (a/b));
		};
		
		
		
		System.out.println("---------------------------------------------------------");
		
		
		biMultiply.andThen(biDivision).accept(10, 2);  //andThen for chaining
		
		System.out.println("---------------------------------------------------------");
		
		nameAndActivities();
	}

	private static void nameAndActivities() {
		
		BiConsumer<String, List<String>> nameActivity = (name,activities) -> 
			System.out.println(name + " - " + activities);
			
		List<Student> sList = StudentDataBase.getAllStudents();
		
		sList.forEach(student -> {
			nameActivity.accept(student.getName(), student.getActivities());
		});
		
		
		
	}

}
