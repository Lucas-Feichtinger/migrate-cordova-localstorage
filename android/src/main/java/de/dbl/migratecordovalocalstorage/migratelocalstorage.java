package de.dbl.migratecordovalocalstorage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MigrateLocalStorage {


    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public String getVertragswerk(Context context) {
        //String dataDir = context.getApplicationInfo().dataDir;
        //Log.i("dir: ", dataDir + "/app_webview/Local Storage/leveldb");
        String localStoragePath = "/data/data/de.dbl.reparaturapp/app_webview/Default/Local Storage/leveldb";

        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        // try to read vertragswerk from LevelDB
        //
        // to be done...
        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        // try to read vertragswerk from *.ldb as Textfile
        //

        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        // try to read vertragswerk from *.log as Textfile
        //
        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        File storedFileLoc = new File(localStoragePath);

        readVertragswerkFromTextfile(storedFileLoc);

        return "test";
    }

    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

    public String readVertragswerkFromTextfile(File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                readVertragswerkFromTextfile(fileEntry);
            } else {
                Path fileName = Path.of(fileEntry.getName());

                String content = Files.readString(fileEntry.getName());
                System.out.println(actual);
            }
        }
    }

    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --


}
