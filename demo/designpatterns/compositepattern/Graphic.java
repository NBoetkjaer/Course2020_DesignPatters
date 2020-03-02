package demo.designpatterns.compositepattern;

/*
 * This is the "Component class" in the Composite pattern.
 */
public abstract class Graphic {
	
	public abstract void add(Graphic g);
	public abstract void remove(Graphic g);

	
	protected int x, y, width, height;

	public Graphic(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void moveBy(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public void growBy(int dw, int dh) {
		this.width += dw;
		this.height += dh;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("x=%d, y=%d, width=%d, height%d", this.x, this.y, this.width, this.height);
	}
}