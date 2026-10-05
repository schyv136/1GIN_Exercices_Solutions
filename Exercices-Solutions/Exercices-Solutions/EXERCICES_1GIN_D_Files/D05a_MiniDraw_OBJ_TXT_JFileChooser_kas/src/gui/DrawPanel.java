package gui;


/**
 *
 * @author fred
 */

import AllFigures.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

import java.io.IOException;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class DrawPanel extends JPanel implements MouseListener,MouseMotionListener
{
    /** vector of Figures to paint **/
    protected Figures figures = new Figures();

    //ActionModes: 0:DRAW 1:DELETE 2:Forward 3:Backward 4:TOTOP 5:TOBOTTOM 6:MoveFigure
    protected int actionMode=0;
    //DrawModes : 0:RECTANGLE, 1:ELLIPSE, 2:LINE
    protected int drawMode=0;

    protected Color borderColor=Color.RED;
    protected Color fillColor  =Color.ORANGE;

    /**
    * constructor creating MouseListener
    */
    public DrawPanel()
    {
        //without this, mouseEvents are not evaluated!
        addMouseListener(this);  //don't forget...
        addMouseMotionListener(this);  //for MouseMove/MouseDragged => inverted drawing

        // setting the double buffer for better performance
        this.setDoubleBuffered(true);
    }

    //getters & setters
    public void setFillColor(Color fc)   { fillColor   = fc; }
    public void setBorderColor(Color bc) { borderColor = bc; }
    public void setDrawMode  (int dm)    { drawMode    = dm; }
    public void setActionMode(int am)    { actionMode  = am; }

    public Color getFillColor()   { return fillColor;   }
    public Color getBorderColor() { return borderColor; }
    public int   getDrawMode()    { return drawMode;    }
    public int   getActionMode()  { return actionMode;  }

    /**
     * Draw axis and coordinates on the upper and left sides of the panel
     * @param g	the graphic context on which to paint
     */
    public void drawAxis(Graphics g)
    {
	g.setColor(getForeground());
    	g.drawLine( 0, 0, 0         , getHeight() );
    	g.drawLine( 0, 0, getWidth(), 0           );
    	for (int i=0; i<=getHeight() / 10 ; i++)  g.drawLine( 0    , i*10 , 2    , i*10  );
    	for (int i=0; i<=getWidth()  / 10 ; i++)  g.drawLine( i*10 , 0    , i*10 , 2     );
    	for (int i=0; i<=getHeight() / 100; i++)  g.drawLine( 0    , i*100, 5    , i*100 );
    	for (int i=0; i<=getWidth()  / 100; i++)  g.drawLine( i*100, 0    , i*100, 5     );
    	g.drawString("(0,0)",3,15);
    	for (int i=1; i<=getHeight() / 100; i++)  g.drawString( ""+i*100, 6       , i*100+5 );
    	for (int i=1; i<=getWidth()  / 100; i++)  g.drawString( ""+i*100, i*100-12, 18      );
    }



     /**
      * Paint/Repaint panel automatically when necessary
      * paintComponent is called automatically whenever the panel
      * reappears on screen or changes it's size
      * Also called when performing a repaint()
      * @param g 	the panel's graphic context
      */
     @Override
     public void paintComponent(Graphics g)
     {
         super.paintComponent(g);
         g.setColor(getBackground());
         g.fillRect( 0, 0, getWidth(), getHeight() );
         drawAxis(g);
         figures.draw(g);
     }
    //=========================================================================
    //FileOperations

     public void clear()
     {
         figures.deleteAll();
         repaint();
     }


     public void loadFromFile(String fileName)
     {
         figures.loadFromFile(fileName);
         repaint();
     }

     public void saveToFile(String fileName)
     {
         figures.saveToFile(fileName);
     }

    public void loadFromTxtFile(String fileName) throws IOException
     {
         figures.loadFromTxtFile(fileName);
         repaint();
     }

     public void saveToTxtFile(String fileName) throws IOException
     {
         figures.saveToTxtFile(fileName);
     }

    //=========================================================================
    //MouseActions

    protected Point start;
    protected Figure selected = null; //introduced for 'Move while dragging'

    //Extras: for Inverted drawing while dragging
    protected Point old;
    protected boolean drawOk=false;


    @Override
    public void mousePressed(MouseEvent me)
    {
        start = me.getPoint();
        old   = me.getPoint(); //init 'old' Mouse Position (during drag)
        drawOk = true;
        selected = figures.clickedFigureAt(start); 
        //marker - nice at the beginning but not necessary
        //getGraphics().drawLine(me.getX()-3, me.getY()-3, me.getX()+3, me.getY()+3);
        //getGraphics().drawLine(me.getX()-3, me.getY()+3, me.getX()+3, me.getY()-3);
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
        Point end = me.getPoint();
        
        if (actionMode==0) //ActionMode.DRAW
           {
            if (drawMode==0)           //DrawMode:RECTANGLE
               figures.add(new Rectangle(start, end, borderColor, fillColor  ));
            else if (drawMode==1)      //DrawMode:ELLIPSE
               figures.add(new Ellipse  (start, end, borderColor, fillColor  ));
            else if (drawMode==2)      //DrawMode:LINE)
               figures.add(new Line     (start, end, borderColor, borderColor));
            }

        else

          if(actionMode == 1)      //ActionMode:DELETE
             {
                figures.delete(selected);
             }
          else if (actionMode== 2) //ActionMode:Forward
             {
                figures.forward(selected);
             }
          else if (actionMode== 3) //ActionMode:Backward
             {
                figures.backward(selected);
             }
          else if (actionMode== 4) //ActionMode:TOTOP
             {
                figures.toTop(selected);
             }
          else if (actionMode== 5) //ActionMode:TOBOTTOM
             {
                figures.toBottom(selected);
             }
          else if (actionMode== 6) //ActionMode:Move Figure (-> shift)
             {
               // ==> now: immediate move while dragging see mouseDragged
               // if (selected!=null) selected.shiftBy(end.x-start.x , end.y-start.y);
             }

        drawOk=false; //no inverted drawing until next MousePressed Event
        selected = null;
        repaint();        
    }

    @Override
    public void mouseExited(MouseEvent me)  {} //has to be overwritten because it's abstract in super class

    @Override
    public void mouseEntered(MouseEvent me) {} //has to be overwritten because it's abstract in super class

    @Override
    public void mouseClicked(MouseEvent me) {} //has to be overwritten because it's abstract in super class



    //INVERTED DRAWING
    //Has to use MouseDragged (MouseMove only works if no Button is pushed!)
    @Override
    public void mouseDragged(java.awt.event.MouseEvent evt) {
        //if (evt.getButton()==1) {  //GRRRR!!! works differently on Mac and Win!!!
        if (drawOk) {                //==> DrawOk to make it work anywhere...
            int x=evt.getX();
            int y=evt.getY();

            if (actionMode==6) { //Move while dragging
                if (selected!=null) selected.shiftBy(x-old.x , y-old.y);
                repaint();
            }
            else if (actionMode==0)  //inverted drawing
            {
                Graphics g = getGraphics();
                g.setXORMode(new Color(255,255,255)); 
                g.setColor(Color.GRAY);
                if (drawMode==2) { //draw lines
                    g.drawLine(start.x,start.y,old.x,old.y);
                    g.drawLine(start.x,start.y,x,y);
                }
                if (drawMode==0) { //draw rectangles
                    g.fillRect(Math.min(start.x,old.x), Math.min(start.y,old.y),
                               Math.abs(start.x-old.x), Math.abs(start.y-old.y));
                    g.fillRect(Math.min(start.x,x), Math.min(start.y,y),
                               Math.abs(start.x-x), Math.abs(start.y-y));

                }
                if (drawMode==1) { //draw ellipses
                    g.fillOval(Math.min(start.x,old.x), Math.min(start.y,old.y),
                               Math.abs(start.x-old.x), Math.abs(start.y-old.y));
                    g.fillOval(Math.min(start.x,x), Math.min(start.y,y),
                               Math.abs(start.x-x), Math.abs(start.y-y));
                }
                g.setPaintMode();
            }

            old.x = x;
            old.y = y;
        }
    }

    @Override
    public void mouseMoved(MouseEvent me)  {} //has to be overwritten because it's abstract in super class


}
