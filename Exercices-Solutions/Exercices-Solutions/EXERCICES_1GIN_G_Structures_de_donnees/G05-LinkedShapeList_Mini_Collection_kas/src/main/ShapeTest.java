package main;


import java.io.IOException;
import shapes.Circle;
import shapes.Triangle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

public class ShapeTest {

    public static void main(String[] args) throws IOException {
        Triangle t = new Triangle(100, 100, java.awt.Color.red, 40, 50, 30);
        Rectangle r = new Rectangle(200, 200, java.awt.Color.blue, 50, 60);
        Circle c = new Circle(300, 300, java.awt.Color.pink, 10);
        Square s = new Square(400, 400, java.awt.Color.cyan, 25);
        ShapeList shapeList = new ShapeList();
        shapeList.add(t);
        shapeList.add(r);
        shapeList.add(s);
        shapeList.add(c);
        System.out.println(shapeList);

        System.out.println("\n/* Use for each (implicit) Iterator */");
        for (Object sh : shapeList) {
            System.out.println("Surface of shape =" + ((Shape) sh).getSurface());
        }

        //shapeList.sort();

        System.out.println("saving...");
        shapeList.saveToFile("Shapes.shp");
        System.out.println("clearing...");
        shapeList.clear();
        System.out.println(shapeList);

        System.out.println("loading...");
        shapeList.loadFromFile2("Shapes.shp");
        System.out.println("contents :");
        System.out.println(shapeList);
    }
}