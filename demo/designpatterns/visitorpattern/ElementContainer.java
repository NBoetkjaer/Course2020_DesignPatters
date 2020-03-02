package demo.designpatterns.visitorpattern;

import java.util.ArrayList;
import java.util.List;

// This is a container of elements. It's the ObjectStructure in the visitor pattern.
public class ElementContainer
{
    // Collection of elements.
    private List<MyElement> elements = new ArrayList<MyElement>();

    // Adds another element to the collection;
    public void addElement(MyElement e) {
        elements.add(e);
    }

    // Builds the elements into an XML document, representing the data as child elements.
    public void ToXmlElements(String filename) {

    	BuildXmlAsElementsVisitor visitor = new BuildXmlAsElementsVisitor();

        for (MyElement e : elements) {
        	e.accept(visitor);
        }
        visitor.save(filename);
    }

    // Builds the elements into an XML document, representing the data as attributes.
    public void ToXmlAttributes(String filename) {

/*        BuildXmlAsAttributesVisitor visitor = new BuildXmlAsAttributesVisitor();

        for (MyElement e : elements) {
        	e.accept(visitor);
        }
        visitor.save(filename);
  */  }
}
