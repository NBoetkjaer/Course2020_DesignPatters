package demo.designpatterns.compositepattern;

/*
 * This is one of the "Leaf classes" in the Composite pattern.
 */
public class Line extends Graphic {
	@Override
	public void add(Graphic g) {
		throw new UnsupportedOperationException("Cannot add to a leaf node.");
	}

	@Override
	public void remove(Graphic g) {
		throw new UnsupportedOperationException("Cannot remove from a leaf node.");
	}

	private int thickness;

	public Line(int x, int y, int width, int height, int thickness) {
		super(x, y, width, height);
		this.thickness = thickness;
	}

	@Override
	public String toString() {
		return String.format("Line object: %s, thickness=%d", super.toString(), this.thickness);
	}
}