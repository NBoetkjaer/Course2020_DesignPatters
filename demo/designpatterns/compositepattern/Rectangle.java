package demo.designpatterns.compositepattern;

/*
 * This is one of the "Leaf classes" in the Composite pattern.
 */
public class Rectangle extends Graphic {
	@Override
	public void add(Graphic g) {
		throw new UnsupportedOperationException("Cannot add to a leaf node.");
	}

	@Override
	public void remove(Graphic g) {
		throw new UnsupportedOperationException("Cannot remove from a leaf node.");
	}

	private boolean roundedCorners;

	public Rectangle(int x, int y, int width, int height, boolean roundedCorners) {
		super(x, y, width, height);
		this.roundedCorners = roundedCorners;
	}

	@Override
	public String toString() {
		// Return a string representation of this object.
		return String.format("Rectangle object: %s, %s", 
				super.toString(),
				this.roundedCorners ? "rounded corners" : "square corner");
	}
}
