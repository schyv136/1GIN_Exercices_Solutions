
/**
 *
 * @author fred
 */
import binarySearchTree.BST;
import java.io.IOException;
import shapes.Rectangle;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;
import shapes.Triangle;

public class BSTTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Triangle t = new Triangle(100, 100, java.awt.Color.red, 40, 50, 30);
        Rectangle r = new Rectangle(200, 200, java.awt.Color.blue, 50, 60);
        Circle c = new Circle(300, 300, java.awt.Color.pink, 10);
        Square s = new Square(400, 400, java.awt.Color.cyan, 25);

        BST<Shape> bst = new BST();

        bst.add(t);
        bst.add(r);
        bst.add(s);
        bst.add(c);
        System.out.println(bst);

        System.out.println("\n/* Use for each (implicit) Iterator */");
        for (Shape sh : bst) {
            System.out.println("Surface of shape =" + sh.getSurface());
        }
        
        System.out.println("Triangle  is in tree : " + bst.contains(t));
        System.out.println("Rectangle is in tree : " + bst.contains(r));
        
        
        System.out.println("Saving Object File...");
        bst.saveToObjectFile("Shapes.obj");
        System.out.println("clearing...");
        bst.clear();
        System.out.println(bst);

        System.out.println("Loading Object File...");
        bst.loadFromObjectFile("Shapes.obj");
        System.out.println("contents :");
        System.out.println(bst);
        
        
        System.out.println("\n/************ remove triangle ************/");
        System.out.println("* Removed: " + bst.remove(t));
        for (Shape sh : bst) {
            System.out.println(sh);
        }

        System.out.println("\n/************ remove triangle ************/");
        System.out.println("* Removed: " + bst.remove(t));
        for (Shape sh : bst) {
            System.out.println(sh);
        }

        System.out.println("\n/************ remove circle ************/");
        System.out.println("* Removed: " + bst.remove(c));
        for (Shape sh : bst) {
            System.out.println(sh);
        }

        System.out.println("\n/************ remove rectangle ************/");
        System.out.println("* Removed: " + bst.remove(r));
        for (Shape sh : bst) {
            System.out.println(sh);
        }

        System.out.println("\n/************ remove square ************/");
        System.out.println("* Removed: " + bst.remove(s));
        for (Shape sh : bst) {
            System.out.println(sh);
        }
    }
}