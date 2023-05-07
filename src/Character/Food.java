package Character;

import Character.Owl;


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

    private int feedingPoints;

    private int coinValue;


    public Food(String fileName, int x, int y, int coinValue, int feedingPoints) throws IOException {
        this.image = ImageIO.read(new File(fileName));
        this.FoodGifFile = fileName;
        this.x = x;
        this.y = y;
        this.coinValue = coinValue;

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
    public int getFeedingPoints() {
        return feedingPoints;
    }

    public int getCoinValue() {
        return coinValue;
    }
}