package jwake.ruinfriendshipsgame;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseForCards extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cards.db";
    private static final String TABLE_CARDS = "cards";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_CARDNAME = "cardname";

    private SQLiteDatabase dbase;

    public DataBaseForCards(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String query = "CREATE TABLE " + TABLE_CARDS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_CARDNAME + " TEXT " +
                ");";

        dbase.execSQL(query);
        addCards();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDS);
        onCreate(db);
    }

    //Card description here
    public void addCards() {
        Cards card1 = new Cards("WAKES UP WITH HALF A BURRITO IN BED");
        this.addCards(card1);

        Cards card2 = new Cards("HAS 3-HOUR CONVERSATION ABOUT SPACE");
        this.addCards(card2);

        Cards card3 = new Cards("SPENDS ALL DAY INTERPRETING A TEXT");
        this.addCards(card3);

        Cards card4 = new Cards("HAS A DARK SIDE");
        this.addCards(card4);

        Cards card5 = new Cards("IS A LITTLE BITCH");
        this.addCards(card5);

        Cards card6 = new Cards("IS ALLERGIC TO EVERYTHING");
        this.addCards(card6);

        Cards card7 = new Cards("TOUCHES EVERYONE EXCESSIVELY FOR NO REASON");
        this.addCards(card7);

        Cards card8 = new Cards("MAKES OUT WITH SAME SEX \"BUT ISN'T BI\"");
        this.addCards(card8);

        Cards card9 = new Cards("IS GOING STRAIGHT TO HELL");
        this.addCards(card9);

        Cards card10 = new Cards("GETS CONVINCED STRANGERS ARE CELEBRITIES");
        this.addCards(card10);

        Cards card11 = new Cards("IS ACTIVELY PREPARING FOR THE END OF THE WORLD");
        this.addCards(card11);

        Cards card12 = new Cards("GETS POPCORN BUCKET FROM TRASH FOR FREE REFILLS");
        this.addCards(card12);

        Cards card13 = new Cards("SINGS BUT SHOULDN’T");
        this.addCards(card13);

        Cards card14 = new Cards("HAS SEX WHILE WATCHING TV");
        this.addCards(card14);

        Cards card15 = new Cards("WOULD SURVIVE IN WOODS WITH JUST A HATCHET");
        this.addCards(card15);

        Cards card16 = new Cards("GOES MISSING WITHIN 15 MINUTES OF GOING OUT");
        this.addCards(card16);
    }

    //add card to database
    public void addCards(Cards cards) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CARDNAME, cards.get_cardName());
        dbase.insert(TABLE_CARDS, null, values);
        //dbase.close();
    }

    //gets all cards into an array
    public ArrayList<Cards> getAllCardsArray() {
        ArrayList<Cards> cardsDescription = new ArrayList<Cards>();

        String query = "SELECT * FROM " + TABLE_CARDS; //WHERE 1?
        dbase = this.getReadableDatabase();

        //Cursor point to the location in your results
        Cursor c = dbase.rawQuery(query, null);

        //Move to first row in results
        if(c.moveToFirst()) {
            do {
                Cards questions = new Cards();
                questions.set_id(c.getInt(0));
                questions.set_cardName(c.getString(1));
                cardsDescription.add(questions);

            } while (c.moveToNext());
        }

        //dbase.close();
        return cardsDescription;
    }

}
