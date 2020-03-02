package demo.designpatterns.visitorpattern;

public class Main {

	public static void main(String[] args) {

        // Create an ElementContainer (=ObjectStructure in the visitor pattern).
        ElementContainer container = new ElementContainer();

        // Add some ConcreteElements (CustomerElement and ProductElements). 
        container.addElement(new CustomerElement("Leon Britton", "Mumbles"));
        container.addElement(new CustomerElement("Ashley Williams", "Newton"));
        container.addElement(new ProductElement("DVD/HDD recorder", 500.00));
        container.addElement(new CustomerElement("Angel Rangel", "Swansea"));
        container.addElement(new ProductElement("LCD TV", 2000.00));

        // Call a method to visit all the Elements, to represent them as XML elements.
        container.ToXmlElements("DocAsElements.xml");
        System.out.println("Written document as XML elements to DocAsElements.xml.");

        // Call a method to visit all the Elements, to represent them as XML attributes.
        // container.ToXmlAttributes("DocAsAttributes.xml");
        // System.out.println("Written document as XML attributes data to DocAsAttributes.xml.");
    }
}
