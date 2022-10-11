package com.androidpprog2.chatdemo.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidpprog2.chatdemo.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

    }
}
