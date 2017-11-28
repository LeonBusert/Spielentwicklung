
package MoveTest;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class MoveTest {
    public static void main(String [] args) {
        
        Player player = new Player(300, 300, 50, 1920, 1080);
        
        Frame f = new Frame(player);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1920, 1080);
        f.setUndecorated(true);
    //    f.setVisible(true);
        f.setResizable(false);
        DisplayMode displayMode = new DisplayMode(1920, 1080, 16, 60);
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        
        device.setFullScreenWindow(f);
         //device.setDisplayMode(displayMode);
        
        long lastFrame = System.currentTimeMillis();
        
        while(true){

            long thisFrame = System.currentTimeMillis();
            float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
            lastFrame=thisFrame;
            
            player.update(timeSinceLastFrame, f.getUp(), f.getDown(), f.getLeft(), f.getRight());
            
            
            f.repaintScreen();
            
            
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoveTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
    
