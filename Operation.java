import jdk.nashorn.internal.ir.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Operation {
    int x=2;//这个位置至少为1
    int y;//这个问题需要我们解决
    Color[][] mapcolor = new Color[][]{{Color.black}};
    Gameframe gameframe;
    JButton left;
    JButton right;
    JButton rotation;
    JButton down;
    JButton startstop;
    JButton returnbutton;
    Boolean newBegin=true;
    Shape[] Shape = new Shape[]{
            new Shape(new int[]{-1,0,1,1},new int[]{0,0,0,1}),
            new Shape(new int[]{-1,0,0,0},new int[]{1,1,0,1}),
            new Shape(new int[]{0,0,1,2},new int[]{-1,0,0,0}),
            new Shape(new int[]{0,0,0,1},new int[]{2,1,0,0})}; //这里有许多块，但是我没写完，我们就先用一个形状做演示
    public  Shape shape;
    public int[][] savemap;
    public int score;
    Operation(){
        left= new JButton();
        right = new JButton();
        rotation= new JButton();
        down= new JButton();
        startstop = new JButton();
        shape = new  Shape(Shape[0]);//这部分啥意思有待考虑清楚
        savemap =new int[10][20];
        score = 0;
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                left();
                gameframe.getGamepanel().repaint();
            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                right();
                gameframe.getGamepanel().repaint();
            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dowm();
                gameframe.getGamepanel().repaint();
            }
        });
        rotation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn();
                gameframe.getGamepanel().repaint();
            }
        });
        returnbutton = new JButton();
        returnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe.setVisible(false);
                new Panel().setVisible(true);
                gameframe.dispose();
            }
        });
        startstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(newBegin==true){
                    timer.start();
                    newBegin=false;
                }
                else{ timer.stop();
                newBegin=true;
                }
            }
        });
    }
    public void left(){
        boolean checksol = true;
        for(Point point :shape.points){
            if(point.x+x-1<0 || point.x+x-1>9  ||  savemap[point.x+x-1][point.y+y+2]!=0){
                checksol=false;
            }
        }
        if(checksol==true){ this.x=x-1;}
    }
    public void right(){
        boolean checksol = true;
        for(Point point :shape.points){
            if(point.x+x+1<0 || point.x+x+1>9 ||  savemap[point.x+x+1][point.y+y+2]!=0 ){
                checksol=false;
            }
        }
        if(checksol==true){ this.x=x+1;}
    }
    public void dowm(){
        boolean checksol = true;
        for(Point point :shape.points){
            if( point.y+y+1>17  ||  savemap[point.x+x][point.y+y+2+1]!=0){
                savemap();
                newShape();
                checksol=false;
                if(testdeletemap()==true){
                    deletemap();
                }
            }
        }
        if(checksol==true){ this.y=y+1;}
    }
    public void turn(){//这部分需要观察是否可以进行改进
        int temp=0;
        int checkxaxis=0;
        int checkyaxis=0;
        for(Point point :shape.points){
            checkxaxis=-point.y;
            checkyaxis=point.x;
            if(checkxaxis+x>9 || checkxaxis+x<0 ){
             return;
            }
            if(checkyaxis+y >17){ return;}
        }
        for(Point point :shape.points){
            temp=point.x;
            point.x=-point.y;
            point.y=temp;}
    }
    int[] needtodelete = new int[20];//这个部分需要改进
    boolean testdeletemap(){
    boolean judge = false;
    boolean checkempty = false;
    for(int i=19;i>=2;i--){
        judge=false;
        for(int j=0;j<10;j++){
            if(savemap[j][i]==0){
                judge=true;
                break;
            }
        }
          if(!judge){
              checkempty=true;
              needtodelete[i-1]=needtodelete[i]+1;
          } else{
              needtodelete[i-1]=needtodelete[i];
          }
    }
    return checkempty;
    }
    void deletemap(){
        for(int i=19;i>=2;i--){
            for(int j=0;j<10;j++){
                savemap[j][i+needtodelete[i]]=savemap[j][i];
            }
        }
    }

     Timer timer = new Timer(300, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dowm();
            gameframe.getGamepanel().repaint();
        }
    });
    public void setGameframe(Gameframe gameframe){
        this.gameframe =gameframe;
        this.gameframe.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){ right(); gameframe.getGamepanel().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_LEFT){ left(); gameframe.getGamepanel().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_DOWN){ dowm(); gameframe.getGamepanel().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_UP){ turn(); gameframe.getGamepanel().repaint();}
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public void savemap(){
        for(Point point : shape.points){//这部分需要更好的推敲切记
            savemap[point.x+x][point.y+y+2]=1;
        }
    }
    public void newShape(){
       this.x=2;
       this.y=0;
        shape= new Shape(Shape[0]);
}

//这部分有借鉴，用到了points这个类
}

class Shape{
    Point[] points;
    Shape(int[]xs, int[] ys){
       points = new Point[4];
       for(int i=0;i<4;i++){
           points[i] = new Point(xs[i],ys[i] );
       }
    }
    Shape(Shape shape){
        points = new Point[4];
       for(int i =0;i<4;i++){
           points[i]=new Point(shape.points[i].x,shape.points[i].y);
       }
    }

}