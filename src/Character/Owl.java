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

public class Owl extends Animal{ // extendar Animal och får dess egenskaper

    // instance variables
    private int position_Y;
    private int position_X;

    private int direction_X;
    private int direction_Y;
    private int size;
    private int speed;
    private int health;
    private int fatigue;
    private int hunger;
    private int happiness;
    private String name;
    int beenAlivefor; // in seconds

    int rep = 0;

    private Boolean directionUp;
    enum Mood // ger ugglan olika sorters humör
    {
        Död ,
        Glad,
        Hungrig,
    }

    private Mood mood; // initierar humöret

    public String[] filePaths = new String[3]; // array med ljudfiler

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
    }

    public void levelUp() {
    }

    public void improveStats() {
    }

    public void feed(Food food) {
        if(health + food.getFeedingPoints() > 100)
            health = 100;
        else
            health += food.getFeedingPoints(); // ugglans hälsa ökar med matens hälsa
    }

    public void rest() {
    }

    public void update()
    {
          move(); // uppdaterar ugglans position

          rep++;

          if(rep == 120) //varje sekund
          {
              beenAlivefor++;

                if(health > 0) // om ugglan inte är hungrig så minskar hunger
                {
                    health-= 3;
                    //debug console
                    System.out.println("Hunger: " + health);
                }
                else // ugglan är död
                {
                    JOptionPane.showMessageDialog(null, "Ugglan dog av hunger, spelet  börjar om");
                    health = 100; // hälsan sätts till 100
                    beenAlivefor = 0; // tiden sätts till 0
                }


              rep = 0; // reset timer
          }


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

    public void setMood(int mode) // sätter ugglans humör
    {
        switch(mode)
        {

            case 0: // om mode är 0 så är ugglan död och rör sig inte
                this.mood = Mood.Död;
                this.speed = 0;
                break;
            case 1: // om mode är 1 så är ugglan glad och rör sig snabbt
                this.mood = Mood.Glad;
                this.speed = 4;
                break;
            case 2: // om mode är 2 så är ugglan hungrig och rör sig långsamt
                this.mood = Mood.Hungrig;
                this.speed = 2;
                break;



        }
    }

    public int getValueFromMood()
    {
       return mood.ordinal();
    }
    public String getMoodString()
    {
        switch (mood.ordinal()) // skriver ut hur ugglan mår beroende på humör
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

    public int getHealth() { return health;}
    public void setHealth(int health) {this.health = health;}
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

    public int getBeenAlivefor() {
        return beenAlivefor;
    }

    public void setName(String name) {
        this.name = name;
    }
}
