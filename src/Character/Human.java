package Character;

public class Human extends Varelse {
    boolean isMan;

    // Constructor that extends the Varelse Class
    public Human(int position_X, int position_Y, int size, Boolean hasTeeths, boolean isMan) {
        super(position_X, position_Y, size, hasTeeths);
        this.isMan = isMan;
    }

    // Getters
    public boolean getIsMan() {
        return isMan;
    }

    //setters
    public void setIsMan(boolean isMan) {
        this.isMan = isMan;
    }
}
