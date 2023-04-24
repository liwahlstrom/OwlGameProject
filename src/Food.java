import Character.Owl;

// varje mat är food en basklass, man kan inte skapa något från food det är bara en abstrakt interface
// ger olika hp attributer, position, x o y,
// göra en abstakt klass av food det ska inte gå att göra en klass av food
//kunna inherita subklasser från food som är en basklass och då så kan subklassen overrida metoder
//virtuella memberfunctions from the base it can also define its own member data and member functions.
// speciella attributer egna grejer som inte andra har
//overrida debug string så att alla får en unik debug string
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
