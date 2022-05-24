import javax.swing.*;
import java.awt.*;


class Gamepanel2 extends JPanel {


    Operation2 operation2;

    Gamepanel2(Operation2 operation2){


        this.operation2=operation2;
        setOpaque(false);
        setBounds(111,85,376,537);
    }
    @Override
    public void paintComponent(Graphics g){
        for(Point point : operation2.shape.points){
            if(operation2.tempcolor==Color.WHITE){
                g.setColor(Color.WHITE);
                g.fillRect((point.x+operation2.x)*24,(point.y+operation2.y)*24,24,24);
                //   g.drawImage(new ImageIcon("block3.png").getImage(),(point.x+operation.x)*24,(point.y+operation.y)*24,24,24,null);
            }else{ g.setColor(operation2.tempcolor);
                g.fillRect((point.x+operation2.x)*24,(point.y+operation2.y)*24,24,24);
                g.drawImage(new ImageIcon("pics/block3.png").getImage(),(point.x+operation2.x)*24,(point.y+operation2.y)*24,24,24,null);
                String temp = String.valueOf(operation2.score);
                g.setColor(Color.black);
                g.setFont(new Font("黑体",Font.PLAIN,25));
                g.drawString(temp,300,70);
            }
        }
        for(Point point : operation2.preshape.points){
            g.fillRect((point.x+3)*24,(point.y+20)*24,24,24);}

        for(int i =19;i>=2;i--){
            for(int j=0;j<10;j++){
                if(operation2.savemap[j][i]!=0){
                    g.setColor(operation2.color[operation2.savemap[j][i]-1]);
                    g.fillRect((j)*24,(i-2)*24,24,24);
                    g.drawImage(new ImageIcon("pics/block3.png").getImage(),(j)*24,(i-2)*24,24,24,null);//这个部分的j，i同样值得思考！！！
                }
            }
        }

    }
}



class Staticpanel2 extends  JPanel{

    Operation2 operation2;


    Staticpanel2(Operation2 operation2){
        this.operation2 =operation2;
        setBounds(0,0,615,930);








        setLayout(null);

        JButton left = operation2.left;
        JButton right = operation2.right;
        JButton dowm =operation2.down;
        JButton rotation = operation2.rotation;
        JButton startpause = operation2.startstop;
        JButton returnbutton =operation2.returnbutton;
        JButton restart = operation2.over;
        JButton restart2 = operation2.restart;
        left.setBounds(55,753,49,30);
        right.setBounds(165,753,49,30);
        dowm.setBounds(120,791,30,49);
        rotation.setBounds(120,694,30,49);
        startpause.setBounds(291,692,88,48);
        returnbutton.setBounds(364,764,88,48);
        restart.setBounds(435,830,88,48);
        restart2.setBounds(520,750,48,48);
        add(left);
        add(right);
        add(dowm);
        add(rotation);
        add(startpause);
        add(returnbutton);
        add(restart);
        add(restart2);
        ImageIcon imageIcon1 = new ImageIcon("pics/up.png"); // Icon由图片文件形成
        ImageIcon imageIcon2 = new ImageIcon("pics/down.png");
        ImageIcon imageIcon3 = new ImageIcon("pics/left.png");
        ImageIcon imageIcon4 = new ImageIcon("pics/right.png");
        ImageIcon imageIcon5 = new ImageIcon("pics/Start_Pause.png");
        ImageIcon imageIcon6 = new ImageIcon("pics/返回.png");
        ImageIcon imageIcon7 = new ImageIcon("pics/quit.png");
        Image image1 = imageIcon1.getImage(); // 但这个图片大小可能不适合做Icon
        Image image2 = imageIcon2.getImage();
        Image image3 = imageIcon3.getImage();
        Image image4 = imageIcon4.getImage();
        Image image5 = imageIcon5.getImage();
        Image image6 = imageIcon6.getImage();
        Image image7 = imageIcon7.getImage();
        Image smallImage1 = image1.getScaledInstance(30,49,Image.SCALE_FAST);
        Image smallImage2 = image2.getScaledInstance(30,49,Image.SCALE_FAST) ;
        Image smallImage3 = image3.getScaledInstance(49,30,Image.SCALE_FAST);
        Image smallImage4 = image4.getScaledInstance(49,30,Image.SCALE_FAST) ;
        Image smallImage5 = image5.getScaledInstance(88,48,Image.SCALE_FAST);
        Image smallImage6 = image6.getScaledInstance(88,48,Image.SCALE_FAST);
        Image smallImage7 = image7.getScaledInstance(88,48,Image.SCALE_FAST);
        // 再由修改后的Image来生成合适的Icon
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        ImageIcon smallIcon3 = new ImageIcon(smallImage3);
        ImageIcon smallIcon4 = new ImageIcon(smallImage4);
        ImageIcon smallIcon5 = new ImageIcon(smallImage5);
        ImageIcon smallIcon6 = new ImageIcon(smallImage6);
        ImageIcon smallIcon7 = new ImageIcon(smallImage7);
        // 最后设置它为按钮的图片
        rotation.setIcon(smallIcon1);
        dowm.setIcon(smallIcon2);
        left.setIcon(smallIcon3);
        right.setIcon(smallIcon4);
        startpause.setIcon(smallIcon5);
        returnbutton.setIcon(smallIcon6);
        restart.setIcon(smallIcon7);
        ImageIcon imageIcon8 = new ImageIcon("pics/restart.png");
        Image image8 = imageIcon8.getImage();
        add(restart2);
        Image smallImage8 = image8.getScaledInstance(48,48,Image.SCALE_FAST);
        ImageIcon smallIcon8 = new ImageIcon(smallImage8);
        restart2.setIcon(smallIcon8);
        this.add(left);
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(new Color(0,0,0,30));
        g.fillRect(111,520,200,102);//下一个框
        g.fillRect(355,187,130,330);//荣誉榜
        g.fillRect(111,85,240,432);//游戏运行框
        g.fillRect(313,520,174,102);//速度框
        g.setColor(new Color(2,2,2,30));
        g.fillRect(355,85,130,100);//得分框

        g.setColor(Color.black);
        g.drawRect(111,85,241,433);
        //这里缺一个边框，但是我偏不想加了。
        g.setFont(new Font("黑体",Font.PLAIN,25));
        g.setColor(Color.black);
        g.drawString("得分：",367,120);//得分位置
        g.drawString("下一个",111,550);//下一个位置
        g.drawString("荣誉榜：",367,222);//荣誉榜位置
        g.drawString("速度：",325,555);//速度
    }
}


public class Game2{
    public static void main(String[] args) {


        Operation2 operation2 = new Operation2();
        Gamepanel2 gamepanel2 = new Gamepanel2(operation2);

        Gameframe2 frame2 = new Gameframe2(gamepanel2,operation2);
        operation2.setGameframe(frame2);
        frame2.setVisible(true);

        @SuppressWarnings("unused")
        int musicOpenLab = 1;
    }
}