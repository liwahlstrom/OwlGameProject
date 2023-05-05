package Character;

import Character.Owl;

// varje mat är food en basklass, man kan inte skapa något från food det är bara en abstrakt interface
// ger olika hp attributer, position, x o y,
// göra en abstakt klass av food det ska inte gå att göra en klass av food
//kunna inherita subklasser från food som är en basklass och då så kan subklassen overrida metoder
//virtuella memberfunctions from the base it can also define its own member data and member functions.
// speciella attributer egna grejer som inte andra har
//overrida debug string så att alla får en unik debug string
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Food {
    private BufferedImage image;
    private String FoodGifFile;
    private int x;
    private int y;

    public Food(String fileName, int x, int y) throws IOException {
        this.image = ImageIO.read(new File(fileName));
        this.FoodGifFile = fileName;
        this.x = x;
        this.y = y;
    }

    // getters and setters
    public BufferedImage getImage() {
        return image;
    }
    public int getPosition_X() {
        return x;
    }
    public int getPosition_Y() {
        return y;
    }
    public String getFoodGifFile() {
        return FoodGifFile;
    }
}