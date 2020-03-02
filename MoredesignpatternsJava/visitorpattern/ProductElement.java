package solution.designpatterns.visitorpattern;

// Represents product data.
public class ProductElement extends MyElement {

    private String productName;
    
    public String getProductName() {
    	return productName; 
    }

    public void setProductName(String productName) {
    	this.productName= productName ; 
    }

    private double listPrice;

    public double getListPrice() {
    	return listPrice; 
    }
    
    public void setListPrice(double listPrice) {
    	this.listPrice = listPrice; 
    }

    public ProductElement(String productName, double listPrice) {
        this.productName = productName;
        this.listPrice = listPrice;
    }

    /// Enable the element to be visited (i.e. processed) by any Visitor
    @Override
    public void accept(Visitor v) {
        v.visitProduct(this);
    }
}
