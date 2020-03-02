package solution.designpatterns.visitorpattern;

// Represents an order by a customer.
class OrderElement extends MyElement {
	
    private String customer;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	private String product;
    
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderElement(String c, String p, int q) {
        customer = c;
        product = p;
        quantity = q;
    }

    // Enable the element to be visited (i.e. processed) by any Visitor.
    @Override
    public void accept(Visitor v) {
        v.visitOrder(this);
    }
}
