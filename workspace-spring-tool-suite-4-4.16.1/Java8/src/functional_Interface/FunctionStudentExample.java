package functional_Interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import data.Student;
import data.StudentDataBase;

public class FunctionStudentExample {
	
	static Function<List<Student>, Map<String,Double>> studentFunction = fn -> {
		Map<String,Double> map = new HashMap<>();
		fn.forEach(student-> {
			map.put(student.getName(), student.getGpa());
		});
		
		return map;
	};
	
	
	public static void main(String[] args) {
		
		System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));
	}

}
