package com.example.e_survey.config;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static final String SP_USERNAME = "spUsername";
    public static final String SP_LOGIN_APP = "spLoginApp";
    public static final String SP_TOKEN = "spToken";
    public static final String SP_ID_USER = "spIduser";
    public static final String SP_LEVEL = "spLevel";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    public static final String SP_MOBILE = "spMobile";
    public static final String SP_AVATAR = "spAvatar";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;


    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_LOGIN_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPToken(){
        return sp.getString(SP_TOKEN, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public String getSpIdUser(){
        return  sp.getString(SP_ID_USER, "");
    }

    public  String getSpUsername(){
        return  sp.getString(SP_USERNAME, "");
    }

    public String getSpLevel(){
        return sp.getString(SP_LEVEL, "");
    }

    public String getSpAvatar(){
        return sp.getString(SP_AVATAR, "");
    }

    public String getSpMobile(){
        return sp.getString(SP_MOBILE, "");
    }

}
