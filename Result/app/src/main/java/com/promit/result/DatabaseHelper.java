package com.promit.result;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="item.db";
    private static final String TABLE_NAME="items";
    private static final String COL="col";
    private static final String ID="name";
    private static final String PRICE="price";
    private static final String QUANTITY="quantity";
    private static final String QUANTIT="quantit";
    private static final String QUANTI="quanti";
    private static final int version=1;
    private Context context;
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+COL+" INTEGER PRIMARY  KEY AUTOINCREMENT,"+ID+" TEXT  ,"+PRICE+" INTEGER,"+QUANTITY+" INTEGER,"+QUANTIT+" INTEGER,"+QUANTI+" INTEGER );";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);

        }
        catch(Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Exception :" + e, Toast.LENGTH_SHORT).show();
        }
    }
    public long saveData(String id,String price,String quantity,String ids,String idss)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(PRICE,price);
        contentValues.put(QUANTITY,quantity);
        contentValues.put(QUANTIT,ids);
        contentValues.put(QUANTI,idss);
        long rownumber= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rownumber;
    }
    public Cursor showAllData()
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }
}