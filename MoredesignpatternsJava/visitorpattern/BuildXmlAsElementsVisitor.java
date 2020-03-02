package solution.designpatterns.visitorpattern;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Visits all kinds of Element, and builds XML data as a series of child elements.
public class BuildXmlAsElementsVisitor extends Visitor {

    // This is an XML document that accumulates the result of visiting elements in an object structure.
	Document doc;

    // Constructor. Creates an XML document with <Document/> at the top.
    public BuildXmlAsElementsVisitor() {
    	
    	try {
    		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder builder = builderFactory.newDocumentBuilder();
	    	
	    	doc = builder.newDocument();
	    	Element elem = doc.createElement("Document");
	    	doc.appendChild(elem);
    	} catch (ParserConfigurationException ex) {
    		System.err.println("ParserConfigurationException  occurred");
    	}
    	
    }

    // Visits a CustomerElement, and builds its data into XML child elements.
    @Override
    public void visitCustomer(CustomerElement c) {
        
    	Element customerElem = doc.createElement("Customer");
        
        Element customerNameElem = doc.createElement("CustomerName");
        customerNameElem.setTextContent(c.getCustomerName());
        customerElem.appendChild(customerNameElem);
        
        Element addressElem = doc.createElement("Address");
        addressElem.setTextContent(c.getAddress());
        customerElem.appendChild(addressElem);

        doc.getDocumentElement().appendChild(customerElem);
    }

    // Visits a ProductElement, and builds its data into XML child elements.
    @Override
    public void visitProduct(ProductElement p) {

    	Element productElem = doc.createElement("Product");
        
        Element productNameElem = doc.createElement("ProductName");
        productNameElem.setTextContent(p.getProductName());
        productElem.appendChild(productNameElem);
        
        Element listPriceElem = doc.createElement("ListPrice");
        listPriceElem.setTextContent("" + p.getListPrice());
        productElem.appendChild(listPriceElem);

        doc.getDocumentElement().appendChild(productElem);
    }

    // Visits an OrderElement, and builds its data into XML child elements.
    @Override
    public void visitOrder(OrderElement o) {
        
    	Element orderElem = doc.createElement("Order");
        
        Element customerElem = doc.createElement("Customer");
        customerElem.setTextContent(o.getCustomer());
        orderElem.appendChild(customerElem);
        
        Element productElem = doc.createElement("Product");
        productElem.setTextContent(o.getProduct());
        orderElem.appendChild(productElem);

        Element quantityElem = doc.createElement("Quantity");
        quantityElem.setTextContent("" + o.getQuantity());
        orderElem.appendChild(quantityElem);

        doc.getDocumentElement().appendChild(orderElem);
    }

    // Saves the XML document. 
    public void save(String filename) {
 
    	try { 
	    	// Create a TransformerFactory, and use it to create a Transformer object.
	    	TransformerFactory xf = TransformerFactory.newInstance();
	    	Transformer xformer = xf.newTransformer();
	
	    	// Create a Result object (represents the output file).
	    	Result out = new StreamResult(new File(filename));

	    	// Write the DOM tree to the output file.
	    	xformer.transform(new DOMSource(doc), out);

    	} catch (Exception ex) {
    		System.err.println("Exception occurred during save.");
    	}
    }
}