package edu.qc.seclass.glm.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.MainActivity;
import edu.qc.seclass.glm.model.ItemType;

public class Item extends SQLiteOpenHelper {
    public static final String[][] ITEMS_DEFAULT = {

    };

    public Item(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
        onCreate(this.getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Database.Item.CREATE_TABLE);

        for (String[] type : ITEMS_DEFAULT) {
            edu.qc.seclass.glm.model.Item item = new edu.qc.seclass.glm.model.Item();

            item.setName(type[0]);
            ItemType itemType = MainActivity.itemType.getType(type[1]);
            item.setItemTypeId(itemType.getId());

            add(item);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Database.Item.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // Adding new items
    public edu.qc.seclass.glm.model.Item add(edu.qc.seclass.glm.model.Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        edu.qc.seclass.glm.model.Item newItem = getItem(item.getName());

        if (newItem == null) {
            ContentValues values = new ContentValues();

            values.put(Database.Item.COLUMN_NAME, item.getName());
            values.put(Database.Item.COLUMN_ITEM_TYPE_ID, item.getItemTypeId());

            db.insert(Database.Item.TABLE_NAME, null, values);
        }

        db.close();

        return getItem(item.getName());
    }

    public List<edu.qc.seclass.glm.model.Item> getAllItems(String name) {
        List<edu.qc.seclass.glm.model.Item> itemList;

        String selectQuery = "SELECT * FROM " + Database.Item.TABLE_NAME + " i"
                + " JOIN " + Database.ItemType.TABLE_NAME + " it "
                + " ON i." + Database.Item.COLUMN_ITEM_TYPE_ID + " = it." + Database.ItemType._ID;

        if(name!=null) {
            selectQuery += " WHERE i." + Database.Item.COLUMN_NAME + " like ?";
        }

        selectQuery += " ORDER BY it." + Database.ItemType.COLUMN_NAME + ", i." + Database.Item.COLUMN_NAME;

        itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] selectionArgs = {"%" + name + "%"};
        Cursor cursor = db.rawQuery(selectQuery, selectionArgs);

        if (cursor.moveToFirst()) {
            while(cursor.moveToNext()){
                edu.qc.seclass.glm.model.Item item = new edu.qc.seclass.glm.model.Item();

                item.setId(Integer.parseInt(cursor.getString(0)));
                item.setName(cursor.getString(1));

                long itemTypeId = cursor.getLong(3);

                item.setItemTypeId(itemTypeId);
                item.setItemType(MainActivity.itemType.getType(itemTypeId));

                itemList.add(item);
            }
        }

        return itemList;
    }

    public edu.qc.seclass.glm.model.Item getItem(String name) {
        edu.qc.seclass.glm.model.Item result = null;

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from " + Database.Item.TABLE_NAME
                + " WHERE " + Database.Item.COLUMN_NAME + " = ?";

        String[] selectionArgs = {name};
        Cursor cursor = db.rawQuery(sql, selectionArgs);

        if (cursor.moveToFirst()) {
            result = new edu.qc.seclass.glm.model.Item();

            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));

            long itemTypeId = cursor.getLong(3);

            result.setItemTypeId(itemTypeId);
            result.setItemType(MainActivity.itemType.getType(itemTypeId));
        }

        return result;
    }

    public edu.qc.seclass.glm.model.Item getItem(long id) {
        edu.qc.seclass.glm.model.Item result = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "Select * from " + Database.Item.TABLE_NAME
                + " WHERE " + Database.Item._ID + " = " + id;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            result = new edu.qc.seclass.glm.model.Item();

            result.setId(cursor.getLong(0));
            result.setName(cursor.getString(1));

            long itemTypeId = cursor.getLong(3);

            result.setItemTypeId(itemTypeId);
            result.setItemType(MainActivity.itemType.getType(itemTypeId));
        }

        return result;
    }
}
