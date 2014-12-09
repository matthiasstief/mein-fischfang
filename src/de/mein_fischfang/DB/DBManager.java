package de.mein_fischfang.DB;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * <b>Title:</b> DBManager <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public class DBManager extends SQLiteOpenHelper
{
    private static final String TAG = DBManager.class.getSimpleName();
    private static final String DATABASE_NAME = "db_meinfischfang";
    private static final int DATABASE_VERSION = 1;

    /**
     * DBManager
     *
     * @param context Context
     */
    public DBManager(final Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    /**
     * onCreate
     *
     * @param db SQLiteDatabase
     */
    public final void onCreate(SQLiteDatabase db)
    {
        // Tabelle FISH anlegen
        String sSQL = "create table fish (name text)";
        db.execSQL(sSQL);

        // Fische hinzufügen
        sSQL = "insert into fish (name) values ('Beispiel-Fisch')";
        db.execSQL(sSQL);

        // Tabelle BAIT (Köder) anlegen
        sSQL = "create table bait (name text, type text)";
        db.execSQL(sSQL);

        // Köder hinzufügen
        sSQL = "insert into bait (name, type) values ('Tauwurm', 'Naturköder')";
        db.execSQL(sSQL);
        sSQL = "insert into bait (name, type) values ('Mistwurm', 'Naturköder')";
        db.execSQL(sSQL);
        sSQL = "insert into bait (name, type) values ('Made', 'Naturköder')";
        db.execSQL(sSQL);
        sSQL = "insert into bait (name, type) values ('Mais', 'Naturköder')";
        db.execSQL(sSQL);
        sSQL = "insert into bait (name, type) values ('Köderfisch', 'Naturköder')";
        db.execSQL(sSQL);
        sSQL = "insert into bait (name, type) values ('Boilie', 'Naturköder')";
        db.execSQL(sSQL);
        sSQL = "insert into bait (name, type) values ('Hundefutter', 'Naturköder')";
        db.execSQL(sSQL);

        // Tabelle WATERS (Gewässer) anlegen
        sSQL = "create table waters (name text, type text, latitude real, longitude real)";
        db.execSQL(sSQL);

        // Tabelle ASSEMBLING (Montage) anlegen
        sSQL = "create table assembling (name text)";
        db.execSQL(sSQL);

        // Montagen anlegen
        sSQL = "insert into assembling (name) values ('Grund (Freilaufmontage)')";
        db.execSQL(sSQL);
        sSQL = "insert into assembling (name) values ('Grund (Selbsthakmontage)')";
        db.execSQL(sSQL);
        sSQL = "insert into assembling (name) values ('Pose (Grund)')";
        db.execSQL(sSQL);
        sSQL = "insert into assembling (name) values ('Pose (Freiwasser)')";
        db.execSQL(sSQL);
        sSQL = "insert into assembling (name) values ('Pose/Wasserkugel (Oberfläche)')";
        db.execSQL(sSQL);
        sSQL = "insert into assembling (name) values ('aktive Führung (Grund)')";
        db.execSQL(sSQL);
        sSQL = "insert into assembling (name) values ('aktive Führung (Freiwasser)')";
        db.execSQL(sSQL);

        // Tabelle WEATHER (Wetter) anlegen
        sSQL = "create table weather (name text)";
        db.execSQL(sSQL);

        // Wetter anlegen
        sSQL = "insert into weather (name) values ('klar')";
        db.execSQL(sSQL);
        sSQL = "insert into weather (name) values ('Nebel')";
        db.execSQL(sSQL);
        sSQL = "insert into weather (name) values ('leicht bewölkt')";
        db.execSQL(sSQL);
        sSQL = "insert into weather (name) values ('stark bewölkt')";
        db.execSQL(sSQL);
        sSQL = "insert into weather (name) values ('bedeckt')";
        db.execSQL(sSQL);
        sSQL = "insert into weather (name) values ('leichter Regen')";
        db.execSQL(sSQL);
        sSQL = "insert into weather (name) values ('starker Regen')";
        db.execSQL(sSQL);
        sSQL = "insert into weather (name) values ('Gewitter')";
        db.execSQL(sSQL);

        // Tabelle CATCH (Fang) anlegen
        sSQL = "create table catch (time integer, size integer, weight integer, photo text, latitude real, longitude real, "
                + "hint text, air_temperature real, water_temperature real, pressure real, feed integer, release integer, "
                + "fish integer, bait integer, waters integer, assembling integer, weather integer)";
        db.execSQL(sSQL);
    }

    @Override
    /**
     * onUpgrade
     *
     * @param db SQLiteDatabase
     * @param oldVersion int
     * @param newVersion int
     */
    public final void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Muss aktuell noch nichts gemacht werden
        // Ist für Updates später wichtig
    }

    /**
     * sqlSelect
     *
     * @param sSQL String
     * @param alParam ArrayList<String>
     * @return Cursor
     */
    public final Cursor sqlSelect(String sSQL, ArrayList<String> alParam)
    {
        try
        {
            String[] sArgs = null;
            if (alParam != null && alParam.size() > 0)
            {
                sArgs = new String[alParam.size()];
                for (int i = 0; i < alParam.size(); i++)
                {
                    sArgs[i] = alParam.get(i);
                }
            }

            SQLiteDatabase db = getWritableDatabase();
            Cursor cursor = db.rawQuery(sSQL, sArgs);

            return cursor;
        }
        catch (Exception e)
        {
            Log.e(TAG, e.getMessage(), e);
            return null;
        }
    }

    /**
     * sqlModify
     *
     * @param sSQL String
     * @param alParam ArrayList<String>
     * @return boolean
     */
    public final boolean sqlModify(String sSQL, ArrayList<String> alParam)
    {
        try
        {
            String[] sArgs = null;
            if (alParam != null && alParam.size() > 0)
            {
                sArgs = new String[alParam.size()];
                for (int i = 0; i < alParam.size(); i++)
                {
                    sArgs[i] = alParam.get(i);
                }
            }

            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sSQL, sArgs);

            return true;
        }
        catch (Exception e)
        {
            Log.e(TAG, e.getMessage(), e);
            return false;
        }
    }
}
