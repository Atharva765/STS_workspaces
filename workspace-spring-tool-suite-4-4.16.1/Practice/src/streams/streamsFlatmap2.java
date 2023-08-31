package streams;

import java.util.Arrays;
import java.util.List;

class Order {

    private Integer id;
    private String invoice;
    private List<LineItem> lineItems;
    private double total;
	public Order(Integer id, String invoice, List<LineItem> lineItems, double total) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.lineItems = lineItems;
		this.total = total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

    // getter, setters, constructor
    
}

class LineItem {

    private Integer id;
    private String item;
    private Integer qty;
    private double price;
    private double total;
	public LineItem(Integer id, String item, Integer qty, double price, double total) {
		super();
		this.id = id;
		this.item = item;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

    // getter, setters, constructor
    
	
}


public class streamsFlatmap2 {
	
	public static void main(String[] args) {
		
		

	        LineItem item1 = new LineItem(1, "apple", 1, new Double("1.20"), new Double("1.20"));
	        LineItem item2 = new LineItem(2, "orange", 2, new Double(".50"), new Double("1.00"));
	        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new Double("2.20"));

	        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new Double("99.00"), new Double("495.00"));
	        LineItem item4 = new LineItem(4, "monitor LG", 10, new Double("120.00"), new Double("1200.00"));
	        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new Double("1695.00"));

	        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new Double("499.00"), new Double("1497.00"));
	        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new Double("1497.00"));

	        List<Order> or = Arrays.asList(order1, order2, order3);
	         
	     // sum the line items' total amount
	        Double t = or.stream().flatMap(p->p.getLineItems().stream()).map(o->o.getTotal()).reduce(0.00, Double::sum);
	        System.out.println(t);
	        
	     // sum the order's total amount
	        Double t2= or.stream().map(p->p.getTotal()).reduce(0.00, Double::sum);
	        System.out.println(t2);
	    
	}

}
