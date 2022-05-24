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

/**
 * @author 屹宁 武创
 */
public class Operation3 {
    /**
     *现在是在做不同的模式
     * 这个位置至少为1
     * 这个问题需要我们解决
     */
    int x;
    int y;
    Gameframe3 gameframe3;
    JButton left;
    JButton right;
    JButton rotation;
    JButton down;
    JButton startstop;
    JButton returnbutton;
    JButton restart;
    Boolean newBegin=true;
    Shape[] cShape = new Shape[]{
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
    public  static int  score;
    public Color[] color = new Color[]{Color.green, Color.red, Color.orange, Color.blue, Color.cyan, Color.yellow, Color.magenta, Color.gray};
    public Color tempcolor;

    PrintWriter printWriter;
    JButton over;
    Shape preshape;
    Shape tempshape;
    Random random= new Random();
    public String username;
    static int record =0;
    int speed=100;
    public void setscore(int score){
        Operation3.score =score;
    }

    public void newShape(){
        this.x=random.nextInt(5)+3;
        this.y=-1;
        shape=preshape;
        int a2= random.nextInt(42);
        tempshape=preshape;
        int b = random.nextInt(8);
        tempcolor= color[b];
        int aA=42;
        if(record==0){int a = random.nextInt(aA);
            shape=new Shape(cShape[a]);
        }else{
            shape=tempshape;
        } preshape = new Shape(cShape[a2]);
        record++;
    }

    Operation3(){
        restart = new JButton();
        left= new JButton();
        right = new JButton();
        rotation= new JButton();
        down= new JButton();
        startstop = new JButton();
        over =new JButton();
        newShape();
        //shape = new  Shape(Shape[0]);//这部分啥意思有待考虑清楚
        savemap =new int[10][20];
        int score = 0;
        left.addActionListener(e -> {
            left();gameframe3.requestFocus();
            gameframe3.getGamepanel3().repaint();
        });
        right.addActionListener(e -> {
            right();gameframe3.requestFocus();
            gameframe3.getGamepanel3().repaint();
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dowm();gameframe3.requestFocus();
                gameframe3.getGamepanel3().repaint();
            }
        });
        rotation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn();gameframe3.requestFocus();
                gameframe3.getGamepanel3().repaint();
            }
        });
        returnbutton = new JButton();
        returnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe3.requestFocus();
                gameframe3.setVisible(false);gameframe3.dispose();
                Levelpanel.username=username;
                Levelpanel levelpanel = new Levelpanel();
                Levelpanel.username =username;
                levelpanel.setVisible(true);

            }
        });
        startstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe3.requestFocus();
                if(newBegin){
                    timer.start();
                    newBegin=false;
                }
                else{ timer.stop();new Pausepanel().setVisible(true);
                    newBegin=true;
                }
            }
        });
        over.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe3.requestFocus();
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
                Gameoverframe gameoverframe = new Gameoverframe();
                gameoverframe.score = score;
                gameoverframe.setVisible(true);
                gameframe3.getGamepanel3().repaint();
            }
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canju();
                record=0;
                setscore(0);
                gameframe3.getGamepanel3().repaint();
                newBegin=true;
            }
        });

    }
    public void left(){
        boolean checksol = true;
        for(Point point :shape.points){
            if (point.x + x - 1 < 0 || point.x + x - 1 > 9 || savemap[point.x + x - 1][point.y + y + 2] != 0) {
                checksol = false;
                break;
            }
        }
        if(checksol){ this.x=x-1;}
    }
    public void right(){
        boolean checksol = true;
        for(Point point :shape.points){
            if (point.x + x + 1 < 0 || point.x + x + 1 > 9 || savemap[point.x + x + 1][point.y + y + 2] != 0) {
                checksol = false;
                break;
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
                    //scoreadd();
                }
                if(gameover()==true){
                    timer.stop();
                    newgame();
                    gameframe3.getGamepanel3().repaint();
                    Gameoverframe gameoverframe = new Gameoverframe();
                    gameoverframe.score = score;
                    gameoverframe.setVisible(true);
                }//这个部分同样有点问题
            }
        }
        if(checksol==true){ this.y=y+1;}
    }
    public boolean gameover(){
        boolean judge= false;
        int col=10;
        int colN=0;
        for(int i=colN;i<col;i++){
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
    int[] needtodelete = new int[20];
    boolean testdeletemap(){
        boolean judge = false;
        boolean checkempty = false;
        int row=16; int rowN=15;
        int col=10; int colN=0;
        for(int i=row;i>=rowN;i--){
            judge=false;
            for(int j=colN;j<col;j++){
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
        int row=19;int rowN=2;
        int col=10;int colN=0;
        for(int i=row;i>=rowN;i--) {
            for (int j = colN; j < col; j++) {
                savemap[j][i+ needtodelete[i]] = savemap[j][i];

            }
        }


        if (needtodelete[1] == 1) {
            score = score + 100* needtodelete[1];
        }else if (needtodelete[1] > 1) {
            score = score + 120*needtodelete[1];
        }
    }

    Timer timer = new Timer(speed, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dowm();
            gameframe3.getGamepanel3().repaint();
        }
    });


    public void setGameframe(Gameframe3 gameframe3){
        this.gameframe3 =gameframe3;
        gameframe3.setFocusable(true);
        gameframe3.requestFocus();
        this.gameframe3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){ right(); gameframe3.getGamepanel3().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_LEFT){ left(); gameframe3.getGamepanel3().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_DOWN){ dowm(); gameframe3.getGamepanel3().repaint();}
                if(e.getKeyCode()==KeyEvent.VK_UP){ turn(); gameframe3.getGamepanel3().repaint();}
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
        for(Point point : shape.points){
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
    void canju(){
        int row=10;int rowN=17;
        int col=10;int colN=0;
        for(int i=row;i<=rowN;i++) {
            int r=new Random().nextInt(9);
            int q=new Random().nextInt(9);
            int w=new Random().nextInt(9);
            for(int h=colN;h<col;h++){
                if(h!=r && h!=q && h!=w){
                    savemap[h][i]=2;
                }else{
                    savemap[h][i]=0;

                }
            }

        }
        return ;}

    public void newgame() {
        for (int i = 0; i < savemap.length; i++) {
            for (int j = 0; j < savemap[0].length; j++) {
                savemap[i][j] = 0;
            }
        }
        shape=cShape[0];
        tempcolor=Color.WHITE;
    }}

//这部分有借鉴，用到了points这个类
