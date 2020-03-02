package demo.designpatterns.visitorpattern;

// Base class for all kinds of Element in the object structure (=Document).
// All elements can be visited by a Visitor.
abstract class MyElement {
    public abstract void accept(Visitor v);
}
