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
        String sSQL = "";

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
