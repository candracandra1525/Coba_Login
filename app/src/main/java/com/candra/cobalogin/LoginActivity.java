package com.candra.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String username, password;
    KendaliLogin kl = new KendaliLogin();
    public static String KEY_PREF_USERNAME = "GtPJAx45lMjkuICbExYElQ==username";
    public static String KEY_PREF_NAME = "GtPJAx45lMjkuICbExYElQ==name";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if(username.trim().equals("candra") && password.trim().equals("bebaslah"))
                {
                    kl.setPref(LoginActivity.this, KEY_PREF_USERNAME, username);
                    kl.setPref(LoginActivity.this, KEY_PREF_NAME, "Candra");
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                else if(!username.trim().equals("candra") || !password.trim().equals("bebaslah"))
                {
                    if(!username.trim().equals("candra"))
                    {
                        etUsername.setError("Username Salah !");
                        etUsername.setFocusable(true);
                        etUsername.setText("");
                    }
                    else if(!password.trim().equals("bebaslah"))
                    {
                        etPassword.setError("Password Salah !");
                        etPassword.setFocusable(true);
                        etPassword.setText("");
                    }
                }
                else if(username.trim().equals("andi") && password.trim().equals("andi"))
                {
                    kl.setPref(LoginActivity.this, KEY_PREF_USERNAME, username);
                    kl.setPref(LoginActivity.this, KEY_PREF_NAME, "Andi");
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Proses Login Gagal, Harap Ulangi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}