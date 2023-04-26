package Character;

public class Animal extends Varelse {

    private Boolean isHostile;

    //constructor
    public Animal(int position_X, int position_Y, int size, Boolean hasTeeths, Boolean isHostile) {
        super(position_X, position_Y, size, hasTeeths);
        this.isHostile = isHostile;
    }

    //getters
    public Boolean getIsHostile() {
        return isHostile;
    }

    //setters
    public void setIsHostile(Boolean isHostile) {
        this.isHostile = isHostile;
    }

}
