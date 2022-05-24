import javax.swing.*;
import java.awt.*;

public class sample2 {
    public static void main(String[] args) {
       /* continuegamepanel.username="wuyameng123";
        continuegamepanel continuegamepanel = new continuegamepanel();
        continuegamepanel.setVisible(true);*/


       /* JFrame frame = new JFrame();
        frame.setBounds(300,300,300,300);frame.setLayout(null);
        Container container = new Container(); container.setLayout(null);container.setBackground(Color.CYAN);
        JPanel panel = new JPanel(); JScrollPane scrollPane = new JScrollPane(); scrollPane.setBounds(0,0,300,300);
        container.add(panel);
        panel.setBackground(Color.CYAN);panel.setBounds(0,0,300,300);
        container.setBounds(0,0,300,300);

        scrollPane.setBounds(0,0,300,300);
        JButton[] bt= new JButton[4];
        for(int i=0;i<4;i++){
            bt[i]= new JButton(""+i);
            scrollPane.add(bt[i]);
            bt[i].setBounds(50,50,50,50);
        }
        frame.setContentPane(scrollPane);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);*/








                JPanel panel = new JPanel();panel.setBounds(0,0,250,250);
                JFrame jf = new JFrame("测试窗口");
                jf.setSize(250, 250);
                jf.setLocationRelativeTo(null);
                jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                // 创建文本区域组件
                JTextArea textArea = new JTextArea();
                textArea.setText("我操你大爷");
                textArea.setLineWrap(true);                         // 自动换行
                textArea.setFont(new Font(null, Font.PLAIN, 18));   // 设置字体

                // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        panel.setLayout(new GridLayout(21,0,10,10));
        JButton[] bt= new JButton[4];
                for(int i=0;i<4;i++){
                    bt[i]=new JButton(""+i);
                    bt[i].setBounds(10,20*i,180,70);
                    panel.add(bt[i]);
                }
        JScrollPane scrollPane = new JScrollPane(
                panel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
                jf.setContentPane(scrollPane);
                jf.setVisible(true);


       // JPanel view=new JPanel(); //普通面板 view.setBounds(0, 0, 140, 2000);
        // 将要插入到滚动面板中，定义位置及大小 view.setLayout(null);
        // int y=0,x=5,; for(i=0;i<=20;i++) { JButton button_link=new JButton();
        // button_link.setBackground(Color.red); button_link.setText("连接按钮"+i);
        // view.add(button_link); button_link.setBounds(0, y, 150, 50); y=y+50;//x=x+10;
        // button_link.setVisible(true); } //侧边导航栏 //JScrollPane jscrollpane=new JScrollPane(view);
        // JScrollPane jscrollpane=new JScrollPane(); //jscrollpane.setViewportView(view); container.add(jscrollpane);
        // jscrollpane.setBounds(80, 90, 140, 600); jscrollpane.setPreferredSize(new Dimension(468,450)); jscrollpane.setViewportView(view);
        // jscrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );


    }
}
