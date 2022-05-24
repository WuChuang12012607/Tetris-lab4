import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class helpPanel extends JFrame implements ActionListener {
    Boolean help=true;
    Boolean information= true;

    Container helppanel;
    JButton bt21 = new JButton("return");
    JButton bt22 = new JButton("Game Help");
    JButton bt23 = new JButton("Introduction");

    JTextArea gamehelp = new JTextArea("Tetris is a computer game created by Alexey Pazhitnov in the 1980s. The objective of Tetris is that the player is given a sequence of tetromino pieces that they must pack into a rectangular game board Once an entire row is filled up, it is cleared and the pieces above are lowered by one row.", 5,5 );
    JTextArea introductionforauthor = new JTextArea("         Yi Ning 12012808"+"                Wu Chuang 12012607");


    public  helpPanel(){
        setSize(600,900);
        helppanel = getLayeredPane();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("Tetris");
        ImageIcon imgic=new ImageIcon("pics/panelback1.png");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,600,900);
        helppanel.add(jl);
        helppanel.setSize(600,900);
        helppanel.setBounds(0, 0, 600, 900);
        helppanel.setLayout(null);
        helppanel.add(bt21,new Integer(1));
        bt21.setBounds(200, 50, 190, 100);
        bt21.addActionListener(this);
        helppanel.add(bt22,new Integer(1));
        bt22.setBounds(200, 160, 190, 100);
        helppanel.add(gamehelp,new Integer(1));
        gamehelp.setBounds(50,380,500,300);
        bt22.addActionListener(this);

        helppanel.add(bt23,new Integer(1));
        bt23.setBounds(200, 270, 190, 100);
        helppanel.add(introductionforauthor,new Integer(1));
        introductionforauthor.setBounds(50,700,500,120);
        introductionforauthor.setOpaque(true);
        bt23.addActionListener(this);
        gamehelp.setForeground(Color.black); //设置组件的背景色
        gamehelp.setFont(new Font("楷体",Font.BOLD,25)); //修改字体样式
        gamehelp.setLineWrap(true);//自动换行
        gamehelp.setBackground(new Color(255,255,255,70)); //设置按钮背景色
        introductionforauthor.setForeground(Color.BLACK); //设置组件的背景色
        introductionforauthor.setFont(new Font("楷体",Font.BOLD,25)); //修改字体样式
        introductionforauthor.setLineWrap(true);//自动换行
        introductionforauthor.setBackground(new Color(255,255,255,70)); //设置按钮背景色
        introductionforauthor.setForeground(Color.black); //设置组件的背景色
        ImageIcon imageIcon1 = new ImageIcon("pics/return.png"); // Icon由图片文件形成
        ImageIcon imageIcon2 = new ImageIcon("pics/help.png");
        ImageIcon imageIcon3 = new ImageIcon("pics/author.png");
        Image image1 = imageIcon1.getImage(); // 但这个图片大小可能不适合做Icon
        Image image2 = imageIcon2.getImage();
        Image image3 = imageIcon3.getImage();
        Image smallImage1 = image1.getScaledInstance(200,100,Image.SCALE_FAST);
        Image smallImage2 = image2.getScaledInstance(200,100,Image.SCALE_FAST) ;
        Image smallImage3 = image3.getScaledInstance(200,100,Image.SCALE_FAST);
        // 再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        ImageIcon smallIcon3 = new ImageIcon(smallImage3);
        // 最后设置它为按钮的图片
        bt21.setIcon(smallIcon1);
        bt22.setIcon(smallIcon2);
        bt23.setIcon(smallIcon3);

        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introductionforauthor.setVisible(false);
        gamehelp.setVisible(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==bt21){
            setVisible(false);
            new Panel().setVisible(true);
            dispose();
        }else if(e.getSource()==bt22){
            if (help){
                gamehelp.setVisible(true);
                help=false;
            }else {
                gamehelp.setVisible(false);
                help=true;}
        }else if(e.getSource()==bt23){if (information){
            introductionforauthor.setVisible(true);
            information=false;}else{
            introductionforauthor.setVisible(false);
            information=true;
        }}

    }
}