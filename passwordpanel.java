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
        setSize(500,400);
            setLocationRelativeTo(null);
            JLabel l1 = new JLabel("用户名:");
            username = new JTextField();username.setBounds(150,120,200,30);
            JLabel l2 = new JLabel("密码:");
            password = new JTextField();password.setBounds(150,170,200,30);
            setLayout(null);
            mainpane=getLayeredPane();mainpane.setLayout(null);
            mainpane.add(l1);
            mainpane.add(l2);
            mainpane.setBackground(Color.CYAN);
            mainpane.add(username);
            mainpane.add(password);
            l1.setBounds(71,100,142,60);
            l2.setBounds(71,150,142,60);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            signup= new JButton("注册");   signup.addActionListener(this);
            login = new JButton("登录");   login.addActionListener(this);
            signup.setBounds(80,250,100,50);mainpane.add(signup);
            login.setBounds(270,250,100,50);mainpane.add(login);
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
        g.drawString("已注册",160,90);
    }
}
class havebeennotsigningup extends JFrame{
    havebeennotsigningup(){
        setSize(300,200);
        setLocationRelativeTo(null);
       // setDefaultCloseOperation();
    }
    @Override
    public void paint(Graphics g){
        g.drawString("未注册或密码错误",160,90);
    }
}
