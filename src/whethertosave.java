import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class whethertosave extends JFrame {
    Container main;
    JPanel panel;
    JButton bt1;
     JButton bt2;


     public String username;
     PrintWriter printWriter;

     int[][] savemap;

     whethertosave(){
         this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
         setTitle("存档");
         main=getLayeredPane();
         setResizable(false);
         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ImageIcon imgic=new ImageIcon("pics/level.png");
         JLabel jl=new JLabel(imgic);
         jl.setBounds(0,0,600,500);
         main.add(jl);
         panel = new JPanel();
         panel.setBounds(0,0,500,300);
         panel.setLayout(null);
         setLocationRelativeTo(null);
         repaint();
         setSize(500,300);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);



         main.add(panel,new Integer(0));
         bt1 = new JButton("否");main.add(bt1,new Integer(1));panel.add(bt1);
         bt2 = new JButton("是");main.add(bt2,new Integer(1));panel.add(bt2);
         bt1.setBounds(30,30,90,60);
         bt2.setBounds(300,30,90,60);


         savemap=new int[10][20];
         bt1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 dispose();
             }
         });

         bt2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 File[] files = new File(username+".txt").listFiles();
                 File file = new File(username+".txt",username +files.length+".txt");
                 try {
                     file.createNewFile();
                 } catch (IOException ea) {
                     ea.printStackTrace();
                 }
                 try {
                     printWriter = new PrintWriter(file);
                 } catch (FileNotFoundException fileNotFoundException) {
                     fileNotFoundException.printStackTrace();
                 }
                 for(int j=0;j<20;j++){
                     for(int i=0;i<10;i++){
                         printWriter.print(savemap[i][j]);
                     }
                 }
                 printWriter.close();
                 dispose();
             }
         });
     }

     @Override
     public void paint(Graphics g){
         g.drawString("是否存档游戏",200,80);
     }
}
