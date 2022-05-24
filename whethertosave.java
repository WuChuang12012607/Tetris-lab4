import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class whethertosave extends JFrame {
     JButton bt1;
     JButton bt2;
     public String username;
     PrintWriter printWriter;
     Container main;
     int[][] savemap;
     JPanel panel;
     whethertosave(){
         savemap=new int[10][20];
         main=getContentPane();
         setSize(500,300);
         setLocationRelativeTo(null);
         setLayout(null);
         panel = new JPanel();
         panel.setBounds(0,0,500,300);
         panel.setLayout(null);
         bt1 = new JButton("是");panel.add(bt1);
         bt2 = new JButton("否");panel.add(bt2);
         add(bt1);bt1.setBounds(30,30,90,60);
         bt1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 dispose();
             }
         });
         add(bt2);bt2.setBounds(300,30,90,60);
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
         g.drawString("是否继续游戏",70,30);
     }
}
