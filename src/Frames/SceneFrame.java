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

public class SceneFrame extends JComponent {
    private Owl owl;
    private boolean visible;
    private Image owlImage;
    private int imageSize;
    private int coin = 0;



    public SceneFrame(Owl owl) {
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
                }
                Random rand = new Random();
            }
        });

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (visible) {

            g.setColor(new Color(52, 210, 86));
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(new Color(39, 144, 22
            ));
            g.fillRect(0, 0, getWidth(), 70);

            g.setColor(new Color(39, 144, 22));
            g.fillRect(0, getHeight() - 100, getWidth(), 100); // Draw a rectangle from x=0, y=height-30 to the end of the screen with height=30

            String imageFile = "C://Users//wahlstrom.li//Downloads//percyliv.gif";
            BufferedImage image;
            try {
                image = ImageIO.read(new File(imageFile));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            int x = 20;
            int y = 90;
            g.drawImage(image, x, y, null);


            int owlX = owl.getPosition_X();
            int owlY = owl.getPosition_Y();
            int size = owl.getSize();
            String owlGifFile = "C://Users//wahlstrom.li//Downloads//Percy.gif";
            try {
                BufferedImage owlImage = ImageIO.read(new File(owlGifFile));

                if (owlX < 0) {
                    owlX = 0;
                } else if (owlX + size > getWidth()) {
                    owlX = getWidth() - size;
                }

                if (owlY < 0) {
                    owlY = 0;
                } else if (owlY + size > getHeight()) {
                    owlY = getHeight() - size;
                }

                g.drawImage(owlImage, owlX, owlY, size, size, null);
            } catch (IOException e) {
                e.printStackTrace();
            }


            String borderFile = "C://Users//wahlstrom.li//Downloads//Border.gif";
            try {
                BufferedImage borderimage = ImageIO.read((new File(borderFile)));
                g.drawImage(borderimage, 20, 150, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Font myFont = new Font("Courier New", 1, 15);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.drawString("100%", 230, 170);
            g.drawString("Humör:" + owl.getMoodString(), 20, 220);
            g.drawString("Tap Percy to Pet him!", 20, 580);


            String coinFile = "C://Users//wahlstrom.li//Downloads//Coins.gif";
            try {
                BufferedImage coinImage = ImageIO.read(new File(coinFile));
                g.drawImage(coinImage, 1200, 80, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Font coinFont = new Font("TimesRoman", 1, 20);
            g.setFont(coinFont);
            g.setColor(Color.BLACK);
            g.drawString(coin + "$", 1150, 120);

            Font titelFont = new Font("Courier", 1, 30);
            g.setColor(Color.black);
            g.setFont(titelFont);
            g.drawString("Percy" + " the owl", getWidth() / 2, 50);


            String barFile = "C://Users//wahlstrom.li//Downloads//Healthbar.gif";
            try {
                BufferedImage barImage = ImageIO.read(new File(barFile));

                g.drawImage(barImage, 20, 150, null);
            } catch (IOException e) {
                e.printStackTrace();
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
    private static void playSound(String filepath) {
        try {
            File musicPath = new File(filepath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}