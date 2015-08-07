package jwake.ruinfriendshipsgame;

public class Cards {

    //control + enter = getters and setters

    private int _id;
    private String _cardName;

    public Cards() {
    }

    public Cards(String cardName) {
        _cardName = cardName;
    }

    public Cards(int id, String cardName) {
        _id = id;
        _cardName = cardName;
    }

    //Setters
    public void set_cardName(String cardName) {
        _cardName = cardName;
    }

    public void set_id(int id) {
        _id = id;
    }

    //Getters
    public String get_cardName() {
        return _cardName;
    }

    public int get_id() {
        return _id;
    }
}
