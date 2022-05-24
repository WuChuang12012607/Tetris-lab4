import javax.swing.*;
import java.awt.*;


public class Gameframe3 extends JFrame {
    Gamepanel3 gamepanel3;
    Container mainpane;
    Operation3 operation3;
    public Staticpanel3 staticpanel3;

    Gameframe3(Gamepanel3 gamepanel3, Operation3 operation3) {
        this.gamepanel3 = gamepanel3;
        this.operation3 = operation3;
        mainpane = getLayeredPane();
        setBounds(100, 50, 600, 900);
        setTitle("TETRIS");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imgic=new ImageIcon("小成品.png");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,600,900);
        getContentPane().add(jl);
        staticpanel3 = new Staticpanel3(operation3);
        mainpane.add(staticpanel3);
        setGamepanel();
        setFocusable(true);
        setLocationRelativeTo(null);
    }
    void setGamepanel() {
        this.setIconImage(new ImageIcon("Tetris.png").getImage());
        gamepanel3 = new Gamepanel3(operation3);
        mainpane.add(gamepanel3);
    }
    Gamepanel3 getGamepanel3() {
        this.setIconImage(new ImageIcon("Tetris.png").getImage());
        return gamepanel3;
    }
}