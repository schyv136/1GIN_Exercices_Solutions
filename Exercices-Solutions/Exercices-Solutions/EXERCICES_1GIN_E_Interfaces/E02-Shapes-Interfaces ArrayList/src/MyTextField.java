
import java.awt.Point;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author scy
 */
public class MyTextField extends JTextField implements Computable {
    private int width;
    private int height;
    private int x;
    private int y;

    public MyTextField(String text) {
        super(text);
        Point position=getLocation();
        x=position.x;
        y=position.y;
        width=getWidth();
        height=getHeight();
    }
    
    

    @Override
    public double getSurface() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return (width+height)*2;
    }
    
}
