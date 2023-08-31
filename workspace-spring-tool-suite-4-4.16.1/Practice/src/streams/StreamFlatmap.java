package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;



 class Developer {

    private Integer id;
    private String name;
    private Set<String> book;
    

    

    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<String> getBook() {
		return book;
	}



	public void setBook(Set<String> book) {
		this.book = book;
	}

	

	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", book=" + book + "]";
	}



	public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
}

public class StreamFlatmap {
	public static void main(String[] args) {
		
		
		// Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
          
        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
          
        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
  
        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        
        listOfListofInts.stream().flatMap(p->p.stream().filter(o->o % 2 != 0)).forEach(System.out::println);
        
        int s = listOfListofInts.stream().flatMap(p->p.stream()).reduce(0, Integer::sum);
        System.out.println("SUM " +  s);
        
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        
         List<String> ls = Stream.of(array).flatMap(Stream::of).filter(p-> !p.equals("a")).collect(Collectors.toList());
         System.out.println(ls);
         
         
         
         
         //=========================================================================================================================
         
         
         
         Developer o1 = new Developer();
         o1.setName("mkyong");
         o1.addBook("Java 8 in Action");
         o1.addBook("Spring Boot in Action");
         o1.addBook("Effective Java (3nd Edition)");

         Developer o2 = new Developer();
         o2.setName("zilap");
         o2.addBook("Learning Python, 5th Edition");
         o2.addBook("Effective Java (3nd Edition)");

         List<Developer> list = new ArrayList<>();
         list.add(o1);
         list.add(o2);
         
         Set<String> lsset = list.stream()
        		 				.flatMap(p->p.getBook()
        		 						.stream().filter(x-> !x.toLowerCase().contains("python")))
        		 						.collect(Collectors.toSet());
         
         System.out.println(lsset);
         
	}
}
