package com.example.dataobat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String databaseName = "DB_OBAT";
    public final static String tableName = "obat";

    public final static String fieldKode = "kode";
    public final static String fieldNama = "nama";

    public final static String fieldJumlah = "jumlah";
    public final static String fieldSatuan = "satuan";
    public final static String fieldHarga = "harga";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableName + "(kode PRIMARY KEY NOT NULL, nama TEXT, jumlah INT, satuan TEXT, harga INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    public void saveData(String kode, String nama, Integer jumlah, String satuan, Integer harga) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(fieldKode, kode);
        contentValues.put(fieldNama, nama);
        contentValues.put(fieldJumlah, jumlah);
        contentValues.put(fieldSatuan, satuan);
        contentValues.put(fieldHarga, harga);

        db.insert(tableName, null, contentValues);
    }

    public Cursor ReadData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor response = db.rawQuery("SELECT * FROM " + tableName, null);
        return response;
    }
}
