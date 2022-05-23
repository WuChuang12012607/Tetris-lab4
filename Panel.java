import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class Panel extends JFrame implements  ActionListener {

    JPanel mainpanel ;
    JButton bt11 ;
    JButton bt12 ;
    JButton bt13 ;
    JButton bt14 ;
    JButton bt15 ;

    public Panel() {
        mainpanel = new JPanel();
        bt11 = new JButton("New Game");
        bt12 = new JButton("Continue Game");
        bt13 = new JButton("Setting");
        bt14 = new JButton("Reference");
        bt15 = new JButton("Quit");
        setSize(1110, 1008);
        setLayout(null);
        mainpanel.setSize(1111, 1008);
        mainpanel.setBackground(Color.CYAN);
        add(mainpanel);
        mainpanel.setLayout(null);
        mainpanel.add(bt11);
        bt11.setBounds(370, 426, 370, 88);
        bt11.addActionListener(this);

        mainpanel.add(bt12);
        bt12.setBounds(370, 530, 370, 88);
        mainpanel.add(bt13);
        bt13.setBounds(370, 634, 370, 88);
        bt13.addActionListener(this);

        mainpanel.add(bt14);
        bt14.setBounds(370, 738, 370, 88);
        bt14.addActionListener(this);
        mainpanel.add(bt15);
        bt15.setBounds(370, 842, 370, 88);
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
        else if(e.getSource()==bt13){
           setVisible(false);
            new settingpanel().setVisible(true);
            dispose();
        }else if(e.getSource()==bt11){
            setVisible(false);
            Operation operation = new Operation();

            Gamepanel gamepanel = new Gamepanel(operation);
            Gameframe frame = new Gameframe(gamepanel,operation);
            operation.setGameframe(frame);

            frame.setVisible(true);
            dispose();
        }
    }
}












class LoginFrame extends JFrame implements ActionListener {

// 申明需要的组件

    JButton jb1, jb2;//按钮

    JTextField jtf1;//文本框

    JPasswordField jpf1;//密码框

    public LoginFrame() {

// 窗口属性的设置

        setTitle("登陆窗");// 窗口标题

        setSize(300, 180);// 窗口大小

        setLocationRelativeTo(null);// 窗口居中

        setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭窗口则退出虚拟机

        setLayout(new FlowLayout());// 设置布局流式布局

        JPanel jp = new JPanel(new GridLayout(4, 1));// 设置面板为表格布局4行1列

// 第一行

        JPanel jp1 = new JPanel();

        JLabel jl1 = new JLabel("账号 ");

        jtf1 = new JTextField(12);

        jp1.add(jl1);

        jp1.add(jtf1);

        jp.add(jp1);

// 第二行

        JPanel jp2 = new JPanel();

        JLabel jl2 = new JLabel("密码 ");

        jpf1 = new JPasswordField(12);

        jp2.add(jl2);

        jp2.add(jpf1);

        jp.add(jp2);

// 第三行

        JPanel jp3 = new JPanel();

        jb1 = new JButton("登陆");

        jb1.addActionListener(this);// 添加动作响应器

        jb2 = new JButton("重置");

        jb2.addActionListener(this);// 添加动作响应器

        jp3.add(jb1);

        jp3.add(jb2);

        jp.add(jp3);

// 第四行

        JPanel jp4 = new JPanel();

        JLabel jl3 = new JLabel("提示: 账号 admin 密码 123");

        jl3.setForeground(Color.DARK_GRAY);

        jp4.add(jl3);

        jp.add(jp4);

        add(jp);

    }

// 动作响应

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();// 根据动作命令,来进行分别处理

        if (cmd.equals("登陆")) {

            String id = jtf1.getText();// 取得用户名

            String key = new String(jpf1.getPassword());// 取得密码

            if (id.equals("admin") && key.equals("123")) {// 判断是否登录成功

// 如果登录成功

                setVisible(false);// 本窗口隐藏,

                new MainFrame(id).setVisible(true);// 新窗口显示

                dispose();//本窗口销毁,释放内存资源

            } else {

//如果登录失败  弹出提示

                JOptionPane.showMessageDialog(this, "用户名或者密码错误.", "通知", JOptionPane.ERROR_MESSAGE);

                clearText();//清空文本框 密码框的输入

            }

        } else if (cmd.equals("重置")) {

            clearText();

        }

    }

    private void clearText() {//清空文本框, 密码框的输入

        jtf1.setText("");

        jpf1.setText("");

    }

//main方法, 程序的入口


}


 class MainFrame extends JFrame {

     public MainFrame(String name) {

         setTitle("主窗口");//标题

         setSize(300, 260);//大小

         setLocationRelativeTo(null);//居中

         setDefaultCloseOperation(EXIT_ON_CLOSE);

         JPanel jp = new JPanel();

         JLabel jl1 = new JLabel("欢迎");

         JLabel jl2 = new JLabel(name);

         jl2.setForeground(Color.BLUE);//设置文本颜色

         JLabel jl3 = new JLabel("使用系统.");

         jp.add(jl1);

         jp.add(jl2);

         jp.add(jl3);

         add(jp, BorderLayout.NORTH);

         JTextArea jta = new JTextArea();

         jta.setLineWrap(true);

         jta.append("消息提示");

         jta.append(" 消息!通知~!");

         JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         add(jsp);

         JPanel jp2 = new JPanel();

         JButton jb = new JButton("退出");

         jb.addActionListener(new ActionListener() {

             public void actionPerformed(ActionEvent e) {

                 System.exit(0);//退出

             }

         });

         jp2.add(jb);

         add(jp2, BorderLayout.SOUTH);

     }
 }



