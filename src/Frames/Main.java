package Frames;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;
import java.util.Random;
import java.util.Random.*;
import Character.Owl;
// få in arv och arv i flera led implemets och extenders
public class Main {
    public static void main(String[] args) throws IOException {
        Owl myOwl = new Owl(200,200,200,true,true); // konstruktor
        SceneFrame mySceneFrame = new SceneFrame(myOwl);
        JFrame frame = new JFrame("Owl Scene");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör så att programmet avslutas när skärmen stängs ner.
        frame.add(mySceneFrame); // lägger till en fysisk skärm
        frame.setSize(1440, 1024); // ger skärmen en storlek i form av bredd och höjd
        frame.setVisible(true); // Tillåter skrämen att visas
        frame.setLocationRelativeTo(null); // Centrerar skärmen

        // Loopa för att repainta sceneframe
        int rep = 0; // börjar på noll
        while (true) {
            if (rep == 300)
            {rep = 0;
                Random ran = new Random();
            myOwl.setMood(ran.nextInt(7));
            }
            else {rep ++;}
            mySceneFrame.repaint();
            myOwl.update();
            try {
                Thread.sleep(1000/120); // 60 FPS, bestämmer hur snabbt ugglan ska röra sig
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}