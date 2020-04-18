package com.rrokullia.pluscomputers.mosque;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.rrokullia.pluscomputers.mosque.model.takvimi.Namazi;
import com.rrokullia.pluscomputers.mosque.model.takvimi.Welcome;
import com.rrokullia.pluscomputers.mosque.utilities.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class TakvimiActivity extends AppCompatActivity {


    private ImageButton back_button;
    private ImageView icSettings;
    private TextView lblImsaku, lblSabahu, lblLindjaDiellit, lblDreka,
            lblAkshami, lblJacia, lblJacianeXhami;
    private TextView txtImsaku, txtSabahi, txtLindjaDiellit, txtDreka,
            txtAkshami, txtJacia, txtJacianeXhami, txtverejtje;
    private TextView txtData, txtDita;
    private ImageView ic_back, ic_next;

    int i = 0;
    int j = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takvimi);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        back_button = findViewById(R.id.donacionet_button_back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        icSettings = findViewById(R.id.ic_settings);
        boundViews();


        merrKohetNamazit(0);

        ic_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                merrKohetNamazit(i);
            }
        });

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                merrKohetNamazit(i);
            }
        });



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void merrKohetNamazit(long id){
        LocalDateTime now;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
        now = LocalDateTime.now().plusDays(id);
        String dateNowWithSlash = dtf.format(now);
        String dateNowWithPoints = dateNowWithSlash.replace("/", ".");

        Welcome welcome = Helper.getNamazFromJson(getApplicationContext());

        List<Namazi> namaziList = welcome.getNamazi();
        for (Namazi namazi : namaziList) {
            if (namazi.getData().equals(dateNowWithPoints)){
                txtDita.setText(namazi.getDita());
                txtData.setText(namazi.getData());
                txtImsaku.setText(namazi.getImsaku());
                txtSabahi.setText(namazi.getSabahu());
                txtLindjaDiellit.setText(namazi.getDielli());
                txtDreka.setText(namazi.getDreka());
                txtAkshami.setText(namazi.getAkshami());
                txtJacia.setText(namazi.getJacija());
                txtJacianeXhami.setText("-");
            }

        }
    }

    public void boundViews(){
        lblImsaku = findViewById(R.id.lbl_imsaku);
        lblSabahu = findViewById(R.id.lbl_sabahu);
        lblLindjaDiellit = findViewById(R.id.lbl_lindja_diellit);
        lblDreka = findViewById(R.id.lbl_dreka);
        lblAkshami = findViewById(R.id.lbl_akshami);
        lblJacia = findViewById(R.id.lbl_jacia);
        lblJacianeXhami = findViewById(R.id.lbl_jacia_xhami);

        txtImsaku = findViewById(R.id.txt_imsaku);
        txtSabahi = findViewById(R.id.txt_sabahu);
        txtLindjaDiellit = findViewById(R.id.txt_lindja_diellit);
        txtDreka = findViewById(R.id.txt_dreka);
        txtAkshami = findViewById(R.id.txt_akshami);
        txtJacia = findViewById(R.id.txt_jacia);
        txtJacianeXhami = findViewById(R.id.txt_jacia_xhami);
        txtverejtje = findViewById(R.id.txt_verejtje);

        txtData = findViewById(R.id.txt_data);
        txtDita = findViewById(R.id.txt_dita);

        ic_back = findViewById(R.id.ic_back);
        ic_next = findViewById(R.id.ic_next);
    }
}
