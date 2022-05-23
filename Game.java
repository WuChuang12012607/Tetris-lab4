import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//首先，我们需要三个部分，Gamepanel，Gameframe ，Staticpanel,Operation以及Gamedata
class Gameframe extends JFrame {
     Gamepanel gamepanel;
     Container mainpane;
     Operation operation;
     JButton returnbutton;
    Gameframe(Gamepanel gamepanel , Operation operation){
        this.gamepanel=gamepanel;
        this.operation=operation;
        mainpane=getLayeredPane();
        setBounds(100,50,360,600);
        setResizable(false);
        setBack();
        Staticpanel staticpanel = new Staticpanel(operation);
        mainpane.add(staticpanel);
        setGamepanel();
        setFocusable(true);
        setLocationRelativeTo(null);

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
    Gamepanel  getGamepanel(){
        return gamepanel;
    }

}

class Gamepanel extends JPanel{
    Operation operation;
    Color[][] sol;
    Gamepanel(Operation operationandgamedata){
        this.operation=operationandgamedata;
        setOpaque(false);
        setBounds(15,30,200,360);
    }
    @Override
    public void paintComponent(Graphics g){
        for(Point point : operation.shape.points){
            g.fillRect((point.x+operation.x)*20,(point.y+operation.y)*20,20,20);
        }
        for(int i =19;i>=2;i--){
            for(int j=0;j<10;j++){
                if(operation.savemap[j][i]!=0){
                    g.fillRect((j)*20,(i-2)*20,20,20);//这个部分的j，i同样值得思考！！！
                }
            }
        }

    }
}
class Staticpanel extends  JPanel{
    Operation operation;
    Gameframe gameframe;
    public void setGameframe(Gameframe gameframe){
        this.gameframe=gameframe;
    }
    Staticpanel(Operation operation){
        this.operation =operation;
    setBounds(0,0,360,600);
    setLayout(null);
        JButton left = operation.left;
        JButton right = operation.right;
        JButton dowm =operation.down;
        JButton rotation = operation.rotation;
        JButton startstop = operation.startstop;
        JButton returnbutton =operation.returnbutton;
        JButton login = new JButton();
        left.setBounds(233,255,45,45);
        right.setBounds(278,255,45,45);
        dowm.setBounds(233,300,45,45);
        rotation.setBounds(278,300,45,45);
        startstop.setBounds(233,350,90,50);
        returnbutton.setBounds(240,518,45,45);
        login.setBounds(290,518,45,45);
        add(left);
        add(right);
        add(dowm);
        add(rotation);
        add(startstop);
        add(returnbutton);
        add(login);
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
        g.drawString("得分"+operation.score,240,53);
        g.drawString("下一个",236,140);
        g.drawString("荣誉榜",25,435);
    }
}



public class Game{
    public static void main(String[] args) {
        Operation operation = new Operation();
        Gamepanel gamepanel = new Gamepanel(operation);
        Gameframe frame = new Gameframe(gamepanel,operation);
        operation.setGameframe(frame);
        frame.setVisible(true);
    }
}

