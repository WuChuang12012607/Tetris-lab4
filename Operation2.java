import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Operation2 {//现在是在做不同的模式
    int x;//这个位置至少为1
    int y;//这个问题需要我们解决
    Color[][] mapcolor = new Color[][]{{Color.black}};
    Gameframe2 gameframe2;
    JButton left;
    JButton right;
    JButton rotation;
    JButton down;
    JButton startstop;
    JButton returnbutton;
    JButton restart;
    Boolean newBegin=true;
    Shape[] Shape = new Shape[]{
            //L
            new Shape(new int[]{-1,0,1,1},new int[]{0,0,0,1}),
            new Shape(new int[]{-1,0,0,0},new int[]{1,1,0,-1}),
            new Shape(new int[]{-1,-1,0,1},new int[]{-1,0,0,0}),
            new Shape(new int[]{0,0,0,1},new int[]{1,0,-1,-1}),
            //I
            new Shape(new int[]{0,1,-1,-2},new int[]{0,0,0,0}),
            new Shape(new int[]{-1,0,1,1},new int[]{0,0,0,1}),
            new Shape(new int[]{0,0,0,0},new int[]{-2,-1,0,1}),
            new Shape(new int[]{-2,-1,0,1},new int[]{0,0,0,0}),
            //L'
            new Shape(new int[]{0,0,0,0},new int[]{-1,0,1,2}),
            new Shape(new int[]{-1,0,1,1},new int[]{0,0,0,-1}),
            new Shape(new int[]{0,0,0,1},new int[]{-1,0,1,1}),
            new Shape(new int[]{-1,0,1,-1},new int[]{-1,0,0,0}),
            //S
            new Shape(new int[]{-1,-1,0,0},new int[]{-1,0,0,1}),
            new Shape(new int[]{-1,0,0,1},new int[]{0,0,-1,-1}),
            //S'
            new Shape(new int[]{0,0,-1,-1},new int[]{0,-1,0,1}),
            new Shape(new int[]{-1,0,0,1},new int[]{-1,-1,0,0}),
            //T
            new Shape(new int[]{-1,0,0,1},new int[]{0,0,-1,0}),
            new Shape(new int[]{0,0,1,0},new int[]{-1,0,0,1}),
            new Shape(new int[]{-1,0,0,1},new int[]{0,0,1,0}),
            new Shape(new int[]{0,0,-1,0},new int[]{-1,0,0,1}),
            //田
            new Shape(new int[]{0,0,1,1},new int[]{0,1,0,1}),
            //这是后加的
            //十
            new Shape(new int[]{-1,0,0,0,1},new int[]{0,0,1,-1,0}),
            //|--
            new Shape(new int[]{0,0,0,1,2},new int[]{1,0,-1,0,0}),
            new Shape(new int[]{-1,0,1,0,0},new int[]{0,0,0,1,2}),
            new Shape(new int[]{-2,-1,0,0,0},new int[]{0,0,0,1,-1}),
            new Shape(new int[]{-1,0,0,0,1},new int[]{0,0,-1,-2,0}),
            //凹
            new Shape(new int[]{0,0,0,1,1},new int[]{0,1,-1,1,-1}),
            new Shape(new int[]{-1,-1,0,1,1},new int[]{0,-1,0,-1,0}),
            new Shape(new int[]{-1,0,0,0,-1},new int[]{-1,-1,0,1,1}),
            new Shape(new int[]{-1,-1,0,1,1},new int[]{1,0,0,0,1}),
            //2
            new Shape(new int[]{-1,0,0,0,1}, new int[]{-1,-1,0,1,1}),
            new Shape(new int[]{-1,-1,0,1,1}, new int[]{1,0,0,0,-1}),
            //5
            new Shape(new int[]{1,0,0,0,-1}, new int[]{-1,-1,0,1,1}),
            new Shape(new int[]{-1,-1,0,1,1},new int[]{-1,0,0,0,1}),
            //L
            new Shape(new int[]{0,0,0,0,1},new int[]{-2,-1,0,1,0}),
            new Shape(new int[]{-2,-1,0,1,0},new int[]{0,0,0,0,-1}),
            new Shape(new int[]{0,0,0,0,-1},new int[]{-1,0,1,2,0}),
            new Shape(new int[]{-1,0,1,2,0}, new int[]{0,0,0,0,1}),
            //differ from latter
            new Shape(new int[]{-2,-1,0,1,0}, new int[]{0,0,0,0,1}),
            new Shape(new int[]{0,0,0,0,1}, new int[]{-1,0,1,2,0}),
            new Shape(new int[]{-1,0,1,2,0}, new int[]{0,0,0,0,-1}),
            new Shape(new int[]{0,0,0,0,-1}, new int[]{-2,-1,0,1,0})

    };
    public  Shape shape;
    public int[][] savemap;
    public int score;
    public Color[] color = new Color[]{Color.green, Color.red, Color.orange, Color.blue, Color.cyan, Color.yellow, Color.magenta, Color.gray};
    public Color tempcolor;

    PrintWriter printWriter;
    JButton over;
    passwordpanel passwordpanel;
    Shape preshape;
    Shape tempshape;
    Random random= new Random();
    public String username;
    static int record =0;

    int speed=200;
    public void setscore(int score){
        this.score=score;
    }
    public void newShape(){
        this.x=random.nextInt(5)+3;
        this.y=-1;
        shape=preshape;
        int a2= random.nextInt(42);
        tempshape=preshape;
        int b = random.nextInt(8);
        tempcolor= color[b];
        if(record==0){int a = random.nextInt(42);
            shape=new Shape(Shape[a]);
        }else{
            shape=tempshape;
        } preshape = new Shape(Shape[a2]);
        record++;
    }

    Operation2(){
        left= new JButton();
        right = new JButton();
        rotation= new JButton();
        down= new JButton();
        startstop = new JButton();
        over =new JButton();
        restart = new JButton();
        newShape();
        //shape = new  Shape(Shape[0]);//这部分啥意思有待考虑清楚
        savemap =new int[10][20];
        final int[] score = {0};
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                left();gameframe2.requestFocus();
                gameframe2.getGamepanel2().repaint();
            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                right();gameframe2.requestFocus();
                gameframe2.getGamepanel2().repaint();
            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dowm();gameframe2.requestFocus();
                gameframe2.getGamepanel2().repaint();
            }
        });
        rotation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn();gameframe2.requestFocus();
                gameframe2.getGamepanel2().repaint();
            }
        });
        returnbutton = new JButton();
        returnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe2.requestFocus();
                gameframe2.setVisible(false);gameframe2.dispose();
                Levelpanel.username=username;
                Levelpanel levelpanel = new Levelpanel();
                levelpanel.username=username;
                levelpanel.setVisible(true);

            }
        });
        startstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe2.requestFocus();
                if(newBegin==true){
                    timer.start();
                    newBegin=false;
                }
                else{ timer.stop();new pausepanel().setVisible(true);
                    newBegin=true;
                }
            }
        });
        over.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe2.requestFocus();
                timer.stop();
                /*whethertosave whethertosave = new whethertosave();
                whethertosave.username=username;
                for(int i=0;i<savemap.length;i++){
                    for (int j=0;j<savemap[0].length;j++){
                        whethertosave.savemap[i][j]=savemap[i][j];
                    }
                }whethertosave.setVisible(true);*/
                newgame();
                record=0;
                newBegin=true;
                gameoverframe gameoverframe = new gameoverframe();
                gameoverframe.score = score[0];
                gameoverframe.setVisible(true);
                gameframe2.getGamepanel2().repaint();
            }
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newgame();
                record=0;
                setscore(0);
                gameframe2.getGamepanel2().repaint();
                newBegin=true;
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
    //savecolor
    public void dowm(){

        boolean checksol = true;
        for(Point point :shape.points){
            if( point.y+y+1>17  ||  savemap[point.x+x][point.y+y+2+1]!=0){
                savemap();
                newShape();
                checksol=false;

                if(testdeletemap()==true){
                    deletemap();
                    //scoreadd();
                }
                if(Gameover()==true){
                    timer.stop();
                    newgame();
                    gameframe2.getGamepanel2().repaint();
                    gameoverframe gameoverframe = new gameoverframe();
                    gameoverframe.score = score;
                    gameoverframe.setVisible(true);
                }//这个部分同样有点问题
            }
        }
        if(checksol==true){ this.y=y+1;}
    }
    public boolean Gameover(){
        boolean judge= false;
        for(int i=0;i<10;i++){
            if(savemap[i][2]!=0){
                judge=true;
            }
        }
        return judge;
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
            if (savemap[checkxaxis+x][checkyaxis+y+2]!=0){
                return;
            }
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
        for(int i=19;i>=2;i--) {
            for (int j = 0; j < 10; j++) {
                savemap[j][i+ needtodelete[i]] = savemap[j][i];

            }
        }


        if (needtodelete[1] == 1) {
            this.score = score + 100* needtodelete[1];//这个问题需要解决
        }else if (needtodelete[1] > 1) {
            this.score = score + 120*needtodelete[1];//同样
        }
    }

    Timer timer = new Timer(speed, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dowm();
            gameframe2.getGamepanel2().repaint();
        }
    });

    public void setScorepanel(Gameframe2 gameframe2){
        this.gameframe2=gameframe2;

    }
    public void setGameframe(Gameframe2 gameframe2){
        this.gameframe2 =gameframe2;
        gameframe2.setFocusable(true);
        gameframe2.requestFocus();
        this.gameframe2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){ right(); gameframe2.getGamepanel2().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_LEFT){ left(); gameframe2.getGamepanel2().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_DOWN){ dowm(); gameframe2.getGamepanel2().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_UP){ turn(); gameframe2.getGamepanel2().repaint();}
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public int savecolor( Color a){
        int sol=0;
        for(int i=0;i<color.length;i++){
            if(a==color[i]){ sol=i+1;}
        }
        return sol;
    }
    public void savemap(){
        for(Point point : shape.points){//这部分需要更好的推敲切记
            savemap[point.x+x][point.y+y+2]=savecolor(tempcolor);
        }
    }

    public void savethegame() throws FileNotFoundException {
        File file = new File(username+".txt",username +1+".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter = new PrintWriter(file);
        for (int i = 0; i < savemap.length; i++) {
            for (int j = 0; j < savemap[0].length; j++) {
                printWriter.print(savemap[i][j]);
            }
        }
        printWriter.close();
    }
    public void newgame() {
        for (int i = 0; i < savemap.length; i++) {
            for (int j = 0; j < savemap[0].length; j++) {
                savemap[i][j] = 0;
            }
        }
        shape=Shape[0];
        tempcolor=Color.WHITE;
    }

//这部分有借鉴，用到了points这个类
}

