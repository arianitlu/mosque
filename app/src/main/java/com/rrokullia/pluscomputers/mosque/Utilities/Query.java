package com.rrokullia.pluscomputers.mosque.Utilities;

import android.text.Html;
import android.util.Log;

import com.rrokullia.pluscomputers.mosque.R;
import com.rrokullia.pluscomputers.mosque.model.Lajmi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;


public final class Query {


    private Query() {
    }

    public static ArrayList<Lajmi> shfaqLajmet(JSONArray response) {

        ArrayList<Lajmi> listLajmeve = new ArrayList<>();

        try {

            for (int i = 0; i < response.length(); i++) {

                JSONObject lajmiAktualObj = response.getJSONObject(i);

                JSONObject titleObj = lajmiAktualObj.getJSONObject("title");

                String date = lajmiAktualObj.getString("date");
                String littleDate = date.substring(0,10);

                int featuredMedia = lajmiAktualObj.getInt("featured_media");

                String titleString = titleObj.getString("rendered");

                titleString = titleString.replace("&#8211;","");

                JSONObject contentObj = lajmiAktualObj.getJSONObject("content");

                String contentString = contentObj.getString("rendered");

                contentString = noTags(contentString);

//                contentString = contentString.replaceAll("\\[\\/?vc_[^\\]]*\\]","");
//
//                contentString = contentString.replaceAll("(?:\\s|^)#[A-Za-z0-9\\-\\.\\_]+(?:\\s|$)", "");
//
//                contentString = contentString.replaceAll("body\\s*\\{.*?\\}", "");

                //contentString =  contentString.replaceAll("\\([^{}]*\\)", "");

                JSONArray categoriesArray = lajmiAktualObj.getJSONArray("categories");

                double categoriesValue = categoriesArray.getDouble(0);

                String categoriesString = String.valueOf(categoriesValue);

                String link = lajmiAktualObj.getString("link");

                Lajmi lajmi = new Lajmi(featuredMedia, titleString, categoriesString,
                        R.drawable.news_circle_green, contentString,littleDate,link);

                listLajmeve.add(lajmi);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }
        return listLajmeve;
    }

    public static String noTags(String str){
        Document doc = Jsoup.parse(str);

        doc.getElementsByTag("style").remove();
        doc.select("[style]").removeAttr("style");

        return doc.body().text();
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

    public static String shfaqMeetings(JSONArray response) {

        String rendered = null;

        try {
            JSONObject meetingsObj = response.getJSONObject(0);
            JSONObject contentObj = meetingsObj.getJSONObject("content");
            rendered = contentObj.getString("rendered");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rendered;
    }
}

