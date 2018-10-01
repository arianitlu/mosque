package com.example.pluscomputers.mosque.Utilities;

import android.util.Log;

import com.example.pluscomputers.mosque.R;
import com.example.pluscomputers.mosque.model.Lajmi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public final class Query {


//    public Lajmi(String title, String category, int image, int color, String description) {

    private static String titleString;
    private static String categoriesString;
    private static String contentString;

    private static Lajmi lajmi;
    private static ArrayList<Lajmi> listLajmeve = new ArrayList<>();


    private Query() {
    }

    public static ArrayList<Lajmi> shfaqLajmet(JSONArray response) {

//        ArrayList<Lajmi> listLajmeve = new ArrayList<>();

        try {

            for (int i = 0; i < response.length(); i++) {

                JSONObject lajmiAktualObj = response.getJSONObject(i);

                JSONObject titleObj = lajmiAktualObj.getJSONObject("title");

                titleString = titleObj.getString("rendered");

                JSONObject contentObj = lajmiAktualObj.getJSONObject("content");

                contentString = contentObj.getString("rendered");

                JSONArray categoriesArray = lajmiAktualObj.getJSONArray("categories");

                double categoriesValue = categoriesArray.getDouble(0);

                categoriesString = String.valueOf(categoriesValue);

//                Lajmi lajmi = new Lajmi(titleString,categoriesString, R.drawable.news_photo1
//                ,R.drawable.news_circle_green,contentString);
//
//                listLajmeve.add(lajmi);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }

        return listLajmeve;
    }

}

