
import javax.swing.JApplet;
import javax.swing.UIManager;

/**
 *
 * @author fred
 */
public class MainApplet extends JApplet { 

    @Override
    public void init() { 
//        try {
//            UIManager.setLookAndFeel(
//                    UIManager.getCrossPlatformLookAndFeelClassName());
            this.getContentPane().add(new DrawPanel());
//        } catch (Exception ex) {
//        }
    }
}