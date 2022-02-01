package de.dbl.migratecordovalocalstorage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class migratelocalstorage {
    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public Map<String, String> getLocalStorageItems(Context context) {
        Map<String, String> map = new HashMap<>();

        String dataDir = context.getApplicationInfo().dataDir;
        File localstorage = new File(dataDir + "/app_webview/Default/Local Storage/leveldb/000003.log");

        Log.i('LocalStorage:' + LocalStorage)
        Log.i('dataDir:' + dataDir)

        if (!localstorage.exists()) {
            return map;
        }

        Cursor cursor = null;
        SQLiteDatabase db = null;
        try {
            File dbfile = context.getDatabasePath(localstorage.getPath());
            dbfile.setWritable(true);
            db = SQLiteDatabase.openDatabase(dbfile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);

            String sql = "SELECT key,value FROM ItemTable";
            cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String key = cursor.getString(0);
                byte[] itemByteArray = cursor.getBlob(1);
                String value = new String(itemByteArray, Charset.forName("UTF-16LE"));

                map.put(key, value);
                cursor.moveToNext();
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
    }
}
