import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class continuegamepanel extends JFrame {//我们在这个部分来讨论一下如何把老用户的保存文档输出出来
    public  static String username;

    public void setUsername(String username) {
        this.username = username;
    }

    File file;
    JButton[] bt;
    JPanel panel ;
    Scanner scanner;
    int[][] savemap= new int[10][20];
    continuegamepanel(){
        this.setIconImage(new ImageIcon("pics/Tetris.png").getImage());
        setTitle("Tetris");
        setTitle("是否继续游戏？");
        File file = new File(username+".txt");
        File[] file2 = file.listFiles();
        panel = new JPanel();panel.setBounds(0,0,250,250);
        setSize(250, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(21,0,10,10));
         bt= new JButton[file2.length-1];
        for(int i=0;i<bt.length;i++){
            int k=i+1;
            bt[i]=new JButton(""+k);
            bt[i].setBounds(10,20*i,180,70);
            panel.add(bt[i]);
            int j = i;
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {String temp = null;
                        scanner = new Scanner(file2[j+1]);
                        while (scanner.hasNext()){
                            temp = scanner.next();
                        }
                        scanner.close();
                        String[] arr = temp.split("");
                        for(int i= 0;i<arr.length;i++){
                            System.out.println(arr[i]);
                        }
                        int n=0;
                        for(int i= 0;i<arr.length;i++){
                            int a1=savemap.length-i%10-1;
                            int a2=savemap[0].length-1-n;
                            savemap[a1][a2]= Integer.parseInt(arr[i]) ;
                           if(i%10==9){ n++;}
                        }
                        setVisible(false);
                        Operation operation = new Operation();
                        operation.username=username;
                       for(int i=0;i<savemap.length;i++){
                           for(int j=0;j<savemap[0].length;j++){
                               operation.savemap[9-i][19-j]=savemap[i][j];
                           }
                       }
                        Gamepanel gamepanel = new Gamepanel(operation);
                        Gameframe frame = new Gameframe(gamepanel,operation);
                        operation.setGameframe(frame);
                        Random random = new Random();
                        int a = random.nextInt(7);
                        operation.shape=operation.Shape[a];//就这样吧。
                        frame.setVisible(true);
                        dispose();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            });
        }
        JScrollPane scrollPane = new JScrollPane(
                panel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        setVisible(true);

    }

}
