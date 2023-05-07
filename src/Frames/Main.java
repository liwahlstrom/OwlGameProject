package Frames;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;
import java.util.Random;
import java.util.Random.*;
import Character.Owl;
public class Main {
    public static void main(String[] args) throws IOException {
        Owl myOwl = new Owl(200,200,200,true,true); // konstruktor
        SceneFrame mySceneFrame = new SceneFrame(myOwl); // instansierar en ny sceneframe
        JFrame frame = new JFrame("Owl Scene"); // skapar en ny JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör så att programmet avslutas när skärmen stängs ner.
        frame.add(mySceneFrame); // lägger till en fysisk skärm
        frame.setSize(1440, 1024); // ger skärmen en storlek i form av bredd och höjd
        frame.setVisible(true); // Tillåter skrämen att visas
        frame.setLocationRelativeTo(null); // Centrerar skärmen

        // Loopa för att repainta sceneframe
        int rep = 0; // börjar på noll
        while (true) { // loopar
            if (rep == 300) // om rep är 300
            {rep = 0;
                Random ran = new Random();
            myOwl.setMood(ran.nextInt(7));
            }
            else {rep ++;}
            mySceneFrame.repaint(); // repaintar sceneframe
            myOwl.update(); // uppdaterar ugglans position och rörelse
            try { // felhanterar genom att vänta 1/120 av en sekund
                Thread.sleep(1000/120); // 60 FPS, bestämmer hur snabbt ugglan ska röra sig
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}