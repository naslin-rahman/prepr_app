package com.example.prepr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        File rootDir = getFilesDir();
        UserManager um = new UserManager(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextActivity(View view){
        int tag = view.getId();

        Intent intent;

        switch(tag){
            case R.id.signUpButton:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.signInButton:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
