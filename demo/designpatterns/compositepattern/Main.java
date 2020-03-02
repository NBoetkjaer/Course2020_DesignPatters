package demo.designpatterns.compositepattern;

public class Main {

	public static void main(String[] args) {
		
		Line line1 = new Line(10, 20, 100, 200, 1);
		Rectangle rect1 = new Rectangle(50, 60, 25, 35, true);

		line1.moveBy(2, 3);
		System.out.println(line1 + "\n");

		rect1.growBy(5, 10);
		System.out.println(rect1 + "\n");

		Group group1 = new Group();
		group1.add(line1);
		group1.add(rect1);
		group1.moveBy(10, 10);
		group1.growBy(20, 20);
		System.out.println(group1 + "\n");
	}
}
