package Frames;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Random;
import java.util.Random.*;
import Character.Owl;
// få in arv och arv i flera led implemets och extenders
public class Main {
    public static void main(String[] args) {
        Owl myOwl = new Owl();
        SceneFrame mySceneFrame = new SceneFrame(myOwl);
        JFrame frame = new JFrame("Owl Scene");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mySceneFrame);
        frame.setSize(1440, 1024);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Loopa för att repainta sceneframe
        int rep = 0;
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
                Thread.sleep(1000/120); // 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}