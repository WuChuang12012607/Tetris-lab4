import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pausepanel extends JFrame {
    JButton bt1;
    JButton bt2;
    Container main;
    simplepanel simplepanel;
    pausepanel(){
        simplepanel = new simplepanel();
        setSize(400,500);
        bt1 = new JButton("是");bt1.setBounds(90,200,100,70);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        bt2 = new JButton("否");bt2.setBounds(200,200,100,70);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
       main = getLayeredPane();
       main.setBounds(0,0,400,500);
        main.add(simplepanel,new Integer(0));
        main.add(bt1,new Integer(1));
        main.add(bt2,new Integer(1));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class simplepanel extends  JPanel{
    simplepanel(){
        setBounds(0,0,400,200);
    }
    @Override
    public void paint(Graphics g){
        g.setFont(new Font("黑体",23,23));
        g.drawString("是否继续游戏",80,100);
    }
}