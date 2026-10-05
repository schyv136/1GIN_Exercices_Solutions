
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

    public MyTextField(int x, int y, int width, int height, String text) {
        super(text);
        setBounds(x, y, width, height);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    
     @Override
    public String toString() {
        return "MyTextField ; [Surface=" + getSurface() + "] - x="+x+", y="+y+", width="+width+", height="+height;
    }

    
    public int compareTo(Computable other)
	{
		double diff = getSurface() - other.getSurface();
		if      (diff>0)  return 1;
		else if (diff<0)  return -1;
		else return 0; 
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
