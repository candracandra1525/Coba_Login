package com.candra.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView tvSesi, tvNama;
    private String ambilSesi, ambilSesiNama;
    private Button btnLogout;
    KendaliLogin kl = new KendaliLogin();
    public static String KEY_PREF_USERNAME = "GtPJAx45lMjkuICbExYElQ==username";
    public static String KEY_PREF_NAME = "GtPJAx45lMjkuICbExYElQ==name";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(kl.isLogin(MainActivity.this, KEY_PREF_USERNAME))
        {
            setContentView(R.layout.activity_main);
            tvSesi = findViewById(R.id.tv_sesi);
            tvNama = findViewById(R.id.tv_name);

            ambilSesi = kl.getPref(MainActivity.this, KEY_PREF_USERNAME);
            ambilSesiNama = kl.getPref(MainActivity.this, KEY_PREF_NAME);
            tvSesi.setText(ambilSesi);
            tvNama.setText(ambilSesiNama);
            btnLogout = findViewById(R.id.btn_logout);
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kl.setPref(MainActivity.this, KEY_PREF_USERNAME, null);
                    kl.setPref(MainActivity.this, KEY_PREF_NAME, null);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            });
        }
        else
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }

    }

}