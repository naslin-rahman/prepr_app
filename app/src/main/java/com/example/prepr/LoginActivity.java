package com.example.prepr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void nextActivity(View view){
        TextView user = findViewById(R.id.username);
        TextView pass = findViewById(R.id.password);

        if (UserManager.authenticate(user.getText().toString(), pass.getText().toString())){
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            startActivity(intent);
        }

    }
}
