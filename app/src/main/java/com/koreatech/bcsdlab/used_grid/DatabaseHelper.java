package com.koreatech.bcsdlab.used_grid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRABHU on 11/12/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="used";
    private static final int DATABASE_VERSION = 1;
    private static final String USED_TABLE = "items";
    private static final String ITEM_TABLE = "CREATE TABLE IF NOT EXISTS "+USED_TABLE +"(_id integer primary key AUTOINCREMENT NOT NULL,thumbnail INTEGER,name TEXT,price INTEGER,content TEXT)";

    Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public void insertSomeUsed() {
        int[] used = new int[]{
                R.drawable.used1,
                R.drawable.used2};
        insertIntoDB(used[0], "남성용 로퍼 265mm", 25000, "사이즈 잘못 사서 팝니다. 거의 새거입니다.");
        insertIntoDB(used[1], "Apple IPod touch 6", 200000, "새 제품입니다.");
        insertIntoDB(used[0], "남성용 로퍼 265mm", 25000, "사이즈 잘못 사서 팝니다. 거의 새거입니다.");
        insertIntoDB(used[1], "Apple IPod touch 6", 200000, "새 제품입니다.");
        insertIntoDB(used[0], "남성용 로퍼 265mm", 25000, "사이즈 잘못 사서 팝니다. 거의 새거입니다.");
        insertIntoDB(used[1], "Apple IPod touch 6", 200000, "새 제품입니다.");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ITEM_TABLE);
        insertSomeUsed();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + USED_TABLE);

        // Create tables again
        onCreate(db);
    }
    /* Insert into database*/
    public void insertIntoDB(int thumbnail, String name, int price, String content){
        Log.d("insert", "before insert");

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();

        values.put("thumbnail", thumbnail);
        values.put("name", name);
        values.put("price", price);
        values.put("content", content);

        // 3. insert
        db.insert(USED_TABLE, null, values);
        // 4. close
        db.close();
        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
        Log.i("insert into DB", "After insert");
    }
    /* Retrive  data from database */
    public ArrayList<UsedItem> getDataFromDB(){


        String query = "select * from "+USED_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UsedItem> modelList = new ArrayList<UsedItem>();
        Cursor cursor = db.rawQuery(query,null);

        while(cursor.moveToNext()){
            modelList.add( new UsedItem(cursor.getInt(cursor.getColumnIndex("thumbnail")), cursor.getString(cursor.getColumnIndex("name")),cursor.getInt(cursor.getColumnIndex("price")),cursor.getString(cursor.getColumnIndex("content"))));

        }

        Log.d("used data", modelList.toString());

        return modelList;
    }


    public boolean updateUsed(int id, int thumbnail, String name, int price, String content) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("thumbnail", thumbnail);
        values.put("name", name);
        values.put("price", price);
        values.put("content", content);

        db.update(USED_TABLE, values, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public int deleteUsed(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(USED_TABLE,
                "id = ? ",
                new String[]{Integer.toString(id)});
    }




}