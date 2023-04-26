package Character;

public class Spider extends Animal{

    int speed;
    int health;

    public Spider(int position_x, int position_y, int size,  Boolean hasTeeths, Boolean isHostile) {
        super( position_x, position_y,  size,  hasTeeths,  isHostile);
    }

    void Move(){


    }

    void interact(Owl owl){
        //a random function
        //if owl is close to spider
        //spider attacks owl
        //owl loses health
    }

    void update_health(){


    }


    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setHealth(int health) {
        this.health = health;
    }

}

