package Character;

public class Varelse extends Levande {

    //Set up a basic class for all living things
    protected Boolean _hasTeeths;

    //public constructor that calls Levande constructor and initializes _hasTeeths
    public Varelse(int position_X, int position_Y, int size, Boolean hasTeeths) {
        super(position_X, position_Y, size);
        _hasTeeths = hasTeeths;
    }

    //getters
    public Boolean getHasTeeths() {
        return _hasTeeths;
    }

    //setters
    public void setHasTeeths(Boolean hasTeeths) {
        _hasTeeths = hasTeeths;
    }

}

