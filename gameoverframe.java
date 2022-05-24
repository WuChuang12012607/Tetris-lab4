import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameoverframe extends JFrame {
    JButton bt1;
    int score;
    gameoverframe(){
        score = 0;
        this.setIconImage(new ImageIcon("Tetris.png").getImage());
        setLayout(null);
        setSize(400,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bt1 = new JButton("重新开始");add(bt1);bt1.setBounds(150,250,100,40);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    @Override
    public void paint(Graphics g){
        g.drawString("Game Over",150,200);
        g.drawString("Your Score:",150,100);
        g.drawString(""+score,150,150);
    }
}

