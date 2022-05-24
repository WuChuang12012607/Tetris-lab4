import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Levelpanel extends JFrame {
    public static String username;
    Container contentPane;
    JPanel panel;
    JButton bt1;
    JButton bt2;
    JButton bt3;
    JButton bt4;
    int speed;
    Random random = new Random();
    Levelpanel(){
        setResizable(false);
        panel = new JPanel();panel.setBounds(0,0,500,500);panel.setLayout(null);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        contentPane=getLayeredPane();
        JSlider slider=new JSlider(200,500);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        panel.add(slider);slider.setBounds(150,20,300,75);
       contentPane.add(panel);
       bt1 = new JButton("生涯模式");panel.add(bt1);bt1.setBounds(150,100,300,75);
       bt2 = new JButton("快速模式");panel.add(bt2);bt2.setBounds(150,180,300,75);//就是出现三四十个块，这个不可以保存
       bt3 = new JButton("恶心人的模式");panel.add(bt3);bt3.setBounds(150,260,300,75);
        bt4 = new JButton("返回"); panel.add(bt4);bt4.setBounds(150,340 , 300,75);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                if (!slider.getValueIsAdjusting()) {
                    speed = slider.getValue();
                    System.out.println(speed);
                    getspeed();
                }
            } });
        int temp=speed;
        this.speed=speed;
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Panel.username = username;
                Panel panel = new Panel();
                panel.setVisible(true);
                dispose();
            }
        });
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operation operation = new Operation();
            operation.username=username;
            System.out.println(speed);
            operation.setspeed(speed);
                int a2= random.nextInt(21);
               operation.shape=operation.Shape[a2];
            Gamepanel gamepanel = new Gamepanel(operation);
            Gameframe frame = new Gameframe(gamepanel,operation);
            operation.setGameframe(frame);
            frame.setVisible(true);
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  Operation2 operation2 = new Operation2();
            operation2.username=username;
                operation2.speed=speed;
                int a2= random.nextInt(21);
                operation2.shape=operation2.Shape[a2];
            Gamepanel2 gamepanel2 = new Gamepanel2(operation2);
            Gameframe2 frame2 = new Gameframe2(gamepanel2,operation2);
            operation2.setGameframe(frame2);
            frame2.setVisible(true);
            }
        });
          bt3.addActionListener(new ActionListener() {
       @Override
          public void actionPerformed(ActionEvent e) {
           Operation3 operation3 = new Operation3();
           operation3.username=username;
           operation3.speed=speed;
           int a2= random.nextInt(21);
           operation3.shape=operation3.Shape[a2];
           Gamepanel3 gamepanel3 = new Gamepanel3(operation3);
           Gameframe3 frame3 = new Gameframe3(gamepanel3,operation3);
           operation3.setGameframe(frame3);
           frame3.setVisible(true);
    }
});


    }



    public void getspeed(){
        System.out.println(speed);
    }
}
