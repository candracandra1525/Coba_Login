package com.candra.cobalogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class KendaliLogin
{
    private SharedPreferences sp;
    private SharedPreferences.Editor spe;

    public void setPref(Context context, String key, String value)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        spe = sp.edit();
        spe.putString(key, value);
        spe.commit();
    }

    public String getPref(Context context, String key)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        String tampung = sp.getString(key, null);
        return tampung;
    }

    public Boolean isLogin (Context context, String key)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        String tampung = sp.getString(key, null);
        if(tampung != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
