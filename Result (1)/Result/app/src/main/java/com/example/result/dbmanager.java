package com.example.result;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper {
    private static final String dbname = "dbcontact";

    public dbmanager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    private static final String SEM = "Sem";
    private static final String SUBJECT = "Sub";
    private static final String TOTAL_MARKS = "total";
    private static final String MIN_MARKS = "Min";
    private static final String NAME = "Name";
    private static final String ROLL_NO = "Roll_no";
    private static final String MARKS = "Marks";
    private static final String tbl_contact = "Student";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "create table tbl_contact(ID integer primary key autoincrement not null,SEM varchar,SUBJECT varchar,SESSIONAL varchar,TOTAL_MARKS INT,MIN_MARKS INT,NAME char,ROLL_NO INT,MARKS INT)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry = "DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public String addrecord(String se, String su,String s, String to, String mi, String n, String c, String e) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("SEM", se);
        cv.put("SUBJECT", su);
        cv.put("SESSIONAL", s);
        cv.put("TOTAL_MARKS", to);
        cv.put("MIN_MARKS", mi);
        cv.put("NAME", n);
        cv.put("ROLL_NO", c);
        cv.put("MARKS", e);

        float res = db.insert("tbl_contact", null, cv);

        if (res == -1)
            return "Failed";
        else
            return "Successfully inserted";

    }

    public Cursor readalldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tbl_contact order by id desc";
        Cursor cursor = db.rawQuery(qry, null);
        return cursor;
    }

    public Cursor readalldata1() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT SEM,SUBJECT,SESSIONAL,ROLL_NO,TOTAL_MARKS,MIN_MARKS,NAME,MARKS  FROM MyTable3 WHERE SEM="+SEM+" AND SUBJECT= "+SUBJECT+"",
                new String[]{SEM});
        /*if (cursor.moveToFirst()) {
            do {
                model contact = new model();
                contact.setContact(cursor.getString(6));
                contact.setName(cursor.getString(5));
                contact.setSem(cursor.getString(1));
                contact.setSub(cursor.getString(2));
                contact.setEmail(cursor.getString(7));
                contact.setTotal(cursor.getString(3));
                contact.setMin(cursor.getString(4));
                // contacts.add(contact);
            } while (cursor.moveToNext());
*/
        return cursor1;
    }
}


  /*  public Cursor readalldata1() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT SEM,SUBJECT,ROLL_NO,TOTAL_MARKS,MIN_MARKS,NAME,MARKS  FROM MyTable3 WHERE SEM=? AND SUBJECT=?";
        Cursor cursor1 = db.rawQuery(qry, null);
        return cursor1;
    }
}
   /* public boolean checkUser(String Sem, String Subject) {
        // array of columns to fetch
        String[] columns = {
                SEM
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = SEM + " = ?" + " AND " + SUBJECT + " = ?";
        // selection arguments
        String[] selectionArgs = {Sem, Subject};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        /*Cursor cursor1 = db.query(tbl_contact, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor1.getCount();
        cursor1.close();
        db.close();
        //if (cursorCount > 0) {
            return true;
        }
        return false;*/


