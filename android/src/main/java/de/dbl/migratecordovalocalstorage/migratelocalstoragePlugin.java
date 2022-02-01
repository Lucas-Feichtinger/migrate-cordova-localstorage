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

@CapacitorPlugin(name = "MigrateLocalStorage")
public class MigrateLocalStoragePlugin extends Plugin {

    private MigrateLocalStorage implementation = new MigrateLocalStorage();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod()
    public void getVertragswerk(PluginCall call) throws JSONException {
       Context appctx = getContext().getApplicationContext();
       JSObject ret = new JSObject();
       ret.put("vwk", implementation.getVertragswerk(appctx));
       call.resolve(ret);
    }
}
