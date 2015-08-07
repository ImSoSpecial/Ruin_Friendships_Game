package jwake.ruinfriendshipsgame;

/**
 * Created by adrianvazquez on 8/6/15.
 */
public class Friends {
    private String _name;
    private int _points;

    public Friends() {
    }

    public Friends(String name, int points) {
        this._name = name;
        this._points = points;
    }

    //Setters
    public void setName(String name) {
        this._name = name;
    }

    public void setPoints(int points) {
        this._points = points;
    }

    //Getters
    public String getName() {
        return _name;
    }

    public int getPoints() {
        return _points;
    }
}
