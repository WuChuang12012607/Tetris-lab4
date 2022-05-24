import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameoverframe extends JFrame {
    JButton bt1;
    public Panel panel;
    int score1= Operation.score;
    int score2= Operation2.score;
    int score3= Operation3.score;
    int score=score1+score2+score3;
    Container mainpane;
    gameoverframe(){
        mainpane = getLayeredPane();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img=new ImageIcon("pics/panelback1.png");
        JLabel jl=new JLabel(img);
        jl.setBounds(0,0,600,900);
        mainpane.add(jl);

        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setLayout(null);
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
        bt1 = new JButton("重新开始");add(bt1);
        bt1.setBounds(160,50,100,20);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    @Override
    public void paint(Graphics g){
        g.drawString("Game Over",190,120);
        g.drawString("Your Score:",190,140);
        g.drawString(" "+score,190,160);
    }
}