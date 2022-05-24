import javax.swing.*;
import java.awt.*;

public class gameoverframe extends JFrame {
    gameoverframe(){
        setLayout(null);
        setSize(200,100);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    @Override
    public void paint(Graphics g){
        g.drawString("操你大爷",90,50);
    }
}
