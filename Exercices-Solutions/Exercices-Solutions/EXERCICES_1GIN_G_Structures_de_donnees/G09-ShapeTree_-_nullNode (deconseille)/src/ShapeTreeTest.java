
import java.io.IOException;
import shapes.*;

public class ShapeTreeTest {

    public static void main(String[] args) throws IOException {
        Triangle t = new Triangle(100, 100, java.awt.Color.red, 40, 50, 30);
        Rectangle r = new Rectangle(200, 200, java.awt.Color.blue, 50, 60);
        Circle c = new Circle(300, 300, java.awt.Color.pink, 10);
        Square s = new Square(400, 400, java.awt.Color.cyan, 25);

        ShapeTree shapeTree = new ShapeTree();

        shapeTree.add(t);
        shapeTree.add(r);
        shapeTree.add(s);
        shapeTree.add(c);
        System.out.println(shapeTree);

        System.out.println("\n/* Use for each (implicit) Iterator */");
        for (Shape sh : shapeTree)
        	System.out.println("Surface of shape ="+sh.getSurface());        

        //shapeList.sort();

        System.out.println("saving...");
        shapeTree.saveToFile("Shapes.shp");
        System.out.println("clearing...");
        shapeTree.clear();
        System.out.println(shapeTree);

        System.out.println("loading...");
        shapeTree.loadFromFile2("Shapes.shp");
        System.out.println("contents :");
        System.out.println(shapeTree);
    }
}