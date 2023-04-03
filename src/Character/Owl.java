package Character;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;


public class Owl {

    enum Mood
    {
        JatteLedsen,
        Arg,
        Död,
        Glad,
        Hungrig,
        Ledsen,
        Trott

    }


    // instance variables
    private int position_Y;
    private int position_X;

    private int direction_X;
    private int direction_Y;

    private int z_direction;
    private int size;
    private int speed;
    private int health;
    private int fatigue;
    private int hunger;
    private int happiness;
    private String name;

    private Boolean directionUp;

    private Mood mood;

    public String[] filePaths = new String[7];

    // constructor
    public Owl() {
        hunger = 100;
        happiness = 100;
        position_Y = 200;
        position_X = (1440/2)-350;
        size = 300;
        speed = 2;
        health = 100;
        fatigue = 100;
        name = "Percy";
        directionUp = true;
        direction_X = speed;
        direction_Y = 0;


        filePaths[0] = "Pledledsen.wav";
        filePaths[1] = "Parg.wav";
        filePaths[2] = "Psjuk.wav";
        filePaths[3] = "Pglad.wav";
        filePaths[4] = "Phungrig.wav";
        filePaths[5] = "Pledsen.wav";
        filePaths[6] = "Ptrott.wav";
        mood = Mood.Arg;

    }

    // methods
    public void move() {
        int screenWidth = 1440;
        int screenHeight = 1024;

        int distanceToLeft = position_X;
        int distanceToRight = screenWidth - position_X - size;
        int distanceToTop = position_Y;
        int distanceToBottom = screenHeight - position_Y - size;

        if (Math.random() < 0.02) {
            double angle = Math.random() * 2 * Math.PI;
            direction_X = (int) (Math.cos(angle) * speed);
            direction_Y = (int) (Math.sin(angle) * speed);
        }

        if (distanceToLeft < 50) {
            direction_X = speed;
        } else if (distanceToRight < 50) {
            direction_X = -speed;
        }
        if (distanceToTop < 50) {
            direction_Y = speed;
        } else if (distanceToBottom < 50) {
            direction_Y = -speed;
        }

        position_X += direction_X;
        position_Y += direction_Y;

    }


    public void interact() {
    }

    public void levelUp() {
    }

    public void improveStats() {
    }

    public void feed() {
    }

    public void rest() {
    }

    public void update()
    {
          move();

    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getPosition_X() {
        return position_X;
    }

    public void setPosition_X(int position_X) {
        this.position_X = position_X;
    }

    public void setMood(int mode)
    {
        switch(mode)
        {
            case 0:
                this.mood = Mood.JatteLedsen;
                this.speed = 1;
                break;
            case 1:
                this.mood = Mood.Arg;
                this.speed = 6;
                break;
            case 2:
                this.mood = Mood.Död;
                this.speed = 1;
                break;
            case 3:
                this.mood = Mood.Glad;
                this.speed = 4;
                break;
            case 4:
                this.mood = Mood.Hungrig;
                this.speed = 1;
                break;
            case 5:
                this.mood = Mood.Ledsen;
                this.speed = 1;
                break;
            case 6:
                this.mood = Mood.Trott;
                this.speed = 0;
                break;

        }
    }

    public int getValueFromMood()
    {
       return mood.ordinal();
    }
    public String getMoodString()
    {
        switch (mood.ordinal())
        {
            case 0:
                return "Percy is Really Sad";
            case 1:
                return "Percy is Angry";
            case 2:
                return "Percy is Dying";
            case 3:
                return "Percy is Happy";
            case 4:
                return "Percy is hungry like a wolf!";
            case 5:
                return "Percy is Sad";
            case 6:
                return "Percy is Tired!";
        }
        return "";
    }
    public int getPosition_Y() {
        return position_Y;
    }

    public void setPosition_Y(int position_Y) {
        this.position_Y = position_Y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public String getName() {
        return name;
    }

    public Mood getMood()
    {
        return this.mood;
    }

    public void setName(String name) {
        this.name = name;
    }
}
