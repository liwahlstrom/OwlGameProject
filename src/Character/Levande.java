package Character;

public class Levande {

    //Set up a basic class for all living things

    protected int position_Y; //protected så att subklasser kan ärva
    protected int position_X; //protected så att subklasser kan ärva
    protected int size; //protected så att subklasser kan ärva

    //public constructor
public Levande(int position_X, int position_Y, int size) { // public constructor
        this.position_X = position_X; //this. refererar till objektet som skapas
        this.position_Y = position_Y;
        this.size = size;
    }
}








