package com.rrokullia.pluscomputers.mosque;

import android.content.Intent;
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

import static com.rrokullia.pluscomputers.mosque.utilities.Helper.convert24HourTimeTo12Hour;

public class TakvimiActivity extends AppCompatActivity {

    private ImageButton back_button;
    private ImageView icSettings;
    private TextView lblImsaku, lblSabahu, lblLindjaDiellit, lblDreka,
            lblIkindija, lblAkshami, lblJacia;
    private TextView txtImsaku, txtSabahi, txtLindjaDiellit, txtDreka,
            txtIkindija, txtAkshami, txtJacia, txtverejtje;
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

        boundViews();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        icSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TakvimiActivity.this, TakvimiSettingsActivity.class);
                startActivity(intent);
            }
        });

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
    public void merrKohetNamazit(long id) {
        LocalDateTime now;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        now = LocalDateTime.now().plusDays(id);
        String dateNowWithSlash = dtf.format(now);
//        String dateNowWithPoints = dateNowWithSlash.replace("/", ".");

        Welcome welcome = Helper.getNamazFromJson(getApplicationContext());

        List<Namazi> namaziList = welcome.getNamazi();
        for (Namazi namazi : namaziList) {
            if (namazi.getDate().equals(dateNowWithSlash)) {

                // Change weekDay from SQ to DE and vica versa
                // txtDita.setText(namazi.getWeekDay());
                txtDita.setText(getDayInGerman(namazi.getWeekDay()));

                // Change labels of dua from SQ to DE and vica versa
                makeLabelLookGerman();

                // Set time taken from json
                txtData.setText(namazi.getDate());
                txtImsaku.setText(namazi.getImsaku());
                txtSabahi.setText(namazi.getSabahu());
                txtLindjaDiellit.setText(namazi.getDielli());
                txtDreka.setText(namazi.getDreka());
                txtIkindija.setText(namazi.getIkindija());
                txtAkshami.setText(namazi.getAkshami());
                txtJacia.setText(namazi.getJacija());

                // Check if namazi have comments property
                if (namazi.getComments() != null) {
                    txtverejtje.setText(namazi.getComments());
                } else {
                    txtverejtje.setText("-");
                }
            }

        }
    }

    public String getDayInGerman(String day) {
        switch (day) {
            case "E Hënë":
                return "Montag";
            case "E Martë":
                return "Dienstag";
            case "E Mërkurë":
                return "Mittwoch";
            case "E Enjte":
                return "Donnerstag";
            case "E Premte":
                return "Freitag";
            case "E Shtunë":
                return "Samstag";
            case "E Diele":
                return "Sonntag";
            default:
                return "";
        }
    }

    public void makeLabelLookGerman() {
        lblImsaku.setText("Fajr");
        lblSabahu.setText("Morgengebet");
        lblLindjaDiellit.setText("Sonnenaufgang");
        lblDreka.setText("Dhuhr");
        lblIkindija.setText("Asr");
        lblAkshami.setText("Maghrib");
        lblJacia.setText("Isha");
    }

    public void boundViews() {
        lblImsaku = findViewById(R.id.lbl_imsaku);
        lblSabahu = findViewById(R.id.lbl_sabahu);
        lblLindjaDiellit = findViewById(R.id.lbl_lindja_diellit);
        lblDreka = findViewById(R.id.lbl_ikindija);
        lblAkshami = findViewById(R.id.lbl_akshami);
        lblJacia = findViewById(R.id.lbl_jacia);
        lblIkindija = findViewById(R.id.lbl_dreka);

        txtImsaku = findViewById(R.id.txt_imsaku);
        txtSabahi = findViewById(R.id.txt_sabahu);
        txtLindjaDiellit = findViewById(R.id.txt_lindja_diellit);
        txtDreka = findViewById(R.id.txt_ikindija);
        txtAkshami = findViewById(R.id.txt_akshami);
        txtJacia = findViewById(R.id.txt_jacia);
        txtIkindija = findViewById(R.id.txt_dreka);
        txtverejtje = findViewById(R.id.txt_verejtje);

        txtData = findViewById(R.id.txt_data);
        txtDita = findViewById(R.id.txt_dita);

        ic_back = findViewById(R.id.ic_back);
        ic_next = findViewById(R.id.ic_next);

        icSettings = findViewById(R.id.ic_settings);
        back_button = findViewById(R.id.donacionet_button_back);
    }

}
