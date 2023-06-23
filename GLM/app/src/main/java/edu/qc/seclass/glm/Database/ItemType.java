package edu.qc.seclass.glm.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemType extends SQLiteOpenHelper {
    public static final String[] ITEM_TYPES_DEFAULT = {


    };
    private String description;

    public ItemType(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
        onCreate(this.getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Database.ItemType.CREATE_TABLE);
        for (String type : ITEM_TYPES_DEFAULT) {
            edu.qc.seclass.glm.model.ItemType itemType = new edu.qc.seclass.glm.model.ItemType(description);
            itemType.setName(type);
            addType(itemType);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Database.ItemType.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addType(edu.qc.seclass.glm.model.ItemType itemType) {
        SQLiteDatabase db = this.getWritableDatabase();

        if (getType(itemType.getName()) == null) {
            ContentValues values = new ContentValues();

            values.put(Database.ItemType.COLUMN_NAME, itemType.getName());
            db.insert(Database.ItemType.TABLE_NAME, null, values);
        }

        db.close();
    }

    public List<edu.qc.seclass.glm.model.ItemType> getTypes() {
        return getTypes("");
    }

    public List<edu.qc.seclass.glm.model.ItemType> getTypes(String name) {
        List<edu.qc.seclass.glm.model.ItemType> itemTypeList = null;
        String query = "SELECT * FROM " + Database.ItemType.TABLE_NAME + " gl";

        if(name!=null) {
            query += " WHERE gl." + Database.ItemType.COLUMN_NAME + " like ?";
        }

        itemTypeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] args = {"%" + name + "%"};
        Cursor cursor = db.rawQuery(query, args);

        if (cursor.moveToFirst()) {
            while(cursor.moveToNext()){
                edu.qc.seclass.glm.model.ItemType itemType = new edu.qc.seclass.glm.model.ItemType(description);

                itemType.setId(Integer.parseInt(cursor.getString(0)));
                itemType.setName(cursor.getString(1));
                itemTypeList.add(itemType);
            }
        }

        return itemTypeList;
    }

    public edu.qc.seclass.glm.model.ItemType getType(String name) {
        edu.qc.seclass.glm.model.ItemType result = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "Select * from " + Database.ItemType.TABLE_NAME
                + " WHERE " + Database.ItemType.COLUMN_NAME + " = ?";

        String[] args = {name};
        Cursor cursor = db.rawQuery(query, args);

        if (cursor.moveToFirst()) {
            result = new edu.qc.seclass.glm.model.ItemType(description);

            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));
        }

        return result;
    }

    public edu.qc.seclass.glm.model.ItemType getType(long id) {
        edu.qc.seclass.glm.model.ItemType result = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "Select * from " + Database.ItemType.TABLE_NAME
                + " WHERE " + Database.ItemType._ID + " = ?";

        String[] args = {"" + id};
        Cursor cursor = db.rawQuery(sql, args);

        if (cursor.moveToFirst()) {
            result = new edu.qc.seclass.glm.model.ItemType(description);

            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));
        }

        return result;
    }

}
