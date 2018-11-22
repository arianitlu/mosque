package com.example.pluscomputers.mosque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pluscomputers.mosque.Utilities.MyService;
import com.example.pluscomputers.mosque.Utilities.OnClickSignal;
import com.onesignal.OneSignal;

public class LoginActivity extends AppCompatActivity {

    private ImageButton btnLogin;
    //private TextView txtMarquee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new OnClickSignal(this))
                .init();

        overridePendingTransition(0, 0);

        startService(new Intent(LoginActivity.this, MyService.class));
        btnLogin = findViewById(R.id.login_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });

//        txtMarquee = findViewById(R.id.login_marquee_text_view);
//
//        txtMarquee.setSelected(true);
//        txtMarquee.setSingleLine();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new OnClickSignal(this))
                .init();
    }
}
