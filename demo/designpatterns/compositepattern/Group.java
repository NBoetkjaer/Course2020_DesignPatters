package demo.designpatterns.compositepattern;

import java.util.ArrayList;
import java.util.List;

/*
 * This is the "Composite class" in the Composite pattern.
 */
public class Group extends Graphic {

	private List<Graphic> graphics = new ArrayList<Graphic>();

	public Group() {
		super(0, 0, 0, 0);

		// For the sake of this example, we'll allow a Group to be created
		// empty.
		// In a real GUI package, we might enforce a stricter rule that a Group
		// must contain at least 2 graphic objects (i.e. it must have something
		// to group together!)
	}

	@Override
	public void add(Graphic g) {
		this.graphics.add(g);
	}

	@Override
	public void remove(Graphic g) {
		this.graphics.remove(g);
	}

	@Override
	public void moveBy(int dx, int dy) {
		// Recursively move all constituent parts.
		for (Graphic g : this.graphics) {
			g.moveBy(dx, dy);
		}
	}

	@Override
	public void growBy(int dw, int dh) {
		// Recursively grow all constituent parts.
		for (Graphic g : this.graphics) {
			g.growBy(dw, dh);
		}
	}

	@Override
	public String toString() {
		// Get a string representation of all constituent parts
		String str = "Group object contains:\n";
		for (Graphic g : this.graphics) {
			str += "\t" + g.toString() + "\n";
		}

		return str;
	}
}