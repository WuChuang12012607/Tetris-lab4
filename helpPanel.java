import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class helpPanel extends JFrame  implements ActionListener {
    JPanel helppanel = new JPanel();

    JButton bt21 = new JButton("return");
    JButton bt22 = new JButton("Game Help");
    JButton bt23 = new JButton("Introduction");
    JTextArea gamehelp = new JTextArea("Tetris is a computer game created by Alexey Pazhitnov in the 1980s. The objective of" +
            " Tetris is that the player is given a sequence of tetromino pieces that they must pack into a rectangular game board" +
            ". Once an entire row is filled up, it is cleared and the pieces above are lowered by one row.",4,4);
    JTextArea introductionforauthor = new JTextArea("The author is a fucking brilliant smart guy.");//这里仍然有点问题，就是显示的时候不能按行出，有点噶
    public  helpPanel(){
        this.setIconImage(new ImageIcon("Tetris.png").getImage());

        setSize(1110, 1008);
            add(helppanel);
            helppanel.setBounds(0, 0, 1110, 1008);
            helppanel.setLayout(null);
            helppanel.add(bt21);
            bt21.setBounds(0, 0, 370, 110);bt21.addActionListener(this);
            helppanel.add(bt22);
            bt22.setBounds(0, 110, 370, 110);
            helppanel.add(gamehelp);gamehelp.setBounds(120,380,700,120);
            bt22.addActionListener(this);

            helppanel.add(bt23);
            bt23.setBounds(0, 220, 370, 110);
            helppanel.add(introductionforauthor);introductionforauthor.setBounds(0,380,700,120);
            bt23.addActionListener(this);

            setResizable(false);
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }


     @Override
     public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt21){
            setVisible(false);
            new Panel().setVisible(true);
            dispose();
        }else if(e.getSource()==bt23){
            gamehelp.setVisible(false);
            introductionforauthor.setVisible(true);
        }else if(e.getSource()==bt22){
            gamehelp.setVisible(true);
            introductionforauthor.setVisible(false);
        }

     }
 }
//green