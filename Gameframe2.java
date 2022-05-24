import javax.swing.*;
import java.awt.*;

public class Gameframe2 extends JFrame {


    Gamepanel2 gamepanel2;
    Container mainpane;
    Operation2 operation2;
    public Staticpanel2 staticpanel2;

    Gameframe2(Gamepanel2 gamepanel2, Operation2 operation2) {
        this.gamepanel2 = gamepanel2;
        this.operation2 = operation2;
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
        staticpanel2 = new Staticpanel2(operation2);
        mainpane.add(staticpanel2);
        setGamepanel();
        setFocusable(true);
        setLocationRelativeTo(null);
    }
    void setGamepanel() {
        this.setIconImage(new ImageIcon("Tetris.png").getImage());
        gamepanel2 = new Gamepanel2(operation2);
        mainpane.add(gamepanel2);
    }
    Gamepanel2 getGamepanel2() {
        this.setIconImage(new ImageIcon("Tetris.png").getImage());
        return gamepanel2;
    }
}