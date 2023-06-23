package edu.qc.seclass.glm.Database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GroceryList extends SQLiteOpenHelper {

    public GroceryList(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
        onCreate(this.getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Database.GroceryList.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Database.GroceryList.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addList(edu.qc.seclass.glm.model.GroceryList groceryList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Database.GroceryList.COLUMN_NAME, groceryList.getName());
        db.insert(Database.GroceryList.TABLE_NAME, null, values);

        db.close();
    }

    public java.util.List<edu.qc.seclass.glm.model.GroceryList> getAllLists(String name) {
        java.util.List<edu.qc.seclass.glm.model.GroceryList> groceryList = null;
        String query = "SELECT * FROM " + Database.GroceryList.TABLE_NAME + " gl";

        if(name!=null) {
            query += " WHERE gl." + Database.GroceryList.COLUMN_NAME + " like ?";
        }

        groceryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] args = {"%" + name + "%"};
        Cursor cursor = db.rawQuery(query, args);

        if (cursor.moveToFirst()) {
            do {
                edu.qc.seclass.glm.model.GroceryList tempList = new edu.qc.seclass.glm.model.GroceryList();

                tempList.setId(Integer.parseInt(cursor.getString(0)));
                tempList.setName(cursor.getString(1));

                groceryList.add(tempList);
            } while (cursor.moveToNext());
        }
        return groceryList;
    }

    public void update(long id, String itemName) {
        itemName = itemName != null ? itemName.replaceAll("'", "''") : itemName;
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "UPDATE " + Database.GroceryList.TABLE_NAME
                + " SET " + Database.GroceryList.COLUMN_NAME + " = '" + itemName + "'"
                + " WHERE " + Database.GroceryList._ID + " = " + id;
        db.execSQL(sql);

        db.close();
    }

    public void deleteList(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " + Database.ListItem.TABLE_NAME
                + " WHERE " + Database.ListItem.COLUMN_GROCERY_LIST_ID + " = " + id;
        db.execSQL(query);

        query = "DELETE FROM " + Database.GroceryList.TABLE_NAME
                + " WHERE " + Database.GroceryList._ID + " = " + id;
        db.execSQL(query);

        db.close();
    }

    public edu.qc.seclass.glm.model.GroceryList getGroceryList(long id) {
        edu.qc.seclass.glm.model.GroceryList result = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "Select * from " + Database.GroceryList.TABLE_NAME
                + " WHERE " + Database.GroceryList._ID + " = " + id;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            result = new edu.qc.seclass.glm.model.GroceryList();

            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));
        }

        return result;
    }
}
