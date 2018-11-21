package com.example.pluscomputers.mosque;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.pluscomputers.mosque.Utilities.MySingleton;
import com.example.pluscomputers.mosque.Utilities.OnClickSignal;
import com.example.pluscomputers.mosque.Utilities.Query;
import com.example.pluscomputers.mosque.adapters.AnetaresiaAdapter;
import com.example.pluscomputers.mosque.adapters.LajmiAdapter;
import com.example.pluscomputers.mosque.model.Anetaresia;
import com.example.pluscomputers.mosque.model.Lajmi;
import com.jaeger.library.StatusBarUtil;
import com.onesignal.OneSignal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {


    private static final String NEWS_REQUEST_URL = "http://1.lagjaledina.com//wp-json/wp/v2/posts/?per_page=100";
            //"http://1.lagjaledina.com/wp-json/wp/v2/posts";
    //http://1.lagjaledina.com//wp-json/wp/v2/posts/?per_page=100

    private static final String IMAGE_REQUEST_URL =
            "http://1.lagjaledina.com/wp-json/wp/v2/media";

    private RecyclerView recyclerView;
    LajmiAdapter mAdapter = new LajmiAdapter(this);
    private ImageButton back_button;
    private TextView toolbarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        back_button = findViewById(R.id.toolbar_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("News");

        overridePendingTransition(0, 0);

        recyclerView = findViewById(R.id.news_recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            merrLajmet();
        } else{
            Toast.makeText(this, "You do not have internet connection", Toast.LENGTH_SHORT).show();
        }

    }

    public void merrLajmet(){


        Uri baseUri = Uri.parse(NEWS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET, uriBuilder.toString(), null, new Response.Listener<JSONArray>() {

                    List<Lajmi> listLajmet = new ArrayList<>();

            @Override
                    public void onResponse(JSONArray response) {
                        listLajmet = Query.shfaqLajmet(response);

                        for (Lajmi lajmi : listLajmet){
                            merrFoton(lajmi);
                        }
                        mAdapter.setLajmi(listLajmet);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NewsActivity.this, "Nuk ka te dhena " +
                                error.networkResponse.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    public void merrFoton(final Lajmi lajmi){

        Uri baseUri = Uri.parse(IMAGE_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        uriBuilder.appendPath(String.valueOf(lajmi.getFeatureMedia()));

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, uriBuilder.toString(), null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                String imageUrl = Query.shfaqFoton(response);
                if (imageUrl == ""){
                    imageUrl = String.valueOf(R.drawable.news_photo1);
                }
                lajmi.setImage(imageUrl);
                //mAdapter.setLajmi(listLajmet);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(NewsActivity.this, "Nuk ka te image " +
                        //error.networkResponse.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}
