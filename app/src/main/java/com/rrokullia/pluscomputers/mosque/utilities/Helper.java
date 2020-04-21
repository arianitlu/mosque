package com.rrokullia.pluscomputers.mosque.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rrokullia.pluscomputers.mosque.model.takvimi.Welcome;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Helper {

    public static Welcome getNamazFromJson(Context context) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = null;
        try {
            InputStream is = context.getAssets().open("namazi1.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Welcome welcome = gson.fromJson(json, Welcome.class);

        return welcome;

    }


    public static void cleanWhiteSpace(TextView textView) {
        if (!textView.getText().toString().isEmpty()) {
            String strArray = textView.getText().toString().replaceAll("\\s+", "");
            ;
            textView.setText(strArray);
        }
    }

    public String ditaDEtoSQConverter(String dita) {
        String ditaRe;

        switch (dita) {
            case "Mi":
                ditaRe = "E mërkurë";
                break;
            case "Do":
                ditaRe = "E enjte";
                break;
            case "Fr":
                ditaRe = "E premte";
                break;
            case "Sa":
                ditaRe = "E shtunë";
                break;
            case "So":
                ditaRe = "E dielë";
                break;
            case "Mo":
                ditaRe = "E hënë";
                break;
            case "Di":
                ditaRe = "E martë";
                break;
            default:
                ditaRe = "";
        }

        return ditaRe;
    }

    public String muajiConverter(String muaji) {
        String input = "";

        switch (muaji) {
            case "Januar":
                input = "1";
                break;
            case "Februar":
                input = "2";
                break;
            case "März":
                input = "3";
                break;
            case "April":
                input = "4";
                break;
            case "Mai":
                input = "5";
                break;
            case "Juni":
                input = "6";
                break;
            case "Juli":
                input = "7";
                break;
            case "August":
                input = "8";
                break;
            case "September":
                input = "9";
                break;
            case "Oktober":
                input = "10";
                break;
            case "November":
                input = "11";
                break;
            case "Dezember":
                input = "12";
                break;
        }

        return input;
    }

    public static void setLocale(String lang, Activity context) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getBaseContext().getResources().updateConfiguration(config, context.getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public static void loadLocale(Activity context) {
        SharedPreferences preferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String language = preferences.getString("My_Lang", "en");
        setLocale(language, context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String convert24HourTimeTo12Hour(String time) {

        String[] timeNow = time.split(":");
        int hour = Integer.parseInt(timeNow[0]);
        int minutes = Integer.parseInt(timeNow[1]);
        String meridiem = hour > 11 ? "PM" : "AM";
        hour = (hour %= 12) == 0 ? 12 : hour;
        String convertedTime = String.format("%02d:%02d %s", hour, minutes, meridiem );

        return convertedTime;

    }
}