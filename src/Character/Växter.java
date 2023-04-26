package Character;

public class Växter extends Levande {

   protected int numberOfLeaves;

   //constructor
    public Växter(int position_X, int position_Y, int size, int numberOfLeaves) {
        super(position_X, position_Y, size);
        this.numberOfLeaves = numberOfLeaves;
    }

    //getters
    public int getNumberOfLeaves() {
        return numberOfLeaves;
    }

    //setters
    public void setNumberOfLeaves(int numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
    }



}