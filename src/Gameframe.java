import javafx.scene.layout.Background;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

//首先，我们需要三个部分，Gamepanel，Gameframe ，Staticpanel,Operation以及Gamedata
public class Gameframe extends JFrame {


    Gamepanel gamepanel;
    Container mainpane;
    Operation operation;
    public Staticpanel staticpanel;

    Gameframe(Gamepanel gamepanel, Operation operation) {

        this.gamepanel = gamepanel;
        this.operation = operation;
        mainpane = getLayeredPane();
        setBounds(100, 50, 600, 900);
        setTitle("TETRIS");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imgic=new ImageIcon("pics/小成品.png");
       JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,600,900);
        getContentPane().add(jl);
        staticpanel = new Staticpanel(operation);
        mainpane.add(staticpanel);
        setGamepanel();
        setFocusable(true);
        setLocationRelativeTo(null);
    }
    void setGamepanel() {
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        gamepanel = new Gamepanel(operation);
        mainpane.add(gamepanel);
    }
    Gamepanel getGamepanel() {
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        return gamepanel;
    }
}
