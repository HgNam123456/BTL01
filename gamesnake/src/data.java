import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class data {
    public static Image imageHead;
    public static Image imageBody;
    public static Image imageApple;
    public static Image imageBG;
    public static void LoadImage(){
        try {
            imageHead = ImageIO.read(new File("C:\\Users\\MY PC\\IdeaProjects\\gamesnake\\src\\blue-box_1622459346.jpg"));
            imageBody = ImageIO.read(new File("C:\\Users\\MY PC\\IdeaProjects\\gamesnake\\src\\communityIcon_2ncix486jzt61.png"));
            imageApple = ImageIO.read(new File("C:\\Users\\MY PC\\IdeaProjects\\gamesnake\\src\\the-gii-dong-vat (9).jpg"));
            imageBG = ImageIO.read(new File("C:\\Users\\MY PC\\IdeaProjects\\gamesnake\\src\\th.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
