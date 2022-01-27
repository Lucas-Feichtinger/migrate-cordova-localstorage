package de.dbl.migratecordovalocalstorage;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import org.json.JSONException;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@CapacitorPlugin(name = "migratelocalstorage")
public class migratelocalstoragePlugin extends Plugin {

    private migratelocalstorage implementation = new migratelocalstorage();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod()
    public void getLocalStorageItems(PluginCall call) throws JSONException {
       Context appctx = getContext().getApplicationContext();
       JSObject ret = new JSObject();
       ret.put("localStorage", implementation.getLocalStorageItems(appctx));
       call.resolve(ret);
    }
}
