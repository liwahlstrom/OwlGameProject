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

// skapa en ny varelse som har en postion x o y, samt hp etc allmänna grejjer
//extend owl from the creature and add specific data
// the creature should act like an interface and should be pure abstract same as food
// cant create a food or creature by itself but trough inheritence can we create classes
public class Owl extends Animal{




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
    enum Mood
    {
        Död,
        Glad,
        Hungrig,


    }

    private Mood mood;

    public String[] filePaths = new String[7];

    // constructor
    public Owl(int _position_X, int _position_Y, int _size, Boolean hasTeeths, Boolean isHostile){
        super(_position_X, _position_Y, _size, hasTeeths, isHostile); // ändra till getter och setters i animal
        hunger = 100;
        happiness = 100;
        position_Y = 200;
        position_X = (1440/2)-350;
        size = 300;
        speed = 2;
        health = 100;
        name = "Percy";
        directionUp = true;
        direction_X = speed;
        direction_Y = 0;


           // ljudfiler
        filePaths[0] = "Psjuk.wav";
        filePaths[1] = "Pglad.wav";
        filePaths[2] = "Phungrig.wav";
        mood = Mood.Glad;
    }




    // methods
    public void move() { // hur ugglan rör sig
        int screenWidth = 1440; // skrärmens bredd
        int screenHeight = 1024; // skärmens höjd
        int distanceToLeft = position_X;
        int distanceToRight = screenWidth - position_X - size;
        int distanceToTop = position_Y;
        int distanceToBottom = screenHeight - position_Y - size;

        // If funktionen gör så att ugglan rör sig i en random riktning i en konstant hastighet tills den når en kant
        if (Math.random() < 0.02) { // random generator som bestämmer om ugglan ska byta riktning vilket är en 0.2% chans
            double angle = Math.random() * 2 * Math.PI; // en random vinkel mellan 0 och 2pi genereras
            direction_X = (int) (Math.cos(angle) * speed); // riktningen i x-led bestäms av cosinus av vinkeln
            direction_Y = (int) (Math.sin(angle) * speed); // riktningen i y-led bestäms av sinus av vinkeln och den speed
        }
// If funktionen som gör så att ugglan inte kan gå utanför skärmen genom att den studsar tillbaka när den når en kant
        if (distanceToLeft < 50) { // om ugglan är till vänster kant är mindre än 50 pixlar så sätts riktningen åt motsatt håll
            direction_X = speed; // riktningen i motsatt håll
        } else if (distanceToRight < 50) { // om ugglan är till höger kant är mindre än 5o pixlar så sätts riktningen i motsatt håll
            direction_X = -speed; //
        }
        if (distanceToTop < 50) { // Gäller dessamma fast för uppe och nere i skärmen alltså i Y-led.
            direction_Y = speed;
        } else if (distanceToBottom < 50) { // om ugglan kommer för nära botten
            direction_Y = -speed;
        }

        position_X += direction_X; // positionen i x-led uppdateras
        position_Y += direction_Y; // positionen i y-led uppdateras

    }


    public void interact() { // hur ugglan interagerar med andra objekt
        // If funktionen som gör så att ugglan äter maten om den är i närheten av den
        if (Math.abs(position_X - 500) < 50 && Math.abs(position_Y - 500) < 50) { // om ugglan är inom 50 pixlar från maten så äter  den
            hunger += 10; // hunger ökar med 10
            happiness += 10; // happiness ökar med 10
        } else { // annars
            hunger -= 1; // hunger minskar med 1
            happiness -= 1; // happiness minskar med 1
        }

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
                this.mood = Mood.Död;
                this.speed = 1;
                break;
            case 1:
                this.mood = Mood.Glad;
                this.speed = 4;
                break;
            case 2:
                this.mood = Mood.Hungrig;
                this.speed = 1;
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
                return "Percy is Dying";
            case 1:
                return "Percy is Happy";
            case 2:
                return "Percy is hungry like a wolf!";

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
