package com.sindicator;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shivani on 12/10/2016.
 */

public class Prefmanager {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE=0;

    private static final String PREF_NAME="Welcome app user";
    private static final String IS_FIRST_TIME_LAUNCH="Is First Time Launch?";


    public Prefmanager(Context context)
    {
        this._context=context;
        sp=_context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sp.edit();
    }

    public void setIsFirstTimeLaunch(boolean firstTimeLaunch)
    {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH,firstTimeLaunch);
        editor.commit();
    }

    public boolean isFirstTimeLAUNCH(){
        return sp.getBoolean(IS_FIRST_TIME_LAUNCH,true);

    }
}
