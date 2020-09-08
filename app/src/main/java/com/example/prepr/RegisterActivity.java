package com.example.prepr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void nextActivity(View view){
        TextView n = findViewById(R.id.setUsername);
        TextView p = findViewById(R.id.setPassword);

        UserManager.addUser(n.getText().toString(),p.getText().toString());

        Intent intent = new Intent(this, DisplayMessageActivity.class );
        startActivity(intent);
    }
}
