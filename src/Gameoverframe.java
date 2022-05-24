import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author 屹宁 武创
 */
public class Gameoverframe extends JFrame {
    JButton bt1;
    int score1= Operation.score;
    int score2= Operation2.score;
    int score3= Operation3.score;
    int score=score1+score2+score3;
    String s= Integer.toString(score);
    Container mainpane;
    Gameoverframe(){
        mainpane = getLayeredPane();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setLayout(null);
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
        bt1 = new JButton("重新开始");add(bt1);
        bt1.setBounds(150,50,100,20);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    @Override
    public void paint(Graphics g){
        g.drawString("Game Over",150,170);
        g.drawString("Your Score:",150,190);
        g.drawString(s,150,210);
    }
}