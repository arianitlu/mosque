package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.rrokullia.pluscomputers.mosque.Utilities.MyService;
import com.rrokullia.pluscomputers.mosque.Utilities.OnClickSignal;
import com.onesignal.OneSignal;

public class LoginActivity extends AppCompatActivity {

    private ImageButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new OnClickSignal(this))
                .init();

        startService(new Intent(getApplicationContext(), MyService.class));

        btnLogin = findViewById(R.id.login_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,NavigationActivity.class);
                startActivity(intent);
            }
        });

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
