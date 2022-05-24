import javax.swing.*;
import java.awt.*;



class Gamepanel extends JPanel{


    Operation operation;

    Gamepanel(Operation operation){


        this.operation=operation;
        setOpaque(false);
        setBounds(111,85,376,537);
    }
    @Override
    public void paintComponent(Graphics g){
        for(Point point : operation.shape.points){
            if(operation.tempcolor==Color.WHITE){
                g.setColor(Color.WHITE);
                g.fillRect((point.x+operation.x)*24,(point.y+operation.y)*24,24,24);
            }else{ g.setColor(operation.tempcolor);
                g.fillRect((point.x+operation.x)*24,(point.y+operation.y)*24,24,24);
                g.drawImage(new ImageIcon("pics/block3.png").getImage(),(point.x+operation.x)*24,(point.y+operation.y)*24,24,24,null);
                String temp = String.valueOf(Operation.score);
                g.setColor(Color.black);
                g.setFont(new Font("黑体",Font.PLAIN,25));
                g.drawString(temp,300,70);
            }
        }
        for(Point point : operation.preshape.points){
            g.fillRect((point.x+3)*24,(point.y+20)*24,24,24);}
    int row=19;
        int col=10;
        int rowN=2;
        for(int i=row;i>=rowN;i--){
            for(int j=0;j<col;j++){
                if(operation.savemap[j][i]!=0){
                    g.setColor(operation.color[operation.savemap[j][i]-1]);
                    g.fillRect((j)*24,(i-2)*24,24,24);
                    g.drawImage(new ImageIcon("pics/block3.png").getImage(),(j)*24,(i-2)*24,24,24,null);
                }
            }
        }

    }
}
class Staticpanel extends  JPanel{

    Operation operation;


    Staticpanel(Operation operation){

        this.operation =operation;
    setBounds(0,0,600,900);








    setLayout(null);

        JButton left = operation.left;
        JButton right = operation.right;
        JButton dowm =operation.down;
        JButton rotation = operation.rotation;
        JButton startpause = operation.startstop;
        JButton returnbutton =operation.returnbutton;
        JButton quit = operation.over;
        JButton restart = operation.restart;
        left.setBounds(55,753,49,30);
        right.setBounds(165,753,49,30);
        dowm.setBounds(120,791,30,49);
        rotation.setBounds(120,694,30,49);
        startpause.setBounds(291,692,88,48);
        returnbutton.setBounds(364,764,88,48);
        quit.setBounds(435,830,88,48);
        restart.setBounds(520,750,48,48);
        add(left);
        add(right);
        add(dowm);
        add(rotation);
        add(startpause);
        add(returnbutton);
        add(quit);
        add(restart);
        /*
         Icon由图片文件形成
           但这个图片大小可能不适合做Icon
         */
        ImageIcon imageIcon1 = new ImageIcon("pics/up.png");
        ImageIcon imageIcon2 = new ImageIcon("pics/down.png");
        ImageIcon imageIcon3 = new ImageIcon("pics/left.png");
        ImageIcon imageIcon4 = new ImageIcon("pics/right.png");
        ImageIcon imageIcon5 = new ImageIcon("pics/Start_Pause.png");
        ImageIcon imageIcon6 = new ImageIcon("pics/返回.png");
        ImageIcon imageIcon7 = new ImageIcon("pics/quit.png");
        ImageIcon imageIcon8 = new ImageIcon("pics/restart.png");
        Image image1 = imageIcon1.getImage();
        Image image2 = imageIcon2.getImage();
        Image image3 = imageIcon3.getImage();
        Image image4 = imageIcon4.getImage();
        Image image5 = imageIcon5.getImage();
        Image image6 = imageIcon6.getImage();
        Image image7 = imageIcon7.getImage();
        Image image8 = imageIcon8.getImage();
        Image smallImage1 = image1.getScaledInstance(30,49,Image.SCALE_FAST);
        Image smallImage2 = image2.getScaledInstance(30,49,Image.SCALE_FAST) ;
        Image smallImage3 = image3.getScaledInstance(49,30,Image.SCALE_FAST);
        Image smallImage4 = image4.getScaledInstance(49,30,Image.SCALE_FAST) ;
        Image smallImage5 = image5.getScaledInstance(88,48,Image.SCALE_FAST);
        Image smallImage6 = image6.getScaledInstance(88,48,Image.SCALE_FAST);
        Image smallImage7 = image7.getScaledInstance(88,48,Image.SCALE_FAST);
        Image smallImage8 = image8.getScaledInstance(48,48,Image.SCALE_FAST);
        // 再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        ImageIcon smallIcon3 = new ImageIcon(smallImage3);
        ImageIcon smallIcon4 = new ImageIcon(smallImage4);
        ImageIcon smallIcon5 = new ImageIcon(smallImage5);
        ImageIcon smallIcon6 = new ImageIcon(smallImage6);
        ImageIcon smallIcon7 = new ImageIcon(smallImage7);
        ImageIcon smallIcon8 = new ImageIcon(smallImage8);
        // 最后设置它为按钮的图片
        rotation.setIcon(smallIcon1);
        dowm.setIcon(smallIcon2);
        left.setIcon(smallIcon3);
        right.setIcon(smallIcon4);
        startpause.setIcon(smallIcon5);
        returnbutton.setIcon(smallIcon6);
        quit.setIcon(smallIcon7);
        restart.setIcon(smallIcon8);

        this.add(left);
}
@Override
/**
 *荣誉榜
 * 游戏运行框
 * 速度框
 * 得分框
 * 得分位置
 * 下一个位置
 * 荣誉榜位置
 * 速度
 */
    public void paintComponent(Graphics g){
        g.setColor(new Color(0,0,0,30));
       g.fillRect(111,520,200,102);
       g.fillRect(355,187,130,330);
        g.fillRect(111,85,240,432);
    g.fillRect(313,520,174,102);
        g.setColor(new Color(2,2,2,30));
        g.fillRect(355,85,130,100);

        g.setColor(Color.black);
        g.drawRect(111,85,241,433);
        //这里缺一个边框，但是我偏不想加了。
        g.setFont(new Font("黑体",Font.PLAIN,25));
        g.setColor(Color.black);
        g.drawString("得分：",367,120);
        g.drawString("下一个",111,550);
        g.drawString("荣誉榜：",367,222);
    g.drawString("速度：",325,555);
    g.drawString("200ms/格" ,376,590);
    }
}



/**
 * @author 屹宁 武创
 */
public class Game{
    public static void main(String[] args) {


        Operation operation = new Operation();
        Gamepanel gamepanel = new Gamepanel(operation);

        Gameframe frame = new Gameframe(gamepanel,operation);
        operation.setGameframe(frame);
        frame.setVisible(true);


    }
}
