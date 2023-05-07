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
                    new Food("C://Users//wahlstrom.li//Downloads//MANDEL.gif", 1440 - 500, 1024 - 450, 10, 25),
                    new Food("C://Users//wahlstrom.li//Downloads//baiisen.gif", 1440 - 650, 1024 - 450, 20, 50),
                    new Food("C://Users//wahlstrom.li//Downloads//mus.gif", 1440 - 800, 1024 - 450, 30, 75)
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
                                owl.feed(food); // kallar på feed metoden i Owl class
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


            // Bild med hjärtan som representerar ugglans hunger i liv, det finns bilder med 1-4 hjärtar
            // Pga upprepande kod har filerna och positionerna gjorts till array
            String[] imageFiles = {"C://Users//wahlstrom.li//Downloads//percyliv.gif",
                    "C://Users//wahlstrom.li//Downloads//percyliv3.gif",
                    "C://Users//Wahlstrom.li//Downloads//percyliv2.gif",
                    "C://Users//wahlstrom.li//Downloads//percyliv1.gif"};
            int[][] positions = {{20, 90}, {40, 90}, {60, 90}, {80, 90}}; // x och y positioner för hjärtanen

            int index;
            if(owl.getHealth() > 75)
                index = 0;
            else if(owl.getHealth() > 50)
                index = 1;
            else if (owl.getHealth() > 25)
                index = 2;
            else if (owl.getHealth() > 0)
                index = 3;
            else
                index = 4;

            if(index < 4)
            {
                BufferedImage image; // Visar bilderna
                try { // felhanterare
                    image = ImageIO.read(new File(imageFiles[index])); // läser in bilderna från arrayen
                } catch (IOException e) { // felhanterare
                    e.printStackTrace(); //
                    return;
                }
                int x = positions[index][0]; // x positionen för hjärtanen
                int y = positions[index][1]; // y positionen för hjärtanen, [1] betyder att det är andra värdet i arrayen


                g.drawImage(image, x, y, null); // ritar ut hjärtanen

            }




            // hämtar owlens position geonom owl klassen
            int owlX = owl.getPosition_X(); // hämtar x - position
            int owlY = owl.getPosition_Y(); // häntar y - position
            int size = owl.getSize(); // hämtar ugglans storlek
            String owlGifFile = "C://Users//wahlstrom.li//Downloads//Percy.gif"; // hämtar bilden på ugglan
            try {
                BufferedImage owlImage = ImageIO.read(new File(owlGifFile)); // läser in bilden på ugglan

                // kollar om ugglan är utanför skärmen
                if (owlX < 0) { // om ugglan är utanför skärmen i x led så kommer den att vara 0
                    owlX = 0;
                } else if (owlX + size > getWidth()) { // om ugglan är utanför skärmen i x led så kommer den att vara 0
                    owlX = getWidth() - size;
                }
                if (owlY < 0) { // om ugglan är utanför skärmen i y led så kommer den att vara 0
                    owlY = 0;
                } else if (owlY + size > getHeight()) { // om ugglan är utanför skärmen i y led så kommer den att vara 0
                    owlY = getHeight() - size;
                }

                g.drawImage(owlImage, owlX, owlY, size, size, null); // ritar ugglan på skärmen
            } catch (IOException e) { // felhanterare
                e.printStackTrace();
            }

            //text för spelet
            Font myFont = new Font("Courier New", 1, 15);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.drawString(owl.getMoodString(), 20, 220); // berättar vilket humör ugglan har genom att hämta det från owl klassen
            g.drawString("Klappa ugglan för att få pengar och mata honom!", 20, 580); // förklarar vad spelet går ut på
          //  g.drawString("Food is Visable" + toString(foodVisable), 20, 400); felhanterare

            // Ritar coin bilden
            String coinFile = "C://Users//wahlstrom.li//Downloads//Coins.gif"; // hämtar bilden på myntet
            try {
                BufferedImage coinImage = ImageIO.read(new File(coinFile)); // läser in bilden på myntet
                g.drawImage(coinImage, 1200, 80, null); // ritar ut myntet
            } catch (IOException e) { // felhantering
                e.printStackTrace();
            }

            // Ritar hur mycket mynt som finns
            Font coinFont = new Font("TimesRoman", 1, 20); // skapar en font för myntet
            g.setFont(coinFont); // sätter fonten
            g.setColor(Color.BLACK); // sätter färgen på texten
            g.drawString(coin + "$", 1150, 120); // ritar ut hur mycket mynt som finns på skärmen


            // Ritar Rubrik
            Font titelFont = new Font("Courier", 1, 30); // skapar font
            g.setColor(Color.black); // sätter färg
            g.setFont(titelFont); // sätter font
            g.drawString(" the owl", (getWidth() / 2)-150, 50); // ritar ut texten på skärmen

            // ritar ut hur länge du levt


            g.drawString("Survived for: " + owl.getBeenAlivefor() + "s", (getWidth() / 2) + 100, 50); // ritar ut texten på skärmen


            // Ritar ut mat GUI
            String FoodFile = "C://Users//wahlstrom.li//Downloads//Mat.gif";
            try {
                BufferedImage FoodImage = ImageIO.read(new File(FoodFile));
                g.drawImage(FoodImage, foodGUI_x, foodGUI_y, null);
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (foodVisable){ // ritar ut maten av olika slag
            for (Food food : foodArray) { // får maten från foodarray, food är en instans av food klassen
                int food_x = food.getPosition_X(); // hämtar x positionen för maten
                int food_y = food.getPosition_Y(); // hämtar y positionen för maten
                String foodGifFile = food.getFoodGifFile();// initierar foodGifFile genom att hämta det från food klassen
                try {
                    BufferedImage foodImage = ImageIO.read(new File(foodGifFile));
                    g.drawImage(foodImage, food_x, food_y, null); // ritar ut maten på skärmen
                } catch (IOException e) { // felhanterare
                    e.printStackTrace();
                }
            }

                try {
                    BufferedImage FoodImage = ImageIO.read(new File(FoodFile));
                    g.drawImage(FoodImage, foodGUI_x, foodGUI_y, null);
                } catch (IOException e) {
                    e.printStackTrace(); // felhantering

                }

                }

            }


        }
        // Metod för att spela upp ljud
    private static void playSound(String filepath) { // hämtar ljudet från filen
        try {
                File musicPath = new File(filepath); // hämtar ljudet från filen
                if (musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath); // hämtar ljudet från filen
                    Clip clip = AudioSystem.getClip(); //
                    clip.open(audioInput); //
                    clip.start(); //  spelar upp ljudet
                }
                else {
                    System.out.println("Can't find file");
                }
                }
            catch (Exception e) {
                System.out.println(e); // felhanterare
            }
             }
}

