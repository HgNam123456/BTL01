import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class GameScreen extends JPanel implements Runnable {
    Thread thread;
    static int [][] bg = new int[20][20];
//    static int padding = 10;
    static int WIDTH = 400;
    static int HEIGHT = 400;
    static boolean isplaying = true;
    static boolean enableTextStartGame = true;
    static boolean isGameOver = false;



    ConRan ran;

    public GameScreen(){
        ran = new ConRan();
        thread = new Thread(this);
        thread.start();
        bg[10][10] = 2;
        data.LoadImage();
    }
    public void run(){
        long t = 0;
        Ostacle(bg);
        while (true){
            if(isplaying){
                ran.update();
            }
           repaint();

            try {
                sleep(20);
            } catch (InterruptedException e) {

            }
        }
    }

    public void paintBg(Graphics g){
        g.setColor(Color.green);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                g.fillRect(i*20+1,j*20+1,16,16);
                if(bg[i][j] == 2){
                    g.drawImage(data.imageApple,i*20+1,j*20+1,16,16,null);

                }
                if (bg[i][j] == 3){
                    g.setColor(Color.blue);
                    g.fillRect(i*20+1,j*20+1,16,16);
                    g.setColor(Color.green);
                }
            }
        }
    }

    public static void Ostacle(int[][] bg){
        for (int i = 5; i <15 ; i++) {
            for (int j = 6; j <8 ; j++) {
                bg[i][j] = 3;
            }
        }
        for (int i = 5; i <15 ; i++) {
            for (int j = 14; j >12 ; j--) {
                bg[i][j] = 3;
            }
        }
    }

    private void veKhung(Graphics g){
        g.setColor(Color.getHSBColor(0.1f,0.4f,0.6f));
        g.fillRect(0,0,WIDTH,HEIGHT);

    }
    public void paint(Graphics g){
        veKhung(g);
        paintBg(g);
        ran.VeRan(g);
        if(!isplaying){
            if(enableTextStartGame){
                g.setColor(Color.white);
                g.setFont(g.getFont().deriveFont(25.0f));
                g.drawString("press space to play",60,200);
            }
        }
        g.drawString("point: "+(ConRan.DodDai-3),10,30);
        if(isGameOver){
            g.setColor(Color.red);
            g.setFont(g.getFont().deriveFont(50.0f));
            g.drawString("GAME OVER",60,100);
        }

    }
}
