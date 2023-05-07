package Frames; // gör så att vi kan använda oss av klasser från andra mappar
import java.awt.*; // gör så att vi kan använda oss av awt
import java.awt.event.MouseAdapter; // gör så att vi kan använda oss av musen
import java.awt.event.MouseEvent; // gör så att vi kan använda oss av musen
import java.awt.image.BufferedImage; // gör så att vi kan använda oss av bilder
import java.io.File; // gör så att vi kan använda oss av filer
import java.io.IOException; // gör så att vi kan använda oss av IOException
import javax.imageio.ImageIO; // gör så att vi kan använda oss av ImageIO
import javax.sound.sampled.AudioInputStream; // gör så att vi kan använda oss av ljud
import javax.sound.sampled.AudioSystem; // gör så att vi kan använda oss av ljud
import javax.sound.sampled.Clip; // gör så att vi kan använda oss av ljud
import javax.swing.JComponent; // gör så att vi kan använda oss av JComponent
import java.util.Random;
import java.awt.Color; // gör så att vi kan använda oss av färger
import java.util.random.*;
import javax.swing.JOptionPane; // gör så att vi kan använda oss av JOptionPane
import Character.Owl; // gör så att vi kan använda oss av Owl klassen
import Character.Food; // gör så att vi kan använda oss av Food klassen

public class SceneFrame extends JComponent { // JComponent är en base class för custom graphics components
    private Owl owl; // owl referens till owl objektet
    private boolean visible;// visible är en boolean som bestämmer om ugglan ska synas eller inte
    private Image owlImage; // owlImage är en bild som ska representera ugglan
    private int imageSize; // imageSize är en int som bestämmer storleken på ugglan
    private int coin = 0; // Gör att coin alltså pengarna alltid börjar med värdet noll
    private Boolean foodVisable = false; // gör så att maten inte syns från början utan att man måste klicka på matbilden för att få upp de olika alternativen till mat

    private int foodGUI_x = 1150; // gör så att maten syns på rätt plats
    private int foodGUI_y = 550; // gör så att maten syns på rätt plats

    private Food[] foodArray = // gör så att maten syns på rätt plats, och att det finns tre olika alternativ till mat som är en förenkling så att inte koden upprepas.
            {
                    new Food("C://Users//wahlstrom.li//Downloads//MANDEL.gif", 1440 - 500, 1024 - 450, 10),
                    new Food("C://Users//wahlstrom.li//Downloads//baiisen.gif", 1440 - 650, 1024 - 450, 20),
                    new Food("C://Users//wahlstrom.li//Downloads//mus.gif", 1440 - 800, 1024 - 450, 30)
            };

// En IOException är en felsökare som är ditsatt när en I/O operation misslyckas eller störs
    public SceneFrame(Owl owl) throws IOException { // konstruktor som throws IOException
        this.owl = owl; //
        this.visible = true; // gör så att ugglan syns


        this.addMouseListener(new MouseAdapter() { // kollar om musen klickas på ugglan eller maten
            @Override // gör så att vi kan använda oss av MouseAdapter klassen som är en adapterklass för musen som vi importerat
            public void mouseClicked(MouseEvent e) {
                int x = owl.getPosition_X(); // gör så att ugglan syns på rätt plats i x led
                int y = owl.getPosition_Y(); // gör så att ugglan syns på rätt plats i y led
                int size = owl.getSize(); //  gör så att ugglan syns i rätt storlek genom att ta från getter metoden i Owl class
                // Denna if metod kollar om musen klickas på ugglan inom de ramar som angetts
                if (e.getX() >= x && e.getX() <= x + size && e.getY() >= y && e.getY() <= y + size) { // om skrämen klickas enligt dessa ramar så ökar coin med 1.
                    coin++; // ökar coin med
                    repaint(1150, 80, 50, 50); // uppdaterar coin display genom att repainta den på samma ställe som tidigare
                }


                for (Food food : foodArray) { // Loopar igenom alla mat alternativ
                    // Kollar om man klickar inom ramarna för mat-bilden
                    if (e.getX() >= food.getPosition_X() && e.getX() <= food.getPosition_X() + 200 && e.getY() >= food.getPosition_Y() && e.getY() <= food.getPosition_Y() + 200) {
                        if (foodVisable) { // Om maten syns så kommer den att vara falsk
                            foodVisable = false;
                            if (coin < food.getCoinValue()) // kollar om man har råd att köpa maten som har olika värde givna till sig i Food class
                            {
                                JOptionPane.showMessageDialog(null, "Du har inte råd med denna maten"); // Om man inte har råd kommer det upp en messege ruta som förklarar att man inte har råd.
                                break; // break gör så att loopen avbryts
                            } else //om man har råd med maten
                            {
                                coin -= food.getCoinValue(); // tar bort pengar från coin av det värdet som maten man köpt har
                                repaint(1150, 80, 50, 50); // uppdaterar coin display genom att repainta den på samma ställe som tidigare men med ett nytt värde på coin
                                break; // avbryter loopen
                            }
                        }
                    }
                }

                // kollar om man klickar inom food bilden
                if (e.getX() >= foodGUI_x && e.getX() <= foodGUI_x + 200 && e.getY() >= foodGUI_y && e.getY() <= foodGUI_y + 200) { // foodGUI_x är en int som bestämmer var maten ska synas i x led och foodGUI_y är en int som bestämmer var maten ska synas i y led
                    if (foodVisable) { // om maten syns så kommer den att vara falsk
                        foodVisable = false;
                    } else { // annars kommer den att vara sann
                        System.out.println("foodGUI_x: " + foodGUI_x + " foodGUI_y: " + foodGUI_y); // skriver ut foodGUI_x och foodGUI_y i konsolen så att maten syns
                        foodVisable = true;
                    }
                }
            }
        });
    }


    @Override // gör så att vi kan använda oss av paintComponent klassen som är en adapterklass för musen som vi importerat
    protected void paintComponent(Graphics g) { // gör så att vi kan använda oss av Graphics klassen som är en adapterklass för musen som vi importerat
        super.paintComponent(g); // super innebär att vi använder oss av den gamla metoden som vi har i paintComponent
        if (visible) {

            // bakgrundsfärgen
            g.setColor(new Color(52, 210, 86)); // gör så att färgen på bakgrunden är grön
            g.fillRect(0, 0, getWidth(), getHeight()); // gör så att bakgrunden är fylld med färgen som är grön
            // borders
            g.setColor(new Color(39, 144, 22)); //
            g.fillRect(0, 0, getWidth(), 70);
            // borders
            g.setColor(new Color(39, 144, 22));
            g.fillRect(0, getHeight() - 100, getWidth(), 100); // Ritar en rectangle från x=0, y=height-30 till slutet av skärmen med height=30

            //Olika filerna med liv-hjärtan som varierar från 1-4 för att de grafiskt ska kunna minska
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


            String imageFile3 = "C://Users//wahlstrom.li//Downloads//percyliv3.gif";
            BufferedImage image3;
            //läser in liv
            try {
                image3 = ImageIO.read(new File(imageFile3));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            //ritar ut liv
            int x3 = 20;
            int y3 = 90;
            g.drawImage(image3, x3, y3, null);



        String imageFile2 = "C://Users//Wahlstrom.li//Downloads//percyliv2.gif";
        BufferedImage image2;
        //läser in liv
        try {
            image2 = ImageIO.read(new File(imageFile2));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //ritar ut liv
        int x2 = 20;
        int y2 = 90;
        g.drawImage(image2, x2, y2, null);

    }

    String imageFile1 = "C://Users//wahlstrom.li//Downloads//percyliv1.gif";
    BufferedImage image1;
    //läser in liv
        try {
        image1 = ImageIO.read(new File(imageFile1));
    }
        catch (IOException e)

    {
        e.printStackTrace();
        return;
    }
    //ritar ut liv
    int x1 = 20;
    int y1 = 90;
        g.drawImage(image1, x1, y1, null);




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
