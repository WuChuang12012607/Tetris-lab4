import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameoverframe extends JFrame {
    JButton bt1;
    gameoverframe(){
        this.setIconImage(new ImageIcon("Tetris.png").getImage());
        setLayout(null);
        setSize(200,100);
        setResizable(false);
        setLocationRelativeTo(null);
        bt1 = new JButton("重新开始");add(bt1);bt1.setBounds(60,50,80,20);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    @Override
    public void paint(Graphics g){
        g.drawString("操你大爷",90,50);
    }
}
