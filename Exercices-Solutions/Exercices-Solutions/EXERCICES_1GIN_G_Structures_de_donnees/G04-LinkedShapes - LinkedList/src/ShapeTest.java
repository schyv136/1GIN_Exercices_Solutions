
import shapes.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShapeTest {

    public static void main(String[] args) throws IOException {
        Triangle t = new Triangle(100, 100, java.awt.Color.red, 40, 50, 30);
        Rectangle r = new Rectangle(200, 200, java.awt.Color.blue, 50, 60);
        Circle c = new Circle(300, 300, java.awt.Color.pink, 10);
        Square s = new Square(400, 400, java.awt.Color.cyan, 25);
        Circle x = new Circle(300, 300, java.awt.Color.pink, 20);
        Circle y = new Circle(300, 300, java.awt.Color.pink, 10);
        ShapeList shapeList = new ShapeList();
        shapeList.add(t);
        shapeList.add(r);
        shapeList.add(s);
        shapeList.add(c);
        shapeList.add(x);
        shapeList.add(y);
        System.out.println(shapeList);

        System.out.println(c.equals(x));
        System.out.println(c.equals(y));

        System.out.println("\n/* Surfaces of all shapes */");
        for (int i = 0; i < shapeList.getCount(); i++) {
            System.out.println("Surface of shape =" + shapeList.get(i).getSurface());
        }

        System.out.println("saving...");
        try {
            shapeList.saveToFile("Shapes.shp");
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file :\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error reading file :\n" + ex.getMessage());
        }
        System.out.println("clearing...");
        shapeList.clear();
        System.out.println(shapeList);

        System.out.println("loading...");
        shapeList.loadFromFile2("Shapes.shp");
        System.out.println("contents :");
        System.out.println(shapeList);

        System.out.println("shapeList.remove(2);");
        shapeList.remove(2);
        System.out.println(shapeList);
        
        System.out.println("shapeList.remove(0);");
        shapeList.remove(0);
        System.out.println(shapeList);

        System.out.println("shapeList.remove(new Circle(300, 300, java.awt.Color.pink, 10));");
        shapeList.remove(new Circle(300, 300, java.awt.Color.pink, 10));
        System.out.println(shapeList);
        
        System.out.println("shapeList.remove(r);");
        shapeList.remove(r);
        System.out.println(shapeList);

        System.out.println("shapeList.remove(new Circle(300, 300, java.awt.Color.pink, 10));");
        shapeList.remove(new Circle(300, 300, java.awt.Color.pink, 10));
        System.out.println(shapeList);
        
        System.out.println("shapeList.remove(s);");
        shapeList.remove(s);
        System.out.println(shapeList);


    }
}