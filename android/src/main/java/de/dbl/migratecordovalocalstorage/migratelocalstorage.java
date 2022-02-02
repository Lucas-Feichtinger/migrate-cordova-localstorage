package de.dbl.migratecordovalocalstorage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MigrateLocalStorage {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public String getVertragswerk(Context context) {
        //String dataDir = context.getApplicationInfo().dataDir;
        //Log.i("dir: ", dataDir + "/app_webview/Local Storage/leveldb");
        String localStoragePath = "/data/data/de.dbl.reparaturapp/app_webview/Default/Local Storage/leveldb";
        File storedFileLoc = new File(localStoragePath);
        String vwk = null;
        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        // try to read vertragswerk from LevelDB
        //
        // to be done...
        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        // try to read vertragswerk from *.ldb as Textfile
        //
        //vwk = readVertragswerkFromTextfile(storedFileLoc,"ldb", localStoragePath);
        //if(vwk != null) return vwk;
        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        // try to read vertragswerk from *.log as Textfile
        //
        vwk = readVertragswerkFromTextfile(storedFileLoc,"log", localStoragePath);
        if(vwk != null) return vwk;
        // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        return null;
    }

    public String readVertragswerkFromTextfile(File folder,String extension, String path) {
        String vwk = null;
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.isFile()) {
                File file = fileEntry.getAbsoluteFile();

                String filePath = String.valueOf(fileEntry.getAbsoluteFile());
                String regex = "^(.*\\.((log)$))?[.]*$";

                if (filePath.matches(regex)){
                    Log.i("line", "matching") ;
                    StringBuilder text = new StringBuilder();

                    try {
                        FileReader reader = new FileReader(file);
                        BufferedReader br = new BufferedReader(reader);
                        String line;

                        while ((line = br.readLine()) != null) {
                            text.append(line);
                            Log.i("line", line) ;
                            text.append('\n');
                        }

                        br.close();
                    }
                    catch (IOException e) {
                        //You'll need to add proper error handling here
                    }
                    String fileText = text.toString();
                    String[] splitFile = fileText.split("vertragswerk");
                    for (String splitPart : splitFile){
                        String vwkSection = splitPart.split(",")[0];
                        String trimmedStr = vwkSection.replaceAll("[^a-zA-Z0-9]", "");
                        if(trimmedStr != "install"){
                            vwk = trimmedStr;
                        }
                    }
                }
            }
        }
        System.out.println(vwk);
        return vwk;
    }
}
