package edu.qc.seclass.glm.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.MainActivity;


public class ListItem extends SQLiteOpenHelper {

    public ListItem(Context context) {
        super(context, Database.DATABASE_NAME, null, Database.DATABASE_VERSION);
        onCreate(this.getWritableDatabase());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Database.ListItem.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Database.ListItem.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public List<edu.qc.seclass.glm.model.ListItem> getListItems(long groceryID) {
        return getListItems(groceryID, null);
    }

    public List<edu.qc.seclass.glm.model.ListItem> getListItems(long groceryID, String itemName) {
        List<edu.qc.seclass.glm.model.ListItem> List = new ArrayList<edu.qc.seclass.glm.model.ListItem>();
        String query = "SELECT li.* FROM " + Database.ListItem.TABLE_NAME + " li "
                + " JOIN " + Database.Item.TABLE_NAME + " i "
                + " ON li." + Database.ListItem.COLUMN_ITEM_ID + " = i." + Database.Item._ID
                + " JOIN " + Database.ItemType.TABLE_NAME + " it "
                + " ON i." + Database.Item.COLUMN_ITEM_TYPE_ID + " = it." + Database.ItemType._ID
                + " WHERE li." + Database.ListItem.COLUMN_GROCERY_LIST_ID + " = " + groceryID;

        if (itemName != null && !itemName.isEmpty()) {
            itemName = itemName.trim();
            query += " AND i." + Database.Item.COLUMN_NAME + " like '%" + itemName + "%'";
        }

        query += " ORDER BY it." + Database.ItemType.COLUMN_NAME + ", i." + Database.Item.COLUMN_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while(cursor.moveToNext()){
                edu.qc.seclass.glm.model.ListItem listItem = mapListItem(cursor);
                List.add(listItem);
            }
        }

        return List;
    }

    public edu.qc.seclass.glm.model.ListItem addListItem(edu.qc.seclass.glm.model.ListItem listItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        edu.qc.seclass.glm.model.ListItem newListItem = getListItem(listItem.getGroceryListId(), listItem.getItemId());

        if (newListItem == null) {
            ContentValues values = new ContentValues();

            values.put(Database.ListItem.COLUMN_GROCERY_LIST_ID, listItem.getGroceryListId());
            values.put(Database.ListItem.COLUMN_ITEM_ID, listItem.getItemId());
            values.put(Database.ListItem.COLUMN_QUANTITY, listItem.getQuantity());
            values.put(Database.ListItem.COLUMN_CHECKED, listItem.isChecked());

            db.insert(Database.ListItem.TABLE_NAME, null, values);

            newListItem = getListItem(listItem.getGroceryListId(), listItem.getItemId());
        }

        db.close();

        return newListItem;
    }

    private edu.qc.seclass.glm.model.ListItem getListItem(long groceryListId, long itemId) {
        edu.qc.seclass.glm.model.ListItem listitem = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + Database.ListItem.TABLE_NAME
                + " WHERE " + Database.ListItem.COLUMN_GROCERY_LIST_ID + " = " + groceryListId
                + " AND " + Database.ListItem.COLUMN_ITEM_ID + " = " + itemId;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            listitem = mapListItem(cursor);
        }

        return listitem;
    }

    public void updateListItem(edu.qc.seclass.glm.model.ListItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + Database.ListItem.TABLE_NAME
                + " SET " + Database.ListItem.COLUMN_QUANTITY + " = " + item.getQuantity()
                + " , " + Database.ListItem.COLUMN_CHECKED + " = " + (item.isChecked() ? 1 : 0)
                + " WHERE " + Database.ListItem._ID + " = " + item.getId();

        db.execSQL(query);

        db.close();
    }

    public edu.qc.seclass.glm.model.ListItem getListItem(long id) {
        edu.qc.seclass.glm.model.ListItem listitem = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + Database.ListItem.TABLE_NAME
                + " WHERE " + Database.ListItem._ID + " = " + id;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            listitem = mapListItem(cursor);
        }

        return listitem;
    }

    public void uncheckAll(long groceryListId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + Database.ListItem.TABLE_NAME
                + " SET " + Database.ListItem.COLUMN_CHECKED + " = " + 0
                + " WHERE " + Database.ListItem.COLUMN_GROCERY_LIST_ID + " = " + groceryListId;

        db.execSQL(query);

        db.close();
    }

    @NonNull
    private edu.qc.seclass.glm.model.ListItem mapListItem(Cursor cursor) {
        edu.qc.seclass.glm.model.ListItem listitem = new edu.qc.seclass.glm.model.ListItem();

        listitem.setId(Integer.parseInt(cursor.getString(0)));
        listitem.setQuantity(Integer.parseInt(cursor.getString(1)));
        listitem.setChecked(cursor.getInt(2) == 1);
        listitem.setItemId(cursor.getLong(3));
        listitem.setItem(MainActivity.item.getItem(cursor.getLong(3)));
        listitem.setGroceryListId(Integer.parseInt(cursor.getString(4)));

        return listitem;
    }

    public void deleteListItem(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + Database.ListItem.TABLE_NAME
                + " WHERE " + Database.ListItem._ID + " = " + id;

        db.execSQL(query);

        db.close();
    }
}
