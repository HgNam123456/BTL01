import javax.xml.crypto.Data;
import java.awt.*;
import java.util.Random;

public class ConRan {
    public static int DodDai = 3;
    int [] x;
    int [] y;
    long t1 = 0;
    public static int GO_UP = 1;
    public static int GO_DOWN = -1;
    public static int GO_LEFT = 2;
    public static int GO_RIGHT = -2;
    int m; int n;

    int vector = ConRan.GO_DOWN;


    public ConRan(){
        x = new int[20];
        y = new int[20];
        x[0] = 2;
        y[0] = 0;
        x[1] = 1;
        x[2] = 0;
        y[1] = 0;
        y[2] = 0;

    }
    public void setVector(int v){

        if(vector != -v){
            vector = v;
        }
    }

    public Point LayToaDoMoi(){
        Random r = new Random();
        int x = r.nextInt(19);
        int y = r.nextInt(19);
        return new Point(x,y);
    }


    public void update(){
        if(System.currentTimeMillis()-t1>500/DodDai){

            if(GameScreen.bg[x[0]][y[0]] == 2){
                DodDai++;
                GameScreen.bg[x[0]][y[0]] = 0;
                m = LayToaDoMoi().x;
                n = LayToaDoMoi().y;
                while(GameScreen.bg[m][n] == 3){
                    m = LayToaDoMoi().x;
                    n = LayToaDoMoi().y;
                }
                GameScreen.bg[m][n] = 2;
            }
            for (int i = DodDai-1; i >0 ; i--) {
                x[i] = x[i-1];
                y[i] = y[i-1];
            }
            if (vector == ConRan.GO_UP){
                y[0]--;
                

            }
            if (vector == ConRan.GO_DOWN){
                y[0]++;
            }
            if (vector == ConRan.GO_LEFT){
                x[0]--;
            }
            if (vector == ConRan.GO_RIGHT){
                x[0]++;
            }
            if(x[0] < 0) x[0] =19;
            if(x[0] > 19) x[0] =0;
            if(y[0] < 0) y[0] =19;
            if(y[0] > 19) y[0] =0;
            for (int i = 1; i <DodDai ; i++) {
                if(x[0] == x[i] && y[0] == y[i]){
                    GameScreen.isplaying = false;
                    DodDai = 3;
                    GameScreen.isGameOver = true;
                }
            }
            t1 = System.currentTimeMillis();
            if(GameScreen.bg[x[0]][y[0]] == 3){
                GameScreen.isplaying = false;
                DodDai = 3;
                GameScreen.isGameOver = true;
            }
        }
    }


    public void VeRan(Graphics g){
        g.setColor(Color.red);
        for (int i = 1; i < DodDai; i++) {
            g.drawImage(data.imageBody,x[i]*20+1,y[i]*20+1,16,16,null);
        }
        g.drawImage(data.imageHead, x[0]*20+1 , y[0]*20+1,16,16,null);
    }
}
