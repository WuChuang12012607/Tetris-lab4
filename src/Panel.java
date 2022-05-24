import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
 class Panel extends JFrame implements  ActionListener {

   public static String username;
    Container mainpanel ;



    JButton bt11 ;
    JButton bt12 ;
    JButton bt14 ;



    public Panel() {
        mainpanel = getLayeredPane();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("Tetris");
        ImageIcon imgic=new ImageIcon("pics/panelback.png");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,810,1000);
        mainpanel.add(jl);
        bt11 = new JButton("New Game");
        bt12 = new JButton("Continue Game");
        bt14 = new JButton("Reference");

        setSize(810, 1000);

        mainpanel.setSize(810, 1000);

     /*   add(mainpanel);*/
        mainpanel.setLayout(null);
        mainpanel.add(bt11,new Integer(1));
        bt11.setBounds(295, 326, 220, 100);
        bt11.addActionListener(this);

        mainpanel.add(bt12,new Integer(1));
        bt12.setBounds(295, 440, 220, 100);
        bt12.addActionListener(this);

        mainpanel.add(bt14,new Integer(1));
        bt14.setBounds(295, 554, 220, 100);
        bt14.addActionListener(this);

        ImageIcon imageIcon1 = new ImageIcon("pics/newgame.png"); // Icon由图片文件形成
        ImageIcon imageIcon2 = new ImageIcon("pics/continue.png");

        ImageIcon imageIcon4 = new ImageIcon("pics/information.png");
        ImageIcon imageIcon5 = new ImageIcon("pics/quit.png");
        Image image1 = imageIcon1.getImage(); // 但这个图片大小可能不适合做Icon
        Image image2 = imageIcon2.getImage();

        Image image4 = imageIcon4.getImage();
        Image image5 = imageIcon5.getImage();
        Image smallImage1 = image1.getScaledInstance(230,100,Image.SCALE_FAST);
        Image smallImage2 = image2.getScaledInstance(230,100,Image.SCALE_FAST) ;

        Image smallImage4 = image4.getScaledInstance(230,100,Image.SCALE_FAST) ;
        Image smallImage5 = image5.getScaledInstance(230,100,Image.SCALE_FAST);
        // 再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        ImageIcon smallIcon4 = new ImageIcon(smallImage4);
        ImageIcon smallIcon5 = new ImageIcon(smallImage5);
        // 最后设置它为按钮的图片
        bt11.setIcon(smallIcon1);
        bt12.setIcon(smallIcon2);
        bt14.setIcon(smallIcon4);


        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==bt14){
            setVisible(false);
            new helpPanel().setVisible(true);
            dispose();
        }
        else if(e.getSource()==bt11){
            setVisible(false);
            Levelpanel levelpanel = new Levelpanel();
            levelpanel.setVisible(true);
            levelpanel.username=username;
            dispose();
        }else if(e.getSource()==bt12){
            setVisible(false);continuegamepanel.username=username;
            continuegamepanel continuegamepanel2 = new continuegamepanel();

            continuegamepanel2.setVisible(true);
            dispose();
        }

    }
}












