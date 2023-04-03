import Character.Owl;
public class Food {
    int position_x;
    int position_y;
    int value;

    public Food(int position_x, int position_y, int value){

    }


    void Interact_with_food(Owl owl){

    }

    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public int getValue() {
        return value;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
