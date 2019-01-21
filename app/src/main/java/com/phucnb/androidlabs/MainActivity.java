package com.phucnb.androidlabs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String SHARED_PREFERENCES_NAME = "emailPref";
    private Button loginBtn;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab3);

        email = (EditText) findViewById(R.id.editText2);

        loginBtn = (Button) findViewById(R.id.LoginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences emailPref = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = emailPref.edit();
               // edit.putString(email.getText());
                edit.commit();
            }
        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        SharedPreferences emailPref = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.M
//    }
}
