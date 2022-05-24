import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class passwordpanel extends JFrame implements ActionListener {
    PrintWriter detecetive;
    Container mainpane;
    JTextField username;
    JTextField password;
    JButton signup;
    JButton login;
    Scanner sc;
    String passwording;
    String usernaming;
    passwordpanel(){
        mainpane = getLayeredPane();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("登录/注册");
        setSize(500,400);
        ImageIcon imgic=new ImageIcon("pics/panelback1.png");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,500,400);
        mainpane.add(jl,new Integer(0));
        mainpane.setSize(500,400);
            setLocationRelativeTo(null);
            JLabel l1 = new JLabel("用户名:");
            username = new JTextField();username.setBounds(150,120,200,30);
            JLabel l2 = new JLabel("密码:");
            password = new JTextField();password.setBounds(150,170,200,30);
            setLayout(null);
            mainpane=getLayeredPane();mainpane.setLayout(null);
            mainpane.add(l1,new Integer(1));
            mainpane.add(l2,new Integer(1));
            mainpane.setBackground(Color.black);
            mainpane.add(username,new Integer(1));
            mainpane.add(password,new Integer(1));
            l1.setBounds(71,100,142,60);
            l2.setBounds(71,150,142,60);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            signup= new JButton("注册");   signup.addActionListener(this);
            login = new JButton("登录");   login.addActionListener(this);
            signup.setBounds(90,250,100,50);mainpane.add(signup,new Integer(1));
            login.setBounds(270,250,100,50);mainpane.add(login,new Integer(1));
        ImageIcon imageIcon1 = new ImageIcon("pics/注册.png"); // Icon由图片文件形成
        ImageIcon imageIcon2 = new ImageIcon("pics/登录.png");
        Image image1 = imageIcon1.getImage(); // 但这个图片大小可能不适合做Icon
        Image image2 = imageIcon2.getImage();
        Image smallImage1 = image1.getScaledInstance(120,60,Image.SCALE_FAST);
        Image smallImage2 = image2.getScaledInstance(120,60,Image.SCALE_FAST) ;
        // 再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        // 最后设置它为按钮的图片
        signup.setIcon(smallIcon1);
        login.setIcon(smallIcon2);

        }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrintWriter temp ;
        Scanner sc ;
        String passwording=password.getText();
        String usernaming= username.getText();String filename= usernaming+".txt";File file = new File(filename);
        String passcheck = null;

       if(e.getSource()==signup){
          if(file.exists()){
              new havebeensigningup().setVisible(true);
          }else {
              file.mkdir();
              File  file2 = new File(filename,filename);
              try {
                  file2.createNewFile();
                  temp=new PrintWriter(file2);
                  temp.print(passwording);
                  temp.close();
              } catch (IOException ioException) {
                  ioException.printStackTrace();
              }
          }
       }else if(e.getSource()==login){
           if(!file.exists()){
               new havebeennotsigningup().setVisible(true);
           }else{
               File  file3 = new File(filename,filename);
               try {
                   sc=new Scanner(file3);
                   while (sc.hasNext()){
                     passcheck=sc.next();
                   }
                   sc.close();
                   passcheck=String.valueOf(passcheck);//这面有点问题在于出现了相同字符但是不能匹配的情况
                   System.out.println(passcheck);
                   System.out.println(passwording);
               } catch (FileNotFoundException fileNotFoundException) {
                   fileNotFoundException.printStackTrace();
               }
               if(!passcheck.equals(passwording)){
                   new havebeennotsigningup().setVisible(true);
               }else{
                   Panel panel = new Panel();
                   panel.username=usernaming;
                  panel.setVisible(true);
                   setVisible(false);
                   dispose();
               }
           }
       }
    }
}

class havebeensigningup extends JFrame{

    havebeensigningup(){
        setSize(300,200);
        setLocationRelativeTo(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g){

        g.drawImage(new ImageIcon("pics/back.png").getImage(),0,0,300,200,null);
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("注册");
        g.setFont(new Font("黑体",1,20));
        g.drawString("已注册",120,120);
    }
}
class havebeennotsigningup extends JFrame{
    havebeennotsigningup(){
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("登录");
        setSize(300,200);
        setLocationRelativeTo(null);
       // setDefaultCloseOperation();
    }
    @Override
    public void paint(Graphics g){

        g.drawImage(new ImageIcon("pics/back.png").getImage(),0,0,300,200,null);
        g.setFont(new Font("黑体",Font.PLAIN,25));
        g.drawString("未注册或密码错误",50,120);
    }
}
