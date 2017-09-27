package khaliliyoussef.inventoryapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry.COLUMN_ITEM_DESC;
import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry.COLUMN_ITEM_IMG;
import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry.COLUMN_ITEM_NAME;
import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry.COLUMN_ITEM_PRICE;
import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry.COLUMN_ITEM_SALES;
import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry.COLUMN_ITEM_STOCK;
import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry.TABLE_NAME;
import static khaliliyoussef.inventoryapp.Data.InventoryContract.InventoryEntry._ID;

/**
 * Created by khalil on 26/9/2017.
 */

public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = InventoryDbHelper.class.getSimpleName();

    //Database name
    public static final String DATABASE_NAME = "inventory.db";

    //Database version
    public static final int DATABASE_VERSION = 1;

    //Constructor
    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_INVENTORY_TABLE =
                "CREATE TABLE " + TABLE_NAME + " ("
                        + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_ITEM_NAME + " TEXT NOT NULL, "
                        + COLUMN_ITEM_DESC + " TEXT NOT NULL, "
                        + COLUMN_ITEM_SALES + " INTEGER, "
                        + COLUMN_ITEM_STOCK + " INTEGER NOT NULL DEFAULT 0, "
                        + COLUMN_ITEM_PRICE + " FLOAT NOT NULL DEFAULT 0, "
                        + COLUMN_ITEM_IMG + " TEXT);";
        db.execSQL(SQL_CREATE_INVENTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("ALTER TABLE IF EXIST" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
