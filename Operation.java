import jdk.nashorn.internal.ir.Block;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Operation {
    int x;//这个位置至少为1
    int y;//这个问题需要我们解决
    Color[][] mapcolor = new Color[][]{{Color.black}};
    Gameframe gameframe;
    JButton left;
    JButton right;
    JButton rotation;
    JButton down;
    JButton startstop;
    JButton returnbutton;
    Boolean newBegin = true;
    Shape[] Shape = new Shape[]{
            new Shape(new int[]{-1, 0, 1, 1}, new int[]{0, 0, 0, 1}),
            new Shape(new int[]{-1, 0, 0, 0}, new int[]{1, 1, 0, -1}),
            new Shape(new int[]{-1, -1, 0, 1}, new int[]{-1, 0, 0, 0}),
            new Shape(new int[]{0, 0, 0, 1}, new int[]{1, 0, -1, -1})}; //这里有许多块，但是我没写完，我们就先用一个形状做演示,这里显然不够，需要加进去另外一些。
    public Shape shape;
    public int[][] savemap;
    public int score;
    public Color[] color = new Color[]{Color.green, Color.red, Color.orange, Color.blue, Color.cyan, Color.yellow, Color.magenta, Color.gray};
    public Color tempcolor;


    //新加部分
    PrintWriter printWriter;
    JButton over;//译为结束
    passwordpanel passwordpanel;

    public void newShape() {
        Random random = new Random();
        this.x = random.nextInt(6) + 2;
        this.y = -1;
        int a = random.nextInt(3);
        shape = new Shape(Shape[a]);
        int b = random.nextInt(8);
        tempcolor = color[b];
    }

    Operation() {
        left = new JButton();
        right = new JButton();
        rotation = new JButton();
        down = new JButton();
        startstop = new JButton();
        over = new JButton();
        newShape();
        savemap = new int[10][20];
        score = 0;
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                left();gameframe.requestFocus();
                gameframe.getGamepanel().repaint();
            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                right();gameframe.requestFocus();
                gameframe.getGamepanel().repaint();
            }
        });
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dowm();gameframe.requestFocus();
                gameframe.getGamepanel().repaint();
            }
        });
        rotation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn();gameframe.requestFocus();
                gameframe.getGamepanel().repaint();
            }
        });
        returnbutton = new JButton();
        returnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe.requestFocus();
                gameframe.setVisible(false);
                new Panel().setVisible(true);
                gameframe.dispose();
            }
        });
        startstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe.requestFocus();
                if (newBegin == true) {
                    timer.start();
                    newBegin = false;
                } else {
                    timer.stop();
                    newBegin = true;
                }
            }
        });
        over.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe.requestFocus();
                timer.stop();
                try {
                    savethegame();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                newgame();
                gameframe.getGamepanel().repaint();
            }
        });
    }

    public void left() {
        boolean checksol = true;
        for (Point point : shape.points) {
            if (point.x + x - 1 < 0 || point.x + x - 1 > 9 || savemap[point.x + x - 1][point.y + y + 2] != 0) {
                checksol = false;
            }
        }
        if (checksol == true) {
            this.x = x - 1;
        }
    }

    public void right() {
        boolean checksol = true;
        for (Point point : shape.points) {
            if (point.x + x + 1 < 0 || point.x + x + 1 > 9 || savemap[point.x + x + 1][point.y + y + 2] != 0) {
                checksol = false;
            }
        }
        if (checksol == true) {
            this.x = x + 1;
        }
    }

    public void dowm() {
        boolean checksol = true;
        for (Point point : shape.points) {
            if (point.y + y + 1 > 17 || savemap[point.x + x][point.y + y + 2 + 1] != 0) {
                savemap();
                newShape();
                checksol = false;
                if (testdeletemap() == true) {
                    deletemap();
                    scoreadd();
                }
                if (Gameover() == true) {
                    timer.stop();
                    new gameoverframe().setVisible(true);
                }//这个部分同样有点问题
            }
        }
        if (checksol == true) {
            this.y = y + 1;
        }
    }

    public boolean Gameover() {
        boolean judge = false;
        for (int i = 0; i < 10; i++) {
            if (savemap[i][2] != 0) {
                judge = true;
            }
        }
        return judge;
    }

    public void savemap() {
        for (Point point : shape.points) {//这部分需要更好的推敲切记
            savemap[point.x + x][point.y + y + 2] = savecolor(tempcolor);
        }
    }


    public void turn() {//这部分需要观察是否可以进行改进
        int temp = 0;
        int checkxaxis = 0;
        int checkyaxis = 0;
        for (Point point : shape.points) {
            checkxaxis = -point.y;
            checkyaxis = point.x;
            if (checkxaxis + x > 9 || checkxaxis + x < 0) {
                return;
            }
            if (checkyaxis + y > 17) {
                return;
            }
            if (savemap[checkxaxis + x][checkxaxis + y + 2] != 0) {
                return;
            }

        }
        for (Point point : shape.points) {
            temp = point.x;
            point.x = -point.y;
            point.y = temp;
        }
    }


    int[] needtodelete = new int[20];//这个部分需要改进

    boolean testdeletemap() {
        boolean judge = false;
        boolean checkempty = false;
        for (int i = 19; i >= 2; i--) {
            judge = false;
            for (int j = 0; j < 10; j++) {
                if (savemap[j][i] == 0) {
                    judge = true;
                    break;
                }
            }
            if (!judge) {
                checkempty = true;
                needtodelete[i - 1] = needtodelete[i] + 1;
            } else {
                needtodelete[i - 1] = needtodelete[i];
            }
        }
        return checkempty;
    }

    void deletemap() {
        for (int i = 19; i >= 2; i--) {
            for (int j = 0; j < 10; j++) {
                savemap[j][i + needtodelete[i]] = savemap[j][i];

            }
        }
        score();
    }

    public void score() {
        if (needtodelete[1] == 1) {
            score = score + 10 * needtodelete[1];//这个问题需要解决
        } else if (needtodelete[1] > 1) {
            score = score + 12 * needtodelete[1];//同样
        }
    }


    void scoreadd() {
        gameframe.gerScorepanel().repaint();
    }

    Timer timer = new Timer(300, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dowm();
            gameframe.getGamepanel().repaint();
        }
    });

    public void setScorepanel(Gameframe gameframe) {
        this.gameframe = gameframe;

    }

    public void setGameframe(Gameframe gameframe) {
        this.gameframe = gameframe;
        gameframe.setFocusable(true);
        gameframe.requestFocus();
        this.gameframe.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right();
                    gameframe.getGamepanel().repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    left();
                    gameframe.getGamepanel().repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    dowm();
                    gameframe.getGamepanel().repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    turn();
                    gameframe.getGamepanel().repaint();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public int savecolor(Color a) {
        int sol = 0;
        for (int i = 0; i < color.length; i++) {
            if (a == color[i]) {
                sol = i + 1;
            }
        }
        return sol;
    }


//这部分有借鉴，用到了points这个类

    //这是这个主游戏的最后一个部分
    String username = "wuyameng123";
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



}

class Shape {
    Point[] points;

    Shape(int[] xs, int[] ys) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(xs[i], ys[i]);
        }
    }

    Shape(Shape shape) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(shape.points[i].x, shape.points[i].y);
        }
    }

}