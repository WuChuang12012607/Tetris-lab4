import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class Panel extends JFrame implements  ActionListener {
    String username;

    JPanel mainpanel ;
    JButton bt11 ;
    JButton bt12 ;
    JButton bt13 ;
    JButton bt14 ;
    JButton bt15 ;

    public Panel() {
        mainpanel = new JPanel();
        setResizable(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imgic=new ImageIcon("小成品.png");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,600,900);
        getContentPane().add(jl);
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
        bt12.addActionListener(this);
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
            operation.username=username;
            Gamepanel gamepanel = new Gamepanel(operation);
            Scorepanel scorepanel = new Scorepanel(operation);
            Gameframe frame = new Gameframe(gamepanel,operation,scorepanel);
            operation.setGameframe(frame);
            frame.setVisible(true);
            frame.add(scorepanel);
            dispose();
        }else if(e.getSource()==bt12){
            setVisible(false);
            continuegamepanel.username=username;
            continuegamepanel continuegamepanel2 = new continuegamepanel();
            continuegamepanel2.setVisible(true);
            dispose();
        }

    }
}












