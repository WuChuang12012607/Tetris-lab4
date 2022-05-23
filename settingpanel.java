import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class settingpanel  extends JFrame   implements  ActionListener{

    JPanel back = new JPanel();
    JButton bt1 =  new JButton("display");
    JButton bt2 =  new JButton("music");
    JButton bt3 =  new JButton("return");
    public settingpanel(){
        setSize(370,336);
        setLayout(null);setLocationRelativeTo(null);
        add(back);
        back.setBounds(0,0,370,336);
        back.add(bt1);bt1.setBounds(37,300,111,50);
        back.add(bt2);bt2.setBounds(222,300,111,50);
        back.add(bt3);bt3.setBounds(0,0,90,50);
        bt3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Panel().setVisible(true);
        dispose();
    }
}
