package com.candra.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    KendaliLogin kl = new KendaliLogin();
    private TextView tvSesi;
    private String ambilSesi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!kl.isLogin(MainActivity.this, "user"))
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        else {
            setContentView(R.layout.activity_main);
            ambilSesi = kl.getPref(MainActivity.this, "user");
            tvSesi = findViewById(R.id.tv_sesi);
            tvSesi.setText(ambilSesi);
        }


    }

    public void prosesLogout(View view)
    {
        kl.setPref(MainActivity.this, "user", null);
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
}