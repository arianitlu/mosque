package com.rrokullia.pluscomputers.mosque;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.rrokullia.pluscomputers.mosque.Utilities.MySingleton;
import com.rrokullia.pluscomputers.mosque.Utilities.OnClickSignal;
import com.rrokullia.pluscomputers.mosque.Utilities.Query;
import com.onesignal.OneSignal;

import org.json.JSONArray;

public class MeetingsActivity extends AppCompatActivity {

    private static final String MEETINGS_REQUEST_URL =
            "http://1.lagjaledina.com/wp-json/wp/v2/pages?slug=kalendar&fields=content";

    private WebView webView;
    private ImageButton back_button;
    private TextView toolbarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        back_button = findViewById(R.id.toolbar_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbarTxt = findViewById(R.id.tolbar_text_view);
        toolbarTxt.setText("Meetings");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        webView = findViewById(R.id.webView);
        webView.setBackgroundColor(getResources().getColor(R.color.webView));

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

            if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                merrMeetings();
            } else{
                Toast.makeText(this, "You do not have internet connection", Toast.LENGTH_SHORT).show();
            }

    }

            public void merrMeetings(){

            Uri baseUri = Uri.parse(MEETINGS_REQUEST_URL);
            Uri.Builder uriBuilder = baseUri.buildUpon();

            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                    Request.Method.GET, uriBuilder.toString(), null, new Response.Listener<JSONArray>() {

                String meetings = null;

                @Override
                public void onResponse(JSONArray response) {
                    meetings = Query.shfaqMeetings(response);
                    webView.loadDataWithBaseURL(null, meetings, "text/html", "utf-8", null);

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(com.rrokullia.pluscomputers.mosque.MeetingsActivity.this, "Nuk ka te dhena " +
                            error.networkResponse.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        }
}
