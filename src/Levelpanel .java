import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Levelpanel extends JFrame {

    public static String username;
    Container contentPane;
    JPanel panel;
    JTextField L1;
    JButton bt1;
    JButton bt2;
    JButton bt3;
    JButton bt4;
    int speed;
    Random random = new Random();
    Levelpanel(){
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("Level selection");
        contentPane = getLayeredPane();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imgic=new ImageIcon("pics/level.png");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,600,500);
        contentPane.add(jl);
        panel = new JPanel();panel.setBounds(0,0,600,500);panel.setLayout(null);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JSlider slider=new JSlider(200,500);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        panel.add(slider);slider.setBounds(150,20,300,50);
        contentPane.add(panel);
        JLabel l1=new JLabel("普通");
        JLabel l2=new JLabel("中级");
        JLabel l3=new JLabel("高级");
        JLabel l4=new JLabel("返回");
        setLayout(null);
        l1.setBounds(270,110,142,60);
        l2.setBounds(270,190,142,60);
        l3.setBounds(270,270,142,60);
        l4.setBounds(270,350,142,60);
        l1.setFont(new Font("黑体",1,25));
        l2.setFont(new Font("黑体",1,25));
        l3.setFont(new Font("黑体",1,25));
        l4.setFont(new Font("黑体",1,25));
        contentPane.add(l1,new Integer(2));
        contentPane.add(l2,new Integer(2));
        contentPane.add(l3,new Integer(2));
        contentPane.add(l4,new Integer(2));

        bt1 = new JButton("生涯模式");panel.add(bt1);bt1.setBounds(150,100,300,75);
        bt2 = new JButton("快速模式");panel.add(bt2);bt2.setBounds(150,180,300,75);//就是出现三四十个块，这个不可以保存
        bt3 = new JButton("恶心人的模式");panel.add(bt3);bt3.setBounds(150,260,300,75);
        bt4 = new JButton("返回"); panel.add(bt4);bt4.setBounds(150,340 , 300,75);
        ImageIcon imageIcon1 = new ImageIcon("pics/1.png"); // Icon由图片文件形成
        ImageIcon imageIcon2 = new ImageIcon("pics/2.png");

        ImageIcon imageIcon3 = new ImageIcon("pics/3.png");
        ImageIcon imageIcon4 = new ImageIcon("pics/4.png");
        Image image1 = imageIcon1.getImage(); // 但这个图片大小可能不适合做Icon
        Image image2 = imageIcon2.getImage();
        Image image3 = imageIcon3.getImage();
        Image image4 = imageIcon4.getImage();
        Image smallImage1 = image1.getScaledInstance(310,75,Image.SCALE_FAST);
        Image smallImage2 = image2.getScaledInstance(310,75,Image.SCALE_FAST) ;

        Image smallImage3 = image3.getScaledInstance(310,75,Image.SCALE_FAST) ;
        Image smallImage4 = image4.getScaledInstance(310,75,Image.SCALE_FAST);
        // 再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        ImageIcon smallIcon3 = new ImageIcon(smallImage3);
        ImageIcon smallIcon4 = new ImageIcon(smallImage4);
        // 最后设置它为按钮的图片
        bt1.setIcon(smallIcon1);
        bt2.setIcon(smallIcon2);
        bt3.setIcon(smallIcon3);
        bt4.setIcon(smallIcon4);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.add(bt1,new Integer(1));
        contentPane.add(bt2,new Integer(1));
        contentPane.add(bt3,new Integer(1));
        contentPane.add(bt4,new Integer(1));
        contentPane.add(slider,new Integer(1));

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
