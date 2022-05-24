import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//首先，我们需要三个部分，Gamepanel，Gameframe ，Staticpanel,Operation以及Gamedata
class Gameframe extends JFrame {
     Gamepanel gamepanel;
     Container mainpane;
     Operation operation;
     Scorepanel scorepanel;
    public Staticpanel staticpanel;
    Gameframe(Gamepanel gamepanel , Operation operation,Scorepanel scorepanel){
        this.gamepanel=gamepanel;
        this.operation=operation;
        this.scorepanel=scorepanel;
        mainpane=getLayeredPane();
        setBounds(100,50,360,600);
        setResizable(false);
        setBack();
        staticpanel = new Staticpanel(operation);
        mainpane.add(staticpanel);
        setGamepanel();
        setFocusable(true);
        setLocationRelativeTo(null);
        setScorepanel();
    }
    void setBack(){
        JLabel ji = new JLabel();
        ji.setBounds(0,0,360,600);
        getContentPane().add(ji);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void setGamepanel(){
        gamepanel =new Gamepanel(operation);
        mainpane.add(gamepanel);
    }
    void setScorepanel(){
        scorepanel = new Scorepanel(operation);
        mainpane.add(scorepanel);
    }
    Gamepanel  getGamepanel(){
        return gamepanel;
    }
    Scorepanel gerScorepanel(){return scorepanel;}
}

class Gamepanel extends JPanel{
    Operation operation;
    Gamepanel(Operation operation){
        this.operation=operation;
        setOpaque(false);
        setBounds(15,30,200,400);
    }
    @Override
    public void paintComponent(Graphics g){
        for(Point point : operation.shape.points){
            if(operation.tempcolor==Color.WHITE){
                g.setColor(Color.WHITE);
                g.fillRect((point.x+operation.x)*20,(point.y+operation.y)*20,20,20);
            }else{ g.setColor(operation.tempcolor);
                g.fillRect((point.x+operation.x)*20,(point.y+operation.y)*20,20,20);
            }
        }
        for(int i =19;i>=2;i--){
            for(int j=0;j<10;j++){
                if(operation.savemap[j][i]!=0){
                    g.setColor(operation.color[operation.savemap[j][i]-1]);
                    g.fillRect((j)*20,(i-2)*20,20,20);//这个部分的j，i同样值得思考！！！
                }
            }
        }

    }
}
class Staticpanel extends  JPanel{
    Operation operation;
    Staticpanel(Operation operation){
        this.operation =operation;
    setBounds(0,0,360,600);
    setLayout(null);
        JButton left = operation.left;
        JButton right = operation.right;
        JButton dowm =operation.down;
        JButton rotation = operation.rotation;
        JButton startpause = operation.startstop;
        JButton returnbutton =operation.returnbutton;
        JButton over = operation.over;
        left.setBounds(233,255,45,45);
        right.setBounds(278,255,45,45);
        dowm.setBounds(233,300,45,45);
        rotation.setBounds(278,300,45,45);
        startpause.setBounds(233,350,90,50);
        returnbutton.setBounds(240,518,45,45);
        over.setBounds(290,518,45,45);
        add(left);
        add(right);
        add(dowm);
        add(rotation);
        add(startpause);
        add(returnbutton);
        add(over);
}
@Override
    public void paintComponent(Graphics g){
        g.setColor(new Color(0,0,0,30));
       g.fillRect(15,30,200,360);
       g.fillRect(15,405,200,130);
        g.fillRect(233,20,105,400);
        g.setColor(new Color(2,2,2,30));
        g.fillRect(233,30,90,70);
        g.fillRect(233,105,90,140);
        g.fillRect(233,255,90,90);
        g.setColor(Color.WHITE);
        g.drawRect(13,28,204,360);
        //这里缺一个边框，但是我偏不想加了。
        g.setFont(new Font("黑体",Font.PLAIN,25));
        g.setColor(Color.WHITE);
        g.drawString("得分",240,53);
        g.drawString("下一个",236,140);
        g.drawString("荣誉榜",25,435);
    }
}
class Scorepanel extends JPanel{
    Operation operation;
    Scorepanel(Operation operation){
        this.operation=operation;
        setOpaque(false);
        setBounds(233,30,90,70);
        setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g){
        String temp = String.valueOf(operation.score);
        g.setFont(new Font("黑体",Font.PLAIN,25));
        g.setColor(Color.WHITE);
       g.drawString(temp,240,73);//这个写分数没有问题了应该，问题在于对于分数的记录明显不对。


    }
}


public class Game{
    public static void main(String[] args) {
        Operation operation = new Operation();
        Gamepanel gamepanel = new Gamepanel(operation);
        Scorepanel scorepanel = new Scorepanel(operation);
        Gameframe frame = new Gameframe(gamepanel,operation,scorepanel);
        operation.setGameframe(frame);
        frame.setVisible(true);
        frame.add(scorepanel);

    }
}

