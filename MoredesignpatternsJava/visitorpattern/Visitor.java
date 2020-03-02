package solution.designpatterns.visitorpattern;

// Base class for all Visitors.
// Every Visitor has methods to visit every kind of Element.
abstract class Visitor {
    public abstract void visitCustomer(CustomerElement c);
    public abstract void visitProduct(ProductElement e);
    public abstract void visitOrder(OrderElement e);
}