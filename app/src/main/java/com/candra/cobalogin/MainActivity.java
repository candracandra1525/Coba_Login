package com.candra.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView tvSesi;
    private Button btnLogout;
    KendaliLogin kl = new KendaliLogin();
    public static String KEY_PREF_USERNAME = "GtPJAx45lMjkuICbExYElQ==username";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(kl.isLogin(MainActivity.this, KEY_PREF_USERNAME))
        {
            setContentView(R.layout.activity_main);
            tvSesi = findViewById(R.id.tv_sesi);
            Intent x = getIntent();
            tvSesi.setText(x.getStringExtra("varName"));
            btnLogout = findViewById(R.id.btn_logout);
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kl.setPref(MainActivity.this, "user", null);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            });


        }
        else
        {
//            setContentView(R.layout.activity_login);
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

}