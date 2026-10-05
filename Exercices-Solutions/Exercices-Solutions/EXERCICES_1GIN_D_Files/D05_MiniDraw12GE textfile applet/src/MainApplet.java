
import javax.swing.JApplet;
import javax.swing.UIManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fred
 */

public class MainApplet extends JApplet
{
   @Override
   public void init()
   {
       try
       {
           // change the default look & feel
           UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
           // load the MainPanel
           this.getContentPane().add(new DrawPanel());
       }
       catch (Exception ex)
       {
       }
   }
}
