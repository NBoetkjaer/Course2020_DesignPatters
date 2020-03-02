package demo.designpatterns.visitorpattern;

// Represents customer data.
class CustomerElement extends MyElement {
	
    private String customerName;

    public String getCustomerName() {
    	return customerName;
    }
    
    public void setCustomerName(String customerName) {
    	this.customerName = customerName;
    }

    private String address;
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }

    public CustomerElement(String n, String a) {
        customerName = n;
        address = a;
    }

    // Enable the element to be visited (i.e. processed) by any Visitor.
    @Override
    public void accept(Visitor v) {
        v.visitCustomer(this);
    }
}
