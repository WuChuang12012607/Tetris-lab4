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
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("暂停");
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
        ImageIcon imgic=new ImageIcon("pics/over.png");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,400,500);
        main.add(jl);
        main.add(simplepanel,new Integer(0));

        ImageIcon imageIcon1 = new ImageIcon("pics/是.png");
        Image image1 = imageIcon1.getImage();
        Image smallImage1 = image1.getScaledInstance(100,70,Image.SCALE_FAST);
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        bt1.setIcon(smallIcon1);
        ImageIcon imageIcon2 = new ImageIcon("pics/否.png");
        Image image2 = imageIcon2.getImage();
        Image smallImage2 = image2.getScaledInstance(100,70,Image.SCALE_FAST);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        bt2.setIcon(smallIcon2);
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