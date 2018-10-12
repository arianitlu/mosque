package com.example.pluscomputers.mosque.Utilities;

import android.util.Log;

import com.example.pluscomputers.mosque.R;
import com.example.pluscomputers.mosque.model.Lajmi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public final class Query {

    private static ArrayList<Lajmi> listLajmeve = new ArrayList<>();

    private Query() {
    }

    public static ArrayList<Lajmi> shfaqLajmet(JSONArray response) {

        try {

            for (int i = 0; i < response.length(); i++) {

                JSONObject lajmiAktualObj = response.getJSONObject(i);

                JSONObject titleObj = lajmiAktualObj.getJSONObject("title");

                int featuredMedia = lajmiAktualObj.getInt("featured_media");

                String titleString = titleObj.getString("rendered");

                titleString = titleString.replace("&#8211;","");

                JSONObject contentObj = lajmiAktualObj.getJSONObject("content");

                String contentString = contentObj.getString("rendered");

                contentString = contentString.replaceAll("\\[\\/?vc_[^\\]]*\\]","");

                JSONArray categoriesArray = lajmiAktualObj.getJSONArray("categories");

                double categoriesValue = categoriesArray.getDouble(0);

                String categoriesString = String.valueOf(categoriesValue);

                Lajmi lajmi = new Lajmi(featuredMedia, titleString, categoriesString,
                        R.drawable.news_circle_green, contentString);

                listLajmeve.add(lajmi);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }
        return listLajmeve;
    }

    public static String shfaqFoton(JSONObject response) {

        String imageUrl = "";

        try {

            JSONObject lajmiAktualObj = response.getJSONObject("guid");

            imageUrl = lajmiAktualObj.getString("rendered");

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return imageUrl;
    }

}

