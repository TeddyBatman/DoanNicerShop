package com.example.doanshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //go to menu activity
    public void openMenu(View view) {
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);

    }
}
