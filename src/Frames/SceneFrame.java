package Frames;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import java.util.Random;
import java.awt.Color;
import java.util.random.*;
import javax.swing.JOptionPane;
import Character.Owl;
import Character.Food;

public class SceneFrame extends JComponent {
    private Owl owl;
    private boolean visible;
    private Image owlImage;
    private int imageSize;
    private int coin = 0;
    private Boolean foodVisable = false;

    private int foodGUI_x = 1150;
    private int foodGUI_y = 550;

    private Food[] foodArray =
           {
            new Food("C://Users//wahlstrom.li//Downloads//MANDEL.gif", 1440 - 500, 1024 - 450, 10),
            new Food("C://Users//wahlstrom.li//Downloads//baiisen.gif", 1440 - 650, 1024 - 450, 20),
            new Food("C://Users//wahlstrom.li//Downloads//mus.gif", 1440 - 800, 1024 - 450, 30 )
           };







    public SceneFrame(Owl owl) throws IOException {
        this.owl = owl;
        this.visible = true;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = owl.getPosition_X();
                int y = owl.getPosition_Y();
                int size = owl.getSize();
                if (e.getX() >= x && e.getX() <= x + size && e.getY() >= y && e.getY() <= y + size) {

                    playSound(owl.filePaths[owl.getValueFromMood()]);
                    coin++;
                    // Update the coin display
                    repaint(1150, 80, 50, 50);
                }


                for (Food food : foodArray) {
                    // Check if the click was inside the food image
                    if (e.getX() >= food.getPosition_X() && e.getX() <= food.getPosition_X() +
                            200 && e.getY() >= food.getPosition_Y() && e.getY() <= food.getPosition_Y() + 200) {
                        if (foodVisable) { // If the food is visable
                            foodVisable = false;
                            if(coin < food.getCoinValue()) //har vi råd??
                            {
                                JOptionPane.showMessageDialog(null, "Du har inte råd med denna maten");
                                break;
                            }
                            else //vi har råd
                            {
                                coin -= food.getCoinValue(); // Subtract the coin value from the total coins
                                repaint(1150, 80, 50, 50);
                                break;
                            }
                        }
                    }
                }


                // Check if the click was inside the food image
                if (e.getX() >= foodGUI_x && e.getX() <= foodGUI_x + 200 && e.getY() >=
                        foodGUI_y && e.getY() <= foodGUI_y + 200) {
                    if (foodVisable) {
                        foodVisable = false;
                    } else {
                        //debug print
                        System.out.println("foodGUI_x: " + foodGUI_x + " foodGUI_y: " + foodGUI_y);
                        foodVisable = true;
                    }
                }
                // Lägg till liknande kod till de andra knapparna
            }
        });
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (visible) {

            //borders o sånt
            g.setColor(new Color(52, 210, 86));
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(new Color(39, 144, 22
            ));
            g.fillRect(0, 0, getWidth(), 70);

            g.setColor(new Color(39, 144, 22));
            g.fillRect(0, getHeight() - 100, getWidth(), 100); // Draw a rectangle from x=0, y=height-30 to the end of the screen with height=30

            //liv
            String imageFile = "C://Users//wahlstrom.li//Downloads//percyliv.gif";
            BufferedImage image;
            //läser in liv
            try {
                image = ImageIO.read(new File(imageFile));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            //ritar ut liv
            int x = 20;
            int y = 90;
            g.drawImage(image, x, y, null);


            // hämtar owlens position
            int owlX = owl.getPosition_X();
            int owlY = owl.getPosition_Y();
            int size = owl.getSize();
            String owlGifFile = "C://Users//wahlstrom.li//Downloads//Percy.gif";
            try {
                BufferedImage owlImage = ImageIO.read(new File(owlGifFile));

                // check if the owl is outside the screen
                if (owlX < 0) {
                    owlX = 0;
                } else if (owlX + size > getWidth()) {
                    owlX = getWidth() - size;
                }
                // check if the owl is outside the screen
                if (owlY < 0) {
                    owlY = 0;
                } else if (owlY + size > getHeight()) {
                    owlY = getHeight() - size;
                }
                //draws OWL
                g.drawImage(owlImage, owlX, owlY, size, size, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //some text
            Font myFont = new Font("Courier New", 1, 15);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.drawString("Humör:" + owl.getMoodString(), 20, 220);
            g.drawString("Tap Percy to Pet him!", 20, 580);
            g.drawString("Food is Visable" + toString(foodVisable), 20, 400);

            // Draw the coin image
            String coinFile = "C://Users//wahlstrom.li//Downloads//Coins.gif";
            try {
                BufferedImage coinImage = ImageIO.read(new File(coinFile));
                g.drawImage(coinImage, 1200, 80, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Draw the coin count
            Font coinFont = new Font("TimesRoman", 1, 20);
            g.setFont(coinFont);
            g.setColor(Color.BLACK);
            g.drawString(coin + "$", 1150, 120);
            // Draws Rubrik
            Font titelFont = new Font("Courier", 1, 30);
            g.setColor(Color.black);
            g.setFont(titelFont);
            g.drawString("Percy" + " the owl", getWidth() / 2, 50);

            // Draws the food GUI

            String FoodFile = "C://Users//wahlstrom.li//Downloads//Mat.gif";
            try {
                BufferedImage FoodImage = ImageIO.read(new File(FoodFile));
                g.drawImage(FoodImage, foodGUI_x, foodGUI_y, null);
            } catch (IOException e) {
                e.printStackTrace();
            }


                //TODO clicking food menu, makes foodVisable false if true etcetera

                // Draws the foods
            if (foodVisable){
            for (Food food : foodArray) {
                int food_x = food.getPosition_X();
                int food_y = food.getPosition_Y();
                String foodGifFile = food.getFoodGifFile();
                try {
                    BufferedImage foodImage = ImageIO.read(new File(foodGifFile));
                    g.drawImage(foodImage, food_x, food_y, null);
                    //debug cords for picture in console
                    System.out.println("food_x: " + food_x + " food_y: " + food_y);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

                try {
                    BufferedImage FoodImage = ImageIO.read(new File(FoodFile));
                    g.drawImage(FoodImage, foodGUI_x, foodGUI_y, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            String foodFile = "C://Users//wahlstrom.li//Downloads//Mat.gif";
            try {
                BufferedImage foodImage = ImageIO.read(new File(foodFile));
                g.drawImage(foodImage, 1100, 580, null);

            } catch (IOException e) {
                e.printStackTrace();

            }

            String nutFile = "C://Users//wahlstrom.li//Downloads//MANDEL.gif";
            try {
                BufferedImage nutImage = ImageIO.read(new File(nutFile));
                g.drawImage(nutImage, 900, 580, null);
            }
            catch (IOException e){
                e.printStackTrace();
            }

            String baggeFile = "C://Users//wahlstrom.li//Downloads//baiisen.gif";
            try{
                BufferedImage nutImage = ImageIO.read(new File(baggeFile));
                g.drawImage(nutImage, 750, 580, null);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        String musFile = "C://Users//wahlstrom.li//Downloads//mus.gif";
        try{
            BufferedImage musImage = ImageIO.read(new File(musFile));
            g.drawImage(musImage, 600, 580, null);
        }
        catch(IOException e){
            e.printStackTrace();
        }





    }

    private String toString(Boolean foodVisable) {
        if (foodVisable) {
            return "true";
        } else {
            return "false";
        }
    }

    private static void playSound(String filepath) {
        try {
                File musicPath = new File(filepath);
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }
                else {
                    System.out.println("Can't find file");
                }
                }
            catch (Exception e) {
                System.out.println(e);
            }
             }
}
//i would finally like to implement that the picture String imageFile = "C://Users//wahlstrom.li//Downloads//percyliv.gif";
//            BufferedImage image;  get cut of for every second not fed and gets full again when fed
//i would also like the hunger to get 1 less for every second and the health is at 60 to begin with and if  the hunger becomes 0 there will be a messege that the owl died
//how could i make the different foods to have different values that give the owl different values of health
// how could i make the different foods to have different values that give the owl different values of health
// with my code?
// kunna döpa ugglan till det man vill
